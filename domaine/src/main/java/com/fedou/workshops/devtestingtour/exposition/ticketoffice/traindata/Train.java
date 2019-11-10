package com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.RatioCalculation.isUnder70PercentWhenBookingOf;

public class Train {
    private static Logger log = LoggerFactory.getLogger(Train.class);

    private final String trainId;
    private int totalFreeSeats;
    private int totalSeats;
    private List<Coach> coaches = new LinkedList<>();

    public Train(String trainId, List<Coach> coaches) {
        this.trainId = trainId;
        this.coaches.addAll(coaches);
        coaches.forEach(coach -> {
            totalSeats += coach.getTotalSeats();
            totalFreeSeats += coach.getTotalFreeSeats();
        });
    }

    public String getTrainId() {
        return trainId;
    }

    public Optional<BookableSeats> findSeatsForBooking(int numberOfSeats) {
        Optional<BookableSeats> result = Optional.empty();

        if (isUnder70PercentWhenBookingOf(totalSeats, totalFreeSeats, numberOfSeats)) {
            result = findSeatsForBooking(numberOfSeats, true);
            if (!result.isPresent()) {
                result = findSeatsForBooking(numberOfSeats, false);
            }
        }
        logResult(numberOfSeats, result);
        return result;
    }

    private Optional<BookableSeats> findSeatsForBooking(int numberOfSeats, boolean respectFreeSeatsRatioPerCoach) {
        for (Coach current : coaches) {
            List<Integer> seats = current.findSeatsForBooking(numberOfSeats, respectFreeSeatsRatioPerCoach);
            if (!seats.isEmpty()) {
                return Optional.of(new BookableSeats(current.getCoachId(), seats));
            }
        }
        return Optional.empty();
    }

    private void logResult(int numberOfSeats, Optional<BookableSeats> seats) {
        log.debug("Booking {} seats for train {} gives {}.", numberOfSeats, this, seats);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Train{");
        sb.append("trainId='").append(trainId).append('\'');
        sb.append(", totalSeats=").append(totalSeats);
        sb.append(", totalFreeSeats=").append(totalFreeSeats);
        sb.append(", ratio=").append(((float) (totalSeats - totalFreeSeats) / (float) totalSeats));
        sb.append(", coaches=").append(coaches);
        sb.append('}');
        return sb.toString();
    }
}

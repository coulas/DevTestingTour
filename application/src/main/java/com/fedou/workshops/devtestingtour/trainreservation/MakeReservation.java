package com.fedou.workshops.devtestingtour.trainreservation;

import com.fedou.workshops.devtestingtour.exposition.ticketoffice.Reservation;
import com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.BookableSeats;
import com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.Train;
import com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.TrainDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.fedou.workshops.devtestingtour.exposition.ticketoffice.booking.BookingReferenceUtils.getUniqueBookingReference;
import static java.util.Collections.emptyList;

@Service
public class MakeReservation {
    private TrainDataService trainDataService;
    private final Reservation failed_reservation = new Reservation(null, null, null);

    @Autowired
    public MakeReservation(TrainDataService trainDataService) {
        this.trainDataService = trainDataService;
    }

    public Reservation book(String trainId, int numberOfSeats) {
        if (numberOfSeats <= 0) {
            return failed_reservation;
        }
        Train train = trainDataService.getTrainById(trainId);
        Optional<BookableSeats> seats = train.findSeatsForBooking(numberOfSeats);
        String reference = "";
        if (seats.isPresent()) {
            reference = getUniqueBookingReference();
            trainDataService.reserve(trainId, reference, seats.get());
        }
        return new Reservation(trainId, reference, seats.get());
    }
}

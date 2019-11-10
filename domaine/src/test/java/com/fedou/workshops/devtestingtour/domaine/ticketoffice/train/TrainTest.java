package com.fedou.workshops.devtestingtour.domaine.ticketoffice.train;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void findSeatsForBooking() {
        Train simpleTrain = givenSimpleEmptyTrain();
        Optional<BookableSeats> seats = simpleTrain.findSeatsForBooking(2);
        assertThat(seats).isNotEmpty().get()
                .isEqualToComparingFieldByField(
                        new BookableSeats("A", asList(1, 2))
                );
    }

    private Train givenSimpleEmptyTrain() {
        return new Train("trainID", asList(
                new Coach("A", 10, asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)),
                new Coach("B", 10, asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        ));
    }
}
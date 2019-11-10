package com.fedou.workshops.devtestingtour.exposition.ticketoffice;

import com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.BookableSeats;

import java.util.List;
import java.util.Objects;

public class Reservation {
    private String trainId;
    private String bookingReference;
    private BookableSeats seats;

    public Reservation(String trainId, String bookingReference, BookableSeats seats) {
        this.trainId = trainId;
        this.bookingReference = bookingReference;
        this.seats = seats;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public BookableSeats getSeats() {
        return seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(trainId, that.trainId) &&
                Objects.equals(bookingReference, that.bookingReference) &&
                Objects.equals(seats, that.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, bookingReference, seats);
    }
}

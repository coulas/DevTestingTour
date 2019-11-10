package com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata;

public interface TrainDataService {

    void reserve(String trainId, String bookingReference, BookableSeats seats);

    Train getTrainById(String trainId);
}

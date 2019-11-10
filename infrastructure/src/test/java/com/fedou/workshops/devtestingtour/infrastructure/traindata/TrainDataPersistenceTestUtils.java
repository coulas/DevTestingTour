package com.fedou.workshops.devtestingtour.infrastructure.traindata;

import com.fedou.workshops.devtestingtour.exposition.ticketoffice.traindata.TrainDataService;

import java.util.List;

public interface TrainDataPersistenceTestUtils extends TrainDataService {
    void saveAll(List<TrainData> trainData);

    List<TrainData> findByTrainAndBooking(String train, String booking);
}

package com.fedou.workshops.devtestingtour.infrastructure.traindata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TrainDataDAO extends JpaRepository<TrainData, String> {
    List<TrainData> findByTrain(String train);
    List<TrainData> findByTrainAndBooking(String train, String booking);
    @Modifying
    @Query(value = "UPDATE Train SET booking=:booking WHERE train=:train AND coach=:coach AND seat IN :seats", nativeQuery = true)
    void updateBooking(@Param("train") String train,
                       @Param("coach") String coach,
                       @Param("seats") List<Integer> seats,
                       @Param("booking") String booking);
}

package com.fedou.workshops.devtestingtour.exposition.ticketoffice;

import com.fedou.workshops.devtestingtour.domaine.ticketoffice.Reservation;
import com.fedou.workshops.devtestingtour.trainreservation.MakeReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/reservation")
public class TicketOfficeController {
    private MakeReservation makeReservation;

    @Autowired
    public TicketOfficeController(MakeReservation makeReservation)
    {
        this.makeReservation = makeReservation;
    }

    @RequestMapping(method = POST, path = "/makeReservation")
    public ReservationDTO makeReservation(@RequestBody ReservationRequestDTO req) {
        Reservation booking = makeReservation.book(req.getTrainId(), req.getNumberOfSeats());
        return ReservationDTO.toDTO(booking);
    }
}

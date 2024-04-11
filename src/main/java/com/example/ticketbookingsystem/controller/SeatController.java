package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.entity.Seat;
import com.example.ticketbookingsystem.service.SeatServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SeatController {

    private SeatServiceInterface seatService;

    @Autowired
    public SeatController(SeatServiceInterface sService){
        seatService = sService;
    }

    @GetMapping("/seats")
    public List<Seat> findAll(){
        return  seatService.findAll();
    }

    @GetMapping("/seats/{seatId}")
    public Seat getSeats(@PathVariable int seatId){
        Seat seat = seatService.findById(seatId);

        if(seat == null){
            throw new RuntimeException("Seat id not found: " + seatId);
        }
        return seat;
    }

    @PostMapping("/seats")
    public Seat addSeat(@RequestBody Seat seat){
        seat.setId(0);
        Seat seatDB = seatService.update(seat);
        return seatDB;
    }

    @PutMapping("/seats")
    public Seat updateSeat(@RequestBody Seat seat){
        Seat seatDB = seatService.update(seat);
        return seatDB;
    }

    @DeleteMapping("/seats/{seatId}")
    public String deleteSeat(@PathVariable int seatId){
        Seat seat = seatService.findById(seatId);

        if(seat == null){
            throw new RuntimeException("Seat id not found: " + seatId);
        }
        seatService.deleteById(seatId);

        return "The seat with ID " + seatId + " has been deleted.";
    }

}

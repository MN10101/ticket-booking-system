package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.entity.Showtime;
import com.example.ticketbookingsystem.service.ShowtimeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowtimeController {

    private ShowtimeServiceInterface showtimeService;

    @Autowired
    public ShowtimeController(ShowtimeServiceInterface sService){
        showtimeService = sService;
    }

    @GetMapping("/showtimes")
    public List<Showtime> findAll(){
        return  showtimeService.findAll();
    }

    @GetMapping("/showtimes/{showtimeId}")
    public Showtime getShowtimes(@PathVariable int showtimeId){
        Showtime showtime = showtimeService.findById(showtimeId);

        if(showtime == null){
            throw new RuntimeException("Showtime id not found: " + showtimeId);
        }
        return showtime;
    }

    @PostMapping("/showtimes")
    public Showtime addShowtime(@RequestBody Showtime showtime){
        showtime.setId(0);
        Showtime showtimeDB = showtimeService.update(showtime);
        return showtimeDB;
    }

    @PutMapping("/showtimes")
    public Showtime updateShowtime(@RequestBody Showtime showtime){
        Showtime showtimeDB = showtimeService.update(showtime);
        return showtimeDB;
    }

    @DeleteMapping("/showtimes/{showtimeId}")
    public String deleteShowtime(@PathVariable int showtimeId){
        Showtime showtime = showtimeService.findById(showtimeId);

        if(showtime == null){
            throw new RuntimeException("Showtime id not found: " + showtimeId);
        }
        showtimeService.deleteById(showtimeId);

        return "The showtime with ID " + showtimeId + " has been deleted.";
    }

}

package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.entity.Booking;
import com.example.ticketbookingsystem.service.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingContoller {

    private BookingServiceInterface bookingService;

    @Autowired
    public BookingContoller(BookingServiceInterface bService){
        bookingService = bService;
    }

    @GetMapping("/bookings")
    public List<Booking> findAll(){
        return  bookingService.findAll();
    }

    @GetMapping("/bookings/{bookingId}")
    public Booking getBookings(@PathVariable int bookingId) {
        Booking booking = bookingService.findById(bookingId);

        if (booking == null) {
            throw new RuntimeException("Booking id not found: " + bookingId);
        }
        return booking;

    }

    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking){
        booking.setId(0);
        Booking bookingDB = bookingService.update(booking);
        return bookingDB;
    }

    @PutMapping("/bookings")
    public Booking updateBooking(@RequestBody Booking booking){
        Booking bookingDB = bookingService.update(booking);
        return bookingDB;
    }

    @DeleteMapping("/bookings/{bookingId}")
    public String deleteBooking(@PathVariable int bookingId){
        Booking booking = bookingService.findById(bookingId);
        if(booking == null){
            throw new RuntimeException("Booking id not found: " + bookingId);
        }
        bookingService.deleteById(bookingId);

        return "The booking with ID " + bookingId + " has been deleted.";

    }

}

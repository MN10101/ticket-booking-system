package com.example.ticketbookingsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name= "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "showtime_id", referencedColumnName = "id")
    private Showtime showtime;

    @ManyToOne
    @JoinColumn(name= "seat_id", referencedColumnName = "id")
    private Seat seat;

    private LocalDateTime bookingDate;

    public Booking() {
    }

    public Booking(Customer customer, Showtime showtime, Seat seat, LocalDateTime bookingDate) {
        this.customer = customer;
        this.showtime = showtime;
        this.seat = seat;
        this.bookingDate = bookingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}

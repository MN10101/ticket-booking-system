package com.example.ticketbookingsystem.entity;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "showtime_id", referencedColumnName = "id")
    private Showtime showtime;

    @Column(name = "seat_row") // Renamed from "row"
    private int seatRow;

    private int number;
    private boolean isBooked;

    public Seat() {
    }

    public Seat(Showtime showtime, int seatRow, int number, boolean isBooked) {
        this.showtime = showtime;
        this.seatRow = seatRow;
        this.number = number;
        this.isBooked = isBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}

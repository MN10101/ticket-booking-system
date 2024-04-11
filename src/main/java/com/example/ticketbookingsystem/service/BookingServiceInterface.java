package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.entity.Booking;

import java.util.List;

public interface BookingServiceInterface {

    List<Booking> findAll();

    Booking findById(int id);

    Booking update(Booking booking);

    void deleteById(int id);
}

package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.dao.BookingRepository;
import com.example.ticketbookingsystem.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements BookingServiceInterface {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bDAO){
        bookingRepository = bDAO;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(int id) {

        Optional<Booking> result = bookingRepository.findById(id);

        Booking booking = null;

        if(result.isPresent()){
            booking = result.get();
        }else {
            throw new RuntimeException("Did not find booking id: " + id);
        }

        return booking;
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteById(int id) {
        bookingRepository.deleteById(id);

    }
}

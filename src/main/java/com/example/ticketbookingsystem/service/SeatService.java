package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.dao.SeatRepository;
import com.example.ticketbookingsystem.entity.Seat;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements SeatServiceInterface {

    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository sDAO){
        seatRepository = sDAO;
    }


    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    @Override
    public Seat findById(int id) {

        Optional<Seat> result = seatRepository.findById(id);

        Seat seat = null;

        if(result.isPresent()){
            seat = result.get();
        }else {
            throw new RuntimeException("Did not find seat id: " + id);
        }

        return seat;
    }

    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteById(int id) {
        seatRepository.deleteById(id);
    }
}

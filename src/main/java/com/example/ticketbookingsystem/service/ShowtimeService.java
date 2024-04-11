package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.dao.ShowtimeRepository;
import com.example.ticketbookingsystem.entity.Showtime;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowtimeService implements ShowtimeServiceInterface {

    private ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository sDAO){
        showtimeRepository = sDAO;
    }

    @Override
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime findById(int id) {

        Optional<Showtime> result = showtimeRepository.findById(id);

        Showtime showtime = null;

        if(result.isPresent()){
            showtime = result.get();
        }else {
            throw new RuntimeException("Did not find showtime id: " + id);
        }

        return showtime;
    }

    @Transactional
    @Override
    public Showtime update(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        showtimeRepository.deleteById(id);

    }
}

package com.example.usareto3.Controller;

import com.example.usareto3.Service.CinemaService;
import com.example.usareto3.Model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getAdmin(@PathVariable("id") int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema cinema){
        return cinemaService.save(cinema);
    }
}

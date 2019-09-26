package com.example.database.controller;

import com.example.database.model.Trainer;
import com.example.database.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrainerController {
    @Autowired
    private TrainerRepository trainerRepository;

    @PutMapping("/trainer")
    public Trainer addTrainer(@RequestBody Trainer trainer) {
        return trainerRepository.save(trainer);

    }

    @GetMapping("/trainer/{trainerid}")
    public Trainer getTrainer(@PathVariable Integer trainerid) {
        return trainerRepository.findById(trainerid).orElse(null);
    }

}

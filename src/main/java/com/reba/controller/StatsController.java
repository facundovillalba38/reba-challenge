package com.reba.controller;

import com.reba.entity.Stats;
import com.reba.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private StatsService statsService;

    @Autowired
    public StatsController (StatsService statsService){
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<List<Stats>> getStats(){
        return new ResponseEntity<>(statsService.getStats(), HttpStatus.OK);
    }


}

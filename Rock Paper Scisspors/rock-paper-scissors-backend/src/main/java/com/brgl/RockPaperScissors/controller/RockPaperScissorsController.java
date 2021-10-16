package com.brgl.RockPaperScissors.controller;

import com.brgl.RockPaperScissors.model.MoveResponse;
import com.brgl.RockPaperScissors.service.RockPaperScissorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/rockpaperscissors")
public class RockPaperScissorsController {

    @Autowired
    RockPaperScissorsService rockPaperScissorsService;

    @PostMapping("/openYourHand/{move}")
    public ResponseEntity<MoveResponse> openYourHand(@PathVariable String move) throws Exception {

        MoveResponse moveResponse = rockPaperScissorsService.openYourHand(move);

        return ResponseEntity.ok(moveResponse);
    }

}

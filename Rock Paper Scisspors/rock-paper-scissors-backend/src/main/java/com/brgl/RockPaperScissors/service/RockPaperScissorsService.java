package com.brgl.RockPaperScissors.service;

import com.brgl.RockPaperScissors.rules.RockPaperScissorsRulesImpl;
import com.brgl.RockPaperScissors.model.Move;
import com.brgl.RockPaperScissors.model.MoveResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RockPaperScissorsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RockPaperScissorsService.class);

    public MoveResponse openYourHand(String inputUserMove) throws Exception {

        RockPaperScissorsRulesImpl rockPaperScissorsRules = new RockPaperScissorsRulesImpl();
        Move player1_Move;
        MoveResponse moveResponse = new MoveResponse();

        try {
            player1_Move = validateInputUserMove(inputUserMove);
            moveResponse = rockPaperScissorsRules.playTheGame(player1_Move);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return moveResponse;
    }

    private Move validateInputUserMove(String inputUserMove) throws Exception {
        switch (inputUserMove) {
            case "ROCK":
                return Move.ROCK;
            case "PAPER":
                return Move.PAPER;
            case "SCISSORS":
                return Move.SCISSORS;
            default:
                throw new Exception("Incorrect user input");
        }
    }

}

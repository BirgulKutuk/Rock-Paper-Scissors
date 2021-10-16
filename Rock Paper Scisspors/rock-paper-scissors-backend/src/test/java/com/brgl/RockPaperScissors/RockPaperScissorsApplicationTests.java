package com.brgl.RockPaperScissors;

import com.brgl.RockPaperScissors.model.Move;
import com.brgl.RockPaperScissors.model.Result;
import com.brgl.RockPaperScissors.rules.RockPaperScissorsRulesImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RockPaperScissorsApplicationTests {

    RockPaperScissorsRulesImpl rockPaperScissorsRulesImpl = new RockPaperScissorsRulesImpl();

    @Test
    void testRock() {
        Move player2_move = rockPaperScissorsRulesImpl.generateRandonMove();
        Result result = rockPaperScissorsRulesImpl.decide(Move.ROCK, player2_move);

        if (player2_move == Move.ROCK) {
            Assert.assertEquals(result, Result.DRAW);
        } else if (player2_move == Move.PAPER) {
            Assert.assertEquals(result, Result.LOSE);
        } else if (player2_move == Move.SCISSORS) {
            Assert.assertEquals(result, Result.WIN);
        }
    }

    @Test
    void testPaper() {
        Move player2_move = rockPaperScissorsRulesImpl.generateRandonMove();
        Result result = rockPaperScissorsRulesImpl.decide(Move.PAPER, player2_move);

        if (player2_move == Move.ROCK) {
            Assert.assertEquals(result, Result.WIN);
        } else if (player2_move == Move.PAPER) {
            Assert.assertEquals(result, Result.DRAW);
        } else if (player2_move == Move.SCISSORS) {
            Assert.assertEquals(result, Result.LOSE);
        }
    }

    @Test
    void testScissors() {
        Move player2_move = rockPaperScissorsRulesImpl.generateRandonMove();
        Result result = rockPaperScissorsRulesImpl.decide(Move.SCISSORS, player2_move);

        if (player2_move == Move.ROCK) {
            Assert.assertEquals(result, Result.LOSE);
        } else if (player2_move == Move.PAPER) {
            Assert.assertEquals(result, Result.WIN);
        } else if (player2_move == Move.SCISSORS) {
            Assert.assertEquals(result, Result.DRAW);
        }
    }
}

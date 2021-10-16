package com.brgl.RockPaperScissors.rules;

import com.brgl.RockPaperScissors.model.Move;
import com.brgl.RockPaperScissors.model.MoveResponse;
import com.brgl.RockPaperScissors.model.Result;

import java.util.Random;

public class RockPaperScissorsRulesImpl implements RockPaperScissorsRules {

    @Override
    public Result decide(Move player_1, Move player_2) {
        switch (player_1) {
            case ROCK:
                switch (player_2) {
                    case SCISSORS:
                        return Result.WIN;
                    case PAPER:
                        return Result.LOSE;
                    default:
                        return Result.DRAW;
                }

            case PAPER:
                switch (player_2) {
                    case ROCK:
                        return Result.WIN;
                    case SCISSORS:
                        return Result.LOSE;
                    default:
                        return Result.DRAW;
                }

            case SCISSORS:
                switch (player_2) {
                    case PAPER:
                        return Result.WIN;
                    case ROCK:
                        return Result.LOSE;
                    default:
                        return Result.DRAW;
                }
        }

        return Result.DRAW;
    }

    @Override
    public MoveResponse playTheGame(Move player1_move) {

        Move player2_Move = generateRandonMove();
        Result result = decide(player1_move, player2_Move);

        return new MoveResponse(player2_Move, result);
    }

    @Override
    public Move generateRandonMove() {
        Move[] values = Move.values();
        int randIndex = new Random().nextInt(values.length);
        return values[randIndex];
    }

}

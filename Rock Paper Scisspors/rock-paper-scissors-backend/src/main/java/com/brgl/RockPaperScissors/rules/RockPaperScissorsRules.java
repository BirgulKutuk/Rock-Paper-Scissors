package com.brgl.RockPaperScissors.rules;

import com.brgl.RockPaperScissors.model.Result;
import com.brgl.RockPaperScissors.model.Move;
import com.brgl.RockPaperScissors.model.MoveResponse;

public interface RockPaperScissorsRules {

    Result decide(Move player1, Move player2);

    MoveResponse playTheGame(Move player1);

    Move generateRandonMove();

}

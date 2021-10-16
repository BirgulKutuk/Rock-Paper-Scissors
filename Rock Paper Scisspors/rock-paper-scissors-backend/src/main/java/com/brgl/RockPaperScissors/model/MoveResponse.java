package com.brgl.RockPaperScissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoveResponse {

    private Move player2_Move;
    private Result result;

}

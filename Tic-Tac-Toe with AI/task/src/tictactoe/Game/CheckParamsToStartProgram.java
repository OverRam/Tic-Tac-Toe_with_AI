package tictactoe.Game;

import java.util.Arrays;

class CheckParamsToStartProgram {
    static boolean checkInputParams(String[] input) {
        return Arrays.stream(input).filter(i -> "easy".equals(i) || "medium".equals(i) ||
                "hard".equals(i) || "user".equals(i)).count() == 2 && input.length == 3;
    }
}

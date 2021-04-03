package tictactoe.Game;

import java.util.Arrays;

class CheckParamsToStartProgram {
    static boolean checkInputParams(String[] input) {
        if (input.length != 3 && !"start".equals(input[0])) {
            return false;
        }
        return Arrays.stream(input).filter(i -> "easy".equals(i) || "user".equals(i)).count() == 2;
    }
}

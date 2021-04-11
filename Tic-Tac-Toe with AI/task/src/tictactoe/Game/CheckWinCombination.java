package tictactoe.Game;

public class CheckWinCombination {

    static int checkCombination(char[][] arrayToCheck, char charToCheck) {
        int slash = 0;
        int backSlash = 0;
        int horizontal = 0;
        int vertical = 0;
        int emptyCells = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                emptyCells += arrayToCheck[i][j] == ' ' ? 1 : 0;
                horizontal += arrayToCheck[i][j] == charToCheck ? 1 : 0;                             //check horizontal
                vertical += arrayToCheck[j][i] == charToCheck ? 1 : 0;                               //check vertical
                if (horizontal == 3 | vertical == 3) {
                    return 1;
                }
                if (i == 0) {
                    backSlash += arrayToCheck[j][j] == charToCheck ? 1 : 0;                         //check back slash
                    slash += arrayToCheck[j][2 - j] == charToCheck ? 1 : 0;                         //check slash
                    if (slash == 3 | backSlash == 3) {
                        return 1;
                    }
                }
            }
            horizontal = 0;
            vertical = 0;
        }
        return emptyCells == 0 ? 0 : -1;
    }
}

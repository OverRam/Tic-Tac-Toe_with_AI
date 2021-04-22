package tictactoe.Game;

public class MediumAi {

    static int[] mediumAiMove(char[][] arrayToCheck, char charToCheck) {
        int slash = 0;
        int backSlash = 0;
        int horizontal = 0;
        int vertical = 0;
        int[] coordinate = {9, 9};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    backSlash += arrayToCheck[j][j] == charToCheck ? 1 : 0;                 //check back slash
                    slash += arrayToCheck[j][2 - j] == charToCheck ? 1 : 0;                 //check slash

                    if (backSlash == 2) {                                                   //coordinates of back slash
                        for (int k = 0; k < 3; k++) {
                            if (' ' == arrayToCheck[k][k]) {
                                coordinate[0] = k;
                                coordinate[1] = k;
                                return coordinate;
                            }
                        }
                    } else if (slash == 2) {                                                //coordinates of slash
                        for (int k = 0; k < 3; k++) {
                            if (' ' == arrayToCheck[k][2 - k]) {
                                coordinate[0] = k;
                                coordinate[1] = 2 - k;
                                return coordinate;
                            }
                        }
                    }
                }

                horizontal += arrayToCheck[i][j] == charToCheck ? 1 : 0;                     //check horizontal
                vertical += arrayToCheck[j][i] == charToCheck ? 1 : 0;                       //check vertical

                if (horizontal == 2) {
                    for (int k = 0; k < 3; k++) {
                        if (' ' == arrayToCheck[i][k]) {
                            coordinate[0] = i;
                            coordinate[1] = k;
                            return coordinate;
                        }
                    }
                } else if (vertical == 2) {
                    for (int k = 0; k < 3; k++) {
                        if (' ' == arrayToCheck[k][i]) {
                            coordinate[0] = k;
                            coordinate[1] = i;
                            return coordinate;
                        }
                    }
                }
            }

            horizontal = 0;
            vertical = 0;
        }
        return coordinate;
    }

}

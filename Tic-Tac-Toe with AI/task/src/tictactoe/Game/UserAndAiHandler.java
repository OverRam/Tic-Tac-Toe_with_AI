package tictactoe.Game;

class UserAndAiHandler {
    private static FiledGame FIELD;
    private static char PLAYER_CHAR;

    static void handler(String modePlayer, FiledGame field, char playerChar) {
        UserAndAiHandler.FIELD = field;
        UserAndAiHandler.PLAYER_CHAR = playerChar;
        System.out.println(!modePlayer.equals("user") ? "Making move level " + "\"" + modePlayer + "\"" : "");

        switch (modePlayer) {
            case "user":
                userPlayer();
                break;
            case "easy":
                easyAiPlayer();
                break;
            case "medium":
                mediumAiPlayer();
                break;
            case "hard":
                hardAiPlayer();
                break;
            default:
                FIELD.setMark(GeneratorCell.aiGenerateCell(FIELD.getFieldToGame()), 'E');
                break;
        }
    }

    private static void userPlayer() {
        FIELD.setMark(GeneratorCell.playerSetCell(FIELD.getFieldToGame()), PLAYER_CHAR);
    }

    private static void easyAiPlayer() {
        FIELD.setMark(GeneratorCell.aiGenerateCell(FIELD.getFieldToGame()), PLAYER_CHAR);
    }

    private static void mediumAiPlayer() {
        int[] coordinatesAiToWin = aiMove(FIELD.getFieldToGame(), PLAYER_CHAR);
        if (coordinatesAiToWin[0] < 9) {
            //If it already has two in a row and can win with one further move, it does so.
            FIELD.setMark(coordinatesAiToWin, PLAYER_CHAR);
        } else {
            //If its opponent can win with one move, it plays the move necessary to block this.
            int[] blockOponent = aiMove(FIELD.getFieldToGame(),
                    PLAYER_CHAR == 'X' ? 'O' : PLAYER_CHAR == 'O' ? 'X' : 'O');
            if (blockOponent[0] < 9) {
                FIELD.setMark(blockOponent, PLAYER_CHAR);
            } else {
                //Otherwise, it makes a random move.
                easyAiPlayer();
            }
        }
    }

    private static void hardAiPlayer() {

    }

    private static int[] aiMove(char[][] arrayToCheck, char charToCheck) {
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

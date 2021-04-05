package tictactoe.Game;

import java.util.Arrays;

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
            case "hard":
                hardAiPlayer();
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
        int[] COORDINATES = aiMove(FIELD.getFieldToGame(), PLAYER_CHAR);
        if (Arrays.stream(COORDINATES).allMatch(Character::isDigit)) {
            FIELD.setMark(COORDINATES, PLAYER_CHAR);
        } else {
            easyAiPlayer();
        }
    }

    private static void hardAiPlayer() {

    }

    private static int[] aiMove(char[][] arrayToCheck, char charToCheck) {
        int slash = 0;
        int backSlash = 0;
        int horizontal = 0;
        int vertical = 0;
        int[] coordinate = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 0) {
                    backSlash += arrayToCheck[j][j] == charToCheck ? 1 : 0;                 //check back slash
                    slash += arrayToCheck[j][2 - j] == charToCheck ? 1 : 0;                 //check slash
                    if (backSlash == 2) {                                                   //coordinates of back slash
                        coordinate[0] = j;
                        coordinate[1] = j;
                        return coordinate;
                    } else if (slash == 2) {                                                //coordinates of slash
                        coordinate[0] = j;
                        coordinate[1] = 2 - j;
                    }
                }

                horizontal += arrayToCheck[i][j] == charToCheck ? 1 : 0;                     //check horizontal
                vertical += arrayToCheck[j][i] == charToCheck ? 1 : 0;                       //check vertical
                if (horizontal == 2) {
                    coordinate[0] = i;
                    coordinate[1] = j;
                    return coordinate;
                } else if (vertical == 2) {
                    coordinate[0] = j;
                    coordinate[1] = i;
                }

            }
            horizontal = 0;
            vertical = 0;
        }
        return coordinate;
    }

}

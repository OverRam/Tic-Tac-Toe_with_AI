package tictactoe.Game;

import java.util.ArrayList;

class UserAndAiHandler {

    static void handler(String modePlayer, FiledGame fieldGame, char playerChar) {
        System.out.println(!modePlayer.equals("user") ? "Making move level " + "\"" + modePlayer + "\"" : "");
        switch (modePlayer) {
            case "user":
                userPlayer(fieldGame, playerChar);
                break;
            case "easy":
                easyAiPlayer(fieldGame, playerChar);
                break;
            case "medium":
                mediumAiPlayer(fieldGame, playerChar);
                break;
            case "hard":
                hardAiPlayer(fieldGame, playerChar);
                break;
            default:
                fieldGame.setMark(GeneratorCell.aiGenerateCell(fieldGame.getFieldToGame()), 'E');
                break;
        }
    }

    private static void userPlayer(FiledGame fieldGame, char playerChar) {
        fieldGame.setMark(GeneratorCell.playerSetCell(fieldGame.getFieldToGame()), playerChar);
    }

    private static void easyAiPlayer(FiledGame fieldGame, char playerChar) {
        fieldGame.setMark(GeneratorCell.aiGenerateCell(fieldGame.getFieldToGame()), playerChar);
    }

    private static void mediumAiPlayer(FiledGame fieldGame, char playerChar) {
        int[] coordinatesAiToWin = mediumAiMove(fieldGame.getFieldToGame(), playerChar);
        if (coordinatesAiToWin[0] < 9) {
            //If it already has two in a row and can win with one further move, it does so.
            fieldGame.setMark(coordinatesAiToWin, playerChar);
        } else {
            //If its opponent can win with one move, it plays the move necessary to block this.
            int[] blockOponent = mediumAiMove(fieldGame.getFieldToGame(),
                    playerChar == 'X' ? 'O' : playerChar == 'O' ? 'X' : 'O');
            if (blockOponent[0] < 9) {
                fieldGame.setMark(blockOponent, playerChar);
            } else {
                //Otherwise, it makes a random move.
                easyAiPlayer(fieldGame, playerChar);
            }
        }
    }

    private static int[] mediumAiMove(char[][] arrayToCheck, char charToCheck) {
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


    private static void hardAiPlayer(FiledGame fieldGame, char playerChar) {
        mediumAiPlayer(fieldGame,playerChar);
        minimax(fieldGame, playerChar);
    }

    private static ArrayList<int[]> getEmptyCells(char[][] arrayToCheck) {
        ArrayList<int[]> coordinatesEmptyCells = new ArrayList<>();
        for (int i = 0; i < arrayToCheck.length; i++) {
            for (int j = 0; j < arrayToCheck.length; j++) {
                if (arrayToCheck[i][j] == ' ') {
                    coordinatesEmptyCells.add(new int[]{i, j});
                }
            }
        }
        return coordinatesEmptyCells;
    }

    private static void minimax(FiledGame fieldGame, char playerChar) {
//        int[][] arrayToTest = getEmptyCells(fieldGame.getFieldToGame()).toArray(x -> new int[x][1]);
//        System.out.println(arrayToTest.length);
    }
}

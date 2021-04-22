package tictactoe.Game;

class FindBestMove {
    static int[] bestMove(char[][] field, char playerChar) {
        int[] bestMove = new int[2];
        int bestScore = Integer.MIN_VALUE;
        char oponentChar = playerChar == 'X' ? 'O' : 'X';

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == ' ') {
                    field[i][j] = playerChar;
                    //perform minimax for all vacancies
                    int score = minimax(field, 0, false, playerChar, oponentChar);
                    if (score > bestScore) {                     //chooses the best move
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                    field[i][j] = ' ';
                }
            }
        }
        return bestMove;
    }

    private static int evaluate(char[][] arrayToCheck, char playerChar, char oponentChar) {
        int playerSlash = 0;
        int playerBackSlash = 0;
        int playerHorizontal = 0;
        int playerVertical = 0;
        int oponentSlash = 0;
        int oponentBackSlash = 0;
        int oponentHorizontal = 0;
        int oponentVertical = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                playerHorizontal += arrayToCheck[i][j] == playerChar ? 1 : 0;                //check player horizontal
                playerVertical += arrayToCheck[j][i] == playerChar ? 1 : 0;                  //check player vertical
                oponentHorizontal += arrayToCheck[i][j] == oponentChar ? 1 : 0;              //check oponent horizontal
                oponentVertical += arrayToCheck[j][i] == oponentChar ? 1 : 0;                //check oponent vertical

                if (playerHorizontal == 3 | playerVertical == 3) {
                    return 10;
                } else if (oponentHorizontal == 3 || oponentVertical == 3) {
                    return -10;
                }

                if (i == 0) {
                    playerBackSlash += arrayToCheck[j][j] == playerChar ? 1 : 0;             //check player back slash
                    playerSlash += arrayToCheck[j][2 - j] == playerChar ? 1 : 0;             //check player slash
                    oponentBackSlash += arrayToCheck[j][j] == oponentChar ? 1 : 0;           //check oponent back slash
                    oponentSlash += arrayToCheck[j][2 - j] == oponentChar ? 1 : 0;           //check oponent slash
                    if (playerSlash == 3 | playerBackSlash == 3) {
                        return 10;
                    } else if (oponentSlash == 3 | oponentBackSlash == 3) {
                        return -10;
                    }
                }
            }
            playerHorizontal = 0;
            playerVertical = 0;
            oponentHorizontal = 0;
            oponentVertical = 0;
        }
        return 0;
    }

    private static boolean isAnyMove(char[][] filed){
        for (char[] chars : filed) {
            for (int j = 0; j < filed.length; j++) {
                if (chars[j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private static int minimax(char[][] field, int depth, boolean isMax, char playerChar, char oponentChar) {
        int bestScore;
        int score = evaluate(field, playerChar, oponentChar);

        if (score == 10) {
            return 10 - depth;
        } else if (score == -10) {
            return -10 + depth;
        }else if (!isAnyMove(field)){
            return 0;
        }

        if (isMax) {  //max player
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == ' ') {
                        field[i][j] = playerChar;
                        bestScore = Math.max(bestScore,
                                minimax(field, depth + 1, false, playerChar, oponentChar));
                        field[i][j] = ' ';
                    }
                }
            }
        } else { // min player
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == ' ') {
                        field[i][j] = oponentChar;
                        bestScore = Math.min(bestScore,
                                minimax(field, depth + 1, true, playerChar, oponentChar));
                        field[i][j] = ' ';
                    }
                }
            }
        }

        return bestScore;
    }
}

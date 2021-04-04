package tictactoe.Game;

import java.util.Arrays;
import java.util.Scanner;

public class GameTicTacToe {

    public void gameMenu() {
        final Scanner sc = new Scanner(System.in);
        String inputParamsPlayer;
        boolean isPlay = true;
        boolean isGoodParam = true;
        String[] playerParams;

        while (isPlay) {
            System.out.print("Input command: ");
            inputParamsPlayer = sc.nextLine();
            playerParams = inputParamsPlayer.split(" ");
            if ("exit".equals(playerParams[0])) {
                isGoodParam = false;
                isPlay = false;
            } else if ("start".equals(playerParams[0])) {
                isGoodParam = CheckParamsToStartProgram.checkInputParams(playerParams);
            }

            System.out.print(isGoodParam ? "" : "exit".equals(playerParams[0]) ? "" : "Bad parameters!\n");

            if (isGoodParam) {
                runGame(new String[]{playerParams[1], playerParams[2]});
            }
        }

        sc.close();
    }


    private void runGame(String[] gamers) {
        FiledGame filedGame = new FiledGame();
        int player = 0;
        boolean isNoWin = true;
        char playerChar;
        PrintGameField.print(filedGame.getFieldToGame());

        while (isNoWin) {
            playerChar = setPlayerChar(player);
            PlayersHandler.handler(gamers[player % 2], filedGame, player, playerChar);
            PrintGameField.print(filedGame.getFieldToGame());
            isNoWin = !checkWinCombination(filedGame.getFieldToGame(), playerChar);
            player++;

            if (player <= 9 && !isNoWin) {
                System.out.print(playerChar + " wins\n");
                isNoWin = false;
            } else if (player == 9) {
                System.out.println("Draw");
                isNoWin = false;
            }

        }
    }

    private boolean checkWinCombination(char[][] arrayToCheck, char charToCheck) {
        int slash = 0;
        int backSlash = 0;

        for (int i = 0; i < 3; i++) {
            int horizontal = 0;
            int vertical = 0;

            for (int j = 0; j < 3; j++) {

                horizontal += arrayToCheck[i][j] == charToCheck ? 1 : 0;             //check horizontal
                vertical += arrayToCheck[j][i] == charToCheck ? 1 : 0;               //check vertical
                if (horizontal == 3 | vertical == 3) {
                    return true;
                }
            }
            backSlash += arrayToCheck[i][i] == charToCheck ? 1 : 0;                    //check back slash
            slash += arrayToCheck[i][2 - i] == charToCheck ? 1 : 0;                     //check slash
        }
        return slash == 3 | backSlash == 3;
    }

    private char setPlayerChar(int player) {
        return player % 2 == 0 ? 'X' : 'O';
    }
}
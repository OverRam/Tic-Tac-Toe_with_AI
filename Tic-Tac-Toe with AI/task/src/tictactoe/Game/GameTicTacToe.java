package tictactoe.Game;

import java.util.Scanner;

public class GameTicTacToe {

    public void startGameMenu() {
        final Scanner sc = new Scanner(System.in);
        boolean isPlay = true;
        boolean isGoodParam = false;
        String[] playerParams;

        while (isPlay) {
            System.out.print("Input command: ");
            playerParams = sc.nextLine().split(" ");

            if (playerParams.length == 3 | (playerParams.length == 1 && playerParams[0].equals("exit"))) {
                if ("exit".equals(playerParams[0])) {
                    isPlay = false;
                } else if ("start".equals(playerParams[0])) {
                    isGoodParam = CheckParamsToStartProgram.checkInputParams(playerParams);
                }

                if (isGoodParam) {
                    startGame(new String[]{playerParams[1], playerParams[2]});
                }
            }
            System.out.print(isGoodParam | "exit".equals(playerParams[0]) ? "" : "Bad parameters!\n");
            isGoodParam = false;
        }
        sc.close();
    }

    private void startGame(String[] gamers) {
        FiledGame filedGame = new FiledGame();
        int player = 0;
        boolean isNoWin = true;
        char playerChar;
        PrintGameField.print(filedGame.getField());
        int checkWin;

        while (isNoWin) {
            playerChar = player % 2 == 0 ? 'X' : 'O';
            UserAndAiHandler.handler(gamers[player % 2], filedGame, playerChar);
            PrintGameField.print(filedGame.getField());
            checkWin = CheckWinCombination.checkCombination(filedGame.getField(), playerChar);
            isNoWin = checkWin != -1;
            player++;

            if (checkWin == 10 || checkWin == 0) {
                System.out.println(checkWin == 10 ? playerChar + " wins" : "Draw");
                isNoWin = false;
            }
        }
    }
}
package tictactoe.Game;

import java.util.Scanner;

public class GameTicTacToe {

    public void startGameMenu() {
        final Scanner sc = new Scanner(System.in);
        String inputParamsPlayer;
        boolean isPlay = true;
        boolean isGoodParam = false;
        String[] playerParams;

        while (isPlay) {
            System.out.print("Input command: ");
            inputParamsPlayer = sc.nextLine();
            playerParams = inputParamsPlayer.split(" ");

            if ("exit".equals(playerParams[0])) {
                System.out.println("exit");
                isGoodParam = false;
                isPlay = false;
            } else if ("start".equals(playerParams[0])) {
                isGoodParam = CheckParamsToStartProgram.checkInputParams(playerParams);
            }

            System.out.print(isGoodParam ? "" : "exit".equals(playerParams[0]) ? "" : "Bad parameters!\n");

            if (isGoodParam) {
                startGame(new String[]{playerParams[1], playerParams[2]});
            }
        }
        sc.close();
    }

    private void startGame(String[] gamers) {
        FiledGame filedGame = new FiledGame();
        int player = 0;
        boolean isNoWin = true;
        char playerChar;
        PrintGameField.print(filedGame.getFieldToGame());
        int checkWin;

        while (isNoWin) {
            playerChar = player % 2 == 0 ? 'X' : 'O';
            UserAndAiHandler.handler(gamers[player % 2], filedGame, playerChar);
            PrintGameField.print(filedGame.getFieldToGame());
            checkWin = CheckWinCombination.checkCombination(filedGame.getFieldToGame(), playerChar);
            isNoWin = checkWin != -1;
            player++;
            System.out.println(checkWin);
            if (checkWin == 10 || checkWin == 0) {
                System.out.println(checkWin == 10 ? playerChar + " wins" : "Draw");
                isNoWin = false;
            }
        }
    }
}
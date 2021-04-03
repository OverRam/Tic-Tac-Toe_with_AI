package tictactoe.Game;

import java.util.Scanner;

public class GameTicTacToe {

    public void gameMenu() {
        System.out.println("Input command: ");
        String[] inputParams = new String[3];
        Scanner sc = new Scanner(System.in);
        boolean isBadParam = true;

        while (isBadParam) {
            inputParams = sc.nextLine().split(" ");
            isBadParam = !CheckParamsToStartProgram.checkInputParams(inputParams);
            System.out.print(isBadParam ? "Bad parameters!\n" : "");
        }
        String[] playersParams = {inputParams[1], inputParams[2]};
        runGame(playersParams);
        sc.close();
    }

    private void runGame(String[] playersParams) {
        FiledGame filedGame = new FiledGame();
        int player = 0;
        boolean isNotEnd = true;
        char playerChar = 'E';

        PrintGameField.print(filedGame.getFieldToGame());
        while (isNotEnd) {
            playerChar = setPlayerChar(player);

            if (player == 9) {
                isNotEnd = false;
                System.out.println("Draw");
            } else {
                PlayersHandler.handler(playersParams[player % 2], filedGame, player, playerChar);
                PrintGameField.print(filedGame.getFieldToGame());
                isNotEnd = !checkWinCombination(filedGame.getFieldToGame(), playerChar);
                player++;
            }

        }
        System.out.println(playerChar + " wins");
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
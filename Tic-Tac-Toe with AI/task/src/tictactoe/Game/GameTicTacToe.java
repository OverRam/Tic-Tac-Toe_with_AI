package tictactoe.Game;

public class GameTicTacToe {

    public void runGame() {
        FiledGame filedGame = new FiledGame();
        int player = 0;
        String level = "\"easy\"";
        boolean isNotEnd = true;
        PrintGameField.print(filedGame.getFieldToGame());

        while (isNotEnd) {
            char playerChar = setPlayerChar(player);
            boolean checkWin = checkWinCombination(filedGame.getFieldToGame(), playerChar);

            if (checkWin) {
                System.out.println(playerChar + " wins");
                isNotEnd = false;
            } else if (player == 8) {
                isNotEnd = false;
                System.out.println("Draw");
            } else if (playerChar == 'X') {
                //Player play
                filedGame.setMark(GeneratorCell.playerGenerateCell(filedGame.getFieldToGame()), setPlayerChar(player));
                PrintGameField.print(filedGame.getFieldToGame());
                player++;
            } else if (playerChar == 'O') {
                playerChar = setPlayerChar(player);
                //Ai play
                filedGame.setMark(GeneratorCell.aiGenerateCell(filedGame.getFieldToGame(), level), playerChar);
                PrintGameField.print(filedGame.getFieldToGame());
                player++;
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
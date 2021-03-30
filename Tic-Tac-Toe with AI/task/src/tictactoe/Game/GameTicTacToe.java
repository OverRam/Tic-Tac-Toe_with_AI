package tictactoe.Game;

public class GameTicTacToe {

    public void runGame() {
        FiledGame filedGame = new FiledGame();
        int[] coordinates = new int[2];
        int player = 0;
        String level = "\"easy\"";
        boolean isNotEnd = true;

        while (isNotEnd) {
            PrintGameField.print(filedGame.getFieldToGame());

            char playerChar = setPlayerChar(player);
            filedGame.setMark(GeneratorCell.playerGenerateCell(filedGame.getFieldToGame()),setPlayerChar(player));

            PrintGameField.print(filedGame.getFieldToGame());

            if (checkWinCombination(filedGame.getFieldToGame(), playerChar)) {
                System.out.println(playerChar + " wins");
                isNotEnd = false;
            } else if (player == 9) {
                isNotEnd = false;
                System.out.println("Draw");
            } else {
                player++;
                playerChar = setPlayerChar(player);
                filedGame.setMark(GeneratorCell.aiGenerateCell(filedGame.getFieldToGame(), level),playerChar);
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

    char setPlayerChar(int player){
        return player % 2 == 0 ? 'X' : 'O';
    }
}
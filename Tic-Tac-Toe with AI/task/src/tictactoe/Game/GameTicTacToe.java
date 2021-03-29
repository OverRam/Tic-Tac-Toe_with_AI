package tictactoe.Game;

public class GameTicTacToe {

    public void run() {

        FiledGame filedGame = new FiledGame();
        int[] coordinates = new int[2];
        System.out.print("Enter the cells: ");
        //gets from user initial char grid
        String initialCharsFillField = InputUser.getInitialFillField();

        //get player move even = O, odd  = X
        int player = (int) initialCharsFillField.chars().filter(e -> e != '_').count();

        //draw initial grid
        FirstFillFieldByUser.firstFillField(filedGame.getFieldToGame(), initialCharsFillField.toCharArray());
        PrintGameField.print(filedGame.getFieldToGame());

        boolean isNotEnd = true;
        while (isNotEnd) {

            boolean isGoodCoordinates = true;
            while (isGoodCoordinates) {
                System.out.print("Enter the coordinates: ");
                coordinates = InputUser.getCoordinates();
                //checks if the field provided by the user is free
                isGoodCoordinates = !IsGoodCellToMark.isGood(filedGame.getFieldToGame(), coordinates);
            }

            char playerChar = player % 2 == 0 ? 'X' : 'O';
            filedGame.setMarkOnField(coordinates, playerChar);
            PrintGameField.print(filedGame.getFieldToGame());

            if (player == 9) {
                isNotEnd = false;
                System.out.println("Draw");
            } else if (checkWinCombination(filedGame.getFieldToGame(), playerChar)) {
                System.out.println(playerChar + " wins");
                isNotEnd = false;
            } else {
                System.out.println("Game not finished");
//                player++;
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
}
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
        int horizontal;
        int vertical;
        for (int i = 0; i < 3; i++) {
            horizontal = 0;
            vertical = 0;
            for (int j = 0; j < 3; j++) {
                if (arrayToCheck[i][j] == charToCheck) {                //check horizontal
                    horizontal++;
                    if (horizontal == 3) {
                        return true;
                    }
                }

                if (arrayToCheck[j][i] == charToCheck) {                //check vertical
                    vertical++;
                    if (vertical == 3) {
                        return true;
                    }
                }

                if (i == j && arrayToCheck[j][i] == charToCheck) {       //check back slash
                    backSlash++;
                    if (backSlash == 3) {
                        return true;
                    }
                }
            }
            if (arrayToCheck[i][2 - i] == charToCheck) {           //check slash
                slash++;
                if (slash == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
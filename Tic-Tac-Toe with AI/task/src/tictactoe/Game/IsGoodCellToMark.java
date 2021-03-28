package tictactoe.Game;

class IsGoodCellToMark {
    static void isGood(char[][] filedToCheck, int[] coordinates, int player) {
        boolean isTrue = true;
        while (isTrue){
            if (filedToCheck[coordinates[0]][coordinates[1]] != ' ') {
                if (player % 2 == 0) {
                    filedToCheck[coordinates[0]][coordinates[1]] = 'X';
                } else {
                    filedToCheck[coordinates[0]][coordinates[1]] = 'O';
                }
                isTrue = false;
            }else {
                System.out.println("This cell is occupied! Choose another one!");
                coordinates = InputCoordinates.getCoordinates();
            }
        }

    }
}

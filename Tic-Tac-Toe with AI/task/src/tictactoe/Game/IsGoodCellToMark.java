package tictactoe.Game;

class IsGoodCellToMark {
    static boolean isGood(char[][] filedToCheck, int[] coordinates) {
        if (filedToCheck[coordinates[0]][coordinates[1]] == ' ') {
            return true;
        }
        System.out.println("This cell is occupied! Choose another one!");
        return false;
    }
}

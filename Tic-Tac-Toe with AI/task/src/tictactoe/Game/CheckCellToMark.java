package tictactoe.Game;

class CheckCellToMark {
    static boolean isBadCell(char[][] filedToCheck, int[] coordinates, boolean isPlayer) {
        if (filedToCheck[coordinates[0]][coordinates[1]] == ' ') {
            return false;
        }
        System.out.print(isPlayer ? "This cell is occupied! Choose another one!\n" : "");
        return true;
    }
}

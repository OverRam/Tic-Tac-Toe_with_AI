package tictactoe.Game;

class FiledGame {
    private final char[][] fieldToGame = new char[3][3];

    public char[][] getFieldToGame() {
        return fieldToGame;
    }

    public void setMarkOnField(int[] coordinates, char mark) {
        this.fieldToGame[coordinates[0]][coordinates[1]] = mark;
    }
}

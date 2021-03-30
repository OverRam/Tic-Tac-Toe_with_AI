package tictactoe.Game;

class FiledGame {
    private final char[][] fieldToGame;

    FiledGame() {
        fieldToGame = new char[3][3];
        for (int i = 0; i < fieldToGame.length; i++) {
            for (int j = 0; j < fieldToGame.length; j++) {
                fieldToGame[i][j] = ' ';
            }
        }
    }

    char[][] getFieldToGame() {
        return fieldToGame;
    }

    void setMark(int[] coordinates, char mark) {
        this.fieldToGame[coordinates[0]][coordinates[1]] = mark;
    }

}

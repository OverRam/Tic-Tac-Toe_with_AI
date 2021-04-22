package tictactoe.Game;

class FiledGame {
    private final char[][] field;

    FiledGame() {
        field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
    }

    char[][] getField() {
        return field;
    }

    void setMark(int[] coordinates, char mark) {
        this.field[coordinates[0]][coordinates[1]] = mark;
    }

}

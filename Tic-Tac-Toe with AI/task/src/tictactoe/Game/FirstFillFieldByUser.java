package tictactoe.Game;

class FirstFillFieldByUser {
    static void firstFillField(char[][] filedToFill, char[] initialChars) {
        for (int i = 0, c = 0; i < filedToFill.length; i++) {
            for (int j = 0; j < filedToFill.length; j++) {
                if (initialChars[c] != '_') {
                    filedToFill[i][j] = initialChars[c];
                }
                c++;
            }
        }
    }
}

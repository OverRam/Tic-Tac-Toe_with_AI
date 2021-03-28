package tictactoe.Game;

class PrintGameField {

    static void print(char[][] filedGame) {
        System.out.println("---------");
        for (char[] chars : filedGame) {
            for (int j = 0; j < filedGame.length; j++) {
                if (j == 0) {
                    System.out.print("| " + chars[j] + " ");
                } else if (j == 2) {
                    System.out.print(chars[j] + " |");
                } else {
                    System.out.print(chars[j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}

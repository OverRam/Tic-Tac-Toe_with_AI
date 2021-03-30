package tictactoe.Game;

class PrintGameField {
    static void print(char[][] filedGame) {
        System.out.println("---------");
        for (char[] chars : filedGame) {
            System.out.print("| ");
            for (char s : chars) {
                System.out.print(s + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}

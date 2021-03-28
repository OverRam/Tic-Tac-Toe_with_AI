package tictactoe.Game;

import java.util.Scanner;

public class GameTicTacToe {
    private FiledGame filedGame = new FiledGame();
    private final Scanner sc = new Scanner(System.in);

    public GameTicTacToe() {
        System.out.println("Enter the cells: ");
        FirstFillFieldByUser.firstFillField(filedGame.getFieldToGame(),sc.nextLine().toUpperCase());
        PrintGameField.print(filedGame.getFieldToGame());
    }
}

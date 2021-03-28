package tictactoe.Game;

import java.util.Scanner;

public class GameTicTacToe {

    public GameTicTacToe() {
        Scanner sc = new Scanner(System.in);
        FiledGame filedGame = new FiledGame();
        int[] coordinates;
        int player = 0;

        System.out.println("Enter the cells: ");

        FirstFillFieldByUser.firstFillField(filedGame.getFieldToGame(), sc.nextLine().toUpperCase());
        PrintGameField.print(filedGame.getFieldToGame());


        coordinates = InputCoordinates.getCoordinates();
        IsGoodCellToMark.isGood(filedGame.getFieldToGame(), coordinates, player);


    }
}

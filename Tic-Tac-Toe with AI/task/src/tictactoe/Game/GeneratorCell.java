package tictactoe.Game;

import java.util.Random;

public class GeneratorCell {
    static int[] playerGenerateCell(char[][] filedGame) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        while (isGoodCoordinates) {
            System.out.print("Enter the coordinates: ");
            coordinates = HandlerCoordinates.getCoordinates();
            //checks if the field provided by the user is free
            isGoodCoordinates = IsBadCellToMark.isBadCell(filedGame, coordinates, true);
        }
        return coordinates;
    }

    static int[] aiGenerateCell(char[][] filedGame,String difficultLevel) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        Random random = new Random();
        System.out.println("Making move level " + difficultLevel);
        while (isGoodCoordinates) {
            coordinates[0] = random.nextInt(3);
            coordinates[1] = random.nextInt(3);
            //checks if the field provided by the user is free
            isGoodCoordinates = IsBadCellToMark.isBadCell(filedGame, coordinates, false);
        }
        return coordinates;
    }
}

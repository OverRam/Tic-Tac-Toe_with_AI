package tictactoe.Game;

public class GeneratorCell {
    static int[] playerGenerateCell(char[][] filedGame) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        while (isGoodCoordinates) {
            System.out.print("Enter the coordinates: ");
            coordinates = InputUser.getCoordinates();
            //checks if the field provided by the user is free
            isGoodCoordinates = !IsGoodCellToMark.isGood(filedGame, coordinates);
        }
        return coordinates;
    }

    static int[] aiGenerateCell(char[][] filedGame,String difficultLevel) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        System.out.println("Making move level " + difficultLevel);
        while (isGoodCoordinates) {
            coordinates = InputUser.getCoordinates();
            //checks if the field provided by the user is free
            isGoodCoordinates = !IsGoodCellToMark.isGood(filedGame, coordinates);
        }
        return coordinates;
    }
}

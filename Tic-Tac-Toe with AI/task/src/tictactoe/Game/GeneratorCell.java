package tictactoe.Game;

public class GeneratorCell {
    static int[] playerGenerateCell(FiledGame filedGame) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        while (isGoodCoordinates) {
            System.out.print("Enter the coordinates: ");
            coordinates = InputUser.getCoordinates();
            //checks if the field provided by the user is free
            isGoodCoordinates = !IsGoodCellToMark.isGood(filedGame.getFieldToGame(), coordinates);
        }
        return coordinates;
    }

    static int[] aiGenerateCell(FiledGame filedGame,String difficultLevel) {
        boolean isGoodCoordinates = true;
        int[] coordinates = new int[2];
        while (isGoodCoordinates) {
            coordinates = InputUser.getCoordinates();
            //checks if the field provided by the user is free
            isGoodCoordinates = !IsGoodCellToMark.isGood(filedGame.getFieldToGame(), coordinates);
        }
        System.out.println("Making move level " + difficultLevel);
        return coordinates;
    }
}

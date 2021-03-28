package tictactoe.Game;

class CheckCoordinatesFromUser {
    static boolean checkCoordinates(int[] coordinates) {
        return coordinates[0] >= 0 & coordinates[0] < 3 & coordinates[1] >= 0 & coordinates[1] < 3;
    }
}

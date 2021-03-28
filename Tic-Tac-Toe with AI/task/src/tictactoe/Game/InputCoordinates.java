package tictactoe.Game;

import java.util.Scanner;

class InputCoordinates {

    static int[] getCoordinates() {
        String inp = new Scanner(System.in).nextLine();
        boolean isBadCoordinate = true;
        int[] coordinate = new int[2];
        String[] string = inp.split(" ");

        while (isBadCoordinate) {
            try {
                coordinate[0] = Integer.parseInt(string[0]);
                coordinate[1] = Integer.parseInt(string[1]);
                if(CheckCoordinatesFromUser.checkCoordinates(coordinate)){
                    isBadCoordinate = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
        return coordinate;
    }
}

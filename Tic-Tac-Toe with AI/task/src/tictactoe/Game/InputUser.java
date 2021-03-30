package tictactoe.Game;

import java.util.Scanner;

class InputUser {

    static int[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
        boolean isBadCoordinate = true;
        int[] coordinate = new int[2];

        while (isBadCoordinate) {
            try {
                String[] string = sc.nextLine().split(" ");
                coordinate[0] = Integer.parseInt(string[0]) - 1;
                coordinate[1] = Integer.parseInt(string[1]) - 1;
                if (CheckCoordinatesFromUser.checkCoordinates(coordinate)) {
                    isBadCoordinate = false;
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                System.out.print("Enter the coordinates: ");
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("You should enter two numbers!");
                System.out.print("Enter the coordinates: ");
            }
        }
        return coordinate;
    }

    static String getInitialFillField() {
        String initString = "";
        boolean isTrue = true;
        while (isTrue) {
            initString = new Scanner(System.in).nextLine().toUpperCase().trim();
            if (initString.length() != 9) {
                System.out.println("Error! You should enter 9 chars! Try again");
            } else {
                isTrue = false;
            }
        }
        return initString;
    }
}

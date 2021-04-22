package tictactoe.Game;

class UserAndAiHandler {

    static void handler(String modePlayer, FiledGame fieldGame, char playerChar) {
        System.out.println(!modePlayer.equals("user") ? "Making move level " + "\"" + modePlayer + "\"" : "");
        switch (modePlayer) {
            case "user":
                userPlayer(fieldGame, playerChar);
                break;
            case "easy":
                easyAiPlayer(fieldGame, playerChar);
                break;
            case "medium":
                mediumAiPlayer(fieldGame, playerChar);
                break;
            case "hard":
                hardAiPlayer(fieldGame, playerChar);
                break;
            default:
                fieldGame.setMark(GeneratorCell.aiGenerateCell(fieldGame.getField()), 'E');
                break;
        }
    }

    private static void userPlayer(FiledGame fieldGame, char playerChar) {
        fieldGame.setMark(GeneratorCell.playerSetCell(fieldGame.getField()), playerChar);
    }

    private static void easyAiPlayer(FiledGame fieldGame, char playerChar) {
        fieldGame.setMark(GeneratorCell.aiGenerateCell(fieldGame.getField()), playerChar);
    }

    private static void mediumAiPlayer(FiledGame fieldGame, char playerChar) {
        int[] coordinatesAiToWin = MediumAi.mediumAiMove(fieldGame.getField(), playerChar);
        if (coordinatesAiToWin[0] < 9) {
            //If it already has two in a row and can win with one further move, it does so.
            fieldGame.setMark(coordinatesAiToWin, playerChar);
        } else {
            //If its opponent can win with one move, it plays the move necessary to block this.
            int[] blockOponent = MediumAi.mediumAiMove(fieldGame.getField(),
                    playerChar == 'X' ? 'O' : playerChar == 'O' ? 'X' : 'O');
            if (blockOponent[0] < 9) {
                fieldGame.setMark(blockOponent, playerChar);
            } else {
                //Otherwise, it makes a random move.
                easyAiPlayer(fieldGame, playerChar);
            }
        }
    }

    private static void hardAiPlayer(FiledGame fieldGame, char playerChar) {
        int[] move = FindBestMove.bestMove(fieldGame.getField(), playerChar);
        fieldGame.setMark(move, playerChar);
    }
}

package tictactoe.Game;

class PlayersHandler {
    private static String MODE;
    private static FiledGame FIELD;
    private static char PLAYER_CHAR;

    static void handler(String modePlayer, FiledGame field, char playerChar) {
        PlayersHandler.MODE = modePlayer;
        PlayersHandler.FIELD = field;
        PlayersHandler.PLAYER_CHAR = playerChar;

        switch (modePlayer) {
            case "user":
                userPlayer();
                break;
            case "easy":
                easyAiPlayer();
                break;
            default:
                FIELD.setMark(GeneratorCell.aiGenerateCell(FIELD.getFieldToGame(), MODE), 'E');
                break;
        }
    }

    private static void userPlayer() {
        FIELD.setMark(GeneratorCell.playerGenerateCell(FIELD.getFieldToGame()), PLAYER_CHAR);
    }

    private static void easyAiPlayer() {
        FIELD.setMark(GeneratorCell.aiGenerateCell(FIELD.getFieldToGame(), MODE), PLAYER_CHAR);
    }

    private static void mediumAiPlayer() {

    }

    private static void hardAiPlayer() {

    }

}

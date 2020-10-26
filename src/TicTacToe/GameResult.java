package TicTacToe;

public class GameResult {

    public String getGameMessageXWon() {
        return "X won";
    }

    public String getGameResult(String boardStructure, String boardSize, String board) {
        return board.equals(boardSize + boardStructure) ? getGameMessageXWon() : getGameMessageNodyWon();
    }

    private String getGameMessageNodyWon() {
        return "Nobody won";
    }
}

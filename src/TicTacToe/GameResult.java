package TicTacToe;

public class GameResult {

    public String getGameMessageXWon() {
        return "X won";
    }

    public String getGameResult(Board board) {
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? getGameMessageXWon() : getGameMessageNodyWon();
    }

    private String getGameMessageNodyWon() {
        return "Nobody won";
    }
}

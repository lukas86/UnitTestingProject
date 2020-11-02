package TicTacToe;

public class GameResult {

    public String getGameMessageXWon() {
        return "X won";
    }

    public String getGameResult(Board board) {
        return board.getBoard().equals(board.getBoardSize() + board.getBoardStructure()) ? getGameMessageXWon() : getGameMessageNodyWon();
    }

    private String getGameMessageNodyWon() {
        return "Nobody won";
    }
}

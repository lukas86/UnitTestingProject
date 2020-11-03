package TicTacToe;

public class GameResult {

    public String getGameMessageXWon() {
        return "X won";
    }

    private String getGameMessageNobodyWon() {
        return "Nobody won";
    }

    public String getGameResult(Board board) {
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? getGameMessageXWon() : getGameMessageNobodyWon();
    }

}

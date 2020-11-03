package TicTacToe;

public class GameResult {
    /**
     * When duplication is getting funneled to same class, it's a good thing
     * When the duplication comes into the same class, we increase the cohesion of the code
     */

    public String getGameMessageXWon() {
        return "X won";
    }

    private String getGameMessageNobodyWon() {
        return "Nobody won";
    }

    public String getGameResult(Board board) {
        BoardStructure boardStructure = new BoardStructure();
        String currentBoard = boardStructure.getEmptyBoard();
        if(currentBoard.equals(boardStructure.getEmptyBoard())) {
            return "Nobody won";
        }
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? getGameMessageXWon() : getGameMessageNobodyWon();
    }

}

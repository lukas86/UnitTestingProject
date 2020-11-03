package TicTacToe;

public class GameResult {
    /**
     * When duplication is getting funneled to same class, it's a good thing
     * When the duplication comes into the same class, we increase the cohesion of the code
     */
    String getGameResult(String emptyBoard) {
        String gameResultTemp = "";
        String currentBoard = emptyBoard;
        if(currentBoard.equals(emptyBoard)) {
            gameResultTemp = "Nobody won";
        }
        return gameResultTemp;
    }

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

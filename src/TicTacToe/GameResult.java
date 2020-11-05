package TicTacToe;

/**
 * When duplication is funneled into the same class, it is a good thing
 */
public class GameResult {
    private final BoardStructure boardStructure;
    private final GameMessage gameMessage;

    public GameResult(GameMessage gameMessage, BoardStructure boardStructure) {
        this.gameMessage = gameMessage;
        this.boardStructure = boardStructure;
    }

    public String getGameResult(Board board) {
        String currentBoard = board.getStructure();
        if (currentBoard.equals(boardStructure.getEmptyBoard())) {
            return new GameMessage().getGameMessageNobodyWon();
        }
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? gameMessage.getGameMessageXWon() : new GameMessage().getGameMessageNobodyWon();
    }
}

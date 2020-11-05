package TicTacToe;

/**
 * When duplication is funneled into the same class, it is a good thing
 */
public class GameResult {

    public String getGameResult(Board board) {
        BoardStructure boardStructure = new BoardStructure();
        String currentBoard = board.getStructure();
        if (currentBoard.equals(boardStructure.getEmptyBoard())) {
            return new GameMessage().getGameMessageNobodyWon();
        }
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? new GameMessage().getGameMessageXWon() : new GameMessage().getGameMessageNobodyWon();
    }
}

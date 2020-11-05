package TicTacToe;

/**
 * When duplication is funneled into the same class, it is a good thing
 */
public class GameResult {
    GameMessage gameMessage;

    public GameResult(GameMessage gameMessage) {
        this.gameMessage = gameMessage;
    }

    public String getGameResult(Board board) {
        //TODO : extract new BoardStructure to outside of this class
        BoardStructure boardStructure = new BoardStructure();
        String currentBoard = board.getStructure();
        if (currentBoard.equals(boardStructure.getEmptyBoard())) {
            return new GameMessage().getGameMessageNobodyWon();
        }
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? gameMessage.getGameMessageXWon() : new GameMessage().getGameMessageNobodyWon();
    }
}

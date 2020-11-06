package TicTacToe;

public class GameResult {
    private final BoardStructure boardStructure;
    private final GameMessage gameMessage;

    public GameResult(GameMessage gameMessage, BoardStructure boardStructure) {
        this.gameMessage = gameMessage;
        this.boardStructure = boardStructure;
    }

    public String getGameResult(Board board) {
        if (getGameResultForEmptyBoard(board)) return new GameMessage().getGameMessageNobodyWon();
        return getGameMessageForNonEmptyBoard(board);
    }

    public boolean getGameResultForEmptyBoard(Board board) {
        return board.getStructure().equals(boardStructure.getEmptyBoard());
    }

    public String getGameMessageForNonEmptyBoard(Board board) {
        return board.getTemplate().equals(board.getSize() + board.getStructure()) ? gameMessage.getGameMessageXWon() : new GameMessage().getGameMessageNobodyWon();
    }
}

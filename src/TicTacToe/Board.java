package TicTacToe;

public class Board {
    private final String boardStructure;
    private final String boardSize;
    private final String board;

    public Board(String boardStructure, String boardSize, String board) {
        this.boardStructure = boardStructure;
        this.boardSize = boardSize;
        this.board = board;
    }

    public String getBoardStructure() {
        return boardStructure;
    }

    public String getBoardSize() {
        return boardSize;
    }

    public String getBoard() {
        return board;
    }
}

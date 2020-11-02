package TicTacToe;

import TicTacToe.Board;

public class BoardBuilder {

    private final String column = "column";
    private final String space = " ";

    private String buildBoardStructure(String tokenVicinityPosition, String direction) {
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    private String buildBoardRepresentation(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    public Board build(String boardSize, String tokenVicinityPosition, String direction) {
        String boardStructure = buildBoardStructure(tokenVicinityPosition, direction);
        String board = buildBoardRepresentation(boardSize, boardStructure);
        return new Board(boardStructure, boardSize, board);
    }
}

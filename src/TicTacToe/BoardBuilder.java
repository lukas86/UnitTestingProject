package TicTacToe;

import TicTacToe.Board;

public class BoardBuilder {
    private String buildBoardRepresentation(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    private String buildBoardStructure(String tokenVicinityPosition, String direction) {
        String column = "column";
        String space = " ";
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    public Board buildBoardRepresentation(String boardTwoByTwo, String s, String right) {
        String boardSize = boardTwoByTwo;
        String boardStructure = buildBoardStructure(s, right);
        String board = buildBoardRepresentation(boardSize, boardStructure);
        return new Board(boardStructure, boardSize, board);
    }
}

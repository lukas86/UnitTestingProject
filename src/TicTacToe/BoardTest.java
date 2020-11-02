package TicTacToe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void canBuildBoardWithCorrectBoardStructure() {
        String boardStructure = "correct board structure";
        Board board = new Board(boardStructure);

        String actual = board.getStructure();

        assertEquals(boardStructure, actual);
    }

    @Test
    void canBuildBoardWithBoardSize() {
        String boardSize = "correct size";
        String boardStructureDoesNotMatter = "board structure doesn't matter";
        Board board = new Board(boardStructureDoesNotMatter, boardSize);

        String actual = board.getSize();

        assertEquals(boardSize, actual);
    }

    @Test
    void canBuildBoardWithBoardTemplate() {
        String boardTemplate = "correct template";
        String boardStructureDoesNotMatter = "board structure doesn't matter";
        String boardSizeDoesNotMatter = "board size doesn't matter";

        Board board = new Board(boardStructureDoesNotMatter, boardSizeDoesNotMatter, boardTemplate);

        String actual = board.getTemplate();

        assertEquals(boardTemplate, actual);
    }

}
package TicTacToe.tests;

import TicTacToe.Board;
import TicTacToe.BoardBuilder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private BoardBuilder boardBuilder;

    @BeforeEach
    void setup() {
        boardBuilder = new BoardBuilder();
    }

    @Test
    void canBuildBoardWithBoardStructure() {
        String boardStructure = "correct board structure";
        Board board = boardBuilder.withStructure(boardStructure).build();

        String actual = board.getStructure();

        assertEquals(boardStructure, actual);
    }

    @Test
    void canBuildBoardWithBoardSize() {
        String boardSize = "correct size";
        Board board = boardBuilder.withSize(boardSize).build();

        String actual = board.getSize();

        assertEquals(boardSize, actual);
    }

    @Test
    void canBuildBoardWithBoardTemplate() {
        String boardTemplate = "correct template";
        Board board = boardBuilder.withTemplate(boardTemplate).build();

        String actual = board.getTemplate();

        assertEquals(boardTemplate, actual);
    }

    @Test
    void boardInstanceIsEqualToItself() {
        Board board = boardBuilder.withStructure("good")
                .withStructure("good")
                .withTemplate("very good")
                .build();

        assertEquals(board, board);
    }

    @Test
    void twoBoardInstancesWithSameValuesAreEqual() {
        Board firstBoard = boardBuilder.withStructure("good")
                .withStructure("good size")
                .withTemplate("good template")
                .build();

        Board secondBoard = boardBuilder.withStructure("good")
                .withStructure("good size")
                .withTemplate("good template")
                .build();
        assertEquals(firstBoard, secondBoard);
    }

    @Test
    void twoBoardInstancesWithDifferentValuesAreNotEqual() {
        Board firstBoard = boardBuilder.withStructure("good 1")
                .withStructure("good size 1")
                .withTemplate("good template 1")
                .build();

        Board secondBoard = boardBuilder.withStructure("good 2")
                .withStructure("good size 2")
                .withTemplate("good template 2")
                .build();
        assertNotEquals(firstBoard, secondBoard);

    }

}
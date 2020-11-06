package TicTacToe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    BoardBuilder boardBuilder;

    @BeforeEach
    void setup() {
        boardBuilder = new BoardBuilder();
    }

    @Test
    void canBuildWithBoardStructure() {
        String boardStructure = "correct structure";
        Board board = boardBuilder.withSize(boardStructure).build();

        String actual = board.getStructure();

        assertEquals(boardStructure, actual);
    }

    @Test
    void canBuildWithBoardSize() {
        String boardSize = "correct size";
        Board board = boardBuilder.withSize(boardSize).build();

        String actual = board.getSize();

        assertEquals(boardSize, actual);
    }

    @Test
    void canBuildWithBoardTemplate() {
        String boardTemplate = "correct size";
        Board board = boardBuilder.withTemplate(boardTemplate).build();

        String actual = board.getSize();

        assertEquals(boardTemplate, actual);
    }

    @Test
    void boardInstanceIsEqualToItself() {
        Board board = boardBuilder.withStructure("good")
                .withSize("good")
                .withTemplate("very good")
                .build();

        assertEquals(board, board);
    }

    @Test
    void twoBoardInstancesWithSameValuesAreEqual() {
        Board firstBoard = boardBuilder.withStructure("good")
                .withSize("good size ")
                .withTemplate("good template")
                .build();

        Board secondBoard = boardBuilder.withStructure("good")
                .withSize("good size ")
                .withTemplate("good template")
                .build();

        assertEquals(firstBoard, secondBoard);
    }

    @Test
    void twoBoardInstanceWithDifferentValuesAreNotEqual() {
        Board firstBoard = boardBuilder.withStructure("good 1")
                .withSize("good size 1")
                .withTemplate("good template 1")
                .build();

        Board secondBoard = boardBuilder.withStructure("good 2")
                .withSize("good size 2")
                .withTemplate("good template 2")
                .build();

        assertNotEquals(firstBoard, secondBoard);
    }
}
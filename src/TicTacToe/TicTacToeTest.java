package TicTacToe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    /**
     * Red -> Green -> Refactor
     *
     *  Guideline : Always start with outputs when doing analysis
     *
     * Tic Tac Toe Game:
     *  * 3x3 board
     *  * X plays first
     *  * 0 plays second
     *  * results:
     *      * X won
     *      * 0 won
     *      * Draw
     *  * Win conditions:
     *      * On column
     *      * On line
     *      * On diagonal
     *
     *  Inputs                      Outputs
     *  X finished line             X won
     *  X finished column           X won
     *  X finished diagonal         X won
     *
     *  Guideline: SIMPLIFY !!!
     *
     *  Guideline: Introduce only one notion at a time, one per test
     *
     *  Guideline: The rule of three -  "only extract duplication when spotted at least three time"
     *
     *  Guideline: Triangulation -
     */

    private String getGameMessageXWon() {
        return "X won";
    }

    private String getGameMessageNodyWon() {
        return "Nobody won";
    }

    private String buildBoard(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    private String getGameResult(String boardStructure, String boardSize, String board) {
        return board.equals(boardSize + boardStructure) ? getGameMessageXWon() : getGameMessageNodyWon();
    }

    //Introduced notion of winning
    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Settings
        String boardOneByOne = "one by one";

        //Arrange
        String boardStructure = "";
        String boardSize = boardOneByOne;
        String board = buildBoard(boardSize, boardStructure);

        //Production code
        String gameResult = getGameResult(boardStructure, boardSize, board);

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(getGameMessageXWon(), actual);
    }



    /**
     *  Introducing notion of column
     *  X 0
     *  X
     */
    @Test
    public void forTwoByTwoBoardXWinsOnLeftColumn() {
        //Settings
        String boardTwoByTwo = "two by two";
        String column = "column";
        String tokenVicinityPosition = "with X on";
        String direction = "left";

        //Arrange
        String space = " ";
        String boardSize = boardTwoByTwo;
        String boardStructure = space + tokenVicinityPosition + space + direction + space + column;
        String board = buildBoard(boardSize, boardStructure);

        //Production code
        String gameResult = getGameResult(boardStructure, boardSize, board);

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(getGameMessageXWon(), actual);
    }

    /**
     *  Introduced no new notion
     *  0 X
     *    X
     */
    @Test
    public void forTwoByTwoBoardXWinsOnRightColumn() {
        //Settings
        String boardTwoByTwo = "two by two";
        String column = "column";
        String tokenVicinityPosition = "with X on";
        String direction = "right";

        //Arrange
        String space = " ";
        String boardSize = boardTwoByTwo;
        String boardStructure = space + tokenVicinityPosition + space + direction + space + column;
        String board = buildBoard(boardSize, boardStructure);

        //Production code
        String gameResult = getGameResult(boardStructure, boardSize, board);

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(getGameMessageXWon(), actual);
    }



}

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

    //Introduced notion of winning
    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Arrange
        String board = "one by one";

        //Production code
        String boardOneByOne = "one by one";
        String gameResult = boardOneByOne.equals("one by one") ? getGameMessageXWon() : getGameMessageNodyWon();

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
        //Arrange
        String board = "two by two" + " with X on left column";

        //Production code
        String boardTwoByTwo = "two by two";
        String gameResult = board.equals(boardTwoByTwo + " with X on left column") ? getGameMessageXWon() : getGameMessageNodyWon();

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
        //Arrange
        String board = "two by two" + " with X on right column";

        //Production code
        String boardTwoByTwo = "two by two";
        String gameResult = board.equals(boardTwoByTwo + " with X on right column") ? getGameMessageXWon() : getGameMessageNodyWon();

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(getGameMessageXWon(), actual);
    }

}

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

    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Arrange
        String board = "one by one";
        String expected = "X won";

        //Production code
        String gameResult = board.equals("one by one") ? "X won" : "Nobody won";

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(expected, actual);
    }

    /**
     *
     *  X 0
     *  X 0
     *
     */
    @Test
    public void forTwoByTwoBoardXWinsColumn() {
        //Arrange
        String board = "two by two with X on left column";
        String expected = "X won";

        //Production code
        String gameResult = board.equals("two by two with X on left column")? "X won" : "Nobody won";

        //Act
        String actual = gameResult;

        //Assert
        assertEquals(expected, actual);
    }
}

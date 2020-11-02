package TicTacToe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    /**
     * Red -> Green -> Refactor
     * <p>
     * Guideline : Always start with outputs when doing analysis
     * <p>
     * Tic Tac Toe Game:
     * * 3x3 board
     * * X plays first
     * * 0 plays second
     * * results:
     * * X won
     * * 0 won
     * * Draw
     * * Win conditions:
     * * On column
     * * On line
     * * On diagonal
     * <p>
     * Inputs                      Outputs
     * X finished line             X won
     * X finished column           X won
     * X finished diagonal         X won
     * <p>
     * Guideline: SIMPLIFY !!!
     * <p>
     * Guideline: Introduce only one notion at a time, one per test
     * <p>
     * Guideline: The rule of three -  "only extract duplication when spotted at least three time"
     * <p>
     * Guideline: Triangulation -
     */

    private GameResult gameResult;
    private BoardBuilder boardBuilder;

    @BeforeEach
    void setup() {
        gameResult = new GameResult();
        boardBuilder = new BoardBuilder();
    }

    //Introduced notion of winning
    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Settings
        String boardOneByOne = "one by one";
        String tokenVicinityPosition = "";
        String direction = "";

        //Arrange
        Board boardObject = boardBuilder.build(boardOneByOne, tokenVicinityPosition, direction);

        //Act
        String actual = gameResult.getGameResult(boardObject);

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
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
        String tokenVicinityPosition = "with X on";
        String direction = "left";

        //Arrange
        Board boardObject = boardBuilder.build(boardTwoByTwo, tokenVicinityPosition, direction);

        //Act
        String actual = gameResult.getGameResult(boardObject);

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
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
        String tokenVicinityPosition = "with X on";
        String direction = "right";

        //Arrange
        Board boardObject = boardBuilder.build(boardTwoByTwo, tokenVicinityPosition, direction);

        //Act
        String actual = gameResult.getGameResult(boardObject);

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
    }




}

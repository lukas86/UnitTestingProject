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

    /**
     *  Design Experiments
     *  Hypothesis: "two by two", "one by one" should be a class "BoardStructure"
     *
     *  Plus:
     *  No more primitives about Board Structure in the tests.
     *  All the structure will be in one place. Structural coherence.
     *  Some coupling is expected from the tests, but only one other class will use BoardStructure.
     *  Duplication will be removed in-between tests.
     *  Clarity will be better because a cohesive design structure is extracted.
     *
     *  Minus:
     *  Increased code complexity, because of a new design element.
     *
     *
     */

    private GameResult gameResult;
    private BoardBuilder boardBuilder;

    @BeforeEach
    void setup() {
        gameResult = new GameResult();
        boardBuilder = new BoardBuilder();
    }

    private String getBoardTwoByTwo() {
        return "two by two";
    }

    private String getTokenVicinityPosition(String token) {
        return "with " + token + " on";
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
        String direction = "left";
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(getBoardTwoByTwo(), getTokenVicinityPosition(token), direction);

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
        String direction = "right";
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(getBoardTwoByTwo(), getTokenVicinityPosition(token), direction);

        //Act
        String actual = gameResult.getGameResult(boardObject);

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
    }

    /**
     *  Introduced no new notion
     *  X X
     *  0
     */
    @Test
    void forTwoByTwoBoardXWinsOnTopLine() {
        //Settings
        String direction = "top";
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(getBoardTwoByTwo(), getTokenVicinityPosition(token), direction);

        //Act
        String productionCode = gameResult.getGameResult(boardObject);
        String actual = productionCode;

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
    }




}

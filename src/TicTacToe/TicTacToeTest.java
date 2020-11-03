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
     *  Hypothesis: "two by two", "one by one" should be a class "TicTacToe.BoardStructure"
     *
     *  Plus:
     *  No more primitives about Board Structure in the tests.
     *  All the structure will be in one place. Structural coherence.
     *  Some coupling is expected from the tests, but only one other class will use TicTacToe.BoardStructure.
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
    private BoardStructure boardStructure;
    private Direction direction;

    @BeforeEach
    void setup() {
        gameResult = new GameResult();
        boardBuilder = new BoardBuilder();
        boardStructure = new BoardStructure();
        direction = new Direction();
    }

    private String getTokenVicinityPosition(String token) {
        return "with " + token + " on";
    }

    //Introduced notion of winning
    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Settings
        String tokenVicinityPosition = "";
        String direction = "";

        //Arrange
        Board boardObject = boardBuilder.build(boardStructure.getBoardOneByOne(), tokenVicinityPosition, direction);

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
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.left());

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
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.right());

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
        String token = "X";

        //Arrange
        Board boardObject = boardBuilder.build(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.top());

        //Act
        String productionCode = gameResult.getGameResult(boardObject);
        String actual = productionCode;

        //Assert
        assertEquals(gameResult.getGameMessageXWon(), actual);
    }

    @Test
    void whenBoardIsEmptyNobodyWon() {
        //Arrange
        String expected = "Nobody won";
        String emptyBoard = "empty board";

        //Production code
        String gameResultTemp = gameResult.getGameResult(emptyBoard);

        //Act
        String actual = gameResultTemp;

        //Assert
        assertEquals(expected, actual);
    }

}
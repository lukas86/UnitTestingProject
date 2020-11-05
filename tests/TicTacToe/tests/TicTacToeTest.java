package TicTacToe.tests;

import TicTacToe.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    /*
      Red -> Green -> Refactor
      <p>
      Guideline : Always start with outputs when doing analysis
      <p>
      Tic Tac Toe Game:
      * 3x3 board
      * X plays first
      * 0 plays second
      * results:
      * X won
      * 0 won
      * Draw
      * Win conditions:
      * On column
      * On line
      * On diagonal
      <p>
      Inputs                      Outputs
      X finished line             X won
      X finished column           X won
      X finished diagonal         X won
      <p>
      Guideline: SIMPLIFY !!!
      <p>
      Guideline: Introduce only one notion at a time, one per test
      <p>
      Guideline: The rule of three -  "only extract duplication when spotted at least three time"
      <p>
      Guideline: Triangulation -
     */

    /**
     * Design experiments
     *
     * Hypothesis: "two by two", "one by one" should be a class called "BoardStructure"
     *
     * Plus:
     * No more primitives about BoardStructure in the tests
     * All the structure will be in one space (Encapsulation)
     * Some coupling is expected from the tests, but only one other class will us BoardStructure
     * Duplication will be removed
     * Clarity will be improved due to cohesive design structure
     *
     * Minus:
     * Increased code complexity because of a new design elements
     */

    private GameResult gameResult;
    private BoardStructure boardStructure;
    private Direction direction;
    private BoardBuilder boardBuilder;

    @BeforeEach
    void setup() {
        gameResult = new GameResult();
        boardStructure = new BoardStructure();
        direction = new Direction();
        boardBuilder = new BoardBuilder();
    }

    private String buildBoardTemplate(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    private String buildBoardStructure(String tokenVicinityPosition, String direction) {
        String column = "column"; String space = " ";
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    private Board buildBoard(String boardOneByOne, String tokenVicinityPosition, String direction) {
        String boardSize = boardOneByOne;
        String boardStructure = buildBoardStructure(tokenVicinityPosition, direction);
        String boardTemplate = buildBoardTemplate(boardSize, boardStructure);

        return boardBuilder.withStructure(boardStructure).withSize(boardSize).withTemplate(boardTemplate).build();
    }

    private String getTokenVicinityPosition(String token) {
        return "with " + token + " on";
    }

    @Test
    void whenBoardIsEmptyNobodyWon() {
        //Arrange
        Board emptyBoard = boardBuilder.withStructure(boardStructure.getEmptyBoard()).build();

        //Act
        String actual = gameResult.getGameResult(emptyBoard);

        //Assert
        assertEquals(new GameMessage().getGameMessageNobodyWon(), actual);
    }

    //Introduced notion of winning
    @Test
    public void forOneByOneBoardXAlwaysWins() {
        //Settings
        String tokenVicinityPosition = "";
        String direction = "";
        //Arrange
        Board board = buildBoard(boardStructure.getBoardOneByOne(), tokenVicinityPosition, direction);

        //Act
        String actual = gameResult.getGameResult(board);

        //Assert
        assertEquals(new GameMessage().getGameMessageXWon(), actual);
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
        Board board = buildBoard(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.left());

        //Act
        String actual = gameResult.getGameResult(board);

        //Assert
        assertEquals(new GameMessage().getGameMessageXWon(), actual);
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
        Board board = buildBoard(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.right());

        //Act
        String actual = gameResult.getGameResult(board);

        //Assert
        assertEquals(new GameMessage().getGameMessageXWon(), actual);
    }

    /**
     *  Introduced concept of line
     *  X X
     *  0
     */
    @Test
    public void forTwoByTwoBoardXWinsOnTopLine() {
        //Settings
        String token = "X";

        //Arrange
        Board board = buildBoard(boardStructure.getBoardTwoByTwo(), getTokenVicinityPosition(token), direction.top());

        //Act
        String actual = gameResult.getGameResult(board);

        //Assert
        assertEquals(new GameMessage().getGameMessageXWon(), actual);
    }

}

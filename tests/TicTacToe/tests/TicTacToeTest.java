package TicTacToe.tests;

import TicTacToe.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private GameResult gameResult;
    private BoardStructure boardStructure;
    private Direction direction;
    private BoardBuilder boardBuilder;
    private GameMessage gameMessage;

    @BeforeEach
    void setup() {
        gameMessage = new GameMessage();
        boardStructure = new BoardStructure();
        gameResult = new GameResult(gameMessage, boardStructure);
        direction = new Direction();
        boardBuilder = new BoardBuilder();
    }

    @Test
    void whenBoardIsEmptyNobodyWon() {
        Board emptyBoard = boardBuilder.buildBoard(boardStructure.getEmptyBoard());

        assertEquals(gameMessage.getGameMessageNobodyWon(), gameResult.getGameResult(emptyBoard));
    }

    @Test
    public void forOneByOneBoardXAlwaysWins() {
        Board board = boardBuilder.buildBoard(boardStructure.getBoardOneByOne(), Token.X(), direction.left());

        assertEquals(gameMessage.getGameMessageXWon(), gameResult.getGameResult(board));
    }

    @Test
    public void forTwoByTwoBoardXWinsOnLeftColumn() {
        Board board = boardBuilder.buildBoard(boardStructure.getBoardTwoByTwo(), Token.X(), direction.left());

        assertEquals(gameMessage.getGameMessageXWon(), gameResult.getGameResult(board));
    }

    @Test
    public void forTwoByTwoBoardXWinsOnRightColumn() {
        Board board = boardBuilder.buildBoard(boardStructure.getBoardTwoByTwo(), Token.X(), direction.right());

        assertEquals(gameMessage.getGameMessageXWon(), gameResult.getGameResult(board));
    }

    @Test
    public void forTwoByTwoBoardXWinsOnTopLine() {
        Board board = boardBuilder.buildBoard(boardStructure.getBoardTwoByTwo(), Token.X(), direction.top());

        assertEquals(gameMessage.getGameMessageXWon(), gameResult.getGameResult(board));
    }

}

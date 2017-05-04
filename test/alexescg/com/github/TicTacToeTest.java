package alexescg.com.github;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alex
 */
public class TicTacToeTest {

    private TicTacToeGame ticTacToeGame;

    @Before
    public void init() {
        ticTacToeGame = new TicTacToeGame();
    }

    @Test
    public void addMoveTest() {
        ticTacToeGame.markSpace(0, 0);
        Assert.assertTrue(ticTacToeGame.getMovements().size() == 1);
        ticTacToeGame.markSpace(0, 1);
        ticTacToeGame.markSpace(0, 2);
        Assert.assertTrue(ticTacToeGame.getMovements().size() == 3);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addRepeatedMoveTest() {
        ticTacToeGame.markSpace(0, 0);
        ticTacToeGame.markSpace(0, 0);
    }

    @Test
    public void alternatePlayerTest() {
        ticTacToeGame.markSpace(0, 0);
        ticTacToeGame.markSpace(0, 1);
        ticTacToeGame.markSpace(0, 2);
        ticTacToeGame.markSpace(1, 0);
        Assert.assertTrue(ticTacToeGame.getSpaceVal(0, 0) == 1);
        Assert.assertTrue(ticTacToeGame.getSpaceVal(0, 1) == 2);
        Assert.assertTrue(ticTacToeGame.getSpaceVal(0, 2) == 1);
        Assert.assertTrue(ticTacToeGame.getSpaceVal(1, 0) == 2);
    }

    @Test
    public void replayGameTest() {
        ticTacToeGame.markSpace(0, 0);
        ticTacToeGame.markSpace(0, 1);
        ticTacToeGame.markSpace(0, 2);

        Move firstMove = ticTacToeGame.getMovements().remove();
        Assert.assertTrue(firstMove.x == 0 && firstMove.y == 0);
        Move secondMove = ticTacToeGame.getMovements().remove();
        Assert.assertTrue(secondMove.x == 0 && secondMove.y == 1);
        Move thridMove = ticTacToeGame.getMovements().remove();
        Assert.assertTrue(thridMove.x == 0 && thridMove.y == 2);
        Assert.assertTrue(ticTacToeGame.getMovements().peek() == null);
    }

}

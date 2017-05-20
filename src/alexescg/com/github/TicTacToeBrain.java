package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author alex
 */
public class TicTacToeBrain {
    private Tree<Move> moveTree;
    private TicTacToeGame currentGame;


    public TicTacToeBrain() {
        this.moveTree = new Tree<>();
    }

    public void makePlay() {
        playRandomSquare();
    }

    public void learn(TicTacToeGame gameToLearnFrom) {
        this.moveTree.addCollection(gameToLearnFrom.getMovements());
    }

    public void setCurrentGame(TicTacToeGame game) {
        this.currentGame = game;
    }

    private void playRandomSquare() {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (this.currentGame.board[x][y] == 0) {
            currentGame.markSpace(x, y);
        } else {
            playRandomSquare();
        }
    }
}

package alexescg.com.github;

import java.util.*;

/**
 * @author alex
 */
public class TicTacToeBrain {
    private Tree<Move> moveTree = new Tree<>();
    private TicTacToeGame currentGame;
    private TreeNode<Move> lastPlay = this.moveTree.getRoot();
    private Random random = new Random(11);


    public TicTacToeBrain() {
        this.moveTree = new Tree<>();
    }

    public void makePlay() {
        if (lastPlay != null && lastPlay.hasChildren()) {
            System.out.println("matching game state");
            playRandomSquare();//placeholder
            matchGameState();
        } else {
            playRandomSquare();

        }

    }

    public void learn(TicTacToeGame gameToLearnFrom) {
        this.moveTree.addCollection(gameToLearnFrom.getMovements());
        this.lastPlay = this.moveTree.getRoot();
    }

    public void setCurrentGame(TicTacToeGame game) {
        this.currentGame = game;
    }

    private void playRandomSquare() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        if (this.currentGame.board[x][y] == 0) {
            currentGame.markSpace(x, y);
        } else {
            playRandomSquare();
        }
    }

    public void matchGameState() {
        if (lastPlay != null && lastPlay.hasChildren()) {
            lastPlay = next();
            System.out.println(lastPlay);
        }
    }

    public TreeNode<Move> next() {
        Move lastMove = this.currentGame.getMovements().getLast();
        return this.lastPlay.getChild(lastMove);
    }
}

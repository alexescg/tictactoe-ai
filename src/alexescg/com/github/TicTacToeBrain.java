package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;

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

    }

    public void learn(TicTacToeGame gameToLearnFrom) {
        this.moveTree.addCollection(gameToLearnFrom.getMovements());
    }

}

package alexescg.com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alex
 */
public class TicTacToeBrain {
    private Tree<Move> moveTree;
    private TicTacToeGame gameToLearn;


    public TicTacToeBrain(Tree<Move> moveTree) {
        this.moveTree = moveTree;
    }

}

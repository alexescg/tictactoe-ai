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
            Move nextMove = calculateBestPlay();
            currentGame.markSpace(nextMove.x, nextMove.y);
        } else {
            playRandomSquare();
        }
        matchGameState();
    }

    public void learn(TicTacToeGame gameToLearnFrom) {
        this.moveTree.addCollection(gameToLearnFrom.getMovements());
    }

    public void setCurrentGame(TicTacToeGame game) {
        this.currentGame = game;
    }

    private void playRandomSquare() {
        Move randomMove = randomMove();
        if (this.currentGame.board[randomMove.x][randomMove.y] == 0) {
            currentGame.markSpace(randomMove.x, randomMove.y);
        } else {
            playRandomSquare();
        }
    }

    private Move validRandomMove() {
        Move randomMove = randomMove();
        if (this.currentGame.board[randomMove.x][randomMove.y] == 0) {
            return randomMove;
        } else {
            validRandomMove();
        }
        return null;
    }

    private Move randomMove() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        return new Move(x, y);
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

    public Move calculateBestPlay() {
        return calculate(this.lastPlay, null);
    }

    private Move calculate(TreeNode<Move> currentNode, Move best) {
        if (currentNode.isLeaf()) {
            System.out.println("soy hojita");
            //check if other player won, try to block
            if (currentNode.getData().moveResult == GameState.WIN) {
                Move winMove = currentNode.getData();
                best = new Move(winMove.x, winMove.y);
                return best;
                //save tie
            } else if (best == null) {
                if (currentNode.getData().moveResult == GameState.TIE) {
                    Move tieMove = currentNode.getData();
                    best = new Move(tieMove.x, tieMove.y);
                    calculate(currentNode.getParent(), best);
                }
            }
        } else {
            //check other best moves
            for (TreeNode<Move> child : currentNode.getChildren()) {
                System.out.println(child);
                calculate(child, best);
            }
        }
        //no best play found
        return validRandomMove();
    }

    public void resetNodePointer() {
        this.lastPlay = this.moveTree.getRoot();
    }
}

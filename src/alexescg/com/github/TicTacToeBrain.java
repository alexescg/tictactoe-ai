package alexescg.com.github;

import java.util.*;

/**
 * @author alex
 */
public class TicTacToeBrain {
    private Tree<Move> moveTree = new Tree<>();
    private TicTacToeGame currentGame;
    private TreeNode<Move> lastPlay = this.moveTree.getRoot();
    private Random random = new Random();


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
        this.resetNodePointer();

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

    private Move randomMove() {
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        return new Move(x, y);
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


    void matchGameState() {
        if (lastPlay != null && lastPlay.hasChildren()) {
            lastPlay = next();
            System.out.println("Siguiente jugada: " + lastPlay);
        }
    }

    private TreeNode<Move> next() {
        Move lastMove = this.currentGame.getMovements().getLast();
        return this.lastPlay.getChild(lastMove);
    }

    private Move calculateBestPlay() {
        return calculate(this.lastPlay, null);
    }


    private Move calculate(TreeNode<Move> currentNode, Move best) {
        if (currentNode.isLeaf()) {
            System.out.println("soy hojita");
            //try to win
            if (currentNode.getData().moveResult == GameState.LOSE) {
                System.out.println("tratando de ganar");
                int depth = getDepthComparedToLastPlay(currentNode);
                TreeNode<Move> optimal = currentNode;
                for (int i = 0; i < depth - 2; i++) {
                    optimal = optimal.getParent();
                }
                return optimal.getData();
            } else if (currentNode.getData().moveResult == GameState.WIN) {
                //check if other player won, try to block
                int depth = getDepthComparedToLastPlay(currentNode);
                TreeNode<Move> optimal = currentNode;
                for (int i = 0; i < depth - 2; i++) {
                    optimal = optimal.getParent();
                }
                System.out.println("debe ser la segunda jugada que hicimos");
                System.out.println(optimal.getData());
                return optimal.getData();
                //save tie
            } else if (best == null) {
                if (currentNode.getData().moveResult == GameState.TIE) {
                    System.out.println("tratando de empatar");
                    Move tieMove = currentNode.getData();
                    best = new Move(tieMove.x, tieMove.y);
                }
                calculate(currentNode.getParent(), best);
            }
        } else if (currentNode.hasChildren()) {
            //check other children
            System.out.println("Buscando hijitos");
            for (TreeNode<Move> child : currentNode.getChildren()) {
                System.out.println(child.getData());
                best = calculate(child, best);
            }
        }
//        else {
//            //TODO:si encuentra el valor correcto, pero no lo esta regresando, checar el stack de recursion para errores,
//            // probablemente con unos cuantos debug salga ;)
//            //no best play found
//            return validRandomMove();
//        }
        return best;
    }

    private int getDepthComparedToLastPlay(TreeNode<Move> currentNode) {
        int i = 0;
        while (!currentNode.equals(lastPlay)) {
            i++;
            currentNode = currentNode.getParent();
        }
        return i;
    }
//TODO: check optimal moves when depth is <= 2
//    private Move getMove(TreeNode<Move> currentNode) {
//        if (currentNode.isLeaf() && currentNode.getData().moveResult != null) {
//            return currentNode.getData();
//        } else {
//            int depth = getDepthComparedToLastPlay(currentNode);
//            if (depth == 2) {
//                return currentNode.getData();
//            } else if (depth == 1){
//
//            }
//
//        }
//    }

    private void resetNodePointer() {
        this.lastPlay = this.moveTree.getRoot();
    }
}

package alexescg.com.github;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author alex
 */
public class TicTacToeGame {
    private Queue<Move> movementsQueue = new LinkedList<>();
    private int[][] board = new int[3][3];
    private boolean playerTurn = true;

    /**
     * TicTacToe Game data structure
     */
    public TicTacToeGame() {
    }

    /**
     * Mark space in board
     *
     * @param x
     * @param y
     */
    public void markSpace(int x, int y) {
        addMove(x, y);
        this.playerTurn = !playerTurn;
    }

    private void addMove(int x, int y) {
        Move move = this.playerTurn
                ? new Move(x, y, Move.Mark.CIRCLE)
                : new Move(x, y, Move.Mark.CROSS);

        if (isSpaceEmpty(x, y)) {
            movementsQueue.add(move);
            board[x][y] = move.mark.getVal();
        } else {
            throw new UnsupportedOperationException("Space not empty");
        }
    }

    /**
     * Get space val
     *
     * @param x horizontal
     * @param y vertical
     * @return value from coordinate
     */
    public int getSpaceVal(int x, int y) {
        return board[x][y];
    }

    /**
     * Get Movements in order
     *
     * @return movements
     */
    public Queue<Move> getMovements() {
        return movementsQueue;
    }

    /**
     * Check if space is empty
     *
     * @param x horizontal
     * @param y vertical
     * @return
     */
    public boolean isSpaceEmpty(int x, int y) {
        return board[x][y] == 0;
    }

    /**
     * Print 3 x 3 grid
     */
    public void printBoard() {
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}

package alexescg.com.github;

import java.util.*;

/**
 * @author alex
 */
public class TicTacToeGame {
    private Deque<Move> movementsDeque = new ArrayDeque<>();
    protected int[][] board = new int[3][3];
    private boolean playerTurn = true;
    private static List<Move[]> winningCombinations = new ArrayList<>();
    private GameState state = GameState.PROGRESS;

    {
        winningCombinations.add(new Move[]{
                new Move(0, 0),
                new Move(1, 1),
                new Move(2, 2)});
        winningCombinations.add(new Move[]{
                new Move(0, 0),
                new Move(0, 1),
                new Move(0, 2)});
        winningCombinations.add(new Move[]{
                new Move(0, 0),
                new Move(1, 0),
                new Move(2, 0)});
        winningCombinations.add(new Move[]{
                new Move(2, 0),
                new Move(2, 1),
                new Move(2, 2)});
        winningCombinations.add(new Move[]{
                new Move(0, 2),
                new Move(1, 2),
                new Move(2, 2)});
        winningCombinations.add(new Move[]{
                new Move(0, 2),
                new Move(1, 1),
                new Move(2, 0)});
        winningCombinations.add(new Move[]{
                new Move(0, 1),
                new Move(1, 1),
                new Move(2, 1)});
        winningCombinations.add(new Move[]{
                new Move(1, 0),
                new Move(1, 1),
                new Move(1, 2)});
    }

    /**
     * Mark space in board
     *
     * @param x
     * @param y
     */
    public void markSpace(int x, int y) {
        addMove(x, y);
        if (this.getState() == GameState.PROGRESS) {
            this.playerTurn = !playerTurn;
        }
    }

    private void addMove(int x, int y) {
        if (isSpaceEmpty(x, y)) {
            Move move = this.playerTurn
                    ? new Move(x, y, Move.Mark.CIRCLE)
                    : new Move(x, y, Move.Mark.CROSS);

            board[x][y] = move.mark.getVal();
            movementsDeque.add(move);
            if (this.getState() != GameState.PROGRESS) {
                move.moveResult = state;
            }
        } else {
            System.out.println("Ocupado. Casilla aleatoria");
            Move nextMove = Main.playerMove();
            markSpace(nextMove.x, nextMove.y);
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
    public Deque<Move> getMovements() {
        return movementsDeque;
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
        System.out.println();
    }

    /**
     * Check current state of the game
     *
     * @return current gameState
     */
    public GameState getState() {
        if (this.state != GameState.PROGRESS) {
            return this.state;
        } else {
            if (this.getMovements().size() <= 4) {
                this.state = GameState.PROGRESS;
            } else if (this.state == GameState.PROGRESS) {
                this.state = checkWinningCombinations();
            } else if (isBoardFilled()) {
                this.state = GameState.TIE;
            } else {
                this.state = GameState.PROGRESS;
            }
            return this.state;
        }
    }

    /**
     * Check if a winning combination is on board.
     *
     * @return {@link GameState}:Win if player win, Lose if player loses
     */
    private GameState checkWinningCombinations() {
        for (Move[] combo : winningCombinations) {
            int first = this.board[combo[0].x][combo[0].y];
            int second = this.board[combo[1].x][combo[1].y];
            int third = this.board[combo[2].x][combo[2].y];
            if (first == second && second == third && (first > 0 && second > 0 && third > 0)) {
                if (playerTurn) {
                    return GameState.WIN;
                } else {
                    return GameState.LOSE;
                }
            }
        }
        return GameState.PROGRESS;
    }

    /**
     * Check if board is completely filled up
     *
     * @return true if board is filled, false if not
     */
    private boolean isBoardFilled() {
        for (int[] row : board) {
            for (int space : row) {
                if (space == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

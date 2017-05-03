package alexescg.com.github;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author alex
 */
public class TicTacToeGame {
    private Queue<Move> movementsQueue = new LinkedList<>();

    public TicTacToeGame() {
    }

    public void addMove(int x, int y) {
        Move move = new Move(x, y);
        movementsQueue.add(move);
    }

    public Queue<Move> getMovements() {
        return movementsQueue;
    }

}

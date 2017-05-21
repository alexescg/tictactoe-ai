package alexescg.com.github;

/**
 * @author alex
 */
public class Move {
    int x;
    int y;
    Mark mark;
    GameState moveResult;

    Move(int x, int y, Mark mark) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                ", mark=" + mark +
                ", moveResult=" + moveResult +
                '}';
    }

    public enum Mark {
        CIRCLE(1),
        CROSS(2);

        private int val;

        Mark(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (x != move.x) return false;
        if (y != move.y) return false;
        if (mark != move.mark) return false;
        return moveResult == move.moveResult;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + mark.hashCode();
        result = 31 * result + moveResult.hashCode();
        return result;
    }
}

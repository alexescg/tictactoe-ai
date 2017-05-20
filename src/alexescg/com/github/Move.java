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
}

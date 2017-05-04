package alexescg.com.github;

/**
 * @author alex
 */
public class Move {
    public int x;
    public int y;
    public Mark mark;

    public Move(int x, int y, Mark mark) {
        this.x = x;
        this.y = y;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
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

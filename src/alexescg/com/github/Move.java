package alexescg.com.github;

/**
 * @author alex
 */
public class Move {
    public int x;
    public int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

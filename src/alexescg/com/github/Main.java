package alexescg.com.github;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game  = new TicTacToeGame();
        game.addMove(0,0);
        game.addMove(1,0);
        for (Move move : game.getMovements()){
            System.out.println(move);
        }
    }
}

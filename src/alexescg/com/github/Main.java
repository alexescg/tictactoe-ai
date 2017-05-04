package alexescg.com.github;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game  = new TicTacToeGame();
        game.markSpace(0,0);
        game.markSpace(1,0);
        game.markSpace(2,0);
//        for (Move move : game.getMovements()){
//            System.out.println(move);
//        }
        game.printBoard();
    }
}

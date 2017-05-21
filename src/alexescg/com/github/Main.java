package alexescg.com.github;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepPlaying = true;
        TicTacToeBrain ticTacToeBrain = new TicTacToeBrain();

        while (keepPlaying) {
            TicTacToeGame game = new TicTacToeGame();
            ticTacToeBrain.setCurrentGame(game);
            while (game.getState() == GameState.PROGRESS) {
                System.out.print("X Coordinate: ");
                int x = scanner.nextInt();
                System.out.print("Y Coordinate: ");
                int y = scanner.nextInt();
                game.markSpace(x, y);
                ticTacToeBrain.matchGameState();
                game.printBoard();
                if (game.getState() == GameState.PROGRESS) {
                    ticTacToeBrain.makePlay();
                    game.printBoard();
                }
            }
            System.out.println("Game over. Result: " + game.getState());
            ticTacToeBrain.learn(game);
            keepPlaying = willKeepPlaying();
        }
    }

    private static boolean willKeepPlaying() {
        System.out.print("Keep playing? y/n ");
        String answer = scanner.next();
        return answer.equals("y");
    }
}

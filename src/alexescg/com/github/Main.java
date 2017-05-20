package alexescg.com.github;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepPlaying = true;
        TicTacToeBrain ticTacToeBrain = new TicTacToeBrain();

        while (keepPlaying) {
            TicTacToeGame game = new TicTacToeGame();
            while (game.getState() == GameState.PROGRESS) {
                System.out.print("X Coordinate: ");
                int x = scanner.nextInt();
                System.out.print("Y Coordinate: ");
                int y = scanner.nextInt();
                game.markSpace(x, y);
                game.printBoard();
            }
            System.out.println("Juego terminado. Resultado: " + game.getState());
            System.out.println("se acabo");

            ticTacToeBrain.learn(game);
            keepPlaying = willKeepPlaying();
        }
    }

    private static boolean willKeepPlaying() {
        System.out.println("Keep playing? y/n");
        String answer = scanner.next();
        return answer.equals("y");
    }
}

import java.util.ArrayList;

public class Simulation {

    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        int score;
        int pushes = 0;
        int playerWins = 0;
        int dealerWins = 0;

        for (int i = 0; i < 10000; i++) {
            score = bj.game(false);
            if (score == 0) {
                pushes += 1;
            } else if (score == -1) {
                dealerWins += 1;
            } else {
                playerWins += 1;
            }
        }
        System.out.println("The total number of pushes is: " + pushes);
        System.out.println("The total number of player wins is: " + playerWins);
        System.out.println("The total number of dealer wins is: " + dealerWins);

        System.out.println("The percentage of pushes is: " + (pushes / 1000.0));
        System.out.println("The percentage of player wins is: " + (playerWins / 1000.0));
        System.out.println("The percentage of dealer wins is: " + (dealerWins / 1000.0));
    }
}

/*
 * 
 * CS 231 
 * Prof. Max Bender
 * Gent Maksutaj
 * February 25th 2024
 * 
 * This is the main file of our Monte Carlo simulation/Blackjack project
 * The Blackjack class uses the Card/Hand/Deck entities(classes) to simulate a real game
 * between the dealer and the player with a certain cutoff value. The code of this class determines
 * who has the higher hand between the player and dealer or who has busted by exceeding the value of 21 per hand
 * and thus determining who the winner of the Blackjack game was
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private int reshuffleCuttof;
    private int scoreBoard;
    Scanner keyboard;

    public Blackjack(int reshuffleCuttof) {
        this.reshuffleCuttof = reshuffleCuttof;
        deck = new Deck();
        deck.build();
        deck.shuffle();
        reset();
        keyboard = new Scanner(System.in);

    }

    public Blackjack() {
        this(16);
    }

    public void reset() {
        playerHand = new Hand();
        dealerHand = new Hand();
        if (deck.size() < this.reshuffleCuttof) {
            deck.shuffle();
        }

    }

    public void deal() {
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());

    }

    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            Card cardAdded = deck.deal();
            playerHand.add(cardAdded);
            System.out.println("Player wants to hit. He is dealt: " +
                    cardAdded.getValue());
        }
        if (playerHand.getTotalValue() > 21) {
            return false;
        }
        return true;

    }

    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            Card cardAdded = deck.deal();
            dealerHand.add(cardAdded);
            System.out.println("Dealer wants to hit. He is dealt: " +
                    cardAdded.getValue());
        }
        if (dealerHand.getTotalValue() > 21) {
            return false;
        }
        return true;

    }

    public void setReshuffleCutoff(int cutoff) {
        this.reshuffleCuttof = cutoff;
    }

    public int getReshuffleCutoff() {
        return this.reshuffleCuttof;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String toString() {
        return "|Player Cards: " + playerHand.toString() + " total: " + playerHand.getTotalValue() + "| Dealer Cards: "
                + dealerHand.toString() + " total: " + dealerHand.getTotalValue() + "|";
    }

    public int getScore() {
        this.scoreBoard = 0;
        if (this.dealerHand.getTotalValue() == this.playerHand.getTotalValue()) {
            this.scoreBoard += 0;
        } else if ((this.dealerHand.getTotalValue() > this.playerHand.getTotalValue())
                && (this.dealerHand.getTotalValue() <= 21)) {
            this.scoreBoard -= 1;
        } else if ((this.playerHand.getTotalValue() > this.dealerHand.getTotalValue())
                && (this.playerHand.getTotalValue() <= 21)) {
            this.scoreBoard += 1;
        }

        else if (this.playerHand.getTotalValue() > 21) {
            this.scoreBoard -= 1;
        }

        else if (this.dealerHand.getTotalValue() > 21) {
            this.scoreBoard += 1;
        }

        return this.scoreBoard;
    }

    public int game(boolean verbose) {
        this.reset();
        this.deal();

        if (verbose) {
            System.out.println("Initial hands: ");
            System.out.println("player hand: " + playerHand.toString() + " , dealer hand: " + dealerHand.toString());
        }

        this.playerTurn();
        this.dealerTurn();

        int result = 0;

        if (this.dealerHand.getTotalValue() == this.playerHand.getTotalValue()) {
            result += 0;
        } else if ((this.dealerHand.getTotalValue() > this.playerHand.getTotalValue())
                && (this.dealerHand.getTotalValue() <= 21)) {
            result -= 1;
        } else if ((this.playerHand.getTotalValue() > this.dealerHand.getTotalValue())
                && (this.playerHand.getTotalValue() <= 21)) {
            result += 1;
        }

        else if (this.playerHand.getTotalValue() > 21) {
            result -= 1;
        }

        else if (this.dealerHand.getTotalValue() > 21) {
            result += 1;
        }

        if (verbose) {
            System.out.println("Final hands: ");
            System.out.println("player hand: " + playerHand.toString() + " , dealer hand: " + dealerHand.toString());
        }

        return result;

    }

    // part of the extension. Determines who won the game or if it ends in a push
    public String playerControlledWinLose() {
        if (playerHand.getTotalValue() > dealerHand.getTotalValue()) {

            return "You Win!";
        } else if (playerHand.getTotalValue() < dealerHand.getTotalValue() && dealerHand.getTotalValue() <= 21) {

            return "You Lose!";
        } else if (dealerHand.getTotalValue() > 21) {

            return "You Win!";
        } else if (playerHand.getTotalValue() == dealerHand.getTotalValue()) {

            return "Push! (Tie)";
        }

        return "You Lose!";
    }

    // part of the extensnion. Collects the input from the user and decides wehter
    // to hit or stand
    public String playerTurnInteractive() {
        // resets and deals then asks for player input
        reset();
        deal();
        System.out.println("Player Turn:");
        System.out.println(toString());
        System.out.println("hit or stand?");
        String hitStand = keyboard.next();

        // logic for hitting and standing
        while (playerHand.getTotalValue() <= 21 || hitStand == "hit") {
            // player hit and stand
            if (hitStand.equals("stand")) {
                break;
            }
            if (hitStand.equals("hit"))
                ;
            {
                playerHand.add(deck.deal());
            }

            // System.out.println(toString());

            // keep going?
            if (playerHand.getTotalValue() <= 21) {
                System.out.println(toString());
                System.out.println("hit or stand?");
                hitStand = keyboard.next();
            }
        }

        // dealer turn
        if (playerHand.getTotalValue() <= 21) {
            dealerTurn();
            System.out.println("Dealer Turn:");
            System.out.println(toString());
            return playerControlledWinLose();
        }
        System.out.println(toString());
        return "You Lose!";
    }

    public static void main(String[] args) {

        // interactive game where user picks whether to hit or stand by typing it out on
        // the terminal
        // Blackjack play = new Blackjack();
        // System.out.println(play.playerTurnInteractive());

        Blackjack newGame = new Blackjack();
        newGame.deal();
        System.out.println("Player is dealt" + ": " + newGame.playerHand.getTotalValue());
        System.out.println("Dealer is dealt" + ": " + newGame.dealerHand.getTotalValue());
        System.out.println(newGame.toString());
        newGame.playerTurn();
        // if player doesn't bust
        if (newGame.playerTurn() == true) {
            System.out.println("Player will stand with" + ": "
                    + newGame.playerHand.getTotalValue());

            newGame.dealerTurn();

            // if dealer doesnt bust
            if (newGame.dealerTurn() == true) {
                System.out.println("Dealer will stay with" + ": "
                        + newGame.dealerHand.getTotalValue());

                // if the values are equal
                if (newGame.dealerHand.getTotalValue() == newGame.playerHand.getTotalValue()) {
                    System.out.println("It is a PUSH! Dealer and player have the same hand");
                    System.out.println(newGame.toString());
                }

                // if dealer is greater than player
                else if (newGame.dealerHand.getTotalValue() > newGame.playerHand.getTotalValue()) {
                    System.out.println("Game is over! Dealer has a higher hand. Dealer wins with hand of" + ": "
                            + newGame.dealerHand.getTotalValue());
                    System.out.println(newGame.toString());
                }

                // if player is greater than dealer
                else {
                    System.out.println("Game is over! Player has a higher hand. Player wins with hand of" + ": "
                            + newGame.playerHand.getTotalValue());
                    System.out.println(newGame.toString());
                }
            }
            // if the dealer busts
            if (newGame.dealerTurn() == false) {
                System.out.println("Game is over! Dealer has busted and player wins!");
                System.out.println(newGame.toString());
            }

            // if the player busts
        }
        if (newGame.playerTurn() == false) {
            System.out.println("Game is over! Player has busted and dealer wins!");
            System.out.println(newGame.toString());
        }
        System.out.println("The game tally is" + ": " + newGame.getScore());

        // this makes sure that the deck shuffles when it gets to 20 cards left
        if (newGame.deck.size() < 20) {
            newGame.deck.shuffle();
        }

    }

}

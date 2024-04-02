/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

Further modified to test the Blackjack class methods by Gent Maksutaj 
February 25th 2024

How to run:     java -ea BlackjackTests
*/

import java.util.ArrayList;

public class BlackjackTests {

    public static void blackjackTests() {

        // case 1: testing Blackjack() and Blackjack(i)
        {
            // set up
            Blackjack bj1 = new Blackjack();
            Blackjack bj2 = new Blackjack(5);

            // verify
            System.out.println(bj1);

            // test
            assert bj1 != null : "Error in Blackjack::Blackjack()";
            assert bj2 != null : "Error in Blackjack::Blackjack()";
        }

        // case 2: testing the deal() method
        {
            // creating an instance of the Blackjack class
            Blackjack bj1 = new Blackjack();
            // adding two cards to each hand
            bj1.deal();

            // should print out the number two to the console
            System.out.println("Size of hand is equal to: " + bj1.getPlayerHand().size());

            // checks if the number of cards in each hand is valid
            assert bj1.getPlayerHand().size() == 0 : "Error in Blackjack::Blackjack()";
            assert bj1.getDealerHand().size() == 0 : "Error in Blackjack::Blackjack()";

        }

        // case 3: testing the reset() method
        {
            Blackjack bj1 = new Blackjack();
            bj1.deal();
            // resets each hand meaning now there should be 0 cards in each hand
            bj1.reset();

            // should print out the number 0 to the console because we reset the hand
            System.out.println("Size of hand is equal to " + bj1.getPlayerHand().size());

            // checks if the number of cards in each hand is valid
            assert bj1.getPlayerHand().size() != 0 : "Error in Blackjack::Blackjack()";
            assert bj1.getDealerHand().size() != 0 : "Error in Blackjack::Blackjack()";

        }

        // case 4: testing the playerTurn() and dealerTurn() methods
        {
            Blackjack bj1 = new Blackjack();
            Card card = new Card(9);
            // by adding the value 9 twice as a card to the player hand we get a total of 18
            // which makes the playerTurn() method return true since we exceed cutoff
            // value but don't bust
            bj1.getPlayerHand().add(card);
            bj1.getPlayerHand().add(card);

            System.out.println(bj1);

            // checking the validity of our tests
            assert bj1.playerTurn() == true : "Error in Blacjjack::Blackjack()";

            // other possiblity
            bj1.getPlayerHand().add(card);
            assert bj1.playerTurn() == false : "Error in Blackjack::Blackjack()";

            // Test for the dealerTurn method
            bj1.getDealerHand().add(card);
            bj1.getDealerHand().add(card);

            System.out.println(bj1);

            // checking the validity of our tests
            assert bj1.dealerTurn() == true : "Error in Blackjack::Blackjack()";

            // other possiblity
            bj1.getDealerHand().add(card);
            assert bj1.dealerTurn() == false : "Error in Blackjack::Blackjack()";

        }

        System.out.println("*** Done testing Blackjack! ***\n");
    }

    public static void main(String[] args) {

        blackjackTests();
    }
}
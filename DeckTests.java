/*
file name:      DeckTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

Further modified by Gent Maksutaj
February 25th 2024

How to run:     java -ea DeckTests
*/

public class DeckTests {

    public static void deckTests() {

        // case 1: testing Deck() and size()
        {
            // set up
            Deck d1 = new Deck();

            // verify
            System.out.println(d1);

            // test
            assert d1 != null : "Error in Deck::Deck()";
            assert d1.size() == 52 : "Error in Deck::Deck()";
        }

        // case 2: testing deal()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            Card c1 = d1.deal();

            assert d1 != null : "Error in Deck::deal()";
            assert c1 != null : "Error in Deck::deal()";
            assert d1.size() == 51 : "Error in Deck::deal()";
        }

        // case 3: testing build()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();
            d1.build();

            assert d1 != null : "Error in Deck::build()";
            assert c1 != null : "Error in Deck::deal()";
            assert c2 != null : "Error in Deck::deal()";
            assert c3 != null : "Error in Deck::deal()";
            assert d1.size() == 52 : "Error in Deck::build()";
        }

        // case 4: testing shuffle()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            String before = d1.toString();
            d1.shuffle();
            String after = d1.toString();

            assert !before.equals(after) : "Error in Deck::shuffle()";
            assert d1.size() == 52 : "Error in Deck::shuffle()";
        }

        {
            // case to check correct number of each card
            Deck d1 = new Deck();

            assert d1.toString().equals(
                    "[10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 2 3 4 5 6 7 8 9 2 3 4 5 6 7 8 9 2 3 4 5 6 7 8 9 2 3 4 5 6 7 8 9 ]")
                    : "Error in Deck::contentOfDeck";

            // todo: add case to check correct number of each card
        }

        {
            // care to check reshuffle randomness
            Deck deck = new Deck();
            int sumBeforeShuffling = 0;
            for (int i = 0; i < 10; i++) {
                sumBeforeShuffling += deck.deal().getValue();
            }
            // sum should be 100 because when we implemented the deck build() function we
            // started off with the cards with value 10

            int sumAfterShuffling = 0;
            deck.shuffle();
            for (int i = 0; i < 10; i++) {
                sumAfterShuffling += deck.deal().getValue();
            }

            // since 10 is the highest possible value of a card we can check how random our
            // reshuffle is by getting the difference between the sumBeforeShuffling and
            // sumAfterShuffling and making sure it exceeds a certain arbitrary value like
            // for example 10

            assert sumBeforeShuffling - sumAfterShuffling > 10 : "Error in Deck::Shuffling not random enough";
            // todo: add case to check reshuffle randomness

        }

        System.out.println("*** Done testing Deck! ***\n");
    }

    public static void main(String[] args) {

        deckTests();
    }
}
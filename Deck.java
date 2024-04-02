/*
 * 
 * CS 231 
 * Prof. Max Bender
 * Gent Maksutaj
 * February 25th 2024
 * 
 * The Deck class is really important to our overall project. The code in this file creates a deck class 
 * which uses the ArrayList data structure to hold 52 instances of a Card object. The constructor of this class
 * creates a new ArrayList and calls the build function in order to build the deck with the appropriate 52 cards.
 * Uses the random library to shuffle the deck in a random fashion.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    ArrayList<Card> deck;

    /**
     * Creates the underlying deck as an ArrayList of Card objects.
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck() {
        this.deck = new ArrayList<Card>();
        this.build();
    }

    /**
     * Builds the underlying deck as a standard 52 card deck.
     * Replaces any current deck stored.
     */
    public void build() {
        this.deck.clear();
        for (int i = 0; i < 16; i++) {
            Card card = new Card(10);
            this.deck.add(card);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 11; j++) {
                if (j != 10) {
                    Card card = new Card(j);
                    this.deck.add(card);
                }

            }
        }
    }

    /**
     * Returns the number of cards left in the deck.
     * 
     * @return the number of cards left in the deck
     */
    public int size() {
        return this.deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * 
     * @return the first card of the deck
     */
    public Card deal() {
        return this.pick(0);

    }

    public Card pick(int i) {
        Card forReturn = deck.get(i);
        this.deck.remove(i);
        return forReturn;

    }

    /**
     * Shuffles the cards currently in the deck. Utilizes the random library
     */
    public void shuffle() {
        Random generator = new Random();
        Deck deck2 = new Deck();
        this.deck.clear();
        for (int i = 0; i < 52; i++) {
            if (deck2.size() != 0) {
                this.deck.add(deck2.pick(generator.nextInt(deck2.size())));
            }
        }
    }

    /**
     * Returns a string representation of the deck.
     * 
     * @return a string representation of the deck
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < this.deck.size(); i++) {
            out.append(this.deck.get(i));
            out.append(" ");
        }
        out.append("]");
        return out.toString();
    }
}

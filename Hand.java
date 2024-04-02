/*
 * 
 * CS 231 
 * Prof. Max Bender
 * Gent Maksutaj
 * February 25th 2024
 * 
 * The hand class uses the data structure ArrayList to determine which of the player or dealer had the higher hand 
 * and which in turn would determine the winner of the game later on inside the blackjack class. Methods of this class
 * include the getter method for the size of the hand, the getter method to get the total value of the hand and a reset method which 
 * clears the hand. There is also a to_string method to represent the hand in a clean way.
 * 
 * 
 */

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    /**
     * Creates an empty hand as an ArrayList of Cards.
     */
    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    /**
     * Removes any cards currently in the hand.
     */
    public void reset() {
        this.hand.clear();
    }

    /**
     * Adds the specified card to the hand.
     * 
     * @param card the card to be added to the hand
     */
    public void add(Card card) {
        this.hand.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * 
     * @return the number of cards in the hand
     */
    public int size() {
        return this.hand.size();
    }

    /**
     * Returns the card in the hand specified by the given index.
     * 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index) {
        return this.hand.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * 
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < this.hand.size(); i++) {
            sum += this.hand.get(i).getValue();
        }
        return sum;
    }

    /**
     * Returns a string representation of the hand.
     * 
     * @return a string representation of the hand
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (int i = 0; i < this.hand.size(); i++) {
            out.append(this.hand.get(i));
            out.append(",");
        }
        out.append("] : ");
        out.append(getTotalValue());
        return out.toString();
    }
}

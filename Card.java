/*
 * 
 * CS 231 
 * Prof. Max Bender
 * Gent Maksutaj
 * February 25th 2024
 * 
 * This file builds the Card class for our project which is beneficial for all our other classes since the 
 * Card object is the main component of each of our other classes. This class has a contstructor which takes a value as 
 * a parameter and builds the card object with that face value. I also implemented a getter method and a to_string method.
 * 
 * 
 */
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * 
     * @param val
     */
    public Card(int val) {
        // TBD
        if (val > 11 || val < 2) {
            throw new IllegalArgumentException();
        }
        value = val;

    }

    /**
     * Returns the value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        // TBD
        return value;
    }

    /**
     * Returns a string representation of this card.
     * 
     * @return a string representation of this card
     */
    public String toString() {
        // TBD
        return ("" + value);
    }
}

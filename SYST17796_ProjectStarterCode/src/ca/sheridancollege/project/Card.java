/**
 * SYST 17796 Project Base code.
 * Author: Cyrus Tabakhi
 */
package ca.sheridancollege.project;

/**
 * An abstract class that models each Card in a deck of cards.
 * This class should be extended for specific types of cards.
 * Each card has a value and a suit.
 */
public abstract class Card {
    private String value;
    private Suit suit;

    public Card(String value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public abstract String toString();
}

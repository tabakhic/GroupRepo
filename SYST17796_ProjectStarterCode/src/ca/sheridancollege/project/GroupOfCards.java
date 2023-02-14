/**
 * SYST 17796 Project Base code.
 *Author: Cyrus Tabakhi
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that models a group of cards for a card game.
 */
public class GroupOfCards {
    private ArrayList<Card> cards;

    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the group of cards.
     * @param card the card to be added
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Removes a card from the group of cards.
     * @param card the card to be removed
     */
    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    /**
     * Gets the card at the specified index.
     * @param index the index of the card to retrieve
     * @return the card at the specified index
     */
    public Card getCard(int index) {
        return this.cards.get(index);
    }

    /**
     * Gets the number of cards in the group of cards.
     * @return the number of cards in the group of cards
     */
    public int getNumberOfCards() {
        return this.cards.size();
    }

    /**
     * Shuffles the group of cards.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}


/**
 * SYST 17796 Project Base code.
 * Author: Cyrus Tabakhi
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Cyrus
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandSize() {
        return hand.size();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public List<Card> searchHand(String rank) {
        List<Card> matchingCards = new ArrayList<>();

        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                matchingCards.add(card);
            }
        }

        return matchingCards;
    }

    public int removeMatchingCards(String rank) {
        List<Card> matchingCards = searchHand(rank);
        hand.removeAll(matchingCards);
        return matchingCards.size();
    }
    
public void incrementScore() {
    score++;
}

public int getScore() {
    return score;
}
}

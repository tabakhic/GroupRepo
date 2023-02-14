package ca.sheridancollege.project;

/**
 * Author: Cyrus Tabakhi
 * A class that models each Playing Card in a deck of cards.
 * Each card has a rank (e.g. Ace, Two, Three) and a suit (e.g. Hearts, Diamonds, Clubs, Spades).
 */
public class PlayingCard extends Card {
    private Rank rank;

    public PlayingCard(Rank rank, Suit suit) {
        super(rank.toString(), suit);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + getSuit();
    }
}

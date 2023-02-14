/**
 * SYST 17796 Project Base code.
 * Author: Cyrus
 */
package ca.sheridancollege.project;

/**
 * An abstract class that models each player in a card game.
 * This class should be extended for specific types of players.
 */
public abstract class Player {
    private String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        this.hand = new GroupOfCards();
    }
    
    /**
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the name of the player
     * @param name the name to set for the player
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the hand of the player
     */
    public GroupOfCards getHand() {
        return hand;
    }
    
    /**
     * Set the hand of the player
     * @param hand the hand to set for the player
     */
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }
    
    /**
     * Abstract method to be implemented by each subclass of Player.
     * Plays a turn of the game according to the specific rules for that player.
     */
    public abstract void playTurn();
}
    
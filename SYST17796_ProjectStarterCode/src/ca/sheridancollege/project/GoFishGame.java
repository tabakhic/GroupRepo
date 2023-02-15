/**
 * SYST 17796 Project Base code.
 * Author: Cyrus Tabakhi
 */

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Cyrus Tabakhi
 */
package ca.sheridancollege.project;

import java.util.Scanner;

public class GoFishGame {
    private static Player player1;
   private static Player player2; 
    private final GroupOfCards deck;
    private int score;

    private Player currentPlayer;

    public GoFishGame(String player1Name, String player2Name) {1
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new GroupOfCards();
        currentPlayer = player1;
    }

    public boolean isGameOver() {
        return deck.isEmpty() && player1.getHandSize() == 0 && player2.getHandSize() == 0;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String getOpponentHandSizesString() {
        return player1.getName() + ": " + player1.getHandSize() + " cards\n"
             + player2.getName() + ": " + player2.getHandSize() + " cards";
    }

    public void playTurn(String rank) {
        Player opponent = (currentPlayer == player1) ? player2 : player1;

        System.out.println(currentPlayer.getName() + " asks " + opponent.getName() + " for " + rank);

        boolean successful = false;
        for (Card card : opponent.searchHand(rank)) {
            currentPlayer.addCardToHand(card);
            opponent.playCard(opponent.getHand().indexOf(card));
            successful = true;
        }

        if (successful) {
            System.out.println("Successful!");
        } else {
            System.out.println("Go fish!");
            currentPlayer.addCardToHand(deck.draw());
            switchCurrentPlayer();
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player names from the user
        String player1Name = null;
        String player2Name = null;

        while (player1Name == null || player1Name.isEmpty()) {
            System.out.print("Enter a name for player 1: ");
            player1Name = scanner.nextLine().trim();
        }

        while (player2Name == null || player2Name.isEmpty()) {
            System.out.print("Enter a name for player 2: ");
            player2Name = scanner.nextLine().trim();
        }

        // Create the game and start playing
        GoFishGame game = new GoFishGame(player1Name, player2Name);

        while (!game.isGameOver()) {
            System.out.println("\n" + game.getOpponentHandSizesString());

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("\n" + currentPlayer.getName() + "'s turn");

            String rank = null;
            while (rank == null || rank.isEmpty()) {
                System.out.print("Enter a rank to ask for: ");
                rank = scanner.nextLine().trim();
            }

            game.playTurn(rank);
        }

        System.out.println("\nGame over!");
        System.out.println(game.getOpponentHandSizesString());

        int player1Score = player1.removeMatchingCards("Ace") + player1.removeMatchingCards("King");
        int player2Score = player2.removeMatchingCards("Ace") + player2.removeMatchingCards("King");

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1Name + " wins!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }}

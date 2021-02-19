package poker;

import java.util.Arrays;

/**
 * 
 * @author Ravi Ramanathan
 *
 */

public class Player {

	public final String name;
	private int balance;
	private Card[] hand;
	private boolean folded;
	private boolean allIn;
	private int dealt = 0;

	/***
	 * Player constructor
	 * 
	 * @param name
	 * @param money
	 */
	public Player(String name, int money) {
		this.name = name;
		this.balance = money;
		this.hand = new Card[2];
		this.folded = false;
		this.allIn = false;
	}

	/***
	 * Deal a player a new card from the deck. Package protected to avoid being
	 * dealt a card externally.
	 * 
	 * @param card Card from top of deck
	 * @return true if dealt a card, false if player already had a full hand
	 */
	boolean deal(Card card) {
		if (dealt == 2) {
			return false;
		}
		this.hand[dealt] = card;
		this.dealt++;
		return true;
	}

	/***
	 * have Player fold
	 */
	void fold() {
		this.folded = true;
	}

	/**
	 * Increase player's bet in the round.
	 * 
	 * @param value amount to be bet
	 * @return the amount actually bet; this could be different if the player does
	 *         not have enough in their balance, in which case they will be all in
	 */
	int bet(int value) {
		if (value < balance) {
			this.balance -= value;
			return value;
		} else {
			this.allIn = true;
			int returned = this.balance;
			this.balance = 0;
			return returned;
		}
	}

	/***
	 * getter for the balance
	 * @return the Player's balance
	 */
	public int getMoney() {
		return this.balance;
	}

	/***
	 *  
	 * @return whether the player has folded
	 */
	public boolean folded() {
		return this.folded;
	}

	/***
	 * Gives the Player the winnings from the round. 
	 * @param winnings amount won in this round
	 * @return the Player's new balance after collecting winnings
	 */
	int collectWinnings(int winnings) {
		this.balance += winnings;
		return this.balance;
	}

	/***
	 * 
	 * @return a copy of the Player's hand
	 */
	public Card[] getHand() {
		Card[] handCopy = new Card[2];
		handCopy[0] = new Card(this.hand[0]);
		handCopy[1] = new Card(this.hand[1]);
		return handCopy;
	}

	/***
	 * 
	 * @return whether Player is all in
	 */
	public boolean isAllIn() {
		return this.allIn;
	}

	@Override
	public String toString() {
		return this.name + ": " + Arrays.toString(hand) + ", Balance: $" + this.balance;
	}
}

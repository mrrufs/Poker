package poker;

import java.util.Arrays;

public class Player {

	public final String name;
	private int balance;
	private Card[] hand;
	private boolean folded;
	private boolean allIn;
	private int dealt = 0;

	public Player(String name, int money) {
		this.name = name;
		this.balance = money;
		this.hand = new Card[2];
		this.folded = false;
		this.allIn = false;
	}

	public boolean deal(Card card) {
		if (dealt == 2) {
			return false;
		}
		this.hand[dealt] = card;
		this.dealt++;
		return true;
	}

	public void fold() {
		this.folded = true;
	}

	public int bet(int value) {
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

	public int getMoney() {
		return this.balance;
	}

	public boolean folded() {
		return this.folded;
	}

	public int collectWinnings(int winnings) {
		this.balance += winnings;
		return this.balance;
	}

	public Card[] getHand() throws Exception {
		Card[] handCopy = new Card[2];
		handCopy[0] = this.hand[0].copy();
		handCopy[1] = this.hand[1].copy();
		return handCopy;
	}

	public boolean isAllIn() {
		return this.allIn;
	}

	@Override
	public String toString() {
		return this.name + ": " + Arrays.toString(hand) + ", Balance: $" + this.balance;
	}
}

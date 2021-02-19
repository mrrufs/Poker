package poker;

public class Card {
	public enum Suit {
		SPADES, CLUBS, HEARTS, DIAMONDS
	}

	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return this.rank;
	}

	public Suit suit() {
		return this.suit;
	}

	public Card copy() {
		return new Card(this.rank, this.suit);
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;

	}
}

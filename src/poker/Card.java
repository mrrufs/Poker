package poker;

/** 
 * 
 * @author Ravi Ramanathan
 *
 */

public class Card {
	public enum Suit {
		SPADES, CLUBS, HEARTS, DIAMONDS
	}

	public enum Rank {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	private final Rank rank;
	private final Suit suit;

	/***
	 * 
	 * @param rank Rank object defined in Card class representing card rank
	 * @param suit Suit object defined in Card class
	 */
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/***
	 * Copy constructor for a card object
	 * @param original
	 */
	public Card(Card original) {
		this.rank = original.rank;
		this.suit = original.suit;
	}

	/***
	 * Getter for the card's rank
	 * @return The rank object representing this card's rank
	 */
	public Rank getRank() {
		return this.rank;
	}

	/***
	 * Getter for the card's suit
	 * @return The suit object representing this card's suit
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/***
	 * Standard toString() method
	 */
	@Override
	public String toString() {
		return this.rank + " of " + this.suit;

	}
}

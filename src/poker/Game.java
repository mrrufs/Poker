package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Game {
	private Card[] deck;
	private ArrayList<Player> players;
	private HashMap<Player, Integer> playerBets;
	private final int BIG_BLIND;
	private final int LITTLE_BLIND;
	private final int round;
	private int MIN_BET;
	private int pot = 0;

	public Game(ArrayList<Player> players, int round, int big_blind, int little_blind) {
		this.players = players;

		// initialize starting bets to 0
		this.playerBets = new HashMap<>(this.players.size());
		for (Player player : players) {
			this.playerBets.put(player, 0);
		}

		// build a new deck
		this.deck = new Card[52];
		int deckPos = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				this.deck[deckPos++] = new Card(Card.Rank.values()[rank], Card.Suit.values()[suit]);
			}
		}

		// shuffle deck 3 times
		for (int i = 0; i < 3; i++) {
			shuffle(this.deck);
		}

		this.round = round;
		this.BIG_BLIND = big_blind;
		this.LITTLE_BLIND = little_blind;
	}

	public Game(ArrayList<Player> players, int round) {
		this(players, round, 2, 1);
	}

	public void run() {
		System.out.println("----- Round " + round + " -----");
		System.out.println(Arrays.toString(this.deck));

		// deal 2 cards to each player
		int deckPos = 0;
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.deal(deck[deckPos++]);
			}
		}

		// debug see hands
		for (Player player : players) {
			System.out.println(player);
		}

		// button goes on round mod #players
		int button = round % players.size();
		int littleBlind = (round + 1) % players.size();
		int bigBlind = (round + 2) % players.size();
		System.out.println("Dealer: " + players.get(button).name);

		// initialize temp bet variable and Player pointer
		int currBet = 0;
		Player playerPointer;

		// little blind ante
		System.out.println("Little Blind: " + players.get(littleBlind).name);
		playerPointer = players.get(littleBlind);
		currBet = playerPointer.bet(this.LITTLE_BLIND);
		pot += currBet;
		playerBets.put(playerPointer, currBet);

		// big blind ante
		System.out.println("Big Blind: " + players.get(bigBlind).name);
		playerPointer = players.get(bigBlind);
		currBet = playerPointer.bet(this.BIG_BLIND);
		pot += currBet;
		playerBets.put(playerPointer, currBet);

		// set min bet to big blind
		this.MIN_BET = this.BIG_BLIND;

		// debug see player bets + current pot
		for (Player player : players) {
			System.out.println(player.name + "'s bet: $" + playerBets.get(player));
		}
		System.out.println("-- Current Pot: $" + pot + " --");

		// debug see hands + balances
		for (Player player : players) {
			System.out.println(player);
		}
	}

	// set check to perform a poker check; i.e. make player bet current max
	private void check(Player player) {
		player.bet(this.MIN_BET);
	}

	// static method to shuffle the deck randomly
	private static void shuffle(Card[] deck) {
		Random random = new Random();
		for (int i = 0; i < deck.length; i++) {
			int randomIndexToSwap = random.nextInt(deck.length);
			Card temp = deck[randomIndexToSwap];
			deck[randomIndexToSwap] = deck[i];
			deck[i] = temp;
		}
	}
}

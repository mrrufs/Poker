package poker;

import java.util.ArrayList;

/**
 * 
 * @author Ravi Ramanathan
 *
 */
public class Driver {

	public static void main(String[] args) {

		ArrayList<Player> players = new ArrayList<>(5);
		players.add(new Player("Cole", 150));
		players.add(new Player("Skippy", 150));
		players.add(new Player("Scamp", 150));
		players.add(new Player("Chompsky", 150));
		players.add(new Player("Buggy", 150));
		int round = 0;
		Game newGame = new Game(players, round++);
		newGame.run();
	}
}

package sample_simon_game;

/**
* This class defines a player with its name and score.
*
* @author Badri Dahal
*/
public class Player implements Comparable<Player> {
	private String playerName;
	private int highScore;
	
	public Player(String playerName, int highScore) {
		this.playerName = playerName;
		this.highScore = 0;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int score) {
		if(score > this.highScore) {
			this.highScore = score;
		}
	}

	@Override
	public String toString() {
		return playerName + ": " + highScore;
	}

	@Override
	public int compareTo(Player compPlayer) {
		int compareScore=((Player)compPlayer).getHighScore();
        /* For Ascending order*/
		//  return this.highScore-compareScore;

        /* For Descending order do like this */
        return compareScore - this.highScore;
	}

	
	
}

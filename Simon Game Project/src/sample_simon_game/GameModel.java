package sample_simon_game;

/**
* This class helps to stoere and perform basic operations of the game.
*
* @author Badri Dahal
 */
public class GameModel {
	private int score;
	private int highScore;
	private double gameSpeed;
	
	static final double slowSpeed = 1.5;
	static final double normalSpeed = 1.2;
	static final double fastSpeed = 0.8;
	
	public GameModel() {
		this.score = 0;
		this.highScore = 0;
		this.gameSpeed = normalSpeed;
	}

	public int getScore() {
		return score;
	}
	
	public void initScore() {
		this.score = 0;
	}

	public void addScore() {
		this.score++;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore() {
		if(this.score > this.highScore) {
			this.highScore = this.score;
		}
	}
	
	public double getGameSpeed() {
		return gameSpeed;
	}
	
	public void setGameSpeed(double speed) {
		this.gameSpeed = speed;
	}
}

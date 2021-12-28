package sample_simon_game;

import java.awt.EventQueue;

/**
* This java application is a game very much similar to Online Simon Game. 
* The overall functionalities resembles the actual game.
*  The actual game can be found online.
*
*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
* @author Badri Dahal
*/

public class GameMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameController newGame = new GameController(new GameModel(), new GameView());					
					newGame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

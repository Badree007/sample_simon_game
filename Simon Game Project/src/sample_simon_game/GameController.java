package sample_simon_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;

/**
* This class controls the overall functionalities and user interactions.
*
* @author Badri Dahal
 */
public class GameController {
	private GameModel model;
	private GameView view;
	private Player currPlayer;
	
	private ArrayList<JButton> gameButtons;
	private ArrayList<Player> playerList;
	private boolean play;
	
	
	public GameController(GameModel model, GameView view) {
		this.model = model;
		this.view = view;
		this.play = true;
	}
	
	public void init() {		
		view.initialize();
		gameButtons = new ArrayList<JButton>();	
		playerList = new ArrayList<Player>();	

		gameButtons.add(view.getBtnBlue());
		gameButtons.add(view.getBtnRed());
		gameButtons.add(view.getBtnYellow());
		gameButtons.add(view.getBtnGreen());
		
		setGameSpeed();
		start();
	}
	
	
	public ArrayList<JButton> getGameButtons() {
		return gameButtons;
	}

	public void setGameButtons(ArrayList<JButton> gameButtons) {
		this.gameButtons = gameButtons;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	private void start() {	
		
		view.getBtnPlay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String playerName = view.getPlayerName().getText();
				
				if(playerName.equals("")) {
					System.out.println("Empty Field");
					
				} else {
					currPlayer = getCurrentPlayer(playerName);
		
					ArrayList<JButton> buttonPattern = new ArrayList<JButton>();
					
					Thread th = new Thread(new Runnable() {
						@Override
						public void run() {
							view.hidePanel();
							model.initScore();
							view.setScore(Integer.toString(model.getScore()));
							view.setHighScore(Integer.toString(currPlayer.getHighScore()));
							view.disableSpeedBtn();
						}
					});
					th.start();
					
			   //// Watch
					Thread newTh = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								System.out.println("Start");
								play = true;
								
								while(play) {
									int gameSpeed = (buttonPattern.size() + 4) * 1000;
									///Watch
									watchPattern(buttonPattern);				
									///Play
									ArrayList<JButton> btnList = playRound(buttonPattern);
									Thread.sleep(gameSpeed);
									
									if(btnList.isEmpty()) {
										gameOver();
										Thread.sleep(2000);
										break;
									};
								}
								view.showPanel();
								view.enableSpeedBtn();
								view.setTextField();
								view.getScorePanel().removeAll();
								view.getScorePanel().revalidate();
								
								Collections.sort(playerList);
								
								int position = 0;
								for(Player p : playerList) {
									System.out.println(p.toString());
									view.updateScoreSheet(p, position);
									position += 20;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					newTh.start();
				}
			}

		});
	}
	
	private Player getCurrentPlayer(String playerName) {
		Player player = null;
		if(playerList.size() > 0) {
			for(Player p : playerList) {
				if(p.getPlayerName().equals(playerName)) {
					player =  p;
					break;
				} else {
					player =  new Player(playerName, 0);
				}
			}
		} else {
			player = new Player(playerName, 0);
		}
		return player;
	}

	private ArrayList<JButton> playRound(ArrayList<JButton> buttonPattern) {
		System.out.println("Playing");
		view.setInstruction("Play!");
		System.out.println("pattern size: " + buttonPattern.size());
		view.enableBtn();
		
		ArrayList<JButton> clickedButton = new ArrayList<JButton>(buttonPattern.size());
		
		for(JButton btn : gameButtons) {
			for( ActionListener al : btn.getActionListeners() ) {
			    btn.removeActionListener( al );
			}
			
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(clickedButton.size() < buttonPattern.size()) {
						System.out.println("clicked");
						clickedButton.add((JButton)e.getSource());
						System.out.println("Clicked button size: " + clickedButton.size());
						
						if(!btn.equals(buttonPattern.get(clickedButton.indexOf(btn)))) {
							gameOver();
							return;
						}
					} 
					
					if(clickedButton.size() == buttonPattern.size()) {
						
						if(clickedButton.equals(buttonPattern)) {
							view.setInstruction("Next Round");
							updateScore();
							play = true;
							return;
						} 
						else {
							gameOver();
							return;
						}
					}
				}
			});
		}
		return clickedButton;
	}
	
	private void gameOver() {
		view.setInstruction("Wrong, Game over!");
		System.out.println("Game Over!!!");
		currPlayer.setHighScore(model.getScore());
		updateGameScore();
		if(!playerList.contains(currPlayer)) {
			playerList.add(currPlayer);
		}
		play = false;
		view.disableBtn();
	}

	private void watchPattern(ArrayList<JButton> buttonPattern) {
		System.out.println("Watching");
		view.setInstruction("Watch!");
		view.disableBtn();
		double speed = model.getGameSpeed() * 1000;
		Random randInt = new Random();
		int nextPattern = randInt.nextInt(4);
		buttonPattern.add(gameButtons.get(nextPattern));
		try {
			Thread.sleep(1000);
			
			for(int i=0; i<buttonPattern.size(); i++) {
				view.glowButton(buttonPattern.get(i));
				Thread.sleep((long) speed);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	private void updateScore() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				model.addScore();
				view.setScore(Integer.toString(model.getScore()));	
				view.getFrame().repaint();
			}			
		});
		t.start();
	}
	
	private void updateGameScore() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				model.setHighScore();
				view.setScore("0");
				view.setHighScore(Integer.toString(model.getHighScore()));
				view.getFrame().repaint();
			}			
		});
		t.start();
	}
	
	private void setGameSpeed() {
		view.getBtnSlow().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAction(view.getBtnSlow(), GameModel.slowSpeed);
			}
			
		});
		view.getBtnFast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAction(view.getBtnFast(), GameModel.fastSpeed);
			}
			
		});
		view.getBtnNormal().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnAction(view.getBtnNormal(), GameModel.normalSpeed);
			}
			
		});
	}
	
	private void btnAction(JButton btn, double speed) {
		model.setGameSpeed(speed);
		view.initialActionBtn();
		btn.setBackground(Color.CYAN);
	}
	
}

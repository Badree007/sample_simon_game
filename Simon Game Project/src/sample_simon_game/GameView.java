package sample_simon_game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;

/**
* This class is responsible to create frame window or graphics for user to interact with the game.
*
* @author Badri Dahal
*/

public class GameView {

	private JFrame frmSampleSimonGame;
	private JButton btnPlay;
	private JPanel panel_6;
	private JPanel panel_7;
	private JButton btnBlue;
	private JButton btnRed;
	private JButton btnYellow;
	private JButton btnGreen;
	private JLabel instruct;
	private JLabel score;
	private JLabel highScore;
	private JButton btnSlow;
	private JButton btnNormal;
	private JButton btnFast;
	private JTextField playerName;
	private JPanel scorePanel;
	private JLabel lblNewLabel_2;
	
	
	public JPanel getScorePanel() {
		return scorePanel;
	}
	
	public JTextField getPlayerName() {
		return playerName;
	}
	
	public void setTextField() {
		playerName.setText("");
	}
	
	public JButton getBtnSlow() {
		return btnSlow;
	}

	public JButton getBtnNormal() {
		return btnNormal;
	}

	public JButton getBtnFast() {
		return btnFast;
	}

	public JFrame getFrame() {
		return frmSampleSimonGame;
	}
	
	public JButton getBtnBlue() {
		return btnBlue;
	}

	public JButton getBtnRed() {
		return btnRed;
	}

	public JButton getBtnYellow() {
		return btnYellow;
	}

	public JButton getBtnGreen() {
		return btnGreen;
	}
	
	public JButton getBtnPlay() {
		return btnPlay;
	}
	
	public JPanel getPanel6() {
		return panel_6;
	}
	
	public JPanel getPanel7() {
		return panel_7;
	}
	

	public JLabel getScore() {
		return score;
	}
	
	public JLabel getHighScore() {
		return highScore;
	}

	public void setScore(String score) {
		this.score.setText(score);
	}

	public void setHighScore(String highScore) {
		this.highScore.setText(highScore);
	}
	
	public void setInstruction(String text) {
		this.instruct.setText(text);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameView window = new GameView();
					window.frmSampleSimonGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	
	public GameView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmSampleSimonGame = new JFrame();
		frmSampleSimonGame.setVisible(true);
		frmSampleSimonGame.setTitle("Sample Simon Game");
		frmSampleSimonGame.setBounds(100, 100, 607, 355);
		frmSampleSimonGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frmSampleSimonGame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 153));
		panel_1.setBounds(0, 0, 591, 229);
		panel_1.setBorder(new EmptyBorder(10, 30, 10, 30));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBounds(30, 10, 531, 208);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(102, 153, 153));
		panel_7.setLayout(null);
		
		JLabel lblWelcome = new JLabel("<HTML><U>Sample Simon Game</U></HTML>");
		lblWelcome.setForeground(SystemColor.textText);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblWelcome.setBounds(0, 0, 531, 44);
		panel_7.add(lblWelcome);
		
		btnPlay = new JButton("Play!");
		btnPlay.setBounds(190, 121, 103, 44);
		panel_7.add(btnPlay);
		btnPlay.setBackground(SystemColor.inactiveCaption);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		playerName = new JTextField();
		playerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playerName.setBounds(135, 67, 214, 34);
		panel_7.add(playerName);
		playerName.setColumns(10);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayerName.setBounds(10, 66, 103, 34);
		panel_7.add(lblPlayerName);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel_9.setBackground(new Color(220, 220, 220));
		panel_9.setBounds(395, 47, 126, 150);
		panel_7.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblScoreSheet = new JLabel("<HTML><U>Score Sheet</U></HTML>");
		lblScoreSheet.setBounds(0, 0, 126, 26);
		lblScoreSheet.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreSheet.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(lblScoreSheet);
		
		scorePanel = new JPanel();
		scorePanel.setBounds(0, 25, 126, 125);
		panel_9.add(scorePanel);
		scorePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		scorePanel.setBackground(new Color(220, 220, 220));
		scorePanel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("* Player Name Field cannot be empty!");
		lblNewLabel_2.setForeground(new Color(244, 164, 96));
		lblNewLabel_2.setBounds(135, 48, 214, 14);
		panel_7.add(lblNewLabel_2);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(102, 153, 153));
		panel_6.setBounds(30, 10, 531, 208);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		
		instruct = new JLabel("Watch!");
		instruct.setForeground(SystemColor.textText);
		instruct.setBounds(0, 0, 531, 65);
		panel_6.add(instruct);
		instruct.setHorizontalAlignment(SwingConstants.CENTER);
		instruct.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 51, 102,0));
		panel_3.setBounds(0, 66, 531, 142);
		panel_6.add(panel_3);
		panel_3.setBorder(new EmptyBorder(10, 20, 10, 20));
		panel_3.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(51, 102, 102));
		panel_8.setBorder(UIManager.getBorder("Button.border"));
		panel_8.setBounds(134, 11, 267, 122);
		panel_3.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 2, 10, 10));
		
		btnBlue = new JButton("");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlue.setForeground(new Color(51, 102, 153));
		btnBlue.setBackground(new Color(51, 102, 153));
		panel_8.add(btnBlue);
		
		btnRed = new JButton("");
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRed.setForeground(new Color(204, 0, 0));
		btnRed.setBackground(new Color(204, 0, 0));
		panel_8.add(btnRed);
		
		btnYellow = new JButton("");
		btnYellow.setForeground(new Color(255, 204, 0));
		btnYellow.setBackground(new Color(255, 204, 0));
		panel_8.add(btnYellow);
		
		btnGreen = new JButton("");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGreen.setForeground(new Color(0, 153, 51));
		btnGreen.setBackground(new Color(51, 153, 51));
		panel_8.add(btnGreen);
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				hidePanel();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 228, 591, 88);
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new EmptyBorder(10, 30, 10, 30));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 5, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0,0,0,0));
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panel_2.add(panel_4);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblScore);
		
		score = new JLabel("0");
		score.setBackground(new Color(224, 255, 255, 0));
		score.setForeground(new Color(224, 255, 255));
		score.setFont(new Font("Tahoma", Font.BOLD, 14));
		score.setFocusable(false);
		score.setOpaque(true);
		panel_4.add(score);
		
		JLabel lblHighScore = new JLabel("High Score:");
		lblHighScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_4.add(lblHighScore);
		
		highScore = new JLabel("0");
		highScore.setBackground(new Color(224, 255, 255, 0));
		highScore.setForeground(new Color(224, 255, 255));
		highScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		highScore.setFocusable(false);
		highScore.setOpaque(true);
		panel_4.add(highScore);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(60, 179, 113));
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Speed - ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_1);
		
		btnSlow = new JButton("Slow");
		btnSlow.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(btnSlow);
		
		btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(btnNormal);
		
		btnFast = new JButton("Fast");
		btnFast.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(btnFast);
	}
	
	public void glowButton(JButton btn) {
		try {
			Color originalColor = btn.getBackground();
			btn.setBackground(originalColor.brighter());
			Timer timer = new Timer(500, event -> {
				btn.setBackground(originalColor);
	        });
	        timer.setRepeats(false);
	        timer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void hidePanel() {
		panel_6.setVisible(true);
		panel_7.setVisible(false);
	}
	
	public void showPanel() {
		panel_7.setVisible(true);
		panel_6.setVisible(false);
	}

	public void disableBtn() {
		btnBlue.setEnabled(false);
		btnRed.setEnabled(false);
		btnYellow.setEnabled(false);
		btnGreen.setEnabled(false);
	}
	
	public void enableBtn() {
		btnBlue.setEnabled(true);
		btnRed.setEnabled(true);
		btnYellow.setEnabled(true);
		btnGreen.setEnabled(true);
	}
	
	public void disableSpeedBtn() {
		btnNormal.setEnabled(false);
		btnSlow.setEnabled(false);
		btnFast.setEnabled(false);
	}
	
	public void enableSpeedBtn() {
		btnNormal.setEnabled(true);
		btnSlow.setEnabled(true);
		btnFast.setEnabled(true);
	}
	
	public void initialActionBtn() {
		btnNormal.setBackground(new Color(240, 240, 240));
		btnSlow.setBackground(new Color(240, 240, 240));
		btnFast.setBackground(new Color(240, 240, 240));
	}
	
	public void updateScoreSheet(Player player, int pos) {
		JLabel lblNewLabel = new JLabel(player.toString());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, pos, 100, 20);
		scorePanel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
}

package com.marianna.Controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.marianna.Model.TicTacToeModel;
import com.marianna.View.Board;
import com.marianna.View.GameMenu;
import com.marianna.View.TicTacToeView;


/**
 * @author marianna 
 * implementation of Singleton class/design pattern in our Controller class of MVC design pattern.
 * In this project we are limiting the use of the controller to one, one controller object per game.
 * A new controller object will be created each time a new game begins or an actual game resets.
 */


public class Controller extends JFrame {

	private Board board;
	private GameMenu menu;
	private TicTacToeModel game;
	private TicTacToeView ticTacToeView;
	private boolean playerBoolean = true;
	private static int playerTurn = 1;
	private static Integer gameCount = 0;
	private static Controller controller;
	private String message;

	Controller(TicTacToeModel game, GameMenu menu, Board board) {

		setLayout(new BorderLayout());
		this.game = game;
		this.menu = menu;
		this.board = board;

		gameCount = 0;
		playerBoolean = true;
		playerTurn = 1;

		board.addButtonListener(new ButtonListener());
		menu = new GameMenu();
		menu.addMenuActionListenr(new MenuListener());

		add(board, BorderLayout.CENTER);
		add(menu, BorderLayout.NORTH);

		setVisible(true);
		setLocationRelativeTo(null);
		setSize(350, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	private Controller() {
	}

	
	
	public static Controller getInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton click = (JButton) e.getSource();

			for (int i = 0; i < board.getButton().length; i++) {
				for (int j = 0; j < board.getButton().length; j++) {

					int counter = game.getNumberOfCells();
					counter = counter * counter;

					if (board.getButton()[i][j] == click && gameCount < counter) {
						gameCount++;

						board.getButton()[i][j].setFont(new Font("calibri", Font.BOLD, 50));
						board.getButton()[i][j].setText(game.getStatus(i, j));
						
						
						

						playerTurn = togglePlayer(playerBoolean);
						board.getButton()[i][j].setEnabled(false);
						
						//if (click.getActionCommand().equals("X") || click.getActionCommand().equals("O")) {	
							//String busyCell;
							//busyCell = "This cell is taken, choose another one.";
							//JOptionPane.showMessageDialog(null, busyCell);
							//
						//}
						
							
							
						setWinner(i, j, playerTurn);

						if (gameCount == counter) {
							int n = 0;
							String gameTied;
							gameTied = "No winner, the game tied! ";
							game = new TicTacToeModel(n, gameTied);
							game.getMessage();
						}
						
						
					}
				}
			}
		}
	}

	
	
	/**
	 * 
	 * @author marianna
	 * Moving menu's actionPerformed method from View class to Controller class
	 * so that the controller take care of the functionality of menu's items.
	 */ 
	public class MenuListener implements ActionListener {
		
	/**
	 * Changing if state to switch in this method in order to minimize the usage
	 * of "if" state, and for more appropriate functionality and coding style purpose.
	 */
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand().toLowerCase();
		
			switch (ac) {
			case "new game":
				reset();
				break;
			case "rules":
				int n = 0;
				 message = "You can choose the game board size between 3-5 i.g 3x3, 4x4, 5x5.\n"
						+ "Player X always starts the game, so make sure you and your partner \n"
						+ "arrange who will take X and who is O. \n"
						+ "The game ends either by the winning of X or O after \n"
						+ "achieving three in a row, or four in a row or five in a raw, based \n"
						+ "on which size of board you chose from the beginning. \n"
						+ "If there's no winner, the game will be tied. \n"
						+ "So, good luck!!";
				game = new TicTacToeModel(n, message);
				game.getMessage();
				break;
			case "exit":
				int n2 = 0;
				message = "Thanks for playing, hope you enjoyed!";
				game = new TicTacToeModel(n2, message);
				game.getMessage();
				System.exit(0);
				break;
			default:
				int n3 = 0;
				message = "Invalid option.";
				game = new TicTacToeModel(n3, message);
				game.getMessage();
				break;
			}
		}
	}

	
	public void checkWinner(int player) {

		for (int i = 0; i < game.move.length; i++) {
			for (int j = 0; j < game.move.length; j++) {
				if (game.getNumberOfCells() == 3) {
					if (game.move[i][0] == player && game.move[i][1] == player && game.move[i][2] == player) {
						displayWinnerMessage(player);
					} else if (game.move[0][j] == player && game.move[1][j] == player && game.move[2][j] == player) {
						displayWinnerMessage(player);
					} else if ((game.move[0][0] == player && game.move[1][1] == player && game.move[2][2] == player)
							|| (game.move[2][0] == player && game.move[1][1] == player && game.move[0][2] == player)) {
						displayWinnerMessage(player);
					}
				}
				if (game.getNumberOfCells() == 4) {
					if (game.move[i][0] == player && game.move[i][1] == player && game.move[i][2] == player
							&& game.move[i][3] == player) {
						displayWinnerMessage(player);
					} else if (game.move[0][j] == player && game.move[1][j] == player && game.move[2][j] == player
							&& game.move[3][j] == player) {
						displayWinnerMessage(player);
					} else if ((game.move[0][0] == player && game.move[1][1] == player && game.move[2][2] == player
							&& game.move[3][3] == player)
							|| (game.move[3][0] == player && game.move[2][1] == player && game.move[1][2] == player
									&& game.move[0][3] == player)) {
						displayWinnerMessage(player);
					}
				}
				if (game.getNumberOfCells() == 5) {
					if (game.move[i][0] == player && game.move[i][1] == player && game.move[i][2] == player
							&& game.move[i][3] == player && game.move[i][4] == player) {
						displayWinnerMessage(player);
					} else if (game.move[0][j] == player && game.move[1][j] == player && game.move[2][j] == player
							&& game.move[3][j] == player && game.move[4][j] == player) {
						displayWinnerMessage(player);
					} else if ((game.move[0][0] == player && game.move[1][1] == player && game.move[2][2] == player
							&& game.move[3][3] == player && game.move[4][4] == player)
							|| (game.move[4][0] == player && game.move[3][1] == player && game.move[2][2] == player
									&& game.move[1][3] == player && game.move[0][4] == player)) {
						displayWinnerMessage(player);
					}
				}
			}
		}
	}

	
	/*
	 * Commenting out reset() method so the players be able to see the result of the game
	 * before starting a new game or quitting.
	 */
	public void displayWinnerMessage(int player) {

		if (player == 1) {
			int n = 0;
			message = "The winner is: X";
			game = new TicTacToeModel(n, message);
			game.getMessage();
			//reset();

		} else if (player == 2) {
			int n = 0;
			message = "The winner is: O";
			game = new TicTacToeModel(n, message);
			game.getMessage();
			//reset();
		}
	}

	
	public void setWinner(int i, int j, int winner) {

		char playerChar = (char) winner;
		game.move[i][j] = playerChar;
		checkWinner(winner);
	}

	
	public int togglePlayer(boolean turn) {

		if (turn == true) {
			playerBoolean = false;
			return 1;
		} else {
			playerBoolean = true;
			return 2;
		}
	}
	
	

	/*
	 * Resetting the game board to start over a new game
	 * and creating a new Controller object for the new to-be created board 
	 */
	public void reset() {

		ticTacToeView = new TicTacToeView();
		String msg = "";
		game = new TicTacToeModel(ticTacToeView.getCell(), msg);
		GameMenu menu = new GameMenu();
		Board board = new Board(ticTacToeView.getCell());
		new Controller(game, menu, board);

		this.menu = menu;
		this.board = board;

		gameCount = 0;
		playerBoolean = true;
		playerTurn = 0;

		for (int i = 0; i < board.getButton().length; i++) {
			for (int j = 0; j < board.getButton().length; j++) {
				board.getButton()[i][j].setText("");
				board.getButton()[i][j].setEnabled(true);
				board.getButton()[i][j].setSelected(false);
			}
		}
	}
}

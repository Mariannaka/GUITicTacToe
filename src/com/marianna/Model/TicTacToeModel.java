package com.marianna.Model;

import java.util.Arrays;
import javax.swing.JOptionPane;


public class TicTacToeModel implements GameInterface {
	public char[][] move;
	private int numberOfCells;
	private String message;
	private byte value = 0;

	
	/**
	 * A constructor to create an instance of model which takes two parameter
	 * @param numberOfCells takes in value 3-5 to create the game board accordingly
	 * @param message takes in the appropriate message according to the user's choice as a String parameter,
	 *  and display it as a message dialog by calling getMessage() method
	 */
	public TicTacToeModel(int numberOfCells, String message) {
		this.numberOfCells = numberOfCells;
		this.message = message;

		move = new char[numberOfCells][numberOfCells];
		for (int i = 0; i < move.length; i++) {
			Arrays.fill(move[i], ' ');
		}
	}

	@Override 
	public boolean move(int i, int j) {
		char player = 0;
		if (i >= 0 && i < numberOfCells && j >= 0 && j < numberOfCells) {
			if (move[i][j] != ' ')
				return false;
			else {
				move[i][j] = (char) player;
				return true;
			}
		} else
			return false;
	}

	@Override
	public String getStatus(int i, int j) {
		value++;

		if (value % 2 == 0) {
			return XOEnum.OBUTTON.getValue();
		} else {
			return XOEnum.XBUTTON.getValue();
		}
	}

	@Override
	public String getMessage() {

		JOptionPane.showMessageDialog(null, message);

		return message;
	}

	public int getNumberOfCells() {
		return numberOfCells;
	}

	public char[][] getMove() {
		return move;
	}
}

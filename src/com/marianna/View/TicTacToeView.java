package com.marianna.View;

import javax.swing.JOptionPane;

/**
 * 
 * @author marianna
 * An instance of this View class will be shown/run at the very beginning after
 * the project run. In other words, an input dialog will be displayed for the user to enter
 * the desired game board size (between 3-5)
 *
 */

public class TicTacToeView {

	private int cell;

	public TicTacToeView() {
		firstView();
	}

	
	/*
	 * Showing error message by using an Exception when unknown type of character is
	 * written or when a character can not be converted to a numeric (integer) type
	 * of a value
	 */
	public void firstView() {
		boolean check = true;
		while (check) {

			String input = JOptionPane.showInputDialog("Please choose the size of your game board between 3-5");
			try {
				if (!input.equals("")) {
					cell = Integer.parseInt(input);
					if (cell > 2 && cell < 6) {
						setCell(cell);
						check = false;
					} else {
						JOptionPane.showMessageDialog(null, "You are either choosing too little or too big value.");
					}
				}
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Unknown value. You can only use numbers!");
			}
		}

	}
	
	
	
	
	public int getCell() {
		return cell;
	}

	public void setCell(int cell) {
		this.cell = cell;
	}
}

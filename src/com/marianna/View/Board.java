package com.marianna.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * @author marianna 
 * 
 */

public class Board extends JPanel {

	private JButton[][] button;
	private int btn;

	
	/*
	 * creating the game board and setting the same value for both buttons and layout
	 */
	public Board(int n) {
		this.btn = n;
		button = new JButton[n][n];
		setLayout(new GridLayout(n,n));
		setRowCol();
	}
	
	
	/*
	 * creating the buttons and calling the method when creating the board
	 */
	public void setRowCol() {
		button = new JButton[btn][btn];
		for (int row = 0; row < button.length; row++) {
			for (int col = 0; col < button.length; col++) {
				button[row][col] = new JButton("");
				add(button[row][col], BorderLayout.CENTER);
			}
		}
	}
	

	public void addButtonListener(ActionListener listener) {
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				button[i][j].addActionListener(listener);
			}
		}
	}

	public JButton[][] getButton() {
		return button;
	}
}

package com.marianna.Controller;

import com.marianna.Model.TicTacToeModel;
import com.marianna.View.Board;
import com.marianna.View.GameMenu;
import com.marianna.View.TicTacToeView;

public class Main {

	public static void main(String[] args) {

		TicTacToeView numberOfCells = new TicTacToeView();
		String msg = "";
		TicTacToeModel game = new TicTacToeModel(numberOfCells.getCell(), msg);
		GameMenu menu = new GameMenu();
		Board board = new Board(numberOfCells.getCell());
		new Controller(game, menu, board);
	}
}

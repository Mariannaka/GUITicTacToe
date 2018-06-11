package com.marianna.View;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 * @author marianna A class for menu creation.
 */


public class GameMenu extends JPanel {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem newGameItem,rulesItem,exitItem;
	
	public GameMenu(){

		setLayout(new FlowLayout(3));
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");

		newGameItem = new JMenuItem("New Game");
		rulesItem = new JMenuItem("Rules");
		exitItem = new JMenuItem("Exit");

		menuBar.add(menu);
		menu.add(newGameItem);
		menu.add(rulesItem);
		menu.add(exitItem);
		add(menuBar);
	}
	
	
	/*
	 * A separate method to add actionListeners to each menu item (newGame, rules, exit)
	 */
	public void addMenuActionListenr(ActionListener listener){
		newGameItem.addActionListener(listener);
		rulesItem.addActionListener(listener);
		exitItem.addActionListener(listener);
	}
}

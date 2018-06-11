package com.marianna.Model;

/**
 * @author marianna 
 * implementation of an interface according to one of the assignment's requirement
 */

public interface GameInterface {
	
	public boolean move(int i, int j); 
	public String getStatus(int i, int j); 
	public String getMessage();

}

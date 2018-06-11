package com.marianna.Model;

/**
 * @author marianna 
 * An enum class for predefined values of constants X and O
 * In our case, each of the variables XBUTTON and OBUTTON has only one constant value,
 * Which are X and O.
 */

public enum XOEnum {
	XBUTTON("X"), OBUTTON("O");

	private final String value;

	XOEnum(String dec) {
		value = dec;
	}

	public String getValue() {
		return value;
	}

}

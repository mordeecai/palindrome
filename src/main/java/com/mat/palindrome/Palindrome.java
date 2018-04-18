package com.mat.palindrome;

/**
 * Author: Adrian Zara
 * Description: This is the palindrome object with more functionality compared to a raw String object
 * to make is easier to validate a palindrome string
 *
 */

public class Palindrome {
	
	private final String text;
	private final int index;
	
	public Palindrome(String text, int index) throws Exception {
		if(!Util.isPalindrome(text)) {
			throw new Exception(text + " is not a palindrome");
		}
		this.text = text;
		this.index = index;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getLength() {
		return this.text.length();
	}
	
	@Override
	public boolean equals(Object text) {
		return this.text.equals(((Palindrome) text).getText());
	}
	
	@Override
	public int hashCode() {
		return this.text.length();
	}
	
	@Override
	public String toString() {
		return "Text: " + text + ", Index: " + index  + ", Length: " + text.length() + "\n";
	}

}

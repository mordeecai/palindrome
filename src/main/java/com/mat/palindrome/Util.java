package com.mat.palindrome;

/**
 * Author: Adrian Zara
 * Description: This class holds and can hold all other functionality for the app
 */

public class Util {
		
	//A reusable palindrome text checker
	public static boolean isPalindrome(String text) {
		int i = 0, j = text.length() - 1;
		while(i < j) {
			if(text.charAt(i) != text.charAt(j)) {
				return false;
			}
			i++; j--;
		}
		
		return true;
	}

}

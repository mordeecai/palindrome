package com.mat.palindrome;

/**
 * Author: Adrian Zara
 * Description: This is the class which is resposible for identifying all possible
 * palindromes inside a given string  as well as the presentation and filtering functions
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Extractor {
	private String text;
	private List<Palindrome> palindromes = new ArrayList<>();
	public static final int TOP_BATCH = 3;

	public Extractor(String text) {
		this.text = text;
		palindromes = getPalindromes(); //Force extraction of palindromes during instantiation
	}

	private boolean isWithinString(int beingIndex, int endIndex) {
		return (beingIndex > 0) && endIndex < text.length();
	}

	public List<Palindrome> getPalindromes() {
		for (int i = 0; i < this.text.length() - 1; i++) {
			for (int j = i + 1; j < this.text.length(); j++) {
				if (isWithinString(i, j)) { //This is a double checking whether a substring 
											//is within the parent string
					String str = text.substring(i, j);
					if (Util.isPalindrome(str)) {
						try {
							Palindrome p = new Palindrome(str, i);
							if (!palindromes.contains(p)) { //Check of uniqueness
								palindromes.add(p);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		return palindromes;
	}

	//Extracting the top three longest palindrome in the string
	public List<Palindrome> extractTopThree() {
		final int minLength;
		palindromes.sort(Comparator.comparing(Palindrome::getLength).reversed());
		
		//Get unique lengths of the palindromes by collecting themm as a Set object
		List<Integer> lengthList = palindromes.stream().map(x -> x.getLength()).collect(Collectors.toList());
		Set<Integer> strLengths = new HashSet<Integer>(lengthList);
		if(strLengths.size() > 3) {
			//Set is always in ascending order so we take 3rd to the last length
			minLength = strLengths.stream().collect(Collectors.toList()).get(strLengths.size() - TOP_BATCH);
			return palindromes.stream().filter(x -> x.getLength() >= minLength).collect(Collectors.toList());
		}

		return palindromes;
	}
	
	//Printing top three palindromes
	public void printTopThree() {
		extractTopThree().forEach(p -> System.out.println(p));
	}

}

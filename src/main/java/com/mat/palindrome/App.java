package com.mat.palindrome;

import java.util.Scanner;

/**
 * Author: Adrian Zara
 * Description: This is the entry point class when running the app as a executable jar
 */
public class App 
{
    public static void main( String[] args ) {
    	Scanner sc = new Scanner(System.in);  
    	System.out.println("Enter a string:");  
    	String text = sc.next(); 
    	try {
			Extractor extractor = new Extractor(text);
			extractor.extractTopThree().forEach(p -> System.out.println(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

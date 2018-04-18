package com.mat.palindrome;

/**
 * Author: Adrian Zara
 * Description: This is a Test Suite class which contains test cases that will
 * be executed upon calling maven commands without skipping the tests
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * This is a test of the length of the top three palindromes including the checking of contents
     */
    public void testApp()
    {
    	String test = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";
    	Extractor extractor = new Extractor(test);
    	extractor.printTopThree();
        assertTrue(extractor.extractTopThree().size()  == 6);
        try {
        	Palindrome temp = new Palindrome("hijkllkjih", 23);
        	assertTrue(extractor.extractTopThree().contains(temp));
        	
        	temp = new Palindrome("defggfed", 13);
        	assertTrue(extractor.extractTopThree().contains(temp));
        	
        	temp = new Palindrome("ijkllkji", 24);
        	assertTrue(extractor.extractTopThree().contains(temp));
        	
        	temp = new Palindrome("abccba", 5);
        	assertTrue(extractor.extractTopThree().contains(temp));
        	
        	temp = new Palindrome("efggfe", 14);
        	assertTrue(extractor.extractTopThree().contains(temp));
        	
        	temp = new Palindrome("jkllkj", 25);
        	assertTrue(extractor.extractTopThree().contains(temp));
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

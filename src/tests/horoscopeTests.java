package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Horoscope.Horoscope;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class horoscopeTests {

	private Horoscope horoscopeTest;
	
	@BeforeEach
	void setup() {
		horoscopeTest = new Horoscope(4, 17); //setup
	}
	
	@Test
	void testGetSign() {
		String sign = horoscopeTest.getSign(); //test a method
		assertTrue("Aries".equals(sign));
		
	}
	
	@Test
	void testGetElement() {
		String ariesElement = horoscopeTest.getElement();//test a method
		assertTrue("Fire".equals(ariesElement));
	}
	
	@Test
	void testGetCompatibilityCompatible() {
		assertTrue(horoscopeTest.getCompatibility(10, 11));
	}
	
	@Test
	void testGetCompatibilityNotCompatible() {
		assertFalse(horoscopeTest.getCompatibility(7, 11));
	}
	
	@Test
	void testRandomAdjectivesList() {
		int numberOfwords = horoscopeTest.getAdjectivesList().size();
		int realNumberOfWords = 34;
		assertEquals(realNumberOfWords, numberOfwords);
	}
	
	@Test
	void testRandomAdjective() {
		String word = horoscopeTest.getRandomWordFromList(horoscopeTest.getAdjectivesList());
		
		File myFile = new File("src/adjectives.txt");
		try {
			
			Scanner myReader = new Scanner(myFile);
			String line = myReader.nextLine();

			List<String> words = new ArrayList<String>();
			while( myReader.hasNextLine()) {		    	
				words.add(line);
				line = myReader.nextLine();;
			}
			assertTrue(words.contains(word));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

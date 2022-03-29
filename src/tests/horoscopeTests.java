package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Horoscope.Horoscope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

}

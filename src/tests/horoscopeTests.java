package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Horoscope.Horoscope;




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
	void test() {
		fail("Not yet implemented");
	}

}
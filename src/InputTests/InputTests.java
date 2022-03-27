package InputTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Program.Program;
import Welcome.WelcomeInterface;

class InputTests {

	Scanner scanner  = new Scanner(System.in);

	@Test
	void testGetUserName() {
		String input = WelcomeInterface.promptUserForName(scanner);
		assertNotEquals(null, input);
		assertNotEquals("", input);
	}

	@Test
	void testGetUserActivity() {
		String input = Program.promptUserForActivity(scanner);
		assertTrue(input.toLowerCase().equals("horoscope") || input.toLowerCase().equals("compatibility calculator") || input.toLowerCase().equals("quizzes"));
	}
	
	@Test
	void testGetUserBirthMonth() {
		int input = Program.promptUserForBirthMonth(scanner);
		assertTrue(input > 0 && input < 13);
	}
	
	@Test
	void testGetUserBirthDay() {
		int input = Program.promptUserForBirthDay(scanner);
		assertTrue(input > 0 && input < 32);
	}
}


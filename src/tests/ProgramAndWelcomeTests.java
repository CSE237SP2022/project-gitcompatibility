package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Horoscope.Horoscope;
import Program.Program;
import Quiz.QuizInput;
import Welcome.WelcomeInterface;

class ProgramAndWelcomeTests {

	Scanner scanner  = new Scanner(System.in);
	QuizInput newQuiz = new QuizInput();
	String[][] quizzes = newQuiz.quizzes;
	List<String> quizNames = Program.getQuizNames(quizzes);

	@Test
	void testGetUserName() {
		String input = WelcomeInterface.promptUserForName(scanner);
		assertNotEquals(null, input);
		assertNotEquals("", input);
	}

	@Test
	void testGetUserActivity() {
		Program.displayActivityMenu();
		String input = Program.promptUserForActivity(scanner);
		assertTrue(input.toLowerCase().equals("horoscope") || input.toLowerCase().equals("compatibility calculator") || input.toLowerCase().equals("quizzes") || input.toLowerCase().equals("information"));
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
	
	@Test
	void createUserHoroscope() {
		Horoscope horoscope = null;
		horoscope = Program.createUserHoroscope(horoscope, scanner);
		assertNotEquals(horoscope, null);
	}
	
	@Test
	void testCheckIfUserDoesGoBack() {
		boolean userGoesBack = Program.checkIfUserGoesBack(scanner);
		assertEquals(userGoesBack, true);
	}
	
	@Test
	void testGetQuizNames() {
		List<String> quizNames = Program.getQuizNames(quizzes);
		int quizNamesLength = quizNames.size();
		int numQuizzes = quizzes.length;
		assertEquals(quizNamesLength, numQuizzes);
	}
	
	@Test
	void testGetQuizInput() {
		Program.displayQuizMenu(scanner);
		String input = Program.promptUserForQuizName(scanner, quizNames);
		boolean isAQuizName = false;
		if(quizNames.contains(input)) {
			isAQuizName = true;
		}
		assertEquals(isAQuizName, true);
	}
	
	

}


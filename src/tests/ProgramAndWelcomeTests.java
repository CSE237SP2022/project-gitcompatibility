package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
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
	Program program = new Program();
	
	@BeforeEach
	void resetFields() {
		program.userHoroscope = null;
		program.newUser = null;
	}

	@Test
	void testGetUserName() {
		String input = WelcomeInterface.promptUserForName(scanner);
		assertNotEquals(null, input);
		assertNotEquals("", input);
	}

	@Test
	void testGetUserActivity() {
		program.displayActivityMenu();
		String input = program.promptUserForActivity(scanner);
		assertTrue(input.toLowerCase().equals("horoscope") || input.toLowerCase().equals("compatibility calculator") || input.toLowerCase().equals("quizzes") || input.toLowerCase().equals("information"));
	}
	
	@Test
	void testGetUserBirthMonth() {
		int input = program.promptUserForBirthMonth(scanner);
		assertTrue(input > 0 && input < 13);
	}
	
	@Test
	void testGetUserBirthDay() {
		int input = program.promptUserForBirthDay(scanner);
		assertTrue(input > 0 && input < 32);
	}
	
	// do we need tests for getters and setters?
	@Test
	void createUserHoroscope() {
		program.setUserHoroscope(scanner);
		assertNotEquals(program.getUserHoroscope(), null);
	}
	
	@Test
	void testCheckIfUserDoesGoBack() {
		boolean userGoesBack = program.checkIfUserGoesBack(scanner);
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
		program.displayQuizMenu(scanner);
		String input = program.promptUserForQuizName(scanner, quizNames);
		boolean isAQuizName = false;
		if(quizNames.contains(input)) {
			isAQuizName = true;
		}
		assertEquals(isAQuizName, true);
	}
	
	@Test
	void testCheckIfUserInformationDoesNotExist() {
		boolean exists = program.checkIfUserInformationExists();
		assertEquals(exists, false);
	}
	
	@Test
	void testCheckIfUserInformationDoesExist() {
		program.setUserInformation();
		boolean exists = program.checkIfUserInformationExists();
		assertEquals(exists, true);
	}
	
	@Test
	void testCheckIfHoroscopeDoesNotExist() {
		boolean exists = program.checkIfUserHoroscopeExists();
		assertEquals(exists, false);
	}
	
	@Test
	void testCheckIfUserHoroscopeDoesExist() {
		program.setUserHoroscope(scanner);
		boolean exists = program.checkIfUserHoroscopeExists();
		assertEquals(exists, true);
	}

}


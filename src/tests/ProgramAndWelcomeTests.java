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
	void testCheckIfInputIsEmpty() {
		String input = "";
		boolean isEmpty = WelcomeInterface.checkIfInputIsEmpty(input);
		assertTrue(isEmpty);
	}
	
	@Test
	void testCheckIfInputIsNotEmpty() {
		String input = "Anna";
		boolean isEmpty = WelcomeInterface.checkIfInputIsEmpty(input);
		assertFalse(isEmpty);
	}
	
	@Test
	void testCheckForValidActivity() {
		String input = "quizzes";
		boolean isValid = program.checkIfValidActivity(input);
		assertTrue(isValid);
	}

	@Test
	void testCheckForInvalidActivity() {
		String input = "";
		boolean isValid = program.checkIfValidActivity(input);
		assertFalse(isValid);
	}
	
	@Test
	void testCheckIfValidDay() {
		int day = 15;
		boolean isValid = program.checkIfValidDay(day);
		assertTrue(isValid);
	}
	
	@Test
	void testCheckIfInvalidDay() {
		int day = 32;
		boolean isValid = program.checkIfValidDay(day);
		assertFalse(isValid);
	}
	
	@Test
	void testCheckIfValidMonth() {
		int month = 3;
		boolean isValid = program.checkIfValidMonth(month);
		assertTrue(isValid);
	}
	
	@Test
	void testCheckIfInvalidMonth() {
		int month = 13;
		boolean isValid = program.checkIfValidMonth(month);
		assertFalse(isValid);
	}
	
	@Test
	void testCheckIfStringInputEquals() {
		String input = "horoscope";
		boolean isEqual = program.checkIfStringInputEquals(input, "horoscope");
		assertTrue(isEqual);
	}
	
	@Test
	void testCheckIfStringInputDoesNotEqual() {
		String input = "horoscope";
		boolean isEqual = program.checkIfStringInputEquals(input, "quizzes");
		assertFalse(isEqual);
	}
	
	@Test
	void testGetQuizNames() {
		List<String> quizNames = Program.getQuizNames(quizzes);
		int quizNamesLength = quizNames.size();
		int numQuizzes = quizzes.length;
		assertEquals(quizNamesLength, numQuizzes);
	}
	
	@Test
	void testCheckIfValidQuizName() {
		String input = "study spot quiz";
		boolean isValid = program.checkIfValidQuizName(input, quizNames);
		assertTrue(isValid);
	}
	
	@Test
	void testCheckIfInvalidQuizName() {
		String input = "food quiz";
		boolean isValid = program.checkIfValidQuizName(input, quizNames);
		assertFalse(isValid);
	}
	

}


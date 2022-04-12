package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Quiz.QuizInput;

class QuizInputTests {

	@Test
	void checkYesTestFlase() {
		QuizInput quiz = new QuizInput();
		String userInput = "no"; 
		int yesCounter = 1; 
		
		quiz.checkInput(userInput);
		
		assertEquals(1, yesCounter);
	}
	
	@Test
	void checkNoTestFalse() {
		QuizInput quiz = new QuizInput();
		String userInput = "yes"; 
		int noCounter = 1; 
		
		quiz.checkInput(userInput);
		
		assertEquals(1, noCounter);
	}
	
	@Test
	void checkYesTestTrue() {
		QuizInput quiz = new QuizInput();
		String userInput = "yes"; 
		quiz.yesCounter = 1; 
		
		quiz.checkInput(userInput);
		
		assertEquals(2, quiz.yesCounter);
	}
	
	@Test
	void checkNoTestTrue() {
		QuizInput quiz = new QuizInput();
		String userInput = "no"; 
		quiz.noCounter = 1; 
		
		quiz.checkInput(userInput);
		
		assertEquals(2, quiz.noCounter);
	}
	
}


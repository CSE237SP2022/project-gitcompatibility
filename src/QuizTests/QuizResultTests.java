package QuizTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Quiz.QuizInput;

class QuizResultTests {

	@Test
	void mostlyYesAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 4; 
		quiz.noCounter = 2; 
		String result;
		
		quiz.yesAndNo();
		result = quiz.result;
		
		assertEquals("option one", result); 
	}
	
	@Test
	void mostlyNoAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 2; 
		quiz.noCounter = 4; 
		String result;
		
		quiz.yesAndNo();
		result = quiz.result;
		
		assertEquals("option two", result); 
	}
	
	@Test
	void equalAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 2; 
		quiz.noCounter = 2; 
		String result;
		
		quiz.yesAndNo();
		result = quiz.result;
		
		assertEquals("option three", result); 
	}

}


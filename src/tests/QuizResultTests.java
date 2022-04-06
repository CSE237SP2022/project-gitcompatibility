package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Quiz.QuizInput;

class QuizResultTests {

	@Test
	void mostlyYesAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 4; 
		quiz.noCounter = 2; 
		int option;
		
		quiz.yesAndNo();
		option = quiz.option;
		
		assertEquals(1, option); 
	}
	
	@Test
	void mostlyNoAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 2; 
		quiz.noCounter = 4; 
		int option;
		
		quiz.yesAndNo();
		option = quiz.option;
		
		assertEquals(2, option); 
	}
	
	@Test
	void equalAnswers() {
		QuizInput quiz = new QuizInput();
		quiz.yesCounter = 2; 
		quiz.noCounter = 2; 
		int option;
		
		quiz.yesAndNo();
		option = quiz.option;
		
		assertEquals(3, option);
	}

	
}


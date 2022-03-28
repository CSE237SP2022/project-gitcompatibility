package QuizTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Quiz.QuizInput;

class QuizResultTest {

	@Test
	void mostlyYesAnswers() {
		int yesCounter = 4; 
		int noCounter = 2; 
		
		if(yesAndNo(yesCounter, noCounter)) {
			
		}
		String result = yesAndNo(yesCounter, noCounter); 
		
		assertEquals("yes", result); 
	}
	
	@Test
	void mostlyNoAnswers() {
		int yesCounter = 2; 
		int noCounter = 4; 
		
		String result = yesAndNo(yesCounter, noCounter); 
		
		assertEquals("no", result); 
	}
	
//	@Test
//	void optionOne() {
//		bool quizOptionOne = true;
//		bool quizOptionTwo = false;
//		bool quizOptionThree = false;
//		
//		String result = quizResult(quizOptionOne, quizOptionTwo, quizOptionThree);
//		
//		assertEquals("one", result);
//	}
//	
//	@Test
//	void optionTwo() {
//		bool quizOptionOne = false;
//		bool quizOptionTwo = true;
//		bool quizOptionThree = false;
//		
//		String result = quizResult(quizOptionOne, quizOptionTwo, quizOptionThree);
//		
//		assertEquals("two", result);
//	}
//	
//	@Test
//	void optionThree() {
//		bool quizOptionOne = false;
//		bool quizOptionTwo = false;
//		bool quizOptionThree = true;
//		
//		String result = quizResult(quizOptionOne, quizOptionTwo, quizOptionThree);
//		
//		assertEquals("three", result);
//	}

}


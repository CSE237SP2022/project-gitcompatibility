package QuizTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuizInputTest {

	@Test
	void checkYesTest() {
		String userInput = "yes"; 
		
		bool resultOfCheck = checkYes(userInput);
		
		assertEquals(true, resultOfCheck);
	}
	
	@Test
	void checkNoTest() {
		String userInput = "yes"; 
		
		bool resultOfCheck = checkNo(userInput);
		
		assertEquals(true, resultOfCheck);
	}
	
	@Test
	void quitTest() {
		String userInput = "quit"; 
		
		bool resultOfCheck = quitQuiz(userInput); 
		
		assertEquals(true, resultOfCheck); 
	}
	
	@Test 
	void inputValid(){
		String userInput = "invalid";
		
		bool resultOfCheck = isValidInput(userInput); 
		
		assertEquals(false, resultOfCheck);
	}

}


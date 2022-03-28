package QuizTests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import Quiz.QuizInput;

class QuizInputTest {

	@Test
	void checkYesTestFlase() {
		String userInput = "no"; 
		int yesCounter = 1; 
		
		checkInput(userInput);
		
		assertEquals(1, yesCounter);
	}
	
	@Test
	void checkNoTestFalse() {
		String userInput = "yes"; 
		int noCounter = 1; 
		
		checkInput(userInput);
		
		assertEquals(1, noCounter);
	}
	
	@Test
	void checkYesTestTrue() {
		String userInput = "yes"; 
		int yesCounter = 1; 
		
		checkInput(userInput);
		
		assertEquals(2, yesCounter);
	}
	
	@Test
	void checkNoTestTrue() {
		String userInput = "no"; 
		int noCounter = 1; 
		
		checkInput(userInput);
		
		assertEquals(2, noCounter);
	}
	
//	@Test
//	void quitTest() {
//		String userInput = "quit"; 
//		
//		bool resultOfCheck = quitQuiz(userInput); 
//		
//		assertEquals(true, resultOfCheck); 
//	}
//	
//	@Test 
//	void inputValid(){
//		String userInput = "invalid";
//		
//		bool resultOfCheck = isValidInput(userInput); 
//		
//		assertEquals(false, resultOfCheck);
//	}

}


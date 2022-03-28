package Quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QuizInput {
	
	private int yesCounter; 
	private int noCounter;
	private String[] questions; 
	public String result; 
	
	public QuizInput() {
		this.yesCounter = 0; 
		this.noCounter = 0; 
		this.questions = new String[] {"one", "two", "three", "four", "five"};
		this.result = "";
	}

	public void runQuiz() {
		quizIntroduction();
		runThroughQuestions();
		yesAndNo();
	}
	
	private void runThroughQuestions() {
		for(int i=0; i < questions.length; i++) {
			System.out.println(questions[i]); 
			getUserInputToQuestion();
		}
	}
	
	private void getUserInputToQuestion() {
		Scanner reader = new Scanner(System.in);
		
		String userInput = "";
		
		while(userInput == "") {
			userInput = reader.nextLine(); 
		}
		reader.close(); 
		
		checkInput(userInput);
	}

	private void quizIntroduction() {
		System.out.println("<Quiz Title>");
		System.out.println("To take this quiz, answer 'yes' or 'no' after each question. If you would like to end this quiz at any time, "
				+ "enter 'quit'");
	}

	public void checkInput(String input) {
		if(input == "yes") {
			yesCounter++; 
		}
		else if (input == "no") {
			noCounter++; 
		}
	}
	
	public void yesAndNo() {
		if(yesCounter > noCounter) {
			result = "option one";
			resultOptionOne(); 
		}
		else if(yesCounter < noCounter) {
			result = "option two";
			resultOptionTwo();
		}
		else if(yesCounter == noCounter) {
			result = "option three";
			resultOptionThree(); 
		}
	}
	
	private void resultOptionOne() {
		System.out.println("<Result Option One>");
	}
	
	private void resultOptionTwo() {
		System.out.println("<Result Option Two>");
	}

	private void resultOptionThree() {
		System.out.println("<Result Option Three>");
	}
}

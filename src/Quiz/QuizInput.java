package Quiz;

import java.util.Scanner;

public class QuizInput {
	
	public int yesCounter; 
	public int noCounter;
	private String[] questions; 
	public String result; 
	
	public QuizInput() {
		this.yesCounter = 0; 
		this.noCounter = 0; 
		this.questions = new String[] {"Do you study during the day?", "Do you like quiet study spaces?", "Are study aesthetics important to you?"
				, "Do you live off campus?", "Are you in engineering?", "Do you think WashU gives off Hogwarts vibes?"};
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
		System.out.println("What is you ideal study spot on campus?");
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
		else if(input == "quit") {
			userQuitQuiz(); 
		}
		else {
			System.out.println("Please enter a valid input.");
			getUserInputToQuestion();
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
		System.out.println("Your ideal study spot on campus is Law Library!");
	}
	
	private void resultOptionTwo() {
		System.out.println("Your ideal study spot on campus is Olin Library!");
	}

	private void resultOptionThree() {
		System.out.println("Your ideal study spot on campus is Bytes!");
	}
	
	private void userQuitQuiz() {
		yesCounter = 0; 
		noCounter = 0; 
		System.out.println("You have decided to quit this quiz.");
		return; 
	}
}

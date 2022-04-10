package Quiz;

import java.util.List;
import java.util.Scanner;
import Program.Program;

public class QuizInput {
	
	public int yesCounter; 
	public int noCounter;
	public int option; 
	private String[] studySpotQuiz; 
	private String[] studySpotQuizResults; 
	private String[] quiz2;
	private String[] quiz2Results;
	private String[] quiz3;
	private String[] quiz3Results;
	public String[][] quizzes;
	private String[][] results;
	private String[] whichResult;
	public String result; 
	public int quit; 
	
	public QuizInput() {
		this.yesCounter = 0; 
		this.noCounter = 0; 
		this.option = 0; 
		this.studySpotQuiz = new String[] {"study spot quiz", "Do you study during the day?", "Do you like quiet study spaces?", "Are study aesthetics important to you?"
				, "Do you live off campus?", "Are you in engineering?", "Do you think WashU gives off Hogwarts vibes?"};
		this.studySpotQuizResults = new String[] {"Your ideal study spot on campus is Law Library!", "Your ideal study spot on campus is Olin Library!", "Your ideal study spot on campus is Bytes!"};
		this.quiz2 = new String[] {"quiz2"};
		this.quiz3 = new String[] {"quiz3"};
		this.quizzes = new String[][] {studySpotQuiz, quiz2, quiz3}; 
		this.results = new String[][] {studySpotQuizResults, quiz2Results, quiz3Results};
		this.result = "";
		this.quit = 0; 
	}

	public void runQuiz(String quiz) {
		 
		quizIntroduction();
		determineQuizToRun(quiz);
		if(quit == 0) {
			yesAndNo();
		}
	}
	
	private void determineQuizToRun(String quiz) {
		List<String> quizNames = Program.getQuizNames(quizzes);
		for(int i = 0; i < quizNames.size(); i++) {
			if(quizNames.get(i) == quiz) {
				runThroughQuestions(quizzes[i]);
				whichResult = results[i];
			}
		}
	}
	
	private void runThroughQuestions(String[] quiz) {
		for(int i=1; i < quiz.length; i++) {
			if(quit == 0) {
				System.out.println(quiz[i]); 
				getUserInputToQuestion();
			}
		}
	}
	
	private void getUserInputToQuestion() {
		Scanner reader = new Scanner(System.in);
		
		String userInput = "";
		
		while(userInput == "") {
			userInput = reader.nextLine(); 
		} 
		
		checkInput(userInput);
	}

	private void quizIntroduction() {
		System.out.println("What is your ideal study spot on campus?");
		System.out.println("To take this quiz, answer 'yes' or 'no' after each question. If you would like to end this quiz at any time, "
				+ "enter 'quit'");
	}

	public void checkInput(String input) {
		if(input.equals("yes")) {
			yesCounter++; 
		}
		else if (input.equals("no")) {
			noCounter++; 
		}
		else if(input.equals("quit")) {
			userQuitQuiz(); 
		}
		else {
			System.out.println("Please enter a valid input.");
			getUserInputToQuestion();
		}
	}
	
	public void yesAndNo() {
		if(yesCounter > noCounter) {
			option = 1;
		}
		else if(yesCounter < noCounter) {
			option = 2;
		}
		else if(yesCounter == noCounter) {
			option = 3; 
		}
		printResult(); 
	}
	
	private void printResult() {
		result = whichResult[option-1];
		System.out.println(result);
	}
	
	private void userQuitQuiz() {
		yesCounter = 0; 
		noCounter = 0; 
		System.out.println("You have decided to quit this quiz.");
		result = "";
		quit++; 
		
	}
}

package Quiz;

import java.util.List;
import java.util.Scanner;
import Program.Program;

public class QuizInput {
	
	public int yesCounter; 
	public int noCounter;
	private String[] studySpotQuiz; 
	private String[] quiz2;
	private String[] quiz3;
	private String[][] quizzes; 
	public String result; 
	public int quit; 
	
	public QuizInput() {
		this.yesCounter = 0; 
		this.noCounter = 0; 
		this.studySpotQuiz = new String[] {"study spot quiz", "Do you study during the day?", "Do you like quiet study spaces?", "Are study aesthetics important to you?"
				, "Do you live off campus?", "Are you in engineering?", "Do you think WashU gives off Hogwarts vibes?"};
		this.quiz2 = new String[] {"quiz2"};
		this.quiz3 = new String[] {"quiz3"};
		this.quizzes = new String[][] {studySpotQuiz, quiz2, quiz3}; 
		this.result = "";
		this.quit = 0; 
	}

	public void runQuiz(String quiz) {
		determineQuizToRun(quiz); 
		quizIntroduction();
		
		if(quit == 0) {
			yesAndNo();
		}
	}
	
	private void determineQuizToRun(String quiz) {
		List<String> quizNames = Program.getQuizNames(quizzes);
		for(int i = 0; i < quizNames.size(); i++) {
			if(quizNames[i] == quiz) { //look at iterating through list
				//pass this index of quizzes to runThroughQuestions()
			}
		}
	}
	
	private void runThroughQuestions(String[] quiz) {
		for(int i=0; i < quiz.length; i++) {
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
//		Program program = new Program(); 
//		program.displayActivityMenu(); 
	}
	
	private void resultOptionTwo() {
		System.out.println("Your ideal study spot on campus is Olin Library!");
//		Program program = new Program(); 
//		program.displayActivityMenu(); 
	}

	private void resultOptionThree() {
		System.out.println("Your ideal study spot on campus is Bytes!");
//		Program program = new Program(); 
//		program.displayActivityMenu(); 
	}
	
	private void userQuitQuiz() {
		yesCounter = 0; 
		noCounter = 0; 
		System.out.println("You have decided to quit this quiz.");
		quit++; 
		
	}
}

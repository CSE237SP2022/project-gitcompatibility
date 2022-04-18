package Program;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Welcome.WelcomeInterface;
import Horoscope.Horoscope;
import Quiz.QuizInput;
import UserInformation.UserInformation;

public class Program {
	
	public Horoscope userHoroscope; 
	public UserInformation newUser;

	
	public Program() {
		this.userHoroscope = null;
		this.newUser = null;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Program program = new Program();
		WelcomeInterface.main(args);
		String activity = program.promptUserForActivity(scanner);
		program.checkUserActivity(activity, scanner);
		while(true) {
			program.runProgramRepeatedly(scanner);
		}
	}


	public void runProgramRepeatedly(Scanner scanner) {
		String activity = "";
		if(checkIfUserGoesBack(scanner)) {
			displayActivityMenu();
			activity = promptUserForActivity(scanner);
			checkUserActivity(activity, scanner);
		}
	}


	public void displayActivityMenu() {
		System.out.println("What do you want to do next?");
		System.out.println("Horoscope");
		System.out.println("Compatibility Calculator");
		System.out.println("Quizzes");
		System.out.println("Information");
	}
	
	public void checkIfUserQuits(String input) {
		if(input.equals("quit")) {
			System.exit(0);
		}
	}
	
	public void checkUserActivity(String activity, Scanner scanner) {
		if(activity.toLowerCase().equals("horoscope")) {
			getUserHoroscope(scanner);
		}
		else if (activity.toLowerCase().equals("compatibility calculator")) {
			getCompatibility(scanner);
		}
		else if (activity.toLowerCase().equals("quizzes")) {
			displayQuizMenu(scanner);
		}
		else if(activity.toLowerCase().equals("information")) {
			displayUserInformation();
		}
	}


	public void displayUserInformation() {
		if(!checkIfUserInformationExists()) {
			createUserInformation();
		}
		this.newUser.displayInformation();
	}

	public void createUserInformation() {
		this.newUser = new UserInformation(this.userHoroscope);
	}

	public void displayQuizMenu(Scanner scanner) {
		System.out.println("Which quiz would you like to take?");
		QuizInput newQuiz = new QuizInput();
		String[][] quizzes = newQuiz.quizzes;
		List<String> quizNames = getQuizNames(quizzes);
		for (int i = 0; i < quizNames.size(); ++i) {
			System.out.println(quizNames.get(i));
		}
		String quizName = promptUserForQuizName(scanner, quizNames);
		newQuiz.runQuiz(quizName);
		addQuizNameAndResult(quizName, newQuiz.result);
	}
		
		
	public static List<String> getQuizNames(String[][] quizzes) {
		List<String> quizNames = new LinkedList<String>();
		for(int i = 0; i < quizzes.length; ++i) {
			quizNames.add(quizzes[i][0]);
		}
		return quizNames;
	}

	
	public String promptUserForQuizName(Scanner scanner, List<String> quizNames) {
		String input = "";
		while (!quizNames.contains(input.toLowerCase())) {
			input = scanner.nextLine();
		}
		
		return input;
	}
	
	public void addQuizNameAndResult(String name, String result) {
		if(!checkIfUserInformationExists()) {
			createUserInformation();
		}
		for(int i = 0; i < this.newUser.quizzes.length; i++) {
			if(this.newUser.quizzes[i].equals("unknown")) {
				this.newUser.quizzes[i] = name;
				this.newUser.quizResults[i] = result;
			}
		}
	}
	
	public boolean checkIfUserInformationExists() {
		if(this.newUser == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void getCompatibility(Scanner scanner) {
		if (this.userHoroscope == null) {
			createUserHoroscope(scanner);
		}
		System.out.println("Enter the other person's birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner);
		this.userHoroscope.getCompatibility(month, day);
	}


	public void getUserHoroscope(Scanner scanner) {
		createUserHoroscope(scanner);
		this.userHoroscope.printHoroscope();
	}
	
	public boolean checkIfUserGoesBack(Scanner scanner) {
		String input = "";
		boolean userGoesBack = false;
		while(!input.toLowerCase().equals("back")) {
			userGoesBack = false;
			input = scanner.nextLine();
		}
		userGoesBack = true;
		return userGoesBack;
	}
	
	public void createUserHoroscope(Scanner scanner) {
		System.out.println("Enter your birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner); 
		this.userHoroscope = new Horoscope(month, day);
	}
	
	public int promptUserForBirthMonth(Scanner scanner) {
		System.out.println("Birth month? (1-12)");
		int month = 0;
		while(month < 1 || month > 12) {
			month = scanner.nextInt();
		}
		return month;
	}
	
	public int promptUserForBirthDay(Scanner scanner) {
		System.out.println("Birth day? (1-31)");
		int day = 0;
		while(day < 1 || day > 31 ) {
			day = scanner.nextInt();
		}
		return day;
	}

	public String promptUserForActivity(Scanner scanner) {
		String input = "";
		while (!input.toLowerCase().equals("horoscope") && !input.toLowerCase().equals("compatibility calculator")
				&& !input.toLowerCase().equals("quizzes") && !input.toLowerCase().equals("information")){
			checkIfUserQuits(input.toLowerCase());
			input = scanner.nextLine();
		}
		return input;
	}

}

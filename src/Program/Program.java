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
	
	public UserInformation getUserInformation() {
		return this.newUser;
	}
	
	public void setUserInformation() {
		Horoscope horoscope = getUserHoroscope();
		this.newUser = new UserInformation(horoscope);
	}

	public Horoscope getUserHoroscope() {
		return this.userHoroscope;
	}
	
	public void setUserHoroscope(Scanner scanner) {
		System.out.println("Enter your birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner); 
		this.userHoroscope = new Horoscope(month, day);
	}
	
	public void runProgramRepeatedly(Scanner scanner) {
		String activity = "";
		if(checkForExpectedInput(scanner, "back")) {
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
		if(checkIfStringInputEquals(input, "quit")) {
			System.exit(0);
		}
	}
	
	public void checkUserActivity(String activity, Scanner scanner) {
		String input = activity.toLowerCase();
		if(checkIfStringInputEquals(input, "horoscope")) {
			displayUserHoroscope(scanner);
		}
		else if (checkIfStringInputEquals(input, "compatibility calculator")) {
			getCompatibility(scanner);
		}
		else if (checkIfStringInputEquals(input, "quizzes")) {
			displayQuizMenu(scanner);
		}
		else if(checkIfStringInputEquals(input, "information")) {
			displayUserInformation();
		}
	}

	public void displayUserInformation() {
		if(!checkIfUserInformationExists()) {
			setUserInformation();
		}
		UserInformation user = getUserInformation();
		user.displayInformation();
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
		
		promptToReturnToMain();
		promptToReturnToQuizMenu();
		if(checkForExpectedInput(scanner, "new quiz")) {
			displayQuizMenu(scanner);
		}
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
		while (!checkIfValidQuizName(input, quizNames)) {
			input = scanner.nextLine();
		}
		
		return input;
	}
	
	public boolean checkIfValidQuizName(String input, List<String> quizNames) {
		if (quizNames.contains(input.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addQuizNameAndResult(String name, String result) {
		if(!checkIfUserInformationExists()) {
			setUserInformation();
		}
		UserInformation user = getUserInformation();
		for(int i = 0; i < user.quizzes.length; i++) {
			if(user.quizzes[i].equals("unknown")) {
				user.quizzes[i] = name;
				user.quizResults[i] = result;
			}
		}
	}
	
	public boolean checkIfUserInformationExists() {
		UserInformation user = getUserInformation();
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkIfUserHoroscopeExists() {
		Horoscope horoscope = getUserHoroscope();
		if(horoscope != null) {
			return true;
		}
		else {
			return false;
		}
	}

	public void getCompatibility(Scanner scanner) {
		if (checkIfUserHoroscopeExists()) {
			setUserHoroscope(scanner);
		}
		Horoscope horoscope = getUserHoroscope();
		System.out.println("Enter the other person's birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner);
		horoscope.getCompatibility(month, day);
		
		promptToReturnToMain();
		promptToRecalculateCompatibility();
		if(checkForExpectedInput(scanner, "recalculate")) {
			getCompatibility(scanner);
		}
	}


	public void displayUserHoroscope(Scanner scanner) {
		setUserHoroscope(scanner);
		Horoscope horoscope = getUserHoroscope();
		horoscope.printHoroscope();
	}
	
	public boolean checkForExpectedInput(Scanner scanner, String expectedInput) {
		String input = "";
		boolean gotExpectedInput = false;
		while(!checkIfStringInputEquals(input, expectedInput)) {
			gotExpectedInput = false;
			input = scanner.nextLine();
		}
		gotExpectedInput = true;
		return gotExpectedInput;
	}
	
	public int promptUserForBirthMonth(Scanner scanner) {
		System.out.println("Birth month? (1-12)");
		int month = 0;
		while(!checkIfValidMonth(month)) {
			month = scanner.nextInt();
		}
		return month;
	}
	
	public int promptUserForBirthDay(Scanner scanner) {
		System.out.println("Birth day? (1-31)");
		int day = 0;
		while(!checkIfValidDay(day)) {
			day = scanner.nextInt();
		}
		return day;
	}
	
	public boolean checkIfValidDay(int day) {
		if(day < 1 || day > 31 ) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkIfValidMonth(int month) {
		if(month < 1 || month > 12) {
			return false;
		} else {
			return true;
		}
	}

	public String promptUserForActivity(Scanner scanner) {
		String input = "";
		while (!checkIfValidActivity(input)){
			checkIfUserQuits(input.toLowerCase());
			input = scanner.nextLine();
		}
		return input;
	}
	
	public boolean checkIfValidActivity(String input) {
		if (!checkIfStringInputEquals(input, "horoscope") && !checkIfStringInputEquals(input, "compatibility calculator")
				&& !checkIfStringInputEquals(input, "quizzes") && !checkIfStringInputEquals(input, "information")) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean checkIfStringInputEquals(String actualInput, String expectedInput) {
		if(actualInput.toLowerCase().equals(expectedInput)) {
			return true;
		} else {
			return false;
		}
	}
	
	private void promptToReturnToMain(){
        System.out.println("Enter 'back' to go back to the activity menu.");
    }

    private void promptToRecalculateCompatibility(){
        System.out.println("Enter 'recaclulate' to recalculate your compatibility.");
    }

    private void promptToReturnToQuizMenu(){
        System.out.println("Enter 'new quiz' to return to the quiz menu.");
    }

}

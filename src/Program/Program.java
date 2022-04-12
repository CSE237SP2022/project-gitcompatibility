package Program;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Welcome.WelcomeInterface;
import Horoscope.Horoscope;
import Quiz.QuizInput;
import UserInformation.UserInformation;

public class Program {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WelcomeInterface.main(args);
		String activity = promptUserForActivity(scanner);
		Horoscope userHoroscope = null;
		checkUserActivity(activity, userHoroscope, scanner);
		while(true) {
			runProgramRepeatedly(scanner, userHoroscope);
		}
	}


	public static void runProgramRepeatedly(Scanner scanner, Horoscope userHoroscope) {
		String activity = "";
		if(checkIfUserGoesBack(scanner)) {
			displayActivityMenu();
			activity = promptUserForActivity(scanner);
			checkUserActivity(activity, userHoroscope, scanner);
		}
	}


	public static void displayActivityMenu() {
		System.out.println("What do you want to do next?");
		System.out.println("Horoscope");
		System.out.println("Compatibility Calculator");
		System.out.println("Quizzes");
		System.out.println("Information");
	}
	
	public static void checkIfUserQuits(String input) {
		if(input.equals("quit")) {
			System.exit(0);
		}
	}
	
	public static void checkUserActivity(String activity, Horoscope userHoroscope, Scanner scanner) {
		if(activity.toLowerCase().equals("horoscope")) {
			getUserHoroscope(userHoroscope, scanner);
		}
		else if (activity.toLowerCase().equals("compatibility calculator")) {
			getCompatibility(userHoroscope, scanner);
		}
		else if (activity.toLowerCase().equals("quizzes")) {
			displayQuizMenu(scanner);
		}
		else if(activity.toLowerCase().equals("Information")) {
			UserInformation newUser = new UserInformation();
			newUser.displayInformation();
		}
	}


	public static void displayQuizMenu(Scanner scanner) {
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

	
	public static String promptUserForQuizName(Scanner scanner, List<String> quizNames) {
		String input = "";
		while (!quizNames.contains(input.toLowerCase())) {
			input = scanner.nextLine();
		}
		
		return input;
	}
	
	public static void addQuizNameAndResult(String name, String result) {
		UserInformation newUser = new UserInformation();
		for(int i = 0; i < newUser.quizzes.length; i++) {
			if(newUser.quizzes[i].equals("unknown")) {
				newUser.quizzes[i] = name;
				newUser.quizResults[i] = result;
			}
		}
	}

	public static void getCompatibility(Horoscope userHoroscope, Scanner scanner) {
		if (userHoroscope == null) {
			userHoroscope = createUserHoroscope(userHoroscope, scanner);
		}
		System.out.println("Enter the other person's birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner);
		userHoroscope.getCompatibility(month, day);
	}


	public static void getUserHoroscope(Horoscope userHoroscope, Scanner scanner) {
		userHoroscope = createUserHoroscope(userHoroscope, scanner);
		userHoroscope.printHoroscope();
	}
	
	public static boolean checkIfUserGoesBack(Scanner scanner) {
		String input = "";
		boolean userGoesBack = false;
		while(!input.toLowerCase().equals("back")) {
			userGoesBack = false;
			input = scanner.nextLine();
		}
		userGoesBack = true;
		return userGoesBack;
	}
	
	public static Horoscope createUserHoroscope(Horoscope userHoroscope, Scanner scanner) {
		System.out.println("Enter your birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner); 
		userHoroscope = new Horoscope(month, day);
		UserInformation newUser = new UserInformation(); 
		newUser.birthDayOfUser = day;
		newUser.birthMonthOfUser = month; 
		newUser.horoscopeOfUser = userHoroscope;
		return userHoroscope;
	}
	
	public static int promptUserForBirthMonth(Scanner scanner) {
		System.out.println("Birth month? (1-12)");
		int month = 0;
		while(month < 1 || month > 12) {
			month = scanner.nextInt();
		}
		return month;
	}
	
	public static int promptUserForBirthDay(Scanner scanner) {
		System.out.println("Birth day? (1-31)");
		int day = 0;
		while(day < 1 || day > 31 ) {
			day = scanner.nextInt();
		}
		return day;
	}

	public static String promptUserForActivity(Scanner scanner) {
		String input = "";
		while (!input.toLowerCase().equals("horoscope") && !input.toLowerCase().equals("compatibility calculator")
				&& !input.toLowerCase().equals("quizzes")) {
			checkIfUserQuits(input.toLowerCase());
			input = scanner.nextLine();
		}
		return input;
	}

}

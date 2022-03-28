package Program;

import java.util.Scanner;

import Welcome.WelcomeInterface;
import Horoscope.Horoscope;
import Quiz.QuizInput;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WelcomeInterface.main(args);
		String activity = promptUserForActivity(scanner);
		Horoscope userHoroscope = null;
		goToActivity(activity, userHoroscope, scanner);
	}
	
	public static void goToActivity(String activity, Horoscope userHoroscope, Scanner scanner) {
		if(activity.toLowerCase().equals("horoscope")) {
			userHoroscope = createUserHoroscope(scanner);
			userHoroscope.printHoroscope();
		}
		else if (activity.toLowerCase().equals("compatibility calculator")) {
			if (userHoroscope == null) {
				userHoroscope = createUserHoroscope(scanner);
			}
			System.out.println("Enter the other person's birthday: ");
			int month = promptUserForBirthMonth(scanner);
			int day = promptUserForBirthDay(scanner);
			userHoroscope.getCompatibility(month, day);
		}
		else if (activity.toLowerCase().equals("quizzes")) {
			QuizInput newQuiz = new QuizInput();
			newQuiz.runQuiz();
		}
	}
	
	public static Horoscope createUserHoroscope(Scanner scanner) {
		System.out.println("Enter your birthday: ");
		int month = promptUserForBirthMonth(scanner);
		int day = promptUserForBirthDay(scanner); 
		Horoscope userHoroscope = new Horoscope(month, day);
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
			input = scanner.nextLine();
		}
		return input;
	}

}

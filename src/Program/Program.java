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
			int month = promptUserForBirthMonth(scanner);
			int day = promptUserForBirthDay(scanner);
			userHoroscope = new Horoscope(month, day);
			userHoroscope.getDailyHoroscope();
		}
		else if (activity.toLowerCase().equals("compatibility calculator")) {
			Horoscope.getCompatibility();
		}
		else if (activity.toLowerCase().equals("quizzes")) {
			Quiz.runQuiz();
		}
		
	}
	
	public static int promptUserForBirthMonth(Scanner scanner) {
		System.out.println("What month were you born? (1-12)");
		int month = 0;
		while(month < 1 || month > 12) {
			month = scanner.nextInt();
		}
		return month;
	}
	
	public static int promptUserForBirthDay(Scanner scanner) {
		System.out.println("What day were you born? (1-31)");
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

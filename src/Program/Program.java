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
		goToActivity(activity);
	}
	
	private static void goToActivity(String activity) {
		if(activity.toLowerCase().equals("horoscope")) {
			Horoscope.getDailyHoroscope();
		}
		else if (activity.toLowerCase().equals("compatibility calculator")) {
			Horoscope.getCompatibility();
		}
		else if (activity.toLowerCase().equals("quizzes")) {
			Quiz.runQuiz();
		}
		
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

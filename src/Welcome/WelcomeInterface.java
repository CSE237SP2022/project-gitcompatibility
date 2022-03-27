package Welcome;

import java.util.Scanner;

public class WelcomeInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = promptUserForName(scanner);
		displayWelcomeInterface(name);
		String activity = promptUserForActivity(scanner);
		scanner.close();
	}

	public static String promptUserForName(Scanner scanner) {
		System.out.println("Hi! What's your name?");
		String input = "";
		while (input == "") {
			input = scanner.nextLine();
		}
		return input;
	}

	public static String promptUserForActivity(Scanner scanner) {
		String input = "";
		while (!input.toLowerCase().equals("horoscope") && !input.toLowerCase().equals("compatibility calculator")
				&& !input.toLowerCase().equals("quizzes")) {
			input = scanner.nextLine();
		}
		return input;
	}

	public static String promptUserForActivity(Scanner scanner) {
		String input = "";
		while (!input.toLowerCase().equals("horoscope") && !input.toLowerCase().equals("compatibility calculator")
				&& !input.toLowerCase().equals("quizzes")) {
			input = scanner.nextLine();
		}
		return input;
	}

	public static void displayWelcomeInterface(String name) {
		System.out.println("Welcome, " + name + "!");
		System.out.println("What would you like to do first?");
		System.out.println("Horoscope");
		System.out.println("Compatibility Calculator");
		System.out.println("Quizzes");
	}
}

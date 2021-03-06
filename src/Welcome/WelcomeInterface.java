package Welcome;

import java.util.Scanner;

import UserInformation.UserInformation;

public class WelcomeInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = promptUserForName(scanner);
		displayWelcomeInterface(name);
	}

	public static String promptUserForName(Scanner scanner) {
		System.out.println("Hi! What's your name?");
		String input = "";
		while (checkIfInputIsEmpty(input)) {
			input = scanner.nextLine();
		}
		return input;
	}
	
	public static boolean checkIfInputIsEmpty(String input) {
		if (input.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void displayWelcomeInterface(String name) {
		System.out.println("Welcome, " + name + "!");
		System.out.println("Choose an activity to complete.");
		System.out.println("Enter 'quit' from this menu if you want to exit the program.");
		System.out.println("What would you like to do first?");
		System.out.println("Horoscope");
		System.out.println("Compatibility Calculator");
		System.out.println("Quizzes");
		System.out.println("Information");
	}
}

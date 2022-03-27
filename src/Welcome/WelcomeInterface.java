package Welcome;
import java.util.Scanner;

public class WelcomeInterface {

	public static void main(String[] args) {
		String name = promptUserForName();
		displayWelcomeInterface(name);
	}

	public static String promptUserForName() {
		System.out.println("Hi! What's your name?");
		Scanner scanner  = new Scanner(System.in);
		String input = "";
		while (input == "") {
			input = scanner.nextLine();
		}
		scanner.close();
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

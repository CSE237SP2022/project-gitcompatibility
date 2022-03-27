package Welcome;
import java.util.Scanner;

public class WelcomeInterface {

	public static void main(String[] args) {
		String name = promptUserForName();
		System.out.println(name);
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
}

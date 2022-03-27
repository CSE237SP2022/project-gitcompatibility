package WelcomeTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Welcome.WelcomeInterface;

class WelcomeTests {

	@Test
	void testGetUserInput() {
		String input = WelcomeInterface.promptUserForName();
		assertNotEquals(null, input);
		assertNotEquals("", input);
	}

}

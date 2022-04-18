package UserInformation;

import Horoscope.Horoscope;


public class UserInformation {
	
	public String nameOfUser; 
	public int birthMonthOfUser; 
	public int birthDayOfUser; 
	public Horoscope horoscopeOfUser; 
	public String[] quizzes;
	public String[] quizResults;

	
	public UserInformation(Horoscope userHoroscope) {
		this.nameOfUser = "unknown";
		this.birthMonthOfUser = userHoroscope.month; 
		this.birthDayOfUser = userHoroscope.day; 
		this.horoscopeOfUser = userHoroscope;
		this.quizzes = new String[] {"unknown", "unknown", "unknown"};
		this.quizResults = new String[] {"unknown", "unknown", "unknown"};
	}

	public void displayInformation() {
		System.out.println("User: " + nameOfUser);
		printUserHoroscope();
		System.out.println("");
		System.out.println("Quiz Results: ");
		printQuizResults();
	}
	
	public void printQuizResults() {
		for(int i = 0; i < quizzes.length; i++) {
			System.out.println(quizzes[i] + ": " + quizResults[i]);
		}
	}
	
	public void printUserHoroscope() {
		if(horoscopeOfUser != null) {
			System.out.println("Birthday: " + birthMonthOfUser + " / " + birthDayOfUser);
			System.out.print("Horoscope: ");
			horoscopeOfUser.printHoroscope();
		}
		else {
			System.out.println("Birthday: ");
			System.out.println("Horoscope: ");
		}
	}
	
}

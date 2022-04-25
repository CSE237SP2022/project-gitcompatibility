package UserInformation;

import Horoscope.Horoscope;


public class UserInformation {
	
	public int birthMonthOfUser; 
	public int birthDayOfUser; 
	public Horoscope horoscopeOfUser; 
	public String[] quizzes;
	public String[] quizResults;

	
	public UserInformation(Horoscope userHoroscope) {
		this.birthMonthOfUser = 0; 
		this.birthDayOfUser = 0; 
		this.horoscopeOfUser = userHoroscope;
		this.quizzes = new String[] {"unknown", "unknown", "unknown"};
		this.quizResults = new String[] {"Take the quiz to find out!", "Take the quiz to find out!", "Take the quiz to find out!"};
	}

	public void displayInformation() {
		printUserHoroscope();
		System.out.println(""); //this is simply for formatting
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
			System.out.println("Birthday: " + horoscopeOfUser.month + " / " + horoscopeOfUser.day);
			System.out.print("Horoscope: ");
			horoscopeOfUser.printHoroscope();
		}
	}
	
}

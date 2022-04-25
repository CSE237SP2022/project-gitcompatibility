package UserInformation;

import java.util.List;
import java.util.Map;

import Horoscope.Horoscope;


public class UserInformation {
	
	public int birthMonthOfUser; 
	public int birthDayOfUser; 
	public Horoscope horoscopeOfUser; 

	
	public UserInformation(Horoscope userHoroscope) {
		this.birthMonthOfUser = 0; 
		this.birthDayOfUser = 0; 
		this.horoscopeOfUser = userHoroscope;
	}

	public void displayInformation(Map<String, String> savedQuizResults, List<String> quizNames) {
		printUserHoroscope();
		System.out.println(""); //this is simply for formatting
		System.out.println("Quiz Results: ");
		printQuizResults(savedQuizResults, quizNames);
	}
	
	public void printQuizResults(Map<String, String> savedQuizResults, List<String> quizNames) {
		for(String quizName1:quizNames){
			if(savedQuizResults.containsKey(quizName1)){
				System.out.println(quizName1 + ": " + savedQuizResults.get(quizName1));
			}
			else{
				System.out.println(quizName1 + ": " + "unknown");
			}
			
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

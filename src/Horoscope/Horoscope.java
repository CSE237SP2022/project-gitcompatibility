package Horoscope;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;





public class Horoscope {
	public int day;
	public int month;
	private String sign;
	private String element;
	private final Map<String, LinkedList<String>> compatibleSigns = new HashMap<String, LinkedList<String>>();
	private File signCharacteristicsFile;
	private java.util.Scanner fileIn;
	private LinkedList<String> signCharacteristics;
	private List<String> adjectives = new ArrayList<String>();
	private List<String> planets = new ArrayList<String>();
	String dailyHoroscope;

	public Horoscope(int month, int day) {
		this.month = month;
		this.day = day;
		sign = assignSign2(month, day);
		this.element = setElement();
		File adjFile = new File("src/adjectives.txt");
		this.adjectives = makeList(adjFile);
		File planetList = new File("src/planets.txt");
		this.planets = makeList(planetList);
		dailyHoroscope = setDailyHoroscope();

		this.compatibleSigns.put("Aries" , new LinkedList<String>(Arrays.asList(new String[] { "Gemini", "Libra", "Aquarius", "Aries","Leo", "Sagittarius"})));
		this.compatibleSigns.put("Leo" , new LinkedList<String>(Arrays.asList(new String[] { "Gemini", "Libra",  "Aries","Leo", "Sagittarius"})));
		this.compatibleSigns.put("Saggittarius" , new LinkedList<String>(Arrays.asList(new String[] { "Gemini", "Libra", "Aquarius", "Aries","Leo", "Sagittarius"})));
		this.compatibleSigns.put("Taurus" , new LinkedList<String>(Arrays.asList(new String[] {  "Cancer", "Scorpio", "Pisces","Taurus", "Virgo", "Capricorn"})));
		this.compatibleSigns.put("Virgo" , new LinkedList<String>(Arrays.asList(new String[] {  "Cancer", "Scorpio", "Taurus", "Virgo", "Capricorn"})));
		this.compatibleSigns.put("Capricorn" , new LinkedList<String>(Arrays.asList(new String[] {  "Cancer", "Scorpio", "Pisces","Taurus", "Virgo", "Capricorn"})));
		this.compatibleSigns.put("Gemini" , new LinkedList<String>(Arrays.asList(new String[] {  "Aries", "Leo","Gemini", "Libra", "Aquarius"})));
		this.compatibleSigns.put("Libra" , new LinkedList<String>(Arrays.asList(new String[] { "Leo", "Sagittarius","Gemini", "Libra", "Aquarius"})));
		this.compatibleSigns.put("Aquarius" , new LinkedList<String>(Arrays.asList(new String[] { "Aries","Leo", "Sagittarius","Gemini", "Libra", "Aquarius"})));
		this.compatibleSigns.put("Cancer" , new LinkedList<String>(Arrays.asList(new String[] { "Taurus", "Virgo", "Capricorn", "Cancer", "Scorpio", "Pisces"})));
		this.compatibleSigns.put("Scorpio" , new LinkedList<String>(Arrays.asList(new String[] { "Taurus", "Virgo", "Capricorn","Cancer", "Scorpio", "Pisces"})));
		this.compatibleSigns.put("Pisces" , new LinkedList<String>(Arrays.asList(new String[] { "Taurus", "Capricorn","Cancer", "Scorpio", "Pisces"})));
		this.signCharacteristicsFile = new File("src/signCharacteristics.txt");
		try {
			this.fileIn = new Scanner(signCharacteristicsFile);
		} catch (FileNotFoundException e) {
			System.out.println("this file is not found");
		}
		this.signCharacteristics = new LinkedList<String>();
		readSignCharacteristics();
	}

	public void printHoroscope() {
		System.out.println(sign);
		System.out.println(this.dailyHoroscope);	
		printSignCharacteristics();
	}

	private Map<Integer, Integer> makeMonthCutOffDayMap() {
		Map<Integer, Integer> monthCutOffday = new HashMap<Integer, Integer>();
		monthCutOffday.put(1,  20);
		monthCutOffday.put(2,  19);
		monthCutOffday.put(3,  21);
		monthCutOffday.put(4,  20);
		monthCutOffday.put(5,  21);
		monthCutOffday.put(6,  21);
		monthCutOffday.put(7,  23);
		monthCutOffday.put(8,  23);
		monthCutOffday.put(9,  23);
		monthCutOffday.put(10, 23);
		monthCutOffday.put(11, 22);
		monthCutOffday.put(12, 22);
		return monthCutOffday;
	}
	
	private Map<Integer, String> makeMonthToSignMap(List<String> monthWithSignsList , int month){
		Map<Integer, String> map = new HashMap<Integer, String>();
		String s =Integer.toString(month);
		int indexOfMonth = monthWithSignsList.indexOf(s);
		map.put(1, monthWithSignsList.get(indexOfMonth  + 1));
		map.put(2, monthWithSignsList.get(indexOfMonth  + 2));
		
		return map;
		
	}


	private String assignSign2(int month, int day) {
		Map<Integer, Integer> monthCutOffday = makeMonthCutOffDayMap();
		int cutOff = monthCutOffday.get(month);
		int cutoffNumber = 0;
		if(day<cutOff) {
			cutoffNumber = 1;
		}
		if(day>=cutOff) {
			cutoffNumber = 2;
		}

		File monthsWithSignsFile = new File("src/monthsWithSigns.txt");
		List<String> monthsWithSignsList = new ArrayList<String>();
		monthsWithSignsList = makeList(monthsWithSignsFile);

		Map<Integer, String> monthToSignMap = makeMonthToSignMap(monthsWithSignsList, month);
				// map = cutoff to sign
		
		String sign = monthToSignMap.get(cutoffNumber);
		return sign;
	}


	private String setDailyHoroscope() {
		dailyHoroscope = "With " + getRandomWordFromList(this.planets) + " in retrograde, you may be feeling " + getRandomWordFromList(this.adjectives) + " and " + getRandomWordFromList(this.adjectives);
		return dailyHoroscope;

	}  

	private List<String> makeList(File myFile) {
		try {

			Scanner myReader = new Scanner(myFile);
			String line = myReader.nextLine();

			List<String> words = new ArrayList<String>();
			while( myReader.hasNextLine()) {		    	
				words.add(line);
				line = myReader.nextLine();;
			}
			return words;

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getRandomWordFromList(List<String> wordList) {
		Random rand = new Random();
		String randomWord = (String) wordList.get(rand.nextInt(wordList.size()));
		return randomWord;
	}

	public String getSign() {
		return sign;
	}


	public List<String> getAdjectivesList() {
		return this.adjectives;
	}

	public String getDailyHoroscope() {
		return this.dailyHoroscope;
	}

	public String getElement() {
		return this.element;
	}

	private String setElement(){
		if(getSign().equals("Aries")||getSign().equals("Leo")||getSign().equals("Saggittarius")){
			return "Fire";
		}
		else if(getSign().equals("Taurus")||getSign().equals("Virgo")||getSign().equals("Capricorn")){
			return "Earth";
		}
		else{
			return "Air";
		}
	}

	public boolean getCompatibility(int month, int day){
		Horoscope compare = new Horoscope(month,day);
		for(String sign:compatibleSigns.get(getSign())){
			if(sign.equals(compare.getSign())){
				System.out.println(getSign() + " and " + compare.getSign() + " are a match made in heaven!<3");
				return true;
			}			
		}
		System.out.println(getSign() + " and " + compare.getSign() + " are not compatible :-(");
		return false;
	}

	public void readSignCharacteristics() {
		
		while(fileIn.hasNextLine()) {
			String searchFile = fileIn.nextLine();
			if (checkLineForWord(searchFile)) {
				this.signCharacteristics.add(searchFile);
				getNextLines();
				break;
			}
		}			

	}

	public LinkedList<String> getSignCharacteristics() {
		return this.signCharacteristics;
	}

	public void printSignCharacteristics() {
		for(String line:signCharacteristics){
			System.out.println(line);
		}
	}

	public boolean checkLineForWord(String searchFile) {

		if (searchFile.equals(this.getSign())) {
			return true;
		}
		return false;
	}

	public void getNextLines() {
		for(int i=0; i<4; ++i) {
			String line = fileIn.nextLine();
			this.signCharacteristics.add(line);

		}
	}

}

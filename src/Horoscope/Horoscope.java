package Horoscope;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Horoscope {
	private String sign;
	private String element;
	private final Map<String, LinkedList<String>> compatibleSigns = new HashMap<String, LinkedList<String>>();

	
	
	public Horoscope(int month, int day) {
		
		sign = assignSign(month, day);
		this.element = getElement();
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
	}
	
	
	public void printHoroscope() {
		System.out.println(sign);
		this.getDailyHoroscope();
	}
	
	private String assignSign(int month, int day){	
		if(month == 3) {
			if(day < 21) {
				sign = "Pisces";
			}
			else {
				sign = "Aries";
			}
		}
		if(month == 4) {
			if(day < 20) {
				sign = "Aries";
			}
			else {
				sign = "Taurus";
			}
		}
		if(month == 5) {
			if(day < 21) {
				sign = "Taurus";
			}
			else {
				sign = "Gemini";
			}
		}
		if(month == 6) {
			if(day < 21) {
				sign = "Gemini";
			}
			else {
				sign = "Cancer";
			}
		}
		if(month == 7) {
			if(day < 23) {
				sign = "Cancer";
			}
			else {
				sign = "Leo";
			}
		}
		if(month == 8) {
			if(day < 23) {
				sign = "Leo";
			}
			else {
				sign = "Virgo";
			}
		}
		if(month == 9) {
			if(day < 23) {
				sign = "Virgo";
			}
			else {
				sign = "Libra";
			}
		}
		if(month == 10) {
			if(day < 23) {
				sign = "Libra";
			}
			else {
				sign = "Scorpio";
			}
		}
		if(month == 11) {
			if(day < 22) {
				sign = "Scorpio";
			}
			else {
				sign = "Sagittarius";
			}
		}
		if(month == 12) {
			if(day < 22) {
				sign = "Sagittarius";
			}
			else {
				sign = "Capricorn";
			}
		}
		if(month == 1) {
			if(day < 20) {
				sign = "Capricorn";
			}
			else {
				sign = "Aquarius";
			}
		}
		if(month == 2) {
			if(day < 19) {
				sign = "Aquarius";
			}
			else {
				sign = "Pisces";
			}
		}
		
		return sign;
	}

	public void getDailyHoroscope() {
		
		switch(this.sign) {
		
		default:
			System.out.println("You will have a day today");
			break;
		}
		
	}
	
	public String getSign() {
		return sign;
	}
	
	public String getElement(){
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

}

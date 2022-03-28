package Horoscope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

//import horoscope.Horoscope;

public class Horoscope {
	private String sign;
	private String element;
	private HashMap<String, LinkedList<String>> compatibleSigns;
	
	public Horoscope(int month, int day) {
		sign = assignSign(month, day);
		this.element = getElement();
		compatibleSigns.put("Aries" , (LinkedList<String>) Arrays.asList(new String[] { "Gemini", "Libra", "Aquarius", "Aries","Leo", "Sagittarius"}));
		compatibleSigns.put("Leo" , (LinkedList<String>) Arrays.asList(new String[] { "Gemini", "Libra",  "Aries","Leo", "Sagittarius"}));
		compatibleSigns.put("Saggittarius" , (LinkedList<String>) Arrays.asList(new String[] { "Gemini", "Libra", "Aquarius", "Aries","Leo", "Sagittarius"}));
		compatibleSigns.put("Taurus" , (LinkedList<String>) Arrays.asList(new String[] {  "Cancer", "Scorpio", "Pisces","Taurus", "Virgo", "Capricorn"}));
		compatibleSigns.put("Virgo" , (LinkedList<String>) Arrays.asList(new String[] {  "Cancer", "Scorpio", "Taurus", "Virgo", "Capricorn"}));
		compatibleSigns.put("Capricorn" , (LinkedList<String>) Arrays.asList(new String[] {  "Cancer", "Scorpio", "Pisces","Taurus", "Virgo", "Capricorn"}));
		compatibleSigns.put("Gemini" , (LinkedList<String>) Arrays.asList(new String[] {  "Aries", "Leo","Gemini", "Libra", "Aquarius"}));
		compatibleSigns.put("Libra" , (LinkedList<String>) Arrays.asList(new String[] { "Leo", "Sagittarius","Gemini", "Libra", "Aquarius"}));
		compatibleSigns.put("Aquarius" , (LinkedList<String>) Arrays.asList(new String[] { "Aries","Leo", "Sagittarius","Gemini", "Libra", "Aquarius"}));
		compatibleSigns.put("Cancer" , (LinkedList<String>) Arrays.asList(new String[] { "Taurus", "Virgo", "Capricorn", "Cancer", "Scorpio", "Pisces"}));
		compatibleSigns.put("Scorpio" , (LinkedList<String>) Arrays.asList(new String[] { "Taurus", "Virgo", "Capricorn","Cancer", "Scorpio", "Pisces"}));
		compatibleSigns.put("Pisces" , (LinkedList<String>) Arrays.asList(new String[] { "Taurus", "Capricorn","Cancer", "Scorpio", "Pisces"}));
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
		
//		case "Aries":
//			//todo DailyHoroscope
//			break;
//		case "Taurus":
//			//todo DailyHoroscope
//			break;
//		case "Gemini":
//			//todo DailyHoroscope
//			break;
//		case "Cancer":
//			//todo DailyHoroscope
//			break;
//		case "Leo":
//			//todo DailyHoroscope
//			break;
//		case "Virgo":
//			//todo DailyHoroscope
//			break;
//		case "Libra":
//			//todo DailyHoroscope
//			break;
//		case "Scorpio":
//			//todo DailyHoroscope
//			break;
//		case "Sagittarius":
//			//todo DailyHoroscope
//			break;
//		case "Capricorn":
//			break;
//		case "Aquarius":
//			//todo DailyHoroscope
//			break;
//		case "Pisces":
//			//todo DailyHoroscope
//			break;
		default:
			System.out.println("You will have a day today");
			break;
		}
		
	}
	
	public String getSign() {
		return sign;
	}
	
	public String getElement(){
		if(this.sign.equals("Aries")||this.sign.equals("Leo")||this.sign.equals("Saggittarius")){
		return "Fire";
		}
		else if(this.sign.equals("Taurus")||this.sign.equals("Virgo")||this.sign.equals("Capricorn")){
		return "Earth";
		}
		else{
		return "Air";
		}
	}
	
	public boolean getCompatibility(int month, int day){
		Horoscope compare = new Horoscope(month,day);
		for(String sign:compatibleSigns.get(getSign())){
		if(sign.equals(compare.getSign ())){
			return true;
			}			
		}
		return false;
	}

}

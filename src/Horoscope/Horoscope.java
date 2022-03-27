package Horoscope;

public class Horoscope {
	private String sign;
	
	public Horoscope(int month, int day) {
		sign = assignSign(month, day);
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
		
		case "Aries":
			//todo DailyHoroscope
			break;
		case "Taurus":
			//todo DailyHoroscope
			break;
		case "Gemini":
			//todo DailyHoroscope
			break;
		case "Cancer":
			//todo DailyHoroscope
			break;
		case "Leo":
			//todo DailyHoroscope
			break;
		case "Virgo":
			//todo DailyHoroscope
			break;
		case "Libra":
			//todo DailyHoroscope
			break;
		case "Scorpio":
			//todo DailyHoroscope
			break;
		case "Sagittarius":
			//todo DailyHoroscope
			break;
		case "Capricorn":
			break;
		case "Aquarius":
			//todo DailyHoroscope
			break;
		case "Pisces":
			//todo DailyHoroscope
			break;
		default:
			System.out.println("You will have a day today");
			break;
		}
		
	}
	
	public String getSign() {
		return sign;
	}

}

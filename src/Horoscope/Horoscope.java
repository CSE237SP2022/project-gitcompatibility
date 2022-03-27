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
				this.sign = "Aries";
			}
		}
		if(month == 4) {
			if(day < 20) {
				this.sign = "Aries";
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

	public String getDailyHoroscope() {
		return "You will have a day today";
	}
	
	public String getSign() {
		return sign;
	}

}

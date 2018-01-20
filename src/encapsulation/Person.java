package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

public class Person {
	
	private String name, email;
	private char gender;
	private Date birthday;
	
	private ArrayList<String> landekoder = new ArrayList<String>(Arrays.asList("ad", "ae", "af", "ag", "ai", "al", 
			"am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", 
			"bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", 
			"cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", 
			"dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", 
			"fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", 
			"gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", 
			"is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", 
			"la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", 
			"mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", 
			"na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", 
			"ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", 
			"sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", 
			"sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", 
			"tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", 
			"ye", "yt", "za", "zm", "zw"));
	
	
	public Person() {
		
	}
	
	public void isValidName(String name) {
		for(int i = 0; i < name.length();i++) {
			char c = name.charAt(i);
			if(! (Character.isLetter(c) || c == ' ' || c == '-')) {
				throw new IllegalArgumentException("Not all letters");
			}
		}
		if(! name.contains(" ")) {
			throw new IllegalArgumentException("Just firstname");
		}
		
		String first = name.substring(0,name.indexOf(' '));
		String last = name.substring(name.indexOf(' ') + 1);
		if(first.length() < 2 || last.length() < 2){
			throw new IllegalArgumentException("To short");
		}
	}
	
	public void isValidMail(String mail) {
		if(! mail.contains(".")) {
			throw new IllegalArgumentException("Ingen punktum");
		}
		
		String [] parts = mail.split("@");
		String first = parts[0].substring(0,parts[0].indexOf("."));
		String last = parts[0].substring(parts[0].indexOf(".") + 1);
		if(!(first.equals(getFirstname()) && last.equals(getLastname()))) {
			throw new IllegalArgumentException("Unavalid name in mail");
		}
		
		String landekode = parts[1].substring(parts[1].indexOf(".") + 1);
		if(!(landekoder.contains(landekode))) {
			throw new IllegalArgumentException("Unvalid landekode");
		}
		
	}
	
	public void setName(String name) {
		isValidName(name);
		this.name = name;
	}
	
	public String getFirstname() {
		return this.name.substring(0,this.name.indexOf(' '));
	}
	public String getLastname() {
		return this.name.substring(this.name.indexOf(' ') + 1);
	}
	
	public void setEmail(String mail) {
		isValidMail(mail);
	}
	
	public void setBirthday(Date date) {
		Date today = new Date();
		if(date.after(today)) {
			throw new IllegalArgumentException("To late bday");
		}
		else {
			this.birthday = date;
		}
		
	}
	
	public void setGender(char gender) {
		String s = "MF";
		if(!(s.contains(String.valueOf(gender)) || this.gender == '\0')) {
			throw new IllegalArgumentException("Unvalid gender");
		}
		this.gender = gender;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Kristoffer Gjerde");
		System.out.println(p.getFirstname() + p.getLastname());
		p.setEmail("Kristoffer.Gjerde@gmail.no");
		Date d= new Date();
		p.setBirthday(d);
	}

}

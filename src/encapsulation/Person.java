package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;



public class Person {
	
	private String name, email,ssn;
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
		this.gender = ' ';
	}
	
	public void isValidName(String name) {
		
		if(! name.contains(" ")) {
			throw new IllegalArgumentException("Just firstname");
		}
		
		String[] ledd = name.split(" ");
		if (ledd.length != 2) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < name.length();i++) {
			char c = name.charAt(i);
			if(! (Character.isLetter(c) || c == ' ' || c == '-')) {
				throw new IllegalArgumentException("Not all letters");
			}
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
		String first = parts[0].substring(0,parts[0].indexOf(".")).toLowerCase();
		String last = parts[0].substring(parts[0].indexOf(".") + 1).toLowerCase();
		if(!(first.equals(getFirstname().toLowerCase()) && last.equals(getLastname().toLowerCase()))) {
			throw new IllegalArgumentException("Unavalid name in mail");
		}
		
		String landekode = parts[1].substring(parts[1].indexOf(".") + 1);
		if(!(landekoder.contains(landekode))) {
			throw new IllegalArgumentException("Unvalid landekode");
		}
	}
	
	public void isValidSSN(String ssn) {
		String F = "376189542";
		String G = "5432765432";
		if (this.birthday == null || this.gender==' ') {
			throw new IllegalArgumentException("Need more information before setSSN");
		}
		if (ssn.length() != 11) {
			throw new IllegalArgumentException("Unvalid length ssn");
		}
		int bday = Integer.parseInt(ssn.substring(0,2));
		int bmonth = Integer.parseInt(ssn.substring(2,4));
		int byear = Integer.parseInt(ssn.substring(4,6));
		//Check birthday
		if( !(bday == this.birthday.getDate() && bmonth == (this.birthday.getMonth()+1)) && byear == this.birthday.getYear() ) {
			throw new IllegalArgumentException("Illegal birthday");
		}
		//Check odd or even
		ArrayList<String> str = new ArrayList<String>(Arrays.asList(ssn.split("")));
		ArrayList<Integer> nums = new ArrayList<Integer>();
		str.forEach(s -> nums.add(Integer.parseInt(s)));
		
		if( ! ( (this.gender=='M' && nums.get(8)%2!=0) || (this.gender == 'F' && nums.get(8)%2==0) ) ) {
			throw new IllegalArgumentException("Wrong oddoreven");
		}
		
		//Check kontrollsiffer
		int VSK1 = 0;
		for(int i = 0; i < F.length(); i++) { VSK1 += nums.get(i)*Integer.parseInt(F.substring(i,i+1));}
		int VSK2 = 0;
		for(int i = 0; i < G.length(); i++) { VSK2 += nums.get(i)*Integer.parseInt(G.substring(i,i+1));}
		
		int K1 = 11 - (VSK1 % 11);
		int K2 = 11 - (VSK2 % 11);
		K1 = (K1 == 11) ? 0:K1;
		K2 = (K2 == 11) ? 0:K2;
		
		if( K1!=nums.get(9) || K2!=nums.get(10)) {
			throw new IllegalArgumentException("K1 or K2 wrong");
		}
	
	}
	
	public void setName(String name) {
		isValidName(name);
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFirstname() {
		return this.name.substring(0,this.name.indexOf(' '));
	}
	public String getLastname() {
		return this.name.substring(this.name.indexOf(' ') + 1);
	}
	
	public void setEmail(String mail) {
		isValidMail(mail);
		this.email = mail;
	}
	
	public String getEmail() {
		return this.email;
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
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public void setGender(char gender) {
		if(!(gender == 'M' || gender=='F' || gender=='\0')) {
			throw new IllegalArgumentException("Unvalid gender");
		}
		this.gender = gender;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	
	public void setSSN(String ssn) {
		isValidSSN(ssn);
		this.ssn = ssn;
	}
	
	public String getSSN() {
		return this.ssn;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Kristoffer Gjerde");
		System.out.println(p.getFirstname() + p.getLastname());
		p.setEmail("Kristoffer.Gjerde@gmail.no");
		Date d= new java.sql.Date(97, 5, 13);
		System.out.println(d);
		
		p.setBirthday(d);
		p.setGender('M');
		
	}

}

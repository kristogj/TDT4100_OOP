package encapsulation;

import java.util.Date;
import java.util.regex.Pattern;

public class Person {
	
	private String name, email, sex;
	private Date birthday;
	
	
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
		String firstpart = mail.substring(0,mail.indexOf("@"));
	}
	
	public void setName(String name) {
		isValidName(name);
		this.name = name;
	}
	
	public void setEmail(String mail) {
		
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Kr kk");
	}

}

package interfaces;



public class Person1 implements Named{
	
	private String givenName, familyName;
	
	public Person1(String givenName, String familyName) {
		this.givenName = givenName;
		this.familyName = familyName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getGivenName() {
		return this.givenName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getFamilyName() {
		return this.familyName;
	}

	
	public void setFullName(String fullName) {
		String[] name = fullName.split(" ");
		setGivenName(name[0]);
		setFamilyName(name[1]);
	}

	
	public String getFullName() {
		return this.givenName + " " + this.familyName;
	}
	
	@Override
	public String toString() {
		return getFamilyName() + ";" + getGivenName();
	}

}

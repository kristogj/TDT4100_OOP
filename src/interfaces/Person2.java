package interfaces;

public class Person2 implements Named{
	
	private String fullName;
	
	public Person2(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public void setGivenName(String givenName) {
		String[] name = fullName.split(" ");
		name[0] = givenName;
		setFullName(String.join("", name));
	}

	@Override
	public String getGivenName() {
		String[] name = fullName.split(" ");
		return name[0];
	}

	@Override
	public void setFamilyName(String familyName) {
		String[] name = fullName.split(" ");
		name[1] = familyName;
		setFullName(String.join("", name));
	}

	@Override
	public String getFamilyName() {
		String[] name = fullName.split(" ");
		return name[1];
	}

	@Override
	public void setFullName(String fullName) {
		this.fullName = fullName;
		
	}

	@Override
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public String toString() {
		return getFamilyName() + ";" + getGivenName();
	}
}

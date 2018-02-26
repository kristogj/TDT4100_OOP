package objectstructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	
	private String name;
	private char gender; //'F' or 'M'
	
	private Person mother, father;
	private List<Person> children;
	
	
	public Person(String name, char gender) {
		this.name = name;
		if ("FM".indexOf(gender) == -1) {
			throw new IllegalArgumentException("Unvalid gender");
		}
		this.gender = gender;
		this.children = new ArrayList<Person>();
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.getChildCount();
	}
	
	public String getName() {
		return name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public Person getFather() {
		return father;
	}
	
	public Person getMother() {
		return mother;
	}
	
	public int getChildCount() {
		return this.children.size();
	}
	
	public Person getChild(int i) {
		if (i >= getChildCount()) {
			throw new IllegalArgumentException("Unvalid childnumber");
		}
		return this.children.get(i);
	}
	
	//mother/father.addChild(child)
	public void addChild(Person child) {
		checkSelf(this, child);
		//Check if the connection is correct already
		if (this.children.contains(child)) {
			return;
		}
		this.children.add(child);
		
		//Make the connection from child to parent if you have to
		switch(this.gender) {
		case 'F':
			if(! (child.getMother() == this)) {
				child.setMother(this);
			}
			break;
		
		case 'M': 
			if(! (child.getFather() == this)) {
				child.setFather(this);
			}
		}
		
	}
	
	public void removeChild(Person child) {
		// Check if the connection is correct already
		if (! this.children.contains(child)) {
			return;
		}
		this.children.remove(child);
		
		//Remove the connection from child to parent if you have to
		switch(this.gender) {
		case 'F':
			if(child.getMother() == this) {
				child.setMother(null);
			}
			break;
		
		case 'M': 
			if(child.getFather() == this) {
				child.setFather(null);
			}
		}
		
		
	}
	// child.setMother(mother)
	public void setMother(Person mother) {
		
		checkSelf(this, mother);
		checkGender(mother,'F');
		
		//Check if the connection is correct already
		if (this.mother == mother) {
			return;
		}
		
		//Remove the old connection from mother to child
		if (this.mother != null) {
			this.mother.removeChild(this);
		}
		
		this.mother = mother;
		
		// Make the new connection if you have to
		if (this.mother != null) {
			this.mother.addChild(this);
		}
		
	}
	
	public void setFather(Person father) {
		
		checkSelf(this, father);
		checkGender(father, 'M');
		
		//Check if the connection is correct already
		if (this.father == father) {
			return;
		}
		
		//Remove the old connection from mother to child
		if (this.father != null) {
			this.father.removeChild(this);
		}
		
		this.father = father;
		
		// Make the new connection if you have to
		if (this.father != null) {
			this.father.addChild(this);
		}
		
	}
	
	private void checkSelf(Person p1, Person p2) {
		if (p1 == p2) {
			throw new IllegalArgumentException();
		}
	}
	
	private void checkGender(Person p1, char c2) {
		if (p1 != null) {
			char c1 = p1.getGender();
			if (c1 != c2) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
	}

}

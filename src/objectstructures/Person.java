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
	
	public void addChild(Person child) {
		if(child.equals(this)) {
			throw new IllegalArgumentException("You can´t add yourself");
		}
		
		//If Female set mother, if Male set father
		switch (this.gender) {
		
		case 'F': 
			if(child.getMother() != null) {
				//In case of change of mother
				child.getMother().removeChild(child);
			}
			child.mother = this;
			break;
			
		case 'M': 
			if(child.getFather() != null) {
				//In case of change in father
				child.getFather().removeChild(child);
			}
			child.father = this;
			break;
		
		//Would not happen	
		default: throw new IllegalStateException("Unvalid gender");
		}
		this.children.add(child);
	}
	
	public void removeChild(Person child) {
		if( ! this.children.contains(child)) {
			throw new IllegalArgumentException("That´s not your child");
		}
		switch (this.gender) {
		//Remove motherrole
		case 'F': child.mother = null; break;
		//Remove fatherrole
		case 'M': child.father = null; break;
		
		//Would not happen
		default: throw new IllegalStateException("Unvalid gender");
		}
		//Remove child from this objects children
		this.children.remove(child);
	}
	
	public void setMother(Person mother) {
		if (mother.getGender() != 'F') {
			throw new IllegalArgumentException("You should be this childs father");
		}
		mother.addChild(this);
	}
	
	public void setFather(Person father) {
		if(father.getGender() !=  'M') {
			throw new IllegalArgumentException("You should be this childs mother");
		}
		father.addChild(this);
	}
	
	
	public static void main(String[] args) {
		
	}

}

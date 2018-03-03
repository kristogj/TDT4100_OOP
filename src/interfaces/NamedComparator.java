package interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NamedComparator implements Comparator<Named>{

	@Override
	public int compare(Named p1, Named p2) {
		if (p1.getFamilyName().equals(p2.getFamilyName())){
			return p1.getGivenName().compareTo(p2.getGivenName());
		}
		return p1.getFamilyName().compareTo(p2.getFamilyName());
	}
	
	public static void main(String[] args) {
		NamedComparator comparator = new NamedComparator();
		List<Named> persons = new ArrayList<Named>(Arrays.asList(new Person2("Kristoffer Gjerde"),new Person2("Henrik Høiness"),new Person2("Martin Johansen")));
		Collections.sort(persons,comparator);
		System.out.println(persons);
	}

}

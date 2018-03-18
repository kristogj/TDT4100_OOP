package delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	
	private Map<Employee,ArrayList<String>> history = new HashMap<Employee,ArrayList<String>>();
	
	public void printDocument(String document, Employee employee) {
		System.out.println(document);
		if(this.history.containsKey(employee)) {
			this.history.get(employee).add(document);
		}
		else {
			this.history.put(employee, new ArrayList<String>(Arrays.asList(document)));
		}
	}
	
	public List<String> getPrintHistory(Employee employee){
		return this.history.containsKey(employee) ? this.history.get(employee) : new ArrayList<String>();
	}
	
	
}

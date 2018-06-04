package eksamen.kont2017;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

//Forskjellen her er at men extender MenuItem
//Endringer i konstruktør, men resten av metodene blir de samme
public class Meal extends MenuItem implements Iterable<Course>{

	private Collection<Course> courses;

	protected Meal(String name, String description,Course[] courses ){
		super(name, description);
		this.courses = Arrays.asList(courses);
	}

	//Antar at det går ann å legge til flere av samme type course
	public void addCourse(Course course){
		courses.add(course);
	}

	public void removeCourse(Course course){
		if(courses.contains(course)){
			courses.remove(course);
		}
	}

	@Override
	public Iterator<Course> iterator() {
		return courses.iterator();
	}

	public Course findCourse(Predicate<Course> test) {
	    for(Course course : courses)
	        if(test.test(course)){
	            return course;
	        }
	        return null;
	    }
}

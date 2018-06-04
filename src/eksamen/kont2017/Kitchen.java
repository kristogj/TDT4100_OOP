package eksamen.kont2017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Kitchen {
    // for each Table that has requested Courses,
    // there is a Collection of the those that are yet to be made
    private Map<Table, Collection<Course>> courseQueue = new HashMap<Table, Collection<Course>>();
    private Collection<KitchenListener> listeners;

    private void produceCourse(Table table, Course course) {
        if (!courseQueue.containsKey(table)){
            courseQueue.put(table,new ArrayList<Course>());
        }
        Collection<Course> courses = courseQueue.get(table);
        courses.add(course);
        courseQueue.put(table, courses);
    }

    private void courseProduced(Table table, Course course) {
        Collection<Course> courses = courseQueue.get(table);
        courses.remove(course);
        fireCourseReady(table,course);
    }
 

    public void menuItemAdded(Table table, MenuItem item) {
        if( item instanceof Meal){
            for(Course course : (Meal)item){
                produceCourse(table,course);
            }
        }
        else if (item instanceof Course){
            produceCourse(table,(Course)item);
        }

    }
    public void addListener(KitchenListener lytter){
        listeners.add(lytter);
    }
    
    public void removeListener(KitchenListener lytter){
        listeners.remove(lytter);
    }
    
    private void fireCourseReady(Table table, Course course) {
        for (KitchenListener listener : listeners) {
            listener.courseReady(table, course);
        }
    }
}

package eksamen.kont2017;

import java.util.Iterator;

import junit.framework.TestCase;

public class MealTest extends TestCase {

	 

    private Course c1, c2;

    private Meal meal;

 

    protected void setUp() throws Exception {

        this.c1 = new Course("Kylling","Moist");
        this.c2 = new Course("Biff","Moister");
        this.meal = new Meal("Biff og kylling","Moistest",new Course[]{ c1, c2});
    }

    public void testIteration() {
        Iterator<Course> it = meal.iterator();
        assertTrue(it.hasNext());
        assertEquals(it.next(), c1);
        assertTrue(it.hasNext());
        assertEquals(it.next(), c2);
        assertFalse(it.hasNext());
        }


    public void testFindCourse() {
        assertEquals(c1,meal.findCourse(course -> course.getName().equals("Kylling")));

    }

}

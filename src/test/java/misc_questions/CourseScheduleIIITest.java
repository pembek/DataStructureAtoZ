package misc_questions;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CourseScheduleIIITest {

    @Test
    public void scheduleCourseTest(){
        int [][] courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        assertEquals(3, CourseScheduleIII.scheduleCourse(courses));
    }

    @Test
    public void scheduleCourseTest2(){
        int [][] courses = {{1,2},{2,3}};
        assertEquals(2, CourseScheduleIII.scheduleCourse(courses));
    }
}

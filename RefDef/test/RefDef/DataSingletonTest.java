/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author evol9
 */
public class DataSingletonTest {

    public DataSingletonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DataSingleton.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DataSingleton expResult = null;
        DataSingleton result = DataSingleton.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorkingDates method, of class DataSingleton.
     */
    @Test
    public void testGetWorkingDates() {
        System.out.println("getWorkingDates");
        DataSingleton instance = null;
        ArrayList<WorkingDate> expResult = null;
        ArrayList<WorkingDate> result = instance.getWorkingDates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjects method, of class DataSingleton.
     */
    @Test
    public void testGetSubjects() {
        System.out.println("getSubjects");
        DataSingleton instance = null;
        ArrayList<Subject> expResult = null;
        ArrayList<Subject> result = instance.getSubjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudents method, of class DataSingleton.
     */
    @Test
    public void testGetStudents() {
        System.out.println("getStudents");
        DataSingleton instance = null;
        ArrayList<Student> expResult = null;
        ArrayList<Student> result = instance.getStudents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentNameByID method, of class DataSingleton.
     */
    @Test
    public void testGetStudentNameByID() {
        System.out.println("getStudentNameByID");
        int id = 0;
        DataSingleton instance = null;
        String expResult = "";
        String result = instance.getStudentNameByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStudent method, of class DataSingleton.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        Student tempStudent = null;
        DataSingleton instance = null;
        instance.addStudent(tempStudent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLesson method, of class DataSingleton.
     */
    @Test
    public void testAddLesson() {
        DataSingleton instance = DataSingleton.getInstance();
        Initialize init = new Initialize();
        Lesson tempLessonNew;

        System.out.println("addLesson success");
        Lesson tempLesson = new Lesson();
        tempLesson.addStudentID(1);
        tempLesson.setDateID(11);
        tempLesson.setSession(DataSingleton.Session.MORNING);
        tempLesson.setSubjectID(1);
        DataSingleton.LessonStatus expResult = DataSingleton.LessonStatus.SUCCESS;
        DataSingleton.LessonStatus result = instance.addLesson(tempLesson);
        assertEquals(expResult, result);

        System.out.println("addLesson already booked");
        tempLessonNew = new Lesson();
        tempLessonNew.addStudentID(1);
        tempLessonNew.setDateID(11);
        tempLessonNew.setSession(DataSingleton.Session.MORNING);
        tempLessonNew.setSubjectID(1);
        expResult = DataSingleton.LessonStatus.ALREADY_BOOKED;
        result = instance.addLesson(tempLessonNew);
        assertEquals(expResult, result);

        System.out.println("addLesson no empty seats");
        tempLessonNew = new Lesson();
        tempLesson.addStudentID(2);
        tempLesson.addStudentID(3);
        tempLesson.addStudentID(4);
        tempLessonNew.addStudentID(5);
        tempLessonNew.setDateID(11);
        tempLessonNew.setSession(DataSingleton.Session.MORNING);
        tempLessonNew.setSubjectID(1);
        expResult = DataSingleton.LessonStatus.NOT_EMPTY_SEATS;
        result = instance.addLesson(tempLessonNew);
        assertEquals(expResult, result);

        System.out.println("addLesson time conflict");
        tempLessonNew = new Lesson();
        tempLessonNew.addStudentID(1);
        tempLessonNew.setDateID(11);
        tempLessonNew.setSession(DataSingleton.Session.MORNING);
        tempLessonNew.setSubjectID(2);
        expResult = DataSingleton.LessonStatus.TIME_CONFLICT;
        result = instance.addLesson(tempLessonNew);
        assertEquals(expResult, result);
    }

    /**
     * Test of generateLessonSignature method, of class DataSingleton.
     */
    @Test
    public void testGenerateLessonSignature() {
        System.out.println("generateLessonSignature");
        Lesson lesson = null;
        DataSingleton instance = null;
        String expResult = "";
        String result = instance.generateLessonSignature(lesson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLessonDateAsTextByID method, of class DataSingleton.
     */
    @Test
    public void testGetLessonDateAsTextByID() {
        System.out.println("getLessonDateAsTextByID");
        int id = 0;
        DataSingleton.DateFormat format = null;
        DataSingleton instance = null;
        String expResult = "";
        String result = instance.getLessonDateAsTextByID(id, format);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLessons method, of class DataSingleton.
     */
    @Test
    public void testGetLessons() {
        System.out.println("getLessons");
        DataSingleton instance = null;
        ArrayList<Lesson> expResult = null;
        ArrayList<Lesson> result = instance.getLessons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubjectNameByID method, of class DataSingleton.
     */
    @Test
    public void testGetSubjectNameByID() {
        System.out.println("getSubjectNameByID");
        int subjectID = 0;
        DataSingleton instance = null;
        String expResult = "";
        String result = instance.getSubjectNameByID(subjectID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSessionAsText method, of class DataSingleton.
     */
    @Test
    public void testGetSessionAsText() {
        System.out.println("getSessionAsText");
        DataSingleton.Session session = null;
        DataSingleton instance = null;
        String expResult = "";
        String result = instance.getSessionAsText(session);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printLessons method, of class DataSingleton.
     */
    @Test
    public void testPrintLessons() {
        System.out.println("printLessons");
        DataSingleton instance = null;
        instance.printLessons();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLessonsBookedByStudentID method, of class DataSingleton.
     */
    @Test
    public void testGetLessonsBookedByStudentID() {
        System.out.println("getLessonsBookedByStudentID");
        int studentID = 0;
        DataSingleton instance = null;
        ArrayList<Lesson> expResult = null;
        ArrayList<Lesson> result = instance.getLessonsBookedByStudentID(studentID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelLesson method, of class DataSingleton.
     */
    @Test
    public void testCancelLesson() {
        System.out.println("cancelLesson");
        int lessonID = 0;
        int studentID = 0;
        DataSingleton instance = null;
        instance.cancelLesson(lessonID, studentID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addReview method, of class DataSingleton.
     */
    @Test
    public void testAddReview() {
        System.out.println("addReview");
        Review tempReview = null;
        DataSingleton instance = null;
        instance.addReview(tempReview);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkReviewExistance method, of class DataSingleton.
     */
    @Test
    public void testCheckReviewExistance() {
        System.out.println("checkReviewExistance");
        Review review = null;
        DataSingleton instance = null;
        boolean expResult = false;
        boolean result = instance.checkReviewExistance(review);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviews method, of class DataSingleton.
     */
    @Test
    public void testGetReviews() {
        System.out.println("getReviews");
        DataSingleton instance = null;
        ArrayList<Review> expResult = null;
        ArrayList<Review> result = instance.getReviews();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReviews method, of class DataSingleton.
     */
    @Test
    public void testSetReviews() {
        System.out.println("setReviews");
        ArrayList<Review> reviews = null;
        DataSingleton instance = null;
        instance.setReviews(reviews);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

package RefDef;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author evol9
 */
public class Initialize {

    private Properties prop;

    public Initialize() {
        prop = new Properties();

        loadFile("config.properties");
        loadStudents();
        loadSubjects();
        loadLessons();
        System.out.println("Hello from Init");

    }

    /**
     * @return the prop
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * @param prop the prop to set
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private void loadFile(String fileName) {
        try (InputStream input = Initialize.class.getClassLoader().getResourceAsStream(fileName)) {
            if (null != input) {
                getProp().load(input);
            }
            else
                System.out.println("Init file missing fatal error");
//            printProperties(getProp());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadStudents() {
        Student tempStudent;
        int totalStudents = 0;
        String sIndex;
        String keyString;
        ArrayList<String> studentKeyList = new ArrayList<>();

        for (Object key : getProp().keySet()) {
            if (key.toString().startsWith("student")) {
                studentKeyList.add(key.toString());
                System.out.println("Added: " + key);
            }
        }
//        every student has 1 property
        totalStudents = studentKeyList.size();

        for (int i = 0; i < totalStudents; i++) {
            tempStudent = new Student();
            sIndex = String.format(".%02d.", i + 1);
            keyString = "student" + sIndex;
            System.out.println(keyString);
//            tempStudent.setIdNumber(Integer.parseInt(prop.getProperty(keyString + "id")));
//            tempStudent.setFullName(prop.getProperty(keyString + "name"));
            tempStudent.setStudentID(i + 1);
//            System.out.println(prop.getProperty(keyString + "name"));
            tempStudent.setName(prop.getProperty(keyString + "name"));
            DataSingleton.getInstance().getStudents().add(tempStudent);
            System.out.println("Added: " + tempStudent.getName());
        }
    }

    private void loadSubjects() {
        Subject tempSubject;
        int totalSubjects = 0;
        String sIndex;
        String keyString;
        ArrayList<String> subjectKeyList = new ArrayList<>();

        for (Object key : getProp().keySet()) {
            if (key.toString().startsWith("subject")) {
                subjectKeyList.add(key.toString());
                System.out.println("Added: " + key);
            }
        }
//        every subject has 2 property
        totalSubjects = subjectKeyList.size() / 2;

        for (int i = 0; i < totalSubjects; i++) {
            tempSubject = new Subject();
            sIndex = String.format(".%02d.", i + 1);
            keyString = "subject" + sIndex;
            System.out.println(keyString);
//            tempSubject.setIdNumber(Integer.parseInt(prop.getProperty(keyString + "id")));
//            tempSubject.setFullName(prop.getProperty(keyString + "name"));
            tempSubject.setSubjectID(i + 1);
//            System.out.println(prop.getProperty(keyString + "name"));
            tempSubject.setName(prop.getProperty(keyString + "name"));
            tempSubject.setPrice(Double.parseDouble(prop.getProperty(keyString + "price")));
            DataSingleton.getInstance().getSubjects().add(tempSubject);
            System.out.println("Added: " + tempSubject.getName());
            System.out.println("price: " + tempSubject.getPrice());
        }
    }

    private void loadLessons() {
        Lesson tempLesson;
        int totalLessons = 0;
        String sIndex;
        String keyString;
        ArrayList<String> lessonKeyList = new ArrayList<>();
        String property;
        DataSingleton instance = DataSingleton.getInstance();

        for (Object key : getProp().keySet()) {
            if (key.toString().startsWith("lesson")) {
                lessonKeyList.add(key.toString());
                System.out.println("Added: " + key);
            }
        }
//        every lesson has 5 property
        totalLessons = lessonKeyList.size() / 5;

        for (int i = 0; i < totalLessons; i++) {
            tempLesson = new Lesson();
            sIndex = String.format(".%02d.", i + 1);
            keyString = "lesson" + sIndex;
            System.out.println(keyString);
            tempLesson.setLessonID(i + 1);
            tempLesson.setDateID(Integer.parseInt(prop.getProperty(keyString + "dateid")));
            tempLesson.setSession(Integer.parseInt(prop.getProperty(keyString + "sessionid")));
            property = prop.getProperty(keyString + "subjectid");
            System.out.println("subjectid: " + property);
            tempLesson.setSubjectID(Integer.parseInt(property));
            property = prop.getProperty(keyString + "studentsid");
            System.out.println("studentsid: " + property);
            String[] students = property.split(" ");
            for (String studentID : students) {
                System.out.println("studentID: " + studentID);
                tempLesson.addStudentID(Integer.parseInt(studentID));
            }
            property = prop.getProperty(keyString + "reviewsid");
            String[] reviews = property.split(" ");
            for (String reviewID : reviews) {
                System.out.println("reviewID: " + reviewID);
                tempLesson.addReviewID(Integer.parseInt(reviewID));
            }

            tempLesson.setSignature(instance.generateLessonSignature(tempLesson));
            instance.getLessons().add(tempLesson);
        }
    }
}

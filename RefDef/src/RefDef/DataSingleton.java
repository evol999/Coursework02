/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

/**
 *
 * @author evol9
 */
public class DataSingleton {

    private static DataSingleton instance;

    public static DataSingleton getInstance() {
        if (null == instance) {
            instance = new DataSingleton();
        }
        return instance;
    }
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<WorkingDate> workingDates;
    private ArrayList<Lesson> lessons;

    private DataSingleton() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        workingDates = new ArrayList<>();
        lessons = new ArrayList<>();
        initBaseDate();
        initWorkingDates();
    }

    /**
     * @return the workingDates
     */
    public ArrayList<WorkingDate> getWorkingDates() {
        return workingDates;
    }

    /**
     * @return the subjects
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getStudentNameByID(int id) {
        String retVal = null;

        for (Student i : students) {
            if (i.getStudentID() == id) {
                retVal = i.getName();
            }
        }

        return retVal;
    }

    void addStudent(Student tempStudent) {
        int totalStudents = getStudents().size();
        tempStudent.setStudentID(totalStudents + 1);
        getStudents().add(tempStudent);
    }

    private void initBaseDate() {
        LocalDateTime baseDate = LocalDateTime.now();

        String formatedDate = WorkingDate.formatDate(baseDate);
        System.out.println("current date: " + formatedDate);
        baseDate = baseDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        WorkingDate.setBaseDate(baseDate);
        formatedDate = WorkingDate.formatDate(baseDate);
        System.out.println("next Saturday: " + formatedDate);

    }

    private void initWorkingDates() {
        WorkingDate tempDate = new WorkingDate();

        tempDate.setDate(WorkingDate.getBaseDate());

        for (int i = 1; i < 9; i++) {
            tempDate.setWorkingDateID(2 * i - 1);
            getWorkingDates().add(tempDate);
            System.out.println("Added: " + WorkingDate.formatDate(tempDate) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(1);

            tempDate.setWorkingDateID(2 * i);
            getWorkingDates().add(tempDate);
            System.out.println("Added: " + WorkingDate.formatDate(tempDate) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(6);
        }
    }

    LessonStatus addLesson(Lesson tempLesson) {
        LessonStatus retVal = LessonStatus.SUCCESS;

        return retVal;

    }

    private int searchLessonIDbySignature(String signature) {
        int retVal = 0;
        for (Lesson lesson : lessons) {
            if (lesson.getSignature().equals(signature)) {
                retVal = lesson.getLessonID();
            }
        }
        return retVal;
    }

    public enum Session {
        MORNING,
        AFTERNOON,
        EVENING;

        public static Session fromInteger(int x) {
            switch (x) {
                case 1:
                    return MORNING;
                case 2:
                    return AFTERNOON;
                case 3:
                    return EVENING;
            }
            return null;
        }
    }

    public enum LessonStatus {
        SUCCESS,
        NOT_EMPTY_SEATS,
        ALREADY_BOOKED;

        public static LessonStatus fromInteger(int x) {
            switch (x) {
                case 1:
                    return SUCCESS;
                case 2:
                    return NOT_EMPTY_SEATS;
                case 3:
                    return ALREADY_BOOKED;
            }
            return null;
        }
    }

    String generateSignature(Lesson lesson) {
        String retVal;
        int id;

        id = lesson.getDateID();
        retVal = getLessonDateAsTextByID(id);
        id = lesson.getSubjectID();
        retVal += String.format("%03d", id);
        id = lesson.getSession().ordinal();
        retVal += String.format("%03d", id);
        return retVal;
    }

    public String getLessonDateAsTextByID(int id) {
        String retVal = null;

        for (WorkingDate date : workingDates) {
            if (date.getWorkingDateID() == id) {
                retVal = WorkingDate.formatDateShort(date);
            }
        }

        return retVal;
    }

}

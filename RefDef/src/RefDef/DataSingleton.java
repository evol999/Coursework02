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
    // private LocalDateTime baseDate;
    private ArrayList<WorkingDate> workingDates;

    private DataSingleton() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        workingDates = new ArrayList<>();
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
            System.out.println("Added: " + WorkingDate.formatDate(tempDate.getDate()) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(1);

            tempDate.setWorkingDateID(2 * i);
            getWorkingDates().add(tempDate);
            System.out.println("Added: " + WorkingDate.formatDate(tempDate.getDate()) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(6);
        }
    }
}

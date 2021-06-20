/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private LocalDateTime baseDate;
    private ArrayList<LocalDateTime> workingDates;

    private DataSingleton() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        workingDates = new ArrayList<>();
        initBaseDate();
        initWorkingDates();
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

    private String formatDate(LocalDateTime date) {
        String formatedDate;
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, yy.MM.dd");
        formatedDate = date.format(myFormat);
        return formatedDate;
    }

    private void initBaseDate() {
        baseDate = LocalDateTime.now();

        String formatedDate = formatDate(baseDate);
        System.out.println("current date: " + formatedDate);
        baseDate = baseDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        formatedDate = formatDate(baseDate);
        System.out.println("next Saturday: " + formatedDate);

    }

    private void initWorkingDates() {
        LocalDateTime tempDate;
        tempDate = baseDate;

        for (int i = 0; i < 8; i++) {
            workingDates.add(tempDate);
            System.out.println("Added: " + formatDate(tempDate));
            tempDate = tempDate.plusDays(1);
            workingDates.add(tempDate);
            System.out.println("Added: " + formatDate(tempDate));
            tempDate = tempDate.plusDays(6);
        }
    }
}

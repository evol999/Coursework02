/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

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

    private DataSingleton() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
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
}

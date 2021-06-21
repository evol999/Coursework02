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
public class ConsoleUI implements StepsInterface {

    private UserInput menuUser;

    public ConsoleUI() {
        menuUser = new UserInput();
    }

    @Override
    public int mainMenuShow() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("MAIN MENU");
        menuUser.setText("Are you a student or an admin?");
        menuUser.setOption("Student");  //  1.
        menuUser.setOption("Administrator");  //  2.
        menuUser.setOption("Exit");  //  3.
        menuUser.runMenu();
        return menuUser.getSelection();
    }

    @Override
    public int studentStatusShow() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("STUDENT STATUS");
        menuUser.setText("Are you registered?");
        menuUser.setOption("Yes");  //  1.
        menuUser.setOption("No");  //  2.
        menuUser.runMenu();
        return menuUser.getSelection();
    }

    @Override
    public int enterStudentID() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("STUDENT ID INPUT");
        menuUser.setText("Please enter your ID");
        return menuUser.runIntCapture();
    }

    @Override
    public void studentNotFound() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("ERROR");
        menuUser.setText("Student not found");
        menuUser.runDisplayText();
    }

    @Override
    public int studentMenuShow(int studentID) {
        String name = DataSingleton.getInstance().getStudentNameByID(studentID);
        String greeting = "Hello " + name + " what would you like to do?";
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("STUDENT MENU");
        menuUser.setText(greeting);
        menuUser.setOption("Book session");         //  1.
        menuUser.setOption("Cancel session");       //  2.
        menuUser.setOption("Review session");       //  3.
        menuUser.setOption("See booked sessions");  //  4.
        menuUser.runMenu();
        return menuUser.getSelection();

    }

    @Override
    public String enterStudentName() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("STUDENT NAME INPUT");
        menuUser.setText("Please enter your name:");
        menuUser.runTextCapture();
        return menuUser.getCapturedText();

    }

    @Override
    public void registrationSuccess(Student student) {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("REGISTRATION SUCCESS");
        menuUser.setText("Congratulations " + student.getName());
        menuUser.setText("Your ID is " + student.getStudentID());
        menuUser.runDisplayText();
    }

    @Override
    public int selectSubject() {
        ArrayList<Subject> subjectList;

        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("SELECT SUBJECT");
        subjectList = DataSingleton.getInstance().getSubjects();

        for (Subject tempSubject : subjectList) {
            menuUser.setOption(tempSubject.getName());
        }
        return menuUser.runMenu();
    }

    @Override
    public int selectDate() {
        ArrayList<WorkingDate> datetList;
        String tempString;

        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("DATE SELECTION");
        datetList = DataSingleton.getInstance().getWorkingDates();

        for (WorkingDate tempDate : datetList) {
            // System.out.println("date: " + tempDate.getDate() + " id: " + tempDate.getWorkingDateID());
            tempString = WorkingDate.formatDate(tempDate);
            menuUser.setOption(tempString);
        }
        return menuUser.runMenu();
    }

    @Override
    public int selectSession() {
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("SESSION SELECTION");
        menuUser.setOption("Morning");
        menuUser.setOption("Afternoon");
        menuUser.setOption("Evening");

        return menuUser.runMenu();
    }

    @Override
    public void bookSuccess(Lesson lesson) {
        DataSingleton instance = DataSingleton.getInstance();
        String name;
        String subject;
        String date;
        String session;
        String lessonID;


        name = instance.getStudentNameByID(lesson.getStudentsID().get(0));
        subject = instance.getSubjectNameByID(lesson.getLessonID());
        date = instance.getLessonDateAsTextByID(lesson.getDateID(), DataSingleton.DateFormat.LONG);
        session = instance.getSessionAsText(lesson.getSession());
        session = session.toLowerCase();
        lessonID = String.format("%03d", lesson.getLessonID());
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("LESSON BOOK SUCCESS");
        menuUser.setText("Congratulations " + name + " your session has been booked!!!");
        menuUser.setText("Subject: " + subject);
        menuUser.setText("On: " + date);
        menuUser.setText("in the " + session);
        menuUser.setText("lesson ID = " + lessonID);

        menuUser.runDisplayText();
    }

    @Override
    public void notEmpty(Lesson lesson) {
        DataSingleton instance = DataSingleton.getInstance();
        String name;
        String subject;
        String date;
        String session;

        name = instance.getStudentNameByID(lesson.getStudentsID().get(0));
        subject = instance.getSubjectNameByID(lesson.getLessonID());
        date = instance.getLessonDateAsTextByID(lesson.getDateID(), DataSingleton.DateFormat.LONG);
        session = instance.getSessionAsText(lesson.getSession());
        session = session.toLowerCase();
        menuUser.reset();
        menuUser.setText("=================================");
        menuUser.setText("LESSON NOT BOOKED, CAPACITY FULL");
        menuUser.setText(name + " unfortunately there is no room left");
        menuUser.setText("Subject: " + subject);
        menuUser.setText("On: " + date);
        menuUser.setText("in the " + session);
        menuUser.setText("is full");
        menuUser.runDisplayText();
    }

    @Override
    public void alreadyBooked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

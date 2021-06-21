/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import RefDef.DataSingleton.Session;

/**
 *
 * @author evol9
 */
class AppFlow {
    private ConsoleUI console;

    void run() {
        int selection;
        while (Boolean.TRUE) {
            selection = console.mainMenuShow();
            if (1 == selection) {
                processStudent();
            }
            if (2 == selection) {
                processAdmin();
            }
            if (3 == selection) {
                break;
            }
            if (4 == selection) {
                printLessons();
            }
        }
    }

    private void processStudent() {
        int selection;

        selection = console.studentStatusShow();
        if (1 == selection) {
            bookAppointmentStudent();
        }
        if (2 == selection) {
            registerStudent();
        }
    }

    private void bookAppointmentStudent() {
        // Enter ID
        //
        int selection;
        String name = null;
//        String greeting;
        int studentID = 0;
        while (null == name) {
            studentID = console.enterStudentID();
            name = DataSingleton.getInstance().getStudentNameByID(studentID);
            if (null == name) {
                console.studentNotFound();
            }
        }
        selection = console.studentMenuShow(studentID);
        if (1 == selection) {
            bookSession(studentID);
        }
        if (2 == selection) {
//            bookByPhysician();
        }

    }

    private void registerStudent() {
        Student tempStudent = new Student();

        tempStudent.setName(console.enterStudentName());
        DataSingleton.getInstance().addStudent(tempStudent);
        console.registrationSuccess(tempStudent);
    }

    private void processAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AppFlow() {
        this.console = new ConsoleUI();
    }

    private void bookSession(int studentID) {
        int selection;
        Lesson tempLesson = new Lesson();
        DataSingleton.LessonStatus addStatus;

        tempLesson.addStudentID(studentID);
        selection = console.selectSubject();
        tempLesson.setSubjectID(selection);
        selection = console.selectDate();
        tempLesson.setDateID(selection);
        selection = console.selectSession();
        tempLesson.setSession(Session.fromInteger(selection));
        addStatus = DataSingleton.getInstance().addLesson(tempLesson);
        if (null != addStatus) {
            switch (addStatus) {
                case SUCCESS:
                    console.bookSuccess(tempLesson);
                    break;
                case NOT_EMPTY_SEATS:
                    console.notEmpty(tempLesson);
                    break;
                case ALREADY_BOOKED:
                    console.alreadyBooked();
                    break;
                default:
                    break;
            }
        }

    }

    private void printLessons() {
        DataSingleton instance = DataSingleton.getInstance();
        instance.printLessons();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

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
            bookSession();
        }
        if (2 == selection) {
//            bookByPhysician();
        }

    }

    private void registerStudent() {
        Student tempStudent = new Student();

        int totalStudents = DataSingleton.getInstance().getStudents().size();

        tempStudent.setStudentID(totalStudents + 1);
        tempStudent.setName(console.enterStudentName());
        DataSingleton.getInstance().getStudents().add(tempStudent);
        console.registrationSuccess(tempStudent);
    }

    private void processAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AppFlow() {
        this.console = new ConsoleUI();
    }

    private void bookSession() {
        int selection;
        selection = console.selectSubject();
    }

}

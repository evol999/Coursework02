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
class AppFlow {
    private ConsoleUI console;
    private int selection;

    void run() {
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
        String name = null;
//        String greeting;
        int studentID;
        while (null == name) {
            studentID = console.enterStudentID();
            name = DataSingleton.getInstance().getStudentNameByID(studentID);
            if (null == name) {
                console.studentNotFound();
            }
        }
        selection = console.studentMenuShow(name);
        if (1 == selection) {
            bookByArea();
        }
        if (2 == selection) {
//            bookByPhysician();
        }

    }

    private void registerStudent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void bookByArea() {
        UserInput menuUser = new UserInput();
        ArrayList<String> Areas = new ArrayList<>();

        menuUser.setText("");
        menuUser.setOption("Yes");  //  1.
        menuUser.setOption("No");  //  2.
        menuUser.runMenu();
    }

    private void processAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AppFlow() {
        this.console = new ConsoleUI();
    }

}

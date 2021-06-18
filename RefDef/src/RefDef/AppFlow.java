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
        selection = console.studentMenuShow();
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
        console.captureText("Por favor ingrese su ID");

//        greeting = "Hello Mr. " + name + " what would you like to do?";
        UserInput menuUser = new UserInput();
//        menuUser.setText(greeting);
        menuUser.setOption("Book appointment by area of expertise");  //  1.
        menuUser.setOption("Book appointment by physician");  //  2.
        menuUser.setOption("Cancel appointment");  //  3.
        menuUser.setOption("Attend appointment");  //  4.
        menuUser.setOption("Report missing appointment");  //  4.
        menuUser.runMenu();
        if (1 == menuUser.getSelection()) {
            bookByArea();
        }
        if (2 == menuUser.getSelection()) {
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

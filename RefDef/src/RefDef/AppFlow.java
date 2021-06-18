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

    /**
     * @return the selection
     */
    public Processes getSelection() {
        return selection;
    }

    /**
     * @param selection the selection to set
     */
    public void setSelection(Processes selection) {
        this.selection = selection;
    }

    private Processes selection;

    void run() {
        UserInput menuUser = new UserInput();
        while (Boolean.TRUE) {
            menuUser.setText("Are you a student or an admin?");
            menuUser.setOption("Student");  //  1.
            menuUser.setOption("Administrator");  //  2.
            menuUser.setOption("Exit");  //  3.
            menuUser.runMenu();
            if (1 == menuUser.getSelection()) {
                processStudent();
            }
            if (2 == menuUser.getSelection()) {
                processAdmin();
            }
            if (3 == menuUser.getSelection()) {
                break;
            }
            menuUser.reset();
        }
    }

    private void processStudent() {
        UserInput menuUser = new UserInput();
        menuUser.setText("Are you registered?");
        menuUser.setOption("Yes");  //  1.
        menuUser.setOption("No");  //  2.
        menuUser.runMenu();
        if (1 == menuUser.getSelection()) {
            bookAppointmentUser();
        }
        if (2 == menuUser.getSelection()) {
            registerUser();
        }
    }

    private void bookAppointmentUser() {
        // Enter ID
        //
        String name = "Beto", greeting;

        greeting = "Hello Mr. " + name + " what would you like to do?";
        UserInput menuUser = new UserInput();
        menuUser.setText(greeting);
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
            bookByPhysician();
        }

    }

    private void registerUser() {
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

    private void bookByPhysician() {
        setSelection(Processes.BOOK_BY_PHY);
    }

    private void processAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Processes {
        EXIT,
        BOOK_BY_PHY
    }

}

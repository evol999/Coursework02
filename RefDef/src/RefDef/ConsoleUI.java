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
public class ConsoleUI implements StepsInterface {

    private UserInput menuUser;

    public ConsoleUI() {
        menuUser = new UserInput();
    }

    @Override
    public int mainMenuShow() {
        menuUser.reset();
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
        menuUser.setText("Are you registered?");
        menuUser.setOption("Yes");  //  1.
        menuUser.setOption("No");  //  2.
        menuUser.runMenu();
        return menuUser.getSelection();
    }

    @Override
    public int enterStudentID() {
        menuUser.reset();
        menuUser.setText("Please enter your ID");
        return menuUser.runIntCapture();
    }

    public void studentNotFound() {
        menuUser.reset();
        menuUser.setText("Student not found");
        menuUser.runDisplayText();

    }

    public int studentMenuShow(String name) {
        String greeting = "Hello " + name + " what would you like to do?";
        menuUser.reset();
        menuUser.setText(greeting);
        menuUser.setOption("Book session");         //  1.
        menuUser.setOption("Cancel session");       //  2.
        menuUser.setOption("Review session");       //  3.
        menuUser.setOption("See booked sessions");  //  4.
        menuUser.runMenu();
        return menuUser.getSelection();

    }
}

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
    public int studentMenuShow() {
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
        menuUser.setText("Por favor ingrese su ID");
        return menuUser.runIntCapture();
    }
}

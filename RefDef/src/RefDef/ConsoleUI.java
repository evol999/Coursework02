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
public class ConsoleInterface implements Menus {

    @Override
    public int mainMenuShow() {
        UserInput menuUser = new UserInput();
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

    }

}

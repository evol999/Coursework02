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
public interface StepsInterface {

    public int mainMenuShow();

    public int studentStatusShow();

    public int enterStudentID();

    public void studentNotFound();

    public int studentMenuShow(String name);

    public String enterStudentName();

}

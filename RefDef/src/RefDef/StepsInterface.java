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

    public int studentMenuShow(int studentID);

    public String enterStudentName();

    public void registrationSuccess(Student student);

    public int selectSubject();

    public int selectDate();

    public int selectSession();

    public void bookSuccess(Lesson lesson);

    public void notEmpty(Lesson lesson);

    public void alreadyBooked();

}

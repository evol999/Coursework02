/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author evol9
 */
public class Lesson {
    final private int maxStudents = 4;
    private int lessonID;
    private int subjectID;
    private LocalDateTime date;
    private String session;
    private Boolean isAvailable;
    private ArrayList<Integer> studentsID;
    private ArrayList<Integer> ReviewID;
    private double averageRating;

    public Lesson() {
        this.isAvailable = Boolean.TRUE;
        this.studentsID = new ArrayList<>();
    }

    /**
     * @return the lessonID
     */
    public int getLessonID() {
        return lessonID;
    }

    /**
     * @param lessonID the lessonID to set
     */
    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    /**
     * @return the subjectID
     */
    public int getSubjectID() {
        return subjectID;
    }

    /**
     * @param subjectID the subjectID to set
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * @return the session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(String session) {
        this.session = session;
    }

    /**
     * @return the isAvailable
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the studentsID
     */
    public ArrayList<Integer> getStudentsID() {
        return studentsID;
    }

    /**
     * @param studentsID the studentsID to set
     */
    public void setStudentsID(ArrayList<Integer> studentsID) {
        this.studentsID = studentsID;
    }

    /**
     * @return the ReviewID
     */
    public ArrayList<Integer> getReviewID() {
        return ReviewID;
    }

    /**
     * @param ReviewID the ReviewID to set
     */
    public void setReviewID(ArrayList<Integer> ReviewID) {
        this.ReviewID = ReviewID;
    }

    /**
     * @return the averageRating
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating the averageRating to set
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    Boolean addStudentID(int studentID) {
        Boolean retVal = Boolean.TRUE;

        if (getIsAvailable()) {
            studentsID.add(studentID);
            if (studentsID.size() == maxStudents) {
                setIsAvailable(Boolean.FALSE);
            }
        } else
            retVal = Boolean.FALSE;
        return retVal;
    }
}

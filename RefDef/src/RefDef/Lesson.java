/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import RefDef.DataSingleton.Session;
import java.util.ArrayList;

/**
 *
 * @author evol9
 */
public class Lesson {

    final private int maxStudents = 4;
    private int lessonID;
    private int subjectID;
    private int dateID;
    private Session session;
    private Boolean isAvailable;
    private ArrayList<Integer> studentsID;
    private ArrayList<Integer> reviewsID;
    private double averageRating;
    private String signature;
    private static int uniqueIDcounter = 0;

    public Lesson() {
        this.isAvailable = Boolean.TRUE;
        this.studentsID = new ArrayList<>();
        this.reviewsID = new ArrayList<>();
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
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
     * @param sessionID the session to set
     */
    public void setSession(int sessionID) {
        this.session = Session.fromInteger(sessionID);
    }

    /**
     * @return the isAvailable
     */
    public Boolean getIsAvailable() {
        boolean retVal;

        if (studentsID.size() < maxStudents) {
            retVal = Boolean.TRUE;
        } else {
            retVal = Boolean.FALSE;
        }

        return retVal;
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
     * @return the ReviewsID
     */
    public ArrayList<Integer> getReviewsID() {
        return reviewsID;
    }

    /**
     * @param ReviewsID the ReviewsID to set
     */
    public void setReviewsID(ArrayList<Integer> reviewsID) {
        this.reviewsID = reviewsID;
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

        if (getIsAvailable() && (-1 == studentsID.indexOf(studentID))) {
            studentsID.add(studentID);
        } else
            retVal = Boolean.FALSE;
        return retVal;
    }

    /**
     * @return the dateID
     */
    public int getDateID() {
        return dateID;
    }

    /**
     * @param dateID the dateID to set
     */
    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isBookedByStudent(int studentID) {
        boolean retVal = Boolean.FALSE;
        if (-1 != studentsID.indexOf(studentID)) {
            retVal = Boolean.TRUE;
        }
        return retVal;
    }

    /**
     * @return the uniqueIDcounter
     */
    public static int getUniqueIDcounter() {
        return uniqueIDcounter;
    }

    /**
     * @return inscreased uniqueIDcounter
     */
    public static void increaseUniqueIDcounter() {
        uniqueIDcounter++;
    }

    Boolean addReviewID(int reviewID) {
        Boolean retVal = Boolean.TRUE;

        if (getIsAvailable() && (-1 == reviewsID.indexOf(reviewID))) {
            reviewsID.add(reviewID);
        } else {
            retVal = Boolean.FALSE;
        }
        return retVal;

    }

}

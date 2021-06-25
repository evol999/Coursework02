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
public class Review {
    private int reviewID;
    private int lessonID;
    private int studentID;
    private int numericalRating;
    private String writtenReview;
    private String signature;

    /**
     * @return the reviewID
     */
    public int getReviewID() {
        return reviewID;
    }

    /**
     * @param reviewID the reviewID to set
     */
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
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
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the numericalRating
     */
    public int getNumericalRating() {
        return numericalRating;
    }

    /**
     * @param numericalRating the numericalRating to set
     */
    public void setNumericalRating(int numericalRating) {
        this.numericalRating = numericalRating;
    }

    /**
     * @return the writtenReview
     */
    public String getWrittenReview() {
        return writtenReview;
    }

    /**
     * @param writtenReview the writtenReview to set
     */
    public void setWrittenReview(String writtenReview) {
        this.writtenReview = writtenReview;
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
}

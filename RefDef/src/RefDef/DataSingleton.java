/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

/**
 *
 * @author evol9
 */
public class DataSingleton {

    private static DataSingleton instance;

    public static DataSingleton getInstance() {
        if (null == instance) {
            instance = new DataSingleton();
        }
        return instance;
    }
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<WorkingDate> workingDates;
    private ArrayList<Lesson> lessons;
    private ArrayList<Review> reviews;

    private DataSingleton() {
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        workingDates = new ArrayList<>();
        lessons = new ArrayList<>();
        reviews = new ArrayList<>();
        initBaseDate();
        initWorkingDates();
    }

    /**
     * @return the workingDates
     */
    public ArrayList<WorkingDate> getWorkingDates() {
        return workingDates;
    }

    /**
     * @return the subjects
     */
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getStudentNameByID(int id) {
        String retVal = null;

        for (Student i : students) {
            if (i.getStudentID() == id) {
                retVal = i.getName();
            }
        }

        return retVal;
    }

    void addStudent(Student tempStudent) {
        int totalStudents = getStudents().size();
        tempStudent.setStudentID(totalStudents + 1);
        getStudents().add(tempStudent);
    }

    private void initBaseDate() {
        LocalDateTime baseDate = LocalDateTime.now();

        String formatedDate = WorkingDate.formatDate(baseDate);
        System.out.println("current date: " + formatedDate);
        baseDate = baseDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        WorkingDate.setBaseDate(baseDate);
        formatedDate = WorkingDate.formatDate(baseDate);
        System.out.println("next Saturday: " + formatedDate);

    }

    private void initWorkingDates() {
        WorkingDate tempDate = new WorkingDate();

        tempDate.setDate(WorkingDate.getBaseDate());

        for (int i = 1; i < 9; i++) {
            tempDate.setWorkingDateID(2 * i - 1);
            getWorkingDates().add(tempDate);
            System.out.println("Added: " + WorkingDate.formatDate(tempDate) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(1);

            tempDate.setWorkingDateID(2 * i);
            getWorkingDates().add(tempDate);
            System.out.println("Added: " + WorkingDate.formatDate(tempDate) + " ID: " + tempDate.getWorkingDateID());

            tempDate = tempDate.plusDays(6);
        }
    }

    LessonStatus addLesson(Lesson tempLesson) {
        String signature;
        LessonStatus retVal = LessonStatus.SUCCESS;
        int lessonID;

        signature = generateLessonSignature(tempLesson);
        lessonID = findLessonIDbySignature(signature);

        if (0 == lessonID) {
            tempLesson.setLessonID(getNewLessonID());
            tempLesson.setSignature(signature);
            lessons.add(tempLesson);
        } else {
            tempLesson.setLessonID(lessonID);
            retVal = addStudentToLesson(lessonID, tempLesson.getStudentsID().get(0));
        }


        tempLesson.setSignature(signature);

        return retVal;

    }

    private int findLessonIDbySignature(String signature) {
        int retVal = 0;
        for (Lesson lesson : getLessons()) {
            if (lesson.getSignature().equals(signature)) {
                retVal = lesson.getLessonID();
                break;
            }
        }
        return retVal;
    }

    private int getNewLessonID() {
        return getLessons().size() + 1;
    }

    String generateLessonSignature(Lesson lesson) {
        String retVal;
        int id;

        id = lesson.getDateID();
        retVal = getLessonDateAsTextByID(id, DateFormat.SHORT);
        id = lesson.getSubjectID();
        retVal += String.format("%03d", id);
        id = lesson.getSession().ordinal();
        retVal += String.format("%03d", id);
        return retVal;
    }

    public String getLessonDateAsTextByID(int id, DateFormat format) {
        String retVal = null;

        for (WorkingDate date : workingDates) {
            if (date.getWorkingDateID() == id) {
                switch (format) {
                    case SHORT:
                        retVal = WorkingDate.formatDateShort(date);
                        break;
                    case LONG:
                    default:
                        retVal = WorkingDate.formatDate(date);
                        break;
                }
                break;
            }
        }
        return retVal;
    }

    /**
     * @return the lessons
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    private LessonStatus addStudentToLesson(int lessonID, int studentID) {
        LessonStatus retVal = LessonStatus.SUCCESS;

        Lesson tempLesson = getLessonByID(lessonID);

        if (tempLesson.getStudentsID().indexOf(studentID) != -1) {
            retVal = LessonStatus.ALREADY_BOOKED;
        } else if (!tempLesson.getIsAvailable()) {
                retVal = LessonStatus.NOT_EMPTY_SEATS;
        } else {
            tempLesson.addStudentID(studentID);
        }
        return retVal;

    }

    private Lesson getLessonByID(int id) {
        Lesson retVal = null;

        for (Lesson lesson : lessons) {
            if (lesson.getLessonID() == id) {
                retVal = lesson;
                break;
            }

        }
        return retVal;
    }

    String getSubjectNameByID(int subjectID) {
        String retVal = null;

        for (Subject subject : subjects) {
            if (subject.getSubjectID() == subjectID) {
                retVal = subject.getName();
                break;
            }
        }
        return retVal;
    }

    String getSessionAsText(Session session) {
        return session.name();
    }

    void printLessons() {
        String name;
        String subject;
        String date;
        String session;
        String lessonID;
        Lesson lesson;

        for (int i = 0; i < lessons.size(); i++) {
            System.out.println("=================================");
            System.out.println("Lesson: " + String.format("%03d ", i + 1) + "of " + String.format("%03d. ", lessons.size()));
            lesson = lessons.get(i);
            subject = instance.getSubjectNameByID(lesson.getLessonID());
            date = instance.getLessonDateAsTextByID(lesson.getDateID(), DataSingleton.DateFormat.LONG);
            session = instance.getSessionAsText(lesson.getSession());
            session = session.toLowerCase();
            lessonID = String.format("%03d", lesson.getLessonID());
            System.out.println("Subject: " + subject);
            System.out.println("On: " + date);
            System.out.println("in the " + session);
            System.out.println("lesson ID = " + lessonID);
            System.out.println("Students:");
            if (lesson.getStudentsID().size() > 0) {
                for (int j = 0; j < lesson.getStudentsID().size(); j++) {
                    name = instance.getStudentNameByID(lesson.getStudentsID().get(j));
                    System.out.println(String.format("    ID: %03d. ", lesson.getStudentsID().get(j)) + "Name: " + name);
                }
            } else {
                System.out.println("    No students registered");
            }

        }

    }

    ArrayList<Lesson> getLessonsBookedByStudentID(int studentID) {
        ArrayList<Lesson> retVal = new ArrayList<>();
        for (Lesson tempLesson : lessons) {
            if (tempLesson.isBookedByStudent(studentID)) {
                retVal.add(tempLesson);
            }
        }

        return retVal;
    }

    void cancelLesson(int lessonID, int studentID) {
        Lesson lesson;
        int studentIndex;

        lesson = getLessonByID(lessonID);
        studentIndex = lesson.getStudentsID().indexOf(studentID);
        lesson.getStudentsID().remove(studentIndex);
        lesson.setIsAvailable(Boolean.TRUE);
    }

    void addReview(Review tempReview) {
        String signature;
        int reviewID;

//        signature = generateReviewSignature(tempReview);
        signature = tempReview.getSignature();
        reviewID = findReviewIDbySignature(signature);

        if (0 == reviewID) {
            tempReview.setReviewID(getNewReviewID());
//            tempReview.setSignature(signature);
            reviews.add(tempReview);
        } else {
            tempReview.setReviewID(reviewID);
            updateReview(tempReview);
        }

//        tempReview.setSignature(signature);

        return;
    }

    private String generateReviewSignature(Review review) {
        String retVal;
        int id;

        id = review.getLessonID();
        retVal = String.format("%03d", id);
        id = review.getStudentID();
        retVal += String.format("%03d", id);
        return retVal;
    }

    private int findReviewIDbySignature(String signature) {
        int retVal = 0;
        for (Review review : getReviews()) {
            if (review.getSignature().equals(signature)) {
                retVal = review.getReviewID();
                break;
            }
        }
        return retVal;

    }

    private int getNewReviewID() {
        return getReviews().size() + 1;
    }

    boolean checkReviewExistance(Review review) {
        boolean retVal = Boolean.FALSE;
        String signature;
        String writtenReview;
        int reviewID;
        int numericalRating;
        Review existingReview;

        signature = generateReviewSignature(review);
        review.setSignature(signature);

        reviewID = findReviewIDbySignature(signature);

        if (0 != reviewID) {
            existingReview = getReviewByID(reviewID);
            review.setWrittenReview(existingReview.getWrittenReview());
            review.setNumericalRating(existingReview.getNumericalRating());
            retVal = Boolean.TRUE;
        }

        return retVal;
    }

    private Review getReviewByID(int reviewID) {
        Review retVal = null;

        for (Review review : reviews) {
            if (review.getReviewID() == reviewID) {
                retVal = review;
                break;
            }

        }
        return retVal;
    }

    private void updateReview(Review review) {
        Review storedReview;

        storedReview = getReviewByID(review.getReviewID());
        storedReview.setWrittenReview(review.getWrittenReview());
        storedReview.setNumericalRating(review.getNumericalRating());
    }

    public enum Session {
        MORNING,
        AFTERNOON,
        EVENING;

        public static Session fromInteger(int x) {
            switch (x) {
                case 1:
                    return MORNING;
                case 2:
                    return AFTERNOON;
                case 3:
                    return EVENING;
            }
            return null;
        }
    }

    public enum LessonStatus {
        SUCCESS,
        NOT_EMPTY_SEATS,
        ALREADY_BOOKED;

        public static LessonStatus fromInteger(int x) {
            switch (x) {
                case 1:
                    return SUCCESS;
                case 2:
                    return NOT_EMPTY_SEATS;
                case 3:
                    return ALREADY_BOOKED;
            }
            return null;
        }
    }

    public enum DateFormat {
        SHORT,
        LONG;

        public static DateFormat fromInteger(int x) {
            switch (x) {
                case 1:
                    return SHORT;
                case 2:
                    return LONG;
            }
            return null;
        }
    }

    /**
     * @return the reviews
     */
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

}

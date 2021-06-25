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
class AppFlow {
    private ConsoleUI console;

    void run() {
        int selection;
        while (Boolean.TRUE) {
            selection = console.mainMenuShow();
            if (1 == selection) {
                processStudent();
            }
            if (2 == selection) {
                processAdmin();
            }
            if (3 == selection) {
                break;
            }
            if (4 == selection) {
                printLessons();
            }
        }
    }

    private void processStudent() {
        int selection;

        selection = console.studentStatusShow();
        if (1 == selection) {
            bookAppointmentStudent();
        }
        if (2 == selection) {
            registerStudent();
        }
    }

    private void bookAppointmentStudent() {
        // Enter ID
        //
        int selection;
        String name = null;
//        String greeting;
        int studentID = 0;
        while (null == name) {
            studentID = console.enterStudentID();
            name = DataSingleton.getInstance().getStudentNameByID(studentID);
            if (null == name) {
                console.studentNotFound();
            }
        }
        selection = console.studentMenuShow(studentID);
        if (1 == selection) {
            bookLesson(studentID);
        }
        if (2 == selection) {
            editLesson(studentID);
        }
        if (3 == selection) {
            cancelLesson(studentID);
        }
        if (4 == selection) {
            reviewLesson(studentID);
        }
        if (5 == selection) {
            showBookedLesson(studentID);
        }

    }

    private void registerStudent() {
        Student tempStudent = new Student();

        tempStudent.setName(console.enterStudentName());
        DataSingleton.getInstance().addStudent(tempStudent);
        console.registrationSuccess(tempStudent);
    }

    private void processAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AppFlow() {
        this.console = new ConsoleUI();
    }

    private void bookLesson(int studentID) {
        int selection;
        Lesson tempLesson = new Lesson();
        DataSingleton.LessonStatus addStatus;
        DataSingleton instance = DataSingleton.getInstance();

        tempLesson.addStudentID(studentID);
        selection = console.selectSubject();
        tempLesson.setSubjectID(selection);
        selection = console.selectDate();
        tempLesson.setDateID(selection);
        selection = console.selectSession();
        tempLesson.setSession(Session.fromInteger(selection));
        addStatus = instance.addLesson(tempLesson);
        if (null != addStatus) {
            switch (addStatus) {
                case SUCCESS:
                    console.bookSuccess(tempLesson);
                    break;
                case NOT_EMPTY_SEATS:
                    console.notEmpty(tempLesson);
                    break;
                case ALREADY_BOOKED:
                    console.alreadyBooked(tempLesson);
                    break;
                case TIME_CONFLICT:
                    console.timeConflict(tempLesson);
                    break;
                default:
                    break;
            }
        }

    }

    private void printLessons() {
        DataSingleton instance = DataSingleton.getInstance();
        instance.printLessons();
    }

    private void cancelSession(int studentID) {
        DataSingleton instance = DataSingleton.getInstance();
        ArrayList<Lesson> lessonsBookedByStudent = null;
        int lessonID;
        int selection;

        lessonsBookedByStudent = instance.getLessonsBookedByStudentID(studentID);

        if (0 != lessonsBookedByStudent.size()) {
            lessonID = console.selectFromBookedLessons(studentID, lessonsBookedByStudent);
            selection = console.confirmation();
            if (1 == selection) {
                instance.cancelLesson(lessonID, studentID);
//            console.cancelSuccess();
            } else {
//                console.cancelNotDone();
            }

        } else {
//            console.noLessonsBooked();

        }
    }

    private void printLessons() {
        DataSingleton instance = DataSingleton.getInstance();
        instance.printLessons();
    }

    private void cancelLesson(int studentID) {
        DataSingleton instance = DataSingleton.getInstance();
        ArrayList<Lesson> lessonsBookedByStudent = null;
        Lesson lesson;
        int selection;

        lessonsBookedByStudent = instance.getLessonsBookedByStudentID(studentID);

        if (0 != lessonsBookedByStudent.size()) {
            lesson = console.selectFromBookedLessons(studentID, lessonsBookedByStudent);
            if (0 == lesson.getReviewsID().size()) {
                selection = console.confirmation();
                if (1 == selection) {
                    instance.cancelLesson(lesson.getLessonID(), studentID);
                    console.cancellationSuccess();
                } else {
                    console.cancelNotDone();
                }
            } else {
                console.cannotBeCancelled();
            }
        } else {
            console.noLessonsBooked();
        }

    }

    private void showBookedLesson(int studentID) {
        DataSingleton instance = DataSingleton.getInstance();
        ArrayList<Lesson> lessonsBookedByStudent = null;

        lessonsBookedByStudent = instance.getLessonsBookedByStudentID(studentID);

        if (0 != lessonsBookedByStudent.size()) {
            console.showBookedLessons(studentID, lessonsBookedByStudent);
        } else {
            console.noLessonsBooked();
        }
    }

    private void reviewLesson(int studentID) {
        int selection;
        Review tempReview = new Review();
        DataSingleton.LessonStatus addStatus;
        ArrayList<Lesson> lessonsBookedByStudent = null;
        DataSingleton instance = DataSingleton.getInstance();
        String writtenReview;
        boolean alreadyExist;
        Lesson lesson;

        tempReview.setStudentID(studentID);
        lessonsBookedByStudent = instance.getLessonsBookedByStudentID(studentID);
        if (0 == lessonsBookedByStudent.size()) {
            console.noLessonsBooked();
            return;
        }
        lesson = console.selectFromBookedLessons(studentID, lessonsBookedByStudent);
        tempReview.setLessonID(lesson.getLessonID());

        alreadyExist = instance.checkReviewExistance(tempReview);

        if (alreadyExist) {
            selection = console.warningReviewExist(tempReview, lesson);
            if (2 == selection) {
                return;
            }
        }

        selection = console.selectNumericalRatingReview();
        tempReview.setNumericalRating(selection);
        writtenReview = console.enterWrittenReview();
        tempReview.setWrittenReview(writtenReview);

        instance.addReview(tempReview);

        if (alreadyExist) {
            console.reviewUpdated();
        } else {
            console.reviewAdded();
        }

    }

    private void editLesson(int studentID) {
        DataSingleton instance = DataSingleton.getInstance();
        ArrayList<Lesson> lessonsBookedByStudent = null;
        Lesson oldLesson;
        Lesson newLesson;
        int selection;
        DataSingleton.LessonStatus editStatus;

        lessonsBookedByStudent = instance.getLessonsBookedByStudentID(studentID);

        if (0 != lessonsBookedByStudent.size()) {
            oldLesson = console.selectFromBookedLessons(studentID, lessonsBookedByStudent);
            if (0 == oldLesson.getReviewsID().size()) {
                selection = console.confirmation();
                if (1 == selection) {
                    newLesson = new Lesson();
                    newLesson.addStudentID(studentID);
                    newLesson.setSubjectID(oldLesson.getSubjectID());
                    selection = console.selectDate();
                    newLesson.setDateID(selection);
                    selection = console.selectSession();
                    newLesson.setSession(Session.fromInteger(selection));
                    editStatus = instance.editLesson(oldLesson, newLesson);

                    if (null != editStatus) {
                        switch (editStatus) {
                            case SUCCESS:
                                console.cancellationSuccess();
                                console.bookSuccess(newLesson);
                                break;
                            case NOT_EMPTY_SEATS:
                                console.notEmpty(newLesson);
                                break;
                            case ALREADY_BOOKED:
                                console.alreadyBooked(newLesson);
                                break;
                            case TIME_CONFLICT:
                                console.timeConflict(newLesson);
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    console.cancelNotDone();
                }
            } else {
                console.cannotBeCancelled();
            }
        } else {
            console.noLessonsBooked();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author evol9
 */
public class WorkingDate {

    private static LocalDateTime baseDate;

    /**
     * @return the baseDate
     */
    public static LocalDateTime getBaseDate() {
        return baseDate;
    }

    /**
     * @param aBaseDate the baseDate to set
     */
    public static void setBaseDate(LocalDateTime aBaseDate) {
        baseDate = aBaseDate;
    }

    public static String formatDate(LocalDateTime date) {
        String formatedDate;
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, yyyy.MM.dd");
        formatedDate = date.format(myFormat);
        return formatedDate;
    }
    public static String formatDate(WorkingDate date) {
        return formatDate(date.getDate());
    }
    public static String formatDateShort(LocalDateTime date) {
        String formatedDate;
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        formatedDate = date.format(myFormat);
        return formatedDate;
    }

    public static String formatDateShort(WorkingDate date) {
        return formatDateShort(date.getDate());
    }
    private int workingDateID;
    private LocalDateTime date;
    public WorkingDate() {

    }

    /**
     * @return the workingDateID
     */
    public int getWorkingDateID() {
        return workingDateID;
    }

    /**
     * @param workingDateID the workingDateID to set
     */
    public void setWorkingDateID(int workingDateID) {
        this.workingDateID = workingDateID;
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

    private void initBaseDate() {
        baseDate = LocalDateTime.now();

        String formatedDate = formatDate(baseDate);
        System.out.println("current date: " + formatedDate);
        baseDate = baseDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        formatedDate = formatDate(baseDate);
        System.out.println("next Saturday: " + formatedDate);

    }

    WorkingDate plusDays(long i) {
        WorkingDate tempDate = new WorkingDate();

        tempDate.setDate(getDate().plusDays(i));

        return tempDate;

    }
}

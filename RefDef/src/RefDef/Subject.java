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
public class Subject implements Comparable<Subject> {
    private int subjectID;
    private String name;
    private double price;
    private double totalAccumulated;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the totalAccumulated
     */
    public double getTotalAccumulated() {
        return totalAccumulated;
    }

    public void addToTotalPriceXstudents(int students) {
        totalAccumulated += (price * students);
    }

    @Override
    public int compareTo(Subject o) {
        return Double.compare(o.totalAccumulated, this.totalAccumulated);
    }

    void clearTotalAccumulated() {
        totalAccumulated = 0;
    }
}

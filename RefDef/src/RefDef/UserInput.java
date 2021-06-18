/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author evol9
 */
class UserInput {

    static Scanner input;
    private int selection;
    private String capturedText;

    private ArrayList<String> textToDisplay;
    private ArrayList<String> options;

    public UserInput() {
        input = new Scanner(System.in);
        textToDisplay = new ArrayList<>();
        options = new ArrayList<>();
        selection = 0;
    }

    /**
     * @return the capturedText
     */
    public String getCapturedText() {
        return capturedText;
    }

    /**
     * @param capturedText the capturedText to set
     */
    public void setCapturedText(String capturedText) {
        this.capturedText = capturedText;
    }

    /**
     * @return the selection
     */
    public int getSelection() {
        return selection;
    }

    void setText(String text) {
        textToDisplay.add(text);
    }

    void setOption(String option) {
        int index = options.size();
        options.add(String.format("%2d. ", index + 1) + option);
    }

    int runMenu() {
        selection = 0;
        boolean invalidInput = Boolean.TRUE;

        while (invalidInput) {
            // Trying to clear screen but not working.
            System.out.print("\033[H\033[2J");
            System.out.flush();

            for (String line : textToDisplay) {
                System.out.println(line);
            }
            System.out.println("please select from these choices");
            System.out.println("---------------------------------");
            for (String line : options) {
                System.out.println(line);
            }
            try {
                selection = input.nextInt();

            } catch (InputMismatchException e) {
                invalidInput = Boolean.TRUE;
            }
            input.nextLine();
            if (getSelection() > 0 && getSelection() <= options.size()) {
                invalidInput = Boolean.FALSE;
            }
            if (invalidInput) {
                System.out.println("Invalid selection");
            }
        }

        return getSelection();

    }

    void reset() {
        textToDisplay.clear();
        options.clear();
        capturedText = "";
    }

    String getEnteredText() {
        return capturedText;
    }

    String runTextCapture() {
        setCapturedText("");
        boolean invalidInput = Boolean.TRUE;

        while (invalidInput) {
            // Trying to clear screen but not working.
            System.out.print("\033[H\033[2J");
            System.out.flush();

            for (String line : textToDisplay) {
                System.out.println(line);
            }
            System.out.println("---------------------------------");
            try {
                setCapturedText(input.nextLine());
                invalidInput = Boolean.FALSE;

            } catch (InputMismatchException e) {
                invalidInput = Boolean.TRUE;
            }
            input.nextLine();
            if (invalidInput) {
                System.out.println("Invalid string");
            }
        }

        return getEnteredText();

    }

    void runDisplayText() {
        for (String line : textToDisplay) {
            System.out.println(line);
        }
    }

    int runIntCapture() {
        boolean invalidInput = Boolean.TRUE;

        while (invalidInput) {
            // Trying to clear screen but not working.
            System.out.print("\033[H\033[2J");
            System.out.flush();

            for (String line : textToDisplay) {
                System.out.println(line);
            }
            try {
                selection = input.nextInt();
                invalidInput = Boolean.FALSE;

            } catch (InputMismatchException e) {
                invalidInput = Boolean.TRUE;
            }
            input.nextLine();
        }
        if (invalidInput) {
            System.out.println("Invalid selection");
        }
        return getSelection();
    }
}

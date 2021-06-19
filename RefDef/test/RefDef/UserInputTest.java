/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefDef;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author evol9
 */
public class UserInputTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    public UserInputTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCapturedText method, of class UserInput.
     */
    @Test
    public void testGetCapturedText() {
        System.out.println("getCapturedText");
        UserInput instance = new UserInput();
        String expResult = "";
        String result = instance.getCapturedText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapturedText method, of class UserInput.
     */
    @Test
    public void testSetCapturedText() {
        System.out.println("setCapturedText");
        String capturedText = "";
        UserInput instance = new UserInput();
        instance.setCapturedText(capturedText);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelection method, of class UserInput.
     */
    @Test
    public void testGetSelection() {
        System.out.println("getSelection");
        UserInput instance = new UserInput();
        int expResult = 0;
        int result = instance.getSelection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setText method, of class UserInput.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String text = "";
        UserInput instance = new UserInput();
        instance.setText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOption method, of class UserInput.
     */
    @Test
    public void testSetOption() {
        System.out.println("setOption");
        String option = "";
        UserInput instance = new UserInput();
        instance.setOption(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runMenu method, of class UserInput.
     */
    @Test
    public void testRunMenu() {
        System.out.println("runMenu");
        UserInput instance = new UserInput();
        int expResult = 0;
        int result = instance.runMenu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class UserInput.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        UserInput instance = new UserInput();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnteredText method, of class UserInput.
     */
    @Test
    public void testGetEnteredText() {
        System.out.println("getEnteredText");
        UserInput instance = new UserInput();
        String expResult = "";
        String result = instance.getEnteredText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runTextCapture method, of class UserInput.
     */
    @Test
    public void testRunTextCapture() {
        System.out.println("runTextCapture");
        UserInput instance = new UserInput();
        String expResult = "";
        String result = instance.runTextCapture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runDisplayText method, of class UserInput.
     */
    @Test
    public void testRunDisplayText() {
        System.out.println("runDisplayText");
        UserInput instance = new UserInput();
        instance.runDisplayText();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runIntCapture method, of class UserInput.
     */
    @Test
    public void testRunIntCapture() {
        System.out.println("runIntCapture");
        UserInput instance = new UserInput();
        int expResult = 0;
        int result = instance.runIntCapture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

package RefDef;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author evol9
 */
public class Initialize {

    private Properties prop;

    public Initialize() {
        prop = new Properties();

        loadFile("config.properties");
        loadStudents();
        System.out.println("Hello from Init");

    }

    /**
     * @return the prop
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * @param prop the prop to set
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    private void loadFile(String fileName) {
        try (InputStream input = Initialize.class.getClassLoader().getResourceAsStream(fileName)) {
            if (null != input) {
                getProp().load(input);
            }
            else
                System.out.println("Init file missing fatal error");
//            printProperties(getProp());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadStudents() {
        Student tempStudent;
        int totalStudents = 0;
        String sIndex;
        String keyString;
        ArrayList<String> studentKeyList = new ArrayList<>();

        for (Object key : getProp().keySet()) {
            if (key.toString().startsWith("student")) {
                studentKeyList.add(key.toString());
                System.out.println("Added: " + key);
            }
        }
//        every student has 1 property
        totalStudents = studentKeyList.size();

        for (int i = 0; i < totalStudents; i++) {
            tempStudent = new Student();
            sIndex = String.format(".%02d.", i + 1);
            keyString = "student" + sIndex;
            System.out.println(keyString);
//            tempStudent.setIdNumber(Integer.parseInt(prop.getProperty(keyString + "id")));
//            tempStudent.setFullName(prop.getProperty(keyString + "name"));
            tempStudent.setStudentID(i);
//            System.out.println(prop.getProperty(keyString + "name"));
            tempStudent.setName(prop.getProperty(keyString + "name"));
            DataSingleton.getInstance().getStudents().add(tempStudent);
            System.out.println("Added: " + tempStudent.getName());
        }
    }

}

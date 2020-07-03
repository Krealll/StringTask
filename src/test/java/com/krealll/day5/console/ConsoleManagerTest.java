package com.krealll.day5.console;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.*;

public class ConsoleManagerTest {

    ConsoleManager consoleManager;
    ByteArrayInputStream in = new ByteArrayInputStream("Finally, some good food".getBytes());

    @BeforeMethod
    public void setUp() {
        consoleManager = new ConsoleManager();
    }

    @Test
    public void scanConsoleStrPosTest() {
        System.setIn(in);
        String testString = consoleManager.scanConsoleStr();
        System.setIn(System.in);
        assertEquals(testString,"Finally, some good food");
    }

}
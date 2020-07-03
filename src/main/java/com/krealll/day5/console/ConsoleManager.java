package com.krealll.day5.console;

import java.util.Scanner;

public class ConsoleManager {

    public void printToConsole(String string) {
        System.out.printf(string);
    }

    public void printToConsole(int val) {
        System.out.println(val);
    }

    public String scanConsoleStr(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        printToConsole("Enter string:\n");
        return scanner.next();
    }


    /*

    ////



    */
}

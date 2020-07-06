package com.krealll.day5.service;

public class StringManager {

    protected final static String BAD_PARAMETERS_MESSAGE = "Wrong method parameters",
            VOWEL="aeyuioAEYUIO";

    public static String getVowelSymbolStr() {
        return VOWEL;
    }

    protected void shiftArrayToLeft(char[] array, int startIndex, int stopIndex, int step) {
        for (int i = startIndex; i < array.length - step - stopIndex; i++) {
            array[i] = array[i + step];
        }
    }

    protected boolean isLetter(char c){
        return (c>=65&&c<=90)||(c>=97&&c<=122);
    }

    protected boolean isSpace(char c){
        return c==32;
    }

    protected boolean isVowel (char c){
        for (int i = 0; i <VOWEL.length() ; i++) {
            if(c==VOWEL.charAt(i)){
                return true;
            }
        }
        return false;
    }
}

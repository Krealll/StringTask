package com.krealll.day5.service.impl;

import com.krealll.day5.service.DeleteManager;

import java.util.Arrays;

public class StringDeleteManagerImpl implements DeleteManager {

    private static final String VOWEL_SYMBOL_STR = "aeyuioAEYUIO";

    public String delSymbolsExceptLetters(String inputStr) {
        StringBuilder resultString = new StringBuilder(inputStr);
        for (int i = 0; i < resultString.length();) {
            if(i==resultString.length()-1){
                if(!isLetter(resultString.charAt(i))){
                    resultString.delete(i,i+1);
                    break;
                }
            }
            if(!(isLetter(resultString.charAt(i))||isSpace(resultString.charAt(i)))){
                if (isLetter(resultString.charAt(i-1)) && isLetter(resultString.charAt(i+1))) {
                    resultString.setCharAt(i,' ');
                    i++;
                } else {
                    resultString.delete(i,i+1);
                }
            } else {
                i++;
            }
        }
        return resultString.toString();
    }

    public String delWordOfSize(int wordSize, String inputString) {
        StringBuilder resultString = new StringBuilder(inputString);
        int sizeCounter = 0, inputStrSize = inputString.length();
        for (int i = 0; i <inputStrSize-1 ;) {
            while (!isLetter(resultString.charAt(i))){
                i++;
            }
            if(!isVowel(resultString.charAt(i))){
                while (isLetter(resultString.charAt(i))){
                    i++;
                    sizeCounter++;
                }
                if(sizeCounter==wordSize){
                    i-=sizeCounter;
                    resultString.delete(i,i+sizeCounter);
                    inputStrSize-=sizeCounter;
                }
                sizeCounter=0;
            } else {
                while (isLetter(resultString.charAt(i))){
                    i++;
                }
            }
        }
        return resultString.toString();

    }

    private boolean isLetter(char c){
        return (c>=65&&c<=90)||(c>=97&&c<=122);
    }

    private boolean isSpace(char c){
        return c==32;
    }

    private boolean isVowel (char c){
        //TODO: create super class that contains repeating private methods
        for (int i = 0; i <VOWEL_SYMBOL_STR.length() ; i++) {
            if(c==VOWEL_SYMBOL_STR.charAt(i)){
                return true;
            }
        }
        return false;
    }
}

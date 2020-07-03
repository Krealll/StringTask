package com.krealll.day5.service.impl;

import com.krealll.day5.service.DeleteManager;

import java.util.Arrays;

public class SymArrayDeleteManagerImpl implements DeleteManager {

    private static final char[]VOWEL_SYMBOL_STR={'a','e','y','u','i','o','A','E','Y','U','I','O'};

    @Override
    public String delSymbolsExceptLetters(String inputText) {
        char[] symStr = inputText.toCharArray(),
                resultArray;
        int delCounter=0;
        for (int i = 0; i < symStr.length-delCounter;) {
            if(!(isLetter(symStr[i])||isSpace(symStr[i]))){
                if (isLetter(symStr[i - 1]) && isLetter(symStr[i + 1])) {
                    symStr[i] = ' ';
                    i++;
                } else {
                    shiftArrayToLeft(symStr, i, delCounter,1);
                    delCounter++;
                }
            } else {
                i++;
            }
        }
        resultArray= Arrays.copyOf(symStr, symStr.length-delCounter);
        return new String(resultArray);
    }

    private void shiftArrayToLeft(char[] array, int index,int stopIndex,int step) {
        for (int i = index; i < array.length - step - stopIndex; i++) {
            array[i] = array[i + step];
        }
    }

    public String delWordOfSize(int requiredSize, String inputString) {
        char[] charArray= inputString.toCharArray(),
                resultArray;
        int sizeCounter = 0, delCounter=0;
        for (int i = 0; i <charArray.length-delCounter ;) {
            while (!isLetter(charArray[i])){
                i++;
            }
            if(!isVowel(charArray[i])){
                while (isLetter(charArray[i])){
                    i++;
                    sizeCounter++;
                }
                if(sizeCounter==requiredSize){
                    i-=sizeCounter;
                    shiftArrayToLeft(charArray,i,delCounter,sizeCounter);
                    delCounter+=sizeCounter;
                }
                sizeCounter=0;
            } else {
                while (isLetter(charArray[i])){
                    i++;
                }
            }
        }
        resultArray=Arrays.copyOf(charArray,charArray.length-delCounter);
        return new String(resultArray);
    }

    private boolean isLetter(char c){
        return (c>=65&&c<=90)||(c>=97&&c<=122);
    }

    private boolean isSpace(char c){
        return c==32;
    }

    private boolean isVowel (char c){
        //TODO: create super class that contains repeating private methods
        for (int i = 0; i <VOWEL_SYMBOL_STR.length ; i++) {
            if(c==VOWEL_SYMBOL_STR[i]){
                return true;
            }
        }
        return false;
    }
}

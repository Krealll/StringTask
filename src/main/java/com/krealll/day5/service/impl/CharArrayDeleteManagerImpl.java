package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.DeleteManager;
import com.krealll.day5.service.StringManager;

import java.util.Arrays;

public class CharArrayDeleteManagerImpl extends StringManager implements DeleteManager {

    private static final char[]VOWEL_SYMBOL_STR={'a','e','y','u','i','o','A','E','Y','U','I','O'};

    @Override
    public String deleteNonLetterSymbols(String inputString) throws CustomException {
        if(inputString==null){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        char[] charArray = inputString.toCharArray(),
                resultArray;
        int delCounter=0;
        for (int i = 0; i < charArray.length-delCounter;) {
            if(!(isLetter(charArray[i])||isSpace(charArray[i]))){
                if (isLetter(charArray[i - 1]) && isLetter(charArray[i + 1])) {
                    charArray[i] = ' ';
                    i++;
                } else {
                    shiftArrayToLeft(charArray, i, delCounter,1);
                    delCounter++;
                }
            } else {
                i++;
            }
        }
        resultArray= Arrays.copyOf(charArray, charArray.length-delCounter);
        return new String(resultArray);
    }

    public String deleteWord(String inputString, int wordSize) throws CustomException {
        if(inputString==null||wordSize<1){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
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
                if(sizeCounter==wordSize){
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
}

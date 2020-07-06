package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.DeleteManager;
import com.krealll.day5.service.StringManager;

public class StringDeleteManagerImpl extends StringManager implements DeleteManager{

    public String deleteNonLetterSymbols(String inputStr) throws CustomException {
        if(inputStr==null){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
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

    public String deleteWord(String inputString, int wordSize) throws CustomException {
        if(inputString==null||wordSize<1){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
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
}

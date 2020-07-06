package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.DeleteManager;
import com.krealll.day5.service.StringManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDeleteManagerImpl extends StringManager implements DeleteManager {

    private static final String WORD_CONSONANT_START = "\\b[\\p{L}&&[^aeyuioAEYUIO]]\\p{L}{",
                                WORD_CONSONANT_ENDING ="}\\b",
                                NON_LETTER_SYMBOLS="[^\\p{L}]",
                                SPACE_SYMBOL=" ",
                                EMPTY_STRING="";

    public String deleteNonLetterSymbols(String inputStr) throws CustomException {
        if(inputStr==null){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        Pattern pattern = Pattern.compile(NON_LETTER_SYMBOLS);
        Matcher matcher = pattern.matcher(inputStr);
        inputStr=matcher.replaceAll(SPACE_SYMBOL);
        return inputStr;
    }

    public String deleteWord(String inputString, int wordSize) throws CustomException {
        if(inputString==null||wordSize<1){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        Pattern pattern = Pattern.compile(WORD_CONSONANT_START+(wordSize-1)+ WORD_CONSONANT_ENDING);
        Matcher matcher = pattern.matcher(inputString);
        inputString=matcher.replaceAll(EMPTY_STRING);
        return inputString;
    }
}

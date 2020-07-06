package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;
import com.krealll.day5.service.StringManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceManagerImpl extends StringManager implements ReplaceManager {

    private final static String WORD_START_GROUP="$1",
                                WORD_END_GROUP="$3",
                                WORD_BOUNDARY="\\b",
                                WORD_START = "\\b(\\p{L}{",
                                WORD_START_ENDING="})",
                                WORD_DESIRED_SYMBOL="(\\p{L})",
                                WORD_END = "(\\p{L}*)";

    public String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) throws CustomException {
        if(inputString==null||symbolNumber<0){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        Pattern pattern = Pattern.compile(WORD_START+(symbolNumber-1)+WORD_START_ENDING+WORD_DESIRED_SYMBOL+WORD_END);
        Matcher matcher = pattern.matcher(inputString);
        inputString = matcher.replaceAll(WORD_START_GROUP+replaceSymbol+WORD_END_GROUP);
        return inputString;
    }

    public String correctMistake(String inputString, String wrongElement, String correctElement) throws CustomException {
        if(inputString==null||wrongElement==null||correctElement==null){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        Pattern pattern = Pattern.compile(wrongElement);
        Matcher matcher = pattern.matcher(inputString);
        inputString=matcher.replaceAll(correctElement);
        return inputString;
    }

    public String replaceWordBySubStr(String inputString, String subString, int baseWordSize) throws CustomException {
        if(inputString==null||subString==null||baseWordSize<0){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        Pattern pattern = Pattern.compile(WORD_START+baseWordSize+WORD_START_ENDING+WORD_BOUNDARY);
        Matcher matcher = pattern.matcher(inputString);
        inputString = matcher.replaceAll(subString);
        return inputString;
    }
}

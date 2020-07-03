package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExReplaceManagerImpl implements ReplaceManager {

    public String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) throws CustomException {
        if(inputString==null||symbolNumber<0){
            throw new CustomException("Wrong method parameters");
        }
        //TODO: add RegEx implementation
        return "";
    }

    public String correctMistake(String inputString, String wrongElement, String correctElement) throws CustomException {
        if(inputString==null||wrongElement==null||correctElement==null){
            throw new CustomException("Wrong method parameters");
        }
        Pattern pattern = Pattern.compile(wrongElement);
        Matcher matcher = pattern.matcher(inputString);
        inputString=matcher.replaceAll(correctElement);
        return inputString;
    }

    public String replaceWordBySubStr(String inputString, String subString, int baseWordSize) throws CustomException {
        if(inputString==null||subString==null||baseWordSize<0){
            throw new CustomException("Wrong method parameters");
        }
        //TODO: add RegEx implementation
        return "";
    }
}

package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;
import com.krealll.day5.service.StringManager;

import java.util.Arrays;

public class CharArrayReplaceManagerImpl extends StringManager implements ReplaceManager {

    public String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) throws CustomException {
        if(inputString==null||symbolNumber<0){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        char[] charArray = inputString.toCharArray(),
        resultArray;
        int sizeCounter = 0;
        for (int i = 0; i <charArray.length ; i++) {
            while (!isLetter(charArray[i])){
                i++;
            }
            while(isLetter(charArray[i])){
                sizeCounter++;
                i++;
            }
            if(sizeCounter>=symbolNumber){
                charArray[i-sizeCounter+symbolNumber]=replaceSymbol;
            }
            sizeCounter=0;
        }
        resultArray = Arrays.copyOf(charArray,charArray.length);
        return new String(resultArray);
    }

    public String correctMistake(String inputString, String wrongElement, String correctElement) throws CustomException {
        if(inputString==null|| wrongElement==null||correctElement==null){
            throw new CustomException("Wrong method parameters");
        }
        //TODO: add char array implementation
        return "";
    }

    public String replaceWordBySubStr(String inputString, String subString, int baseWordSize) throws CustomException {
        if(inputString==null||subString==null||baseWordSize<1){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        //TODO: add char array implementation
        return "";
    }
}

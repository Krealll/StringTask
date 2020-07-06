package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;
import com.krealll.day5.service.StringManager;

public class StringReplaceManagerImpl extends StringManager implements ReplaceManager {

    public String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) throws CustomException {
        if(inputString==null||symbolNumber<0){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        StringBuilder resultString = new StringBuilder(inputString);
        int sizeCounter = 0;
        for (int i = 0; i <resultString.length() ; i++) {
            while (!isLetter(resultString.charAt(i))){
                i++;
            }
            while(isLetter(resultString.charAt(i))){
                sizeCounter++;
                i++;
            }
            if(sizeCounter>=symbolNumber){
                resultString.setCharAt(i-sizeCounter+symbolNumber-1,replaceSymbol);
            }
            sizeCounter=0;
        }
        return resultString.toString();
    }

    public String correctMistake(String inputString, String wrongElement, String correctElement) throws CustomException {
        if(inputString==null|| wrongElement==null||correctElement==null){
            throw new CustomException("Wrong method parameters");
        }
        return inputString.replace(wrongElement,correctElement);
    }

    public String replaceWordBySubStr(String inputString, String subString, int baseWordSize) throws CustomException {
        if(inputString==null||subString==null||baseWordSize<1){
            throw new CustomException(BAD_PARAMETERS_MESSAGE);
        }
        StringBuilder resultString = new StringBuilder(inputString);
        int sizeCounter = 0, endOfReplacement, subStrLength = subString.length();
        for (int i = 0; i <resultString.length() ; i++) {
            while (!isLetter(resultString.charAt(i))){
                i++;
            }
            while(isLetter(resultString.charAt(i))){
                sizeCounter++;
                i++;
            }
            if(sizeCounter==baseWordSize){
                if(sizeCounter==subStrLength){
                    resultString.replace(i-sizeCounter,i,subString);
                }else if(sizeCounter>subStrLength){
                    endOfReplacement=i-sizeCounter+subStrLength;
                    resultString.replace(i-sizeCounter,endOfReplacement,subString);
                    resultString.delete(endOfReplacement,i);
                    i-=sizeCounter-subStrLength;
                }else {
                    resultString.replace(i-sizeCounter,i,subString);
                    i+=subStrLength-sizeCounter;
                }
            }
            sizeCounter=0;
        }
        return resultString.toString();
    }
}

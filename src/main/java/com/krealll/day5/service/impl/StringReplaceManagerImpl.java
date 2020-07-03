package com.krealll.day5.service.impl;

import com.krealll.day5.service.ReplaceManager;

public class StringReplaceManagerImpl implements ReplaceManager {
    public String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) {
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

    public String correctMistake(String inputString, String wrongElement, String correctElement) {
        //TODO: add String implementation
        return "";
    }

    public String replaceWordBySubStr(String inputString, String subString, int baseWordSize) {
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

    private boolean isLetter(char c){
        //TODO: create super class that contains repeating private methods
        return (c>=65&&c<=90)||(c>=97&&c<=122);
    }
}

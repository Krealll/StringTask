package com.krealll.day5.service;

import com.krealll.day5.exception.CustomException;

public interface ReplaceManager {

    String replaceSymbolInWord(String inputString, int symbolNumber, char replaceSymbol) throws CustomException;

    String correctMistake(String inputString, String wrongElement, String correctElement) throws CustomException;

    String replaceWordBySubStr(String inputString, String subString, int baseWordSize) throws CustomException;

}

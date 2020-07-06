package com.krealll.day5.service;

import com.krealll.day5.exception.CustomException;

public interface DeleteManager {

    String deleteNonLetterSymbols(String inputStr) throws CustomException;

    String deleteWord(String inputString, int wordSize) throws CustomException;

}

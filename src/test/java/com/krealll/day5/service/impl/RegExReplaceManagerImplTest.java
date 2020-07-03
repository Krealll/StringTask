package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class RegExReplaceManagerImplTest {

    ReplaceManager replaceManager;
    String fileContent = "palypropylene chlordiazepaxide palycarbonate dispropartionate paliomyelitis occipitotemparal";

    @BeforeMethod
    public void setUp() {
        //TODO: add other tests + use groups of test in order to avoid code repetition
        replaceManager = new RegExReplaceManagerImpl();
    }

    @Test
    public void correctMistakeTest() throws CustomException {
        String actual =replaceManager.correctMistake(fileContent,"pa","po"),
                expected = "polypropylene chlordiazepoxide polycarbonate disproportionate poliomyelitis occipitotemporal";
        assertEquals(actual,expected);
    }
}
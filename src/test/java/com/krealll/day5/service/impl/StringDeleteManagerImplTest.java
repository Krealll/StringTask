package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringDeleteManagerImplTest {

    StringDeleteManagerImpl stringDeleteManager;
    String fileContent = "He turned to look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used to.\n" +
            "\n" +
            "He wasn't even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
            "\n" +
            "With that disappearance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
            "\n" +
            "- And the beginning of Infinity.";

    @BeforeMethod
    public void setUp() {
        stringDeleteManager = new StringDeleteManagerImpl();
    }

    @Test
    public void deleteNonLetterSymbolsTest() throws CustomException {
        String actual =stringDeleteManager.deleteNonLetterSymbols(fileContent),
                expected = "He turned to look at her and she was smiling at him It was Noys as she had been and his own heart beating as it had used to" +
                        " He wasn t even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it" +
                        " With that disappearance he knew even as Noys moved slowly into his arms came the end the final end of Eternity" +
                        " And the beginning of Infinity";
        assertEquals(actual,expected);
    }

    @Test
    public void deleteWordTest() throws CustomException {
        String expected = " turned  look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used .\n" +
                "\n" +
                " wasn't even aware that  had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
                "\n" +
                "With that disappearance,  knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
                "\n" +
                "- And the beginning of Infinity.",
                actual = stringDeleteManager.deleteWord(fileContent, 2);
        assertEquals(actual,expected);
    }
}
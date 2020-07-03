package com.krealll.day5.service.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymArrayDeleteManagerImplTest {

    SymArrayDeleteManagerImpl symArrayDeleteManager;
    String fileContent = "He turned to look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used to.\n" +
            "\n" +
            "He wasn't even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
            "\n" +
            "With that disappearance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
            "\n" +
            "- And the beginning of Infinity.";

    @BeforeMethod
    public void setUp() {
        symArrayDeleteManager=new SymArrayDeleteManagerImpl();
    }

    @Test
    public void delSymbolsExceptLettersTest() {
        String actual =symArrayDeleteManager.delSymbolsExceptLetters(fileContent),
                expected = "He turned to look at her and she was smiling at him It was Noys as she had been and his own heart beating as it had used to" +
                        " He wasn t even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it" +
                        " With that disappearance he knew even as Noys moved slowly into his arms came the end the final end of Eternity" +
                        " And the beginning of Infinity";
        assertEquals(actual,expected);
    }

    @Test
    public void delWordOfSizeTest() {
        String actual =symArrayDeleteManager.delWordOfSize(2,fileContent),
                expected = " turned  look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used .\n" +
                        "\n" +
                        " wasn't even aware that  had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
                        "\n" +
                        "With that disappearance,  knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
                        "\n" +
                        "- And the beginning of Infinity.";
        assertEquals(actual,expected);
    }
}
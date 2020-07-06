package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharArrayReplaceManagerImplTest {

    CharArrayReplaceManagerImpl charArrayReplaceManager;
    String firstFileContent = "He turned to look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used to.\n" +
            "\n" +
            "He wasn't even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
            "\n" +
            "With that disappearance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
            "\n" +
            "- And the beginning of Infinity.";

    @BeforeMethod
    public void setUp() {
        charArrayReplaceManager = new CharArrayReplaceManagerImpl();
    }

    @Test
    public void replaceSymbolInWordTest() throws CustomException {
        String expected= "He turned to look at her, and she was smilin+ at him. It was Noys as she had been, and his own heart beatin+ as it had used to.\n" +
                "\n" +
                "He wasn't even aware that he had made his decisi+n until the grayne+s sudden+y invade+ all the sky as the hulk of the kettle disapp+ared from agains+ it.\n" +
                "\n" +
                "With that disapp+arance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eterni+y.\n" +
                "\n" +
                "- And the beginn+ng of Infini+y.",
        actual = charArrayReplaceManager.replaceSymbolInWord(firstFileContent,7,'+');
    }
}
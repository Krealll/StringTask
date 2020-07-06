package com.krealll.day5.service.impl;

import com.krealll.day5.exception.CustomException;
import com.krealll.day5.service.ReplaceManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegExReplaceManagerImplTest {

    ReplaceManager replaceManager;
    String firstFileContent = "palypropylene chlordiazepaxide palycarbonate dispropartionate paliomyelitis occipitotemparal",
            secondFileContent = "He turned to look at her, and she was smiling at him. It was Noys as she had been, and his own heart beating as it had used to.\n" +
                    "\n" +
                    "He wasn't even aware that he had made his decision until the grayness suddenly invaded all the sky as the hulk of the kettle disappeared from against it.\n" +
                    "\n" +
                    "With that disappearance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eternity.\n" +
                    "\n" +
                    "- And the beginning of Infinity.";

    @BeforeMethod
    public void setUp() {
        replaceManager = new RegExReplaceManagerImpl();
    }

    @Test
    public void replaceSymbolInWordTest() throws CustomException {
        String actual = replaceManager.replaceSymbolInWord(secondFileContent,7,'+'),
                expected = "He turned to look at her, and she was smilin+ at him. It was Noys as she had been, and his own heart beatin+ as it had used to.\n" +
                        "\n" +
                        "He wasn't even aware that he had made his decisi+n until the grayne+s sudden+y invade+ all the sky as the hulk of the kettle disapp+ared from agains+ it.\n" +
                        "\n" +
                        "With that disapp+arance, he knew, even as Noys moved slowly into his arms, came the end, the final end of Eterni+y.\n" +
                        "\n" +
                        "- And the beginn+ng of Infini+y.";
        assertEquals(actual,expected);
    }

    @Test
    public void correctMistakeTest() throws CustomException {
        String actual =replaceManager.correctMistake(firstFileContent,"pa","po"),
                expected = "polypropylene chlordiazepoxide polycarbonate disproportionate poliomyelitis occipitotemporal";
        assertEquals(actual,expected);
    }

    @Test
    public void replaceWordBySubStrEqualTest() throws CustomException {
        String actual = replaceManager.replaceWordBySubStr(secondFileContent,"OO",2),
                expected="OO turned OO look OO her, and she was smiling OO him. OO was Noys OO she had been, and his own heart beating OO OO had used OO.\n" +
                        "\n" +
                        "OO wasn't even aware that OO had made his decision until the grayness suddenly invaded all the sky OO the hulk OO the kettle disappeared from against OO.\n" +
                        "\n" +
                        "With that disappearance, OO knew, even OO Noys moved slowly into his arms, came the end, the final end OO Eternity.\n" +
                        "\n" +
                        "- And the beginning OO Infinity.";
        assertEquals(actual,expected);
    }

    @Test
    public void replaceWordBySubStrLessTest() throws CustomException {
        String expected = "O turned O look O her, and she was smiling O him. O was Noys O she had been, and his own heart beating O O had used O.\n" +
                "\n" +
                "O wasn't even aware that O had made his decision until the grayness suddenly invaded all the sky O the hulk O the kettle disappeared from against O.\n" +
                "\n" +
                "With that disappearance, O knew, even O Noys moved slowly into his arms, came the end, the final end O Eternity.\n" +
                "\n" +
                "- And the beginning O Infinity.",
                actual = replaceManager.replaceWordBySubStr(secondFileContent,"O",2);
        assertEquals(actual,expected);
    }

    @Test
    public void replaceWordBySubStrBiggerTest() throws CustomException {
        String expected = "OOO turned OOO look OOO her, and she was smiling OOO him. OOO was Noys OOO she had been, and his own heart beating OOO OOO had used OOO.\n" +
                "\n" +
                "OOO wasn't even aware that OOO had made his decision until the grayness suddenly invaded all the sky OOO the hulk OOO the kettle disappeared from against OOO.\n" +
                "\n" +
                "With that disappearance, OOO knew, even OOO Noys moved slowly into his arms, came the end, the final end OOO Eternity.\n" +
                "\n" +
                "- And the beginning OOO Infinity.",
                actual = replaceManager.replaceWordBySubStr(secondFileContent,"OOO",2);
        assertEquals(actual,expected);
    }
}
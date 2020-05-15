package com.epita.socra.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanConverterTest {

    IConverter converter;

    @Before
    public void prepare() {
        this.converter = new RomanConverter();
    }

    public void givenArabicValue_ReturnRomanValue(String arabicValue, String expectedValue) {
        try {
            String result = this.converter.convert(arabicValue);
            Assert.assertEquals(expectedValue, result);
        } catch (InvalidArgumentException e) {
        }
    }

    @Test()
    public void givenArabicNumber_WhenInputIs10_ReturnX() {
        this.givenArabicValue_ReturnRomanValue("10", "X");
    }

    @Test()
    public void givenArabicNumber_WhenInputIs42_ReturnXLII() {
        this.givenArabicValue_ReturnRomanValue("42", "XLII");
    }

    @Test()
    public void givenArabicNumber_WhenInputIs83_ReturnLXXXIII() {
        this.givenArabicValue_ReturnRomanValue("83", "LXXXIII");
    }

    @Test
    public void giverArabicNumber_WhenInputIs1903_ReturnMCMIII() {
        this.givenArabicValue_ReturnRomanValue("1903", "MCMIII");
    }

    @Test
    public void givenArabicNumber_WhenInputIs999_ReturnCMXCIX() {
        this.givenArabicValue_ReturnRomanValue("999", "CMXCIX");
    }
}

package com.epita.socra.app;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArabicConverterTest {
    IConverter converter;

    @Before
    public void prepare() {
        this.converter = new ArabicConverter();
    }

    public void givenRomanValue_ReturnArabicValue(String romanValue, String expectedValue) {
        try {
            String result = this.converter.convert(romanValue);
            Assert.assertEquals(expectedValue, result);
        } catch (InvalidArgumentException e) {
        }
    }

    @Test()
    public void givenRomanNumber_WhenInputIsI_Return1() {
        this.givenRomanValue_ReturnArabicValue("I", "1");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsV_Return5() {
        this.givenRomanValue_ReturnArabicValue("V", "5");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsX_Return10() {
        this.givenRomanValue_ReturnArabicValue("X", "10");
    }

    @Test()
    public void givenRomainNumber_WhenInputIsXX_Return20() {
        this.givenRomanValue_ReturnArabicValue("XX", "20");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsL_Return50() {
        this.givenRomanValue_ReturnArabicValue("L", "50");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsC_Return100() {
        this.givenRomanValue_ReturnArabicValue("C", "100");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsD_Return500() {
        this.givenRomanValue_ReturnArabicValue("D", "500");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsM_Return1000() {
        this.givenRomanValue_ReturnArabicValue("M", "1000");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsXXX_Return30() {
        this.givenRomanValue_ReturnArabicValue("XXX", "30");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsXLII_Return42()
    {
        this.givenRomanValue_ReturnArabicValue("XLII", "42");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsLXXXIII_Return83()
    {
        this.givenRomanValue_ReturnArabicValue("LXXXIII", "83");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsMCMIII_Return1903()
    {
        this.givenRomanValue_ReturnArabicValue("MCMIII", "1903");
    }

    @Test()
    public void givenRomanNumber_WhenInputIsCMXCIX_Return999()
    {
        this.givenRomanValue_ReturnArabicValue("CMXCIX", "999");
    }

    @Test(expected = InvalidArgumentException.class)
    public void givenRomanNumber_WhenInputIsXXXX_ThrowInvalidArgumentException() throws InvalidArgumentException {
        String romanValue = "XXXX";
        this.converter.convert(romanValue);
    }
}

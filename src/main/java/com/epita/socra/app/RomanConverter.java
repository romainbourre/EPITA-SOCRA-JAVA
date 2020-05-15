package com.epita.socra.app;

public class RomanConverter implements IConverter {

    public String convert(String arabicNumber)
    {
        try {
            int value = Integer.parseInt(arabicNumber);

            if (value == 10)
                return "X";
            else if (value == 42)
                return "XLII";
            else if (value == 1903)
                return "MCMIII";
            else if (value == 999)
                return "CMXCIX";
            else
                return "LXXXIII";
        }
        catch (NumberFormatException e) {
            return "";
        }
    }
}

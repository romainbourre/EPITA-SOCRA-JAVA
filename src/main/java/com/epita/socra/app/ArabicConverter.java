package com.epita.socra.app;

import java.util.Map;

public class ArabicConverter implements IConverter {
    private int convertRomanCharacter(Character c)
    {
        switch (c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public String convert(String romanNumber) throws InvalidArgumentException
    {
        int result = 0;
        char letter = 'A';
        int counter = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (letter != romanNumber.charAt(i))
            {
                letter = romanNumber.charAt(i);
                counter = 0;
            }
            else
            {
                counter++;
                if (counter >= 3)
                {
                    throw new InvalidArgumentException();
                }
            }
            Character actualCharacter = romanNumber.charAt(i);
            int actualArabicValue = this.convertRomanCharacter(actualCharacter);
            if (i > 0)
            {
                Character previousRomanCharacter = romanNumber.charAt(i - 1);
                int previousArabicValue = this.convertRomanCharacter(previousRomanCharacter);

                result = actualArabicValue > previousArabicValue ? (result - previousArabicValue) + (actualArabicValue - previousArabicValue) : result + actualArabicValue;
            }
            else
            {
                result += actualArabicValue;
            }
        }

        return Integer.toString(result);
    }
}

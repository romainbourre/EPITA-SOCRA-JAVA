package com.epita.socra.app;

import java.util.Map;

public class ArabicConverter implements IConverter {
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


            if (romanNumber.charAt(i) == 'I')
                result += 1;
            if (romanNumber.charAt(i) == 'V')
                result += 5;
            if (romanNumber.charAt(i) == 'X')
                result += 10;
            if (romanNumber.charAt(i) == 'L')
                result += 50;
            if (romanNumber.charAt(i) == 'C')
                result += 100;
            if (romanNumber.charAt(i) == 'D')
                result += 500;
            if (romanNumber.charAt(i) == 'M')
                result += 1000;
        }


        return Integer.toString(result);
    }
}

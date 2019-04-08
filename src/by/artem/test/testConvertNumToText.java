package by.artem.test;

import by.artem.ConverterNumToText;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.*;

public class testConvertNumToText {

    private final ConverterNumToText Converter = new ConverterNumToText();


    @Test
    public void checkingConvertFrom0to19() throws Exception {
        String[] nameNum = new String[]{"ноль", "один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        for (int i = 0; i < nameNum.length; i++) {
            assertEquals(" Error in the numbers from 0 to 19", nameNum[i],
                    Converter.convertNumbToText(new BigInteger(String.valueOf(i))));
        }
        System.out.println("Junit test: Convert to words numbers from 0 to 19 all is cool");
    }


    @Test
    public void checkingConvertFrom20to999() throws Exception {

        String[] nameNum = new String[]{"сорок", "семьдесят один", "сто", "двести два",
                "пятьсот пятьдесят пять", "триста десять", "девятьсот девяносто девять"};
        int numbersToCheck[] = new int[]{40, 71, 100, 202, 555, 310, 999};

        for (int i = 0; i < numbersToCheck.length; i++) {
            assertEquals(" Error in the numbers from 20 to 999", nameNum[i],
                    Converter.convertNumbToText(new BigInteger(String.valueOf(numbersToCheck[i]))));
        }

        System.out.println("Junit test: Convert to words numbers from 20 to 999 all is cool");
    }


    @Test
    public void convertBigNumbers() throws Exception {

        String[] nameNum = new String[]{"два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь",
                "минус один миллион одиннадцать",
                "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять"};
        int numbersToCheck[] = new int[]{Integer.MAX_VALUE, -1000011, 123456789};

        for (int i = 0; i < numbersToCheck.length; i++) {
            assertEquals(" Error in the big numbers", nameNum[i],
                    Converter.convertNumbToText(new BigInteger(String.valueOf(numbersToCheck[i]))));
        }
        System.out.println("Junit test: Convert to text big numbers all is cool");
    }


    @Test
    public void convertGenderFormsFrom1and2() throws Exception {

        String[] nameNum = new String[]{"две тысячи", "одна тысяча", "один миллион", "два миллиона"};
        int numbersToCheck[] = new int[]{2000, 1000, 1000000, 2000000};

       for (int i = 0; i < numbersToCheck.length; i++) {
            assertEquals(" Error in the numbers exist units 1/2", nameNum[i],
                    Converter.convertNumbToText(new BigInteger(String.valueOf(numbersToCheck[i]))));
        }
        System.out.println("Junit test: check gender units 1/2 all is cool ");
    }
}

package by.artem.test;

import by.artem.ConverterNumToString;
import org.junit.Test;

import java.math.BigInteger;

import static junit.framework.TestCase.*;

public class ConverterNumToStringTest {

    private final ConverterNumToString Converter = new ConverterNumToString();


    @Test
    public void testConvert_0to19() throws Exception {
        String[] nameNum = new String[]{"ноль", "один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        System.out.println("Junit test: Convert to words numbers 0-19");

        for (int i = 0; i < 20; i++) {
            assertEquals(" Error in the numbers  0-19", nameNum[i],
                    Converter.convertNumbToString(new BigInteger(String.valueOf(i))));
        }
    }


    @Test
    public void testConvert_20to999() throws Exception {

        String[] nameNum = new String[]{"сорок", "семьдесят один", "сто", "двести два",
                "пятьсот пятьдесят пять", "триста десять", "девятьсот девяносто девять"};
        int numbers[] = new int[]{40, 71, 100, 202, 555, 310, 999};

        System.out.println("Junit test: Convert to words numbers 20-999");

        for (int i = 0; i < 7; i++) {
            assertEquals(" Error in the numbers  20-999", nameNum[i],
                    Converter.convertNumbToString(new BigInteger(String.valueOf(numbers[i]))));
        }
    }


    @Test
    public void testConvert_BigNumber() throws Exception {

        String[] nameNum = new String[]{"два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь",
                "минус один миллион одиннадцать",
                "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять"};
        int numbers[] = new int[]{Integer.MAX_VALUE, -1000011, 123456789};

        System.out.println("Junit test: Convert to words big numbers ");

        for (int i = 0; i < 3; i++) {
            assertEquals(" Error in the big numbers", nameNum[i],
                    Converter.convertNumbToString(new BigInteger(String.valueOf(numbers[i]))));
        }
    }


    @Test
    public void testConvert_genderForms_1and2() throws Exception {

        String[] nameNum = new String[]{"две тысячи", "одна тысяча", "один миллион", "два миллиона"};
        int numbers[] = new int[]{2000, 1000, 1000000, 2000000};

        System.out.println("Junit test: check units 1/2");

        for (int i = 0; i < 4; i++) {
            assertEquals(" Error in the numbers exist units 1/2", nameNum[i],
                    Converter.convertNumbToString(new BigInteger(String.valueOf(numbers[i]))));
        }
    }
}

package by.artem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;


import static org.junit.Assert.*;

public class TestConvertNumToTextFromTextFile {

    private BufferedReader br = null;
    private final ConverterNumToText Converter = new ConverterNumToText();

    @Before
    public void setUp() throws Exception {
        br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/test/resources/DataForTesting/TestNumbers.txt"), "UTF8"));
    }

    @After
    public void tearDown() throws Exception {
        if (br != null) {
            br.close();
        }
        br = null;
    }


    @Test
    public void testConvertDataFromFile() throws Exception {
        String tmpLineStr;
        String Units[];
        while ((tmpLineStr = br.readLine()) != null) {
            if (!tmpLineStr.equals("")) {
                Units = tmpLineStr.split(":");
                assertEquals("Error: ",Units[1],
                        Converter.convertNumbToText(new BigInteger(Units[0])));
            }
        }
        System.out.println("Junit test: Data conversion from file was successful  ");
    }
}

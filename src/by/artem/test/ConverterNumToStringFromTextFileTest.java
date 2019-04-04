package by.artem.test;


import by.artem.ConverterNumToString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;


import static org.junit.Assert.*;

public class ConverterNumToStringFromTextFileTest {

    private BufferedReader br = null;
    private final ConverterNumToString Converter = new ConverterNumToString();

    @Before
    public void setUp() throws Exception {
        br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("DataForTest/TestNumbers.txt"), "UTF8"));
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
                assertEquals(Units[1],
                        Converter.convertNumbToString(new BigInteger(Units[0])));
            }
        }
    }
}

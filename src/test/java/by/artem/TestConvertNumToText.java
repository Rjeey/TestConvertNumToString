package by.artem;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;


@RunWith(DataProviderRunner.class)
public class TestConvertNumToText {

    private final ConverterNumToText Converter = new ConverterNumToText();

    @Test
    @UseDataProvider(value ="combo" ,location = TestDataProvider.class)
    public void checkingConvert(String nameNum, int numbersToCheck) throws Exception {

            assertEquals(" Error in the numbers from: ", nameNum,
                    Converter.convertNumbToText(new BigInteger(String.valueOf(numbersToCheck))));
    }

}

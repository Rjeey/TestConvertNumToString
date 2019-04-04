package by.artem;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TryToWork {
    private static Logger log =  Logger.getLogger(TryToWork.class.getName());

    public static void main(String[] args) {
        BigInteger values[] = {new BigInteger("134345"), new BigInteger("99988877766620178587876868578858685768"),
                new BigInteger("5"),
                new BigInteger("-15"), new BigInteger(String.valueOf(Long.MAX_VALUE)),
                new BigInteger(String.valueOf(Integer.MAX_VALUE)), new BigInteger("546534000345")};
        ConverterNumToString obj = new ConverterNumToString();
        for (BigInteger value : values)
            try {
                System.out.println(obj.convertNumbToString(value));
            } catch (IOException e) {
                log.log(Level.SEVERE, null, e);
            }
    }
}

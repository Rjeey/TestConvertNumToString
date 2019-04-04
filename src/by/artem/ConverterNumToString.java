package by.artem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ConverterNumToString {
    private final String PATH_FILE_DEGREE = "dataFiles/nameDegrees.txt";
    private final String PATH_FILE_DISCHARGES = "dataFiles/nameDischarges.txt";
    private final static int MALE_GENDER = 1;
    private final static int FEMALE_GENDER = -1;
    private final static String SPACE = " ";

    private Map<Integer, String> nameDischarges;

    private Map<Integer, String> nameDegrees;

    private final String[][] endings = {{"а", "и", ""},{"","а","ов"}};

    public  String convertNumbToString(BigInteger number) throws IOException{

        nameDegrees = initNameFromFile(PATH_FILE_DEGREE);
        nameDischarges =  initNameFromFile(PATH_FILE_DISCHARGES);

        String numberStr = number.toString();

        if(numberStr.equals("0")) return nameDischarges.get(0);

        String nameNumber = "";

        if(numberStr.charAt(0) == '-'){
            nameNumber += "минус ";
            numberStr = numberStr.substring(1);
        }

        for(int i =0; i < numberStr.length() % 3; i++)
            numberStr = "0" + numberStr;

        try {
            for(int i =0; i < numberStr.length() / 3; i++){
                int degree = numberStr.length() / 3 - i - 1;
                if(degree == 1)
                      nameNumber += convertDischarge(numberStr.substring(i * 3, i * 3 + 3), FEMALE_GENDER) +
                              getFormNameDegree(degree, numberStr.substring(i * 3, i * 3 + 3));
                      else
                          nameNumber += convertDischarge(numberStr.substring(i * 3, i * 3 + 3), MALE_GENDER) +
                                  getFormNameDegree(degree, numberStr.substring(i * 3, i * 3 + 3));

            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return nameNumber.trim();
    }

    private Map<Integer, String> initNameFromFile (String path) throws IOException{

        Map<Integer, String> receiver= new HashMap<>();
        String tmpLineStr;
        String Units[];

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), "UTF8"));

            while ((tmpLineStr = br.readLine()) != null) {
                if (!tmpLineStr.equals("")) {
                    Units = tmpLineStr.split(SPACE);
                    receiver.put(Integer.valueOf(Units[0]), Units[1]);
                }
            }

        return receiver;
    }

    private String convertDischarge(String discharge, int gender) {

        int hundreds = Character.getNumericValue(discharge.charAt(0));
        int dozens = Character.getNumericValue(discharge.charAt(1));
        int units = Character.getNumericValue(discharge.charAt(2));

        if (discharge.equals("000")) return "";
        String words = "";

        if (hundreds != 0)
            words += nameDischarges.get(hundreds * 100) + SPACE;

        if (dozens == 1 && units <= 9 && units >= 0)
            words += nameDischarges.get(dozens * 10 + units) + SPACE;
        else {
            if (dozens != 0)
                words += nameDischarges.get(dozens * 10) + SPACE;

            if (units != 0 && units > 2)
                words += nameDischarges.get(units) + SPACE;
            else if (units != 0 && units <= 2)
                words += nameDischarges.get(units * gender) + SPACE;
        }
        return words;
    }

    private String getFormNameDegree(int degree, String number) {

        if (nameDegrees.get(degree) == null && degree != 0)
            throw new NullPointerException("degree limit exceeded " + degree);

        if (number.equals("000")) return "";

        if (degree == 1) return nameDegrees.get(degree) +
                endings[0][selectForm(Integer.parseInt(number))] + SPACE;
        if (degree > 1) return nameDegrees.get(degree) +
                endings[1][selectForm(Integer.parseInt(number))] + SPACE;
        else
            return "";
    }


    private int selectForm(int n) {

        n = Math.abs(n) % 100;
        int n1 = n % 10;
        if (n > 10 && n < 20) return 2;
        if (n1 > 1 && n1 < 5) return 1;
        if (n1 == 1) return 0;
        return 2;
    }
}
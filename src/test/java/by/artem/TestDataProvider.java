package by.artem;

import com.google.common.collect.Lists;
import com.tngtech.java.junit.dataprovider.DataProvider;

import java.util.Arrays;
import java.util.List;

public class TestDataProvider {

    public static Object[][] dP1(){
        return new Object[][]{{"ноль",0}, {"один",1}, {"два",2}, {"три",3}, {"четыре",4},{"пять",5}, {"шесть",6},
                {"семь",7}, {"восемь",8}, {"девять",9}, {"десять",10}, {"одиннадцать",11}, {"двенадцать",12}, {"тринадцать",13},
                {"четырнадцать",14}, {"пятнадцать",15}, {"шестнадцать",16}, {"семнадцать",17}, {"восемнадцать",18}, {"девятнадцать",19}};
    }

    public static Object[][] dP2(){
        return new Object[][]{{"сорок", 40}, {"семьдесят один", 71}, {"сто", 100}, {"двести два", 202},
                {"пятьсот пятьдесят пять", 555}, {"триста десять", 310}, {"девятьсот девяносто девять", 999}};
    }

    public static Object[][] dP3(){
        return new Object[][]{{"два миллиарда сто сорок семь миллионов четыреста восемьдесят три тысячи шестьсот сорок семь", Integer.MAX_VALUE},
                {"минус один миллион одиннадцать", -1000011},
                {"сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять", 123456789}};
    }

    public static Object[][] dP4(){
        return new Object[][]{{"две тысячи",2000}, {"одна тысяча", 1000}, {"один миллион", 1000000}, {"два миллиона", 2000000}};
    }

    @DataProvider
    public static Object[][] combo(){
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(dP1()));
        result.addAll(Arrays.asList(dP2()));
        result.addAll(Arrays.asList(dP3()));
        result.addAll(Arrays.asList(dP4()));
        return result.toArray(new Object[result.size()][]);
    }

}

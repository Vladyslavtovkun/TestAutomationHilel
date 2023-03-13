package com.hillel.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {

    @DataProvider()
    public static Object [][] data () {
        return new Object[][]{
                {"John", "john@mail.com", "12345", "tg", "PHP"},
                {"Alice", "alice@mail.com", "12346", "vb", "React"},
                {"Tom", "tom@mail.com", "12347", "tg", "Python"}
        };
    }

}

package com.solvd.carina.demo.my_data_providers;

import org.testng.annotations.DataProvider;

public class LoginDP {
    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][] {
                { "", "", "Заповніть це поле.", "Заповніть це поле." },
                { "incorrectEmail@gmailcom", "", "", "Заповніть це поле." },
                { "", "qwe", "Заповніть це поле.", "Виберіть потрібний формат." },
                { "incorrectEmail@", "qwe", "Введіть частину електронної адреси після знака \"@\". " +
                        "Електронна адреса \"incorrectEmail@\" неповна.", "Виберіть потрібний формат." },
                { "correctEmailgmail.com", "C0r3ktP4SS", "Електронна адреса має містити знак \"@\". " +
                        "В електронній адресі \"correctEmailgmail.com\" знака \"@\" немає.", "" },
                { "correctEmail@gmail.com", "qwe", "", "Виберіть потрібний формат." },
                { "@gmail.com", "C0r3ktP4SS", "Введіть частину електронної адреси до знака \"@\". " +
                        "Електронна адреса \"@gmail.com\" неповна.", "" },
        };
    }
}

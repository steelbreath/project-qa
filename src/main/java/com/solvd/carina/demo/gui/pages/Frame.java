package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Frame extends AbstractPage {

    public Frame(WebDriver driver) {
        super((WebDriver) driver.switchTo());
    }
}

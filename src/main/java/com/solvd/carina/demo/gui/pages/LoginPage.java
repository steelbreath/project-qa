package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'res-success')]//h3[contains (text(), 'Login successful.')]")
    private ExtendedWebElement loginSuccessfulTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginSuccessfulTitlePresent() {
        return loginSuccessfulTitle.isPresent();
    }
}

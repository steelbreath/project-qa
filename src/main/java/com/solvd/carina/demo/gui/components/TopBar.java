package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBar extends AbstractUIObject {
    @FindBy(xpath = "//a[@href='register.php3']")
    private ExtendedWebElement signUpLink;

    @FindBy(xpath = "//a[@id='login-active']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//button[@aria-label='Toggle Navigation']")
    private ExtendedWebElement hamburgerMenuButton;

    public TopBar(WebDriver driver) {
        super(driver);
    }

    public TopBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignUpPage openSignUpPage(){
        signUpLink.click();
        return new SignUpPage(driver);
    }

    public LogInWindow clickLogIn(){
        logInButton.click();
        return new LogInWindow(driver);
    }

    public HeaderMenu clickHamburgerMenuButton(){
        hamburgerMenuButton.click();
        return new HeaderMenu(driver);
    }
}

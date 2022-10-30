package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogInWindow extends AbstractUIObject {
    @FindBy(xpath = "//form[@action='login.php3']/p")
    private ExtendedWebElement titleLogin;
    @FindBy(xpath = "//input[@id='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id='upass']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@id='nick-submit']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//a[@href='forgot.php3']")
    private ExtendedWebElement forgotPasswordButton;

    public LogInWindow(WebDriver driver) {
        super(driver);
    }

    public LogInWindow(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeEmailField(String email){
       emailField.type(email);
    }

    public void typePasswordField(String password){
        passwordField.type(password);
    }

    public void clickLogInButton(){
        logInButton.click();
    }

    public boolean isTitleLoginPresent(){
        return titleLogin.isElementWithTextPresent("Login");
    }

    public boolean isEmailFieldPresent(){
        return emailField.isElementPresent();
    }

    public boolean isPasswordFieldPresent(){
        return emailField.isElementPresent();
    }

    public boolean isLogInButtonPresentAndClickable(){
        return logInButton.clickIfPresent();
    }

    public boolean isForgotPasswordButtonPresentAndClickable(){
        return forgotPasswordButton.clickIfPresent();
    }

    public void hoverOverLogInButton(){
        logInButton.hover();
        pause(1);
    }
    public Color getLogInButtonColor(){
        return Color.fromString(logInButton.getElement().getCssValue("background-color"));
    }
}


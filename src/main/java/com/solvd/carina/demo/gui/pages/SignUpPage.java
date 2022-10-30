package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SignUpPage extends AbstractPage {
    @FindBy(id = "uname")
    private ExtendedWebElement nicknameField;

    @FindBy(xpath = "(//input[@id='email'])[2]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//input[@id='upass'])[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement firstCheckbox;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement secondCheckbox;

    @FindBy(xpath = "(//input[@id='nick-submit'])[2]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//h3[contains(.,'Your account was created.')]")
    private ExtendedWebElement accountCreatedText;
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstCheckbox(){
        firstCheckbox.click();
    }

    public void clickSecondCheckbox(){
        secondCheckbox.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void typeNicknameField(String nickname){
        nicknameField.type(nickname);
    }

    public void typeEmailField(String email){
        emailField.type(email);
    }

    public void typePasswordField(String password){
        passwordField.type(password);
    }

    public boolean isAccountCreatedText(){
        return accountCreatedText.isElementPresent();
    }
}

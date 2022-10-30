package com.solvd.carina.demo.my_test_cases;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.gui.components.LogInWindow;
import com.solvd.carina.demo.gui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogInTestCases implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(LogInTestCases.class);
    @Test(description = "Try login to not existing account")
    @MethodOwner(owner = "Pustovit Yevgeniy")
    @TestPriority(Priority.P4)
    public void testLogIn(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();

        LogInWindow logInWindow = homePage.getTopBar().clickLogIn();
        Assert.assertTrue(logInWindow.isTitleLoginPresent());

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/user.properties"));
            logInWindow.typeEmailField(properties.getProperty("user.email"));
            logInWindow.typePasswordField(properties.getProperty("user.password"));
        }catch (IOException e){
            e.getMessage();
        }
        logInWindow.clickLogInButton();

        Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
    }

    @Test(description = "Test login window")
    @MethodOwner(owner = "Pustovit Yevgeniy")
    @TestPriority(Priority.P3)
    public void testLogInWindow(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();

        LogInWindow logInWindow = homePage.getTopBar().clickLogIn();
        Assert.assertTrue(logInWindow.isTitleLoginPresent());

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/user.properties"));
            Assert.assertTrue(logInWindow.isEmailFieldPresent());
            logInWindow.typeEmailField(properties.getProperty("user.email"));
            logInWindow.typeEmailField("");
            Assert.assertTrue(logInWindow.isPasswordFieldPresent());
            logInWindow.typePasswordField(properties.getProperty("user.password"));
            logInWindow.typePasswordField("");
        }catch (IOException e){
            e.getMessage();
        }
        Assert.assertTrue(logInWindow.isLogInButtonPresentAndClickable());
        logInWindow.hoverOverLogInButton();
        Color color = Color.fromString(logInWindow.getLogInButtonColor().asHex());
        LOGGER.info(color.asHex());
        Assert.assertEquals(logInWindow.getLogInButtonColor().asHex(), "#d50000");
        Assert.assertTrue(logInWindow.isForgotPasswordButtonPresentAndClickable());
        Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
    }

}
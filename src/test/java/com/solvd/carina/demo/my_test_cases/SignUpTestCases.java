package com.solvd.carina.demo.my_test_cases;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.gui.components.TopBar;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SignUpTestCases implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(SignUpTestCases.class);
    @Test(description = "Create an account")
    @MethodOwner(owner = "Pustovit Yevgeniy")
    @TestPriority(Priority.P5)
    public void testSignUp(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();

        TopBar topBar = homePage.getTopBar();
        SignUpPage signUpPage = topBar.openSignUpPage();

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/user.properties"));
            signUpPage.typeNicknameField(properties.getProperty("user.nickname"));
            signUpPage.typeEmailField(properties.getProperty("user.email"));
            signUpPage.typePasswordField(properties.getProperty("user.password"));
        }catch (IOException e){
            e.getMessage();
        }
        signUpPage.clickFirstCheckbox();
        signUpPage.clickSecondCheckbox();
        signUpPage.clickSubmitButton();

        Assert.assertTrue(signUpPage.isAccountCreatedText());
    }
}

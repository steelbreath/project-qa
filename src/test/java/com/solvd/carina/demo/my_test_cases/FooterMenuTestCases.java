package com.solvd.carina.demo.my_test_cases;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.enums.FooterMenuButtonLink;
import com.solvd.carina.demo.gui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class FooterMenuTestCases implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(FooterMenuTestCases.class);

    @Test(description = "Test footer menu")
    @MethodOwner(owner = "Pustovit Yevgeniy")
    @TestPriority(Priority.P1)
    public void testFooterMenu(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();

        homePage.scrollToFooterMenu();
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isHomeButtonPresentAndClickable());
        for(FooterMenuButtonLink footerMenuButtonLink:FooterMenuButtonLink.values()){
            homePage.scrollToFooterMenu();
            Assert.assertTrue(footerMenu.isFooterMenuButtonPresent(footerMenuButtonLink));
            footerMenu.clickFooterMenuButton(footerMenuButtonLink);
            if(homePage.isUrlAsExpected("https://www.gsmarena.com/")){
                String currentTab = getDriver().getWindowHandle();
                switchToNewTab(currentTab);
                Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
                switchToPreviousTab(currentTab);
            } else{
                Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
                footerMenu.navigateBack();
            }
        }
    }
    private void switchToNewTab(String oldTab) {
        Set<String> tabs = getDriver().getWindowHandles();

        String newTab = tabs.stream()
                .filter(tab -> !tab.equals(oldTab))
                .findFirst()
                .get();

        getDriver().switchTo().window(newTab);
    }

    private void switchToPreviousTab(String currentTab) {
        currentTab = getDriver().getWindowHandle();
        getDriver().close();
        switchToNewTab(currentTab);
    }
}

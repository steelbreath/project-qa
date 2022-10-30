package com.solvd.carina.demo.my_test_cases;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.carina.demo.gui.components.HeaderMenu;
import com.solvd.carina.demo.gui.enums.HeaderMenuButtonLink;
import com.solvd.carina.demo.gui.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HeaderMenuTestCases implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(HeaderMenuTestCases.class);

    @Test(description = "Test header menu")
    @MethodOwner(owner = "Pustovit Yevgeniy")
    @TestPriority(Priority.P2)
    public void testHeaderMenu(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        homePage.getWeValuePrivacyAd().closeAdIfPresent();

        HeaderMenu headerMenu = homePage.getTopBar().clickHamburgerMenuButton();
        Assert.assertTrue(headerMenu.isHomeButtonPresentAndClickable());
        for(HeaderMenuButtonLink headerMenuButtonLink:HeaderMenuButtonLink.values()){
            Assert.assertTrue(headerMenu.isHeaderMenuButtonPresent(headerMenuButtonLink));
            headerMenu.clickHeaderMenuButton(headerMenuButtonLink);
            if(homePage.isUrlAsExpected("https://www.gsmarena.com/")){
                String currentTab = getDriver().getWindowHandle();
                switchToNewTab(currentTab);
                Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
                switchToPreviousTab(currentTab);
            } else{
                Assert.assertFalse(homePage.isUrlAsExpected("https://www.gsmarena.com/"));
                headerMenu.navigateBack();
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

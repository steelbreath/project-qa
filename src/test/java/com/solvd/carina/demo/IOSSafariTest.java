package com.solvd.carina.demo;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.solvd.carina.demo.mobile.gui.pages.ios.SaucePage;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {
    @Test
    public void safariTest() {
        SaucePage saucePage = new SaucePage(getDriver());
        saucePage.openURL("http://saucelabs.com/test/guinea-pig");
        saucePage.verifyElementText();
        saucePage.sendComment();
    }

}
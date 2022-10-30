package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.enums.HeaderMenuButtonLink;
import com.solvd.carina.demo.gui.pages.Frame;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {
    @FindBy(xpath = "//li/a[contains(.,'Home')]")
    private ExtendedWebElement homeButton;
    @FindBy(xpath = "//li/a[contains(.,'%s')]")
    private ExtendedWebElement headerMenuButton;
    @FindBy(xpath = ".//iframe")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//li/a[contains(.,'Merch')]")
    private ExtendedWebElement merchButton;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isHeaderMenuButtonPresent(HeaderMenuButtonLink headerMenuButtonLink){
        return headerMenuButton.format(headerMenuButtonLink.getValue()).isElementPresent();
    }

    public void clickHeaderMenuButton(HeaderMenuButtonLink headerMenuButtonLink) {
        headerMenuButton.format(headerMenuButtonLink.getValue()).click();
    }

    public boolean isHomeButtonPresentAndClickable(){
        return homeButton.clickIfPresent();
    }

    public Frame openFrame(){
        merchButton.click();
        Frame frame = new Frame(driver);
        driver.switchTo().frame(iframe.getElement());
        return frame;
    }
}

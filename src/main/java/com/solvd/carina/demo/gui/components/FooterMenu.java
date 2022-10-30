package com.solvd.carina.demo.gui.components;

import com.solvd.carina.demo.gui.enums.FooterMenuButtonLink;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.CompareModelsPage;
import com.solvd.carina.demo.gui.pages.NewsPage;

public class FooterMenu extends AbstractUIObject {
    @FindBy(xpath = "//div[@id='footer']/div[@id='footmenu']/p/a[contains(.,'Home')]")
    private ExtendedWebElement homeButton;
    @FindBy(xpath = "//div[@id='footer']/div[@id='footmenu']/p/a[contains(.,'%s')]")
    private ExtendedWebElement footerMenuButton;
    @FindBy(xpath = "(//a[@href='news.php3'][contains(.,'News')])[3]")
    private ExtendedWebElement newsLink;
    @FindBy(xpath = "(//a[@href='compare.php3'][contains(.,'Compare')])[2]")
    private ExtendedWebElement compareLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isFooterMenuButtonPresent(FooterMenuButtonLink footerMenuButtonLink){
        return footerMenuButton.format(footerMenuButtonLink.getValue()).isElementPresent();
    }

    public void clickFooterMenuButton(FooterMenuButtonLink footerMenuButtonLink) {
        footerMenuButton.format(footerMenuButtonLink.getValue()).click();
    }

    public boolean isHomeButtonPresentAndClickable(){
        return homeButton.clickIfPresent();
    }

    public ExtendedWebElement getFooterMenuButton(){
        return footerMenuButton;
    }
    public CompareModelsPage openComparePage() {
        compareLink.click();
        return new CompareModelsPage(driver);
    }

    public NewsPage openNewsPage() {
        newsLink.click();
        return new NewsPage(driver);
    }
}

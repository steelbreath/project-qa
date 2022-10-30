package com.solvd.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.carina.demo.gui.components.TopBar;
import com.solvd.carina.demo.gui.enums.FooterMenuButtonLink;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.components.WeValuePrivacyAd;

import static com.solvd.carina.demo.gui.enums.FooterMenuButtonLink.TERMS_OF_USE;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(id = "social-connect")
    private TopBar topBar;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }
    
    public WeValuePrivacyAd getWeValuePrivacyAd() {
    	return new WeValuePrivacyAd(driver);
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public void scrollToFooterMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while(footerMenu.getFooterMenuButton().format(TERMS_OF_USE.getValue()).getText().length() == 0) {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            pause(0.2);
        }
    }
}

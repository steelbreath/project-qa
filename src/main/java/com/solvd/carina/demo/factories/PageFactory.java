package com.solvd.carina.demo.factories;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.gui.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageFactory extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(PageFactory.class);

    public PageFactory(WebDriver driver) {
        super(driver);
    }

    public AbstractPage getPage(String pageType){
        switch (pageType){
            case "BrandModelsPage":
                return new BrandModelsPage(driver);
            case "CompareModelsPage":
                return new CompareModelsPage(driver);
            case "HomePage":
                return new HomePage(driver);
            case "LoginPage":
                return new LoginPage(driver);
            case "ModelsInfoPage":
                return new ModelInfoPage(driver);
            case "NewsPage":
                return new NewsPage(driver);
            case "SignUpPage":
                return new SignUpPage(driver);
            default:
                return null;
        }
    }
}

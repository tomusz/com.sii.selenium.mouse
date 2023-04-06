package com.sii.pages;

import com.sii.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id='top-menu']/li[1]//a")
    private WebElement clothesNavigationBtn;

    @FindBy(xpath = "//ul[@id='top-menu']/li[2]//a")
    private WebElement accessoriesNavigationBtn;

    @FindBy(xpath = "//ul[@id='top-menu']/li[3]//a")
    private WebElement artNavigationBtn;

    @FindBy(xpath = "(//ul[@class='top-menu'])[2]//li[1]")
    private WebElement clothesSubcategory;

    @FindBy(xpath = "(//ul[@class='top-menu'])[3]//li[1]")
    private WebElement accessoriesSubcategory;



    public TopMenuPage clickOnWomanCategory() {
        clickOnButton(clothesNavigationBtn);
        return this;
    }

    public TopMenuPage clickOnAccessoriesCategory() {
        clickOnButton(accessoriesNavigationBtn);
        return this;
    }

    public TopMenuPage clickOnArtCategory() {
        clickOnButton(artNavigationBtn);
        return this;
    }

    public TopMenuPage moveMoseToClothesCategory() {
        mouseHover(clothesNavigationBtn);
        return this;
    }

    public TopMenuPage moveMoseToAccessoriesCategory() {
        mouseHover(accessoriesNavigationBtn);
        return this;
    }

    public TopMenuPage moveMoseToArtCategory() {
        mouseHover(artNavigationBtn);
        return this;
    }

    public TopMenuPage waitForClothesSubcategory() {
        waitForElementToBeVisible(clothesSubcategory);
        return this;
    }

    public TopMenuPage waitForAccessoriesSubcategory() {
        waitForElementToBeVisible(accessoriesSubcategory);
        return this;
    }
}
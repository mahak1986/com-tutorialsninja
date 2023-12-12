package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    WebElement topMenuBar;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Currency']")
    WebElement mouseHoverOnCurrencyDropDownAndClick;

    @CacheLookup
    @FindBy(xpath = "//button[text()='£Pound Sterling']")
    WebElement mouseHoverOnPoundSterlingAndClick;


    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Show AllDesktops']")
    WebElement clickOnShowAllDesktops;


    @CacheLookup
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    WebElement myAccountOptions;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;


    public void selectMenuBar(String menu) {
        List<WebElement> topMenuList = driver.findElements((By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")));
        }
    }


    public void mouseHoverOnCurrencyDropDownAndClick() {
        mouseHoverToElementAndClick(mouseHoverOnCurrencyDropDownAndClick);
    }

    public void mouseHoverOnPoundSterlingAndClick() {
        mouseHoverToElementAndClick(mouseHoverOnPoundSterlingAndClick);
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
    }
    public void clickOnShowAllDesktops(){
        clickOnElement(clickOnShowAllDesktops);
    }

    public void clickOnMyQAccountTab() {
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }
}


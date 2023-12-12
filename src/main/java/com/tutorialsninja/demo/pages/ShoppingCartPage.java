package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

@Listeners(CustomListeners.class)
public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    //Change quantity to 2
    @CacheLookup
    @FindBy(css = "input[value='1']")
    WebElement quantityOption;

    @CacheLookup
    @FindBy(xpath = "//tr[1]//button[@data-original-title = 'Update']")
    WebElement updateMacBookCart;


    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    WebElement clickOnCheckOutButton;
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement verifyCheckOutText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement VerifyNewCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement clickOnGuestCheckoutRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement clickOnContinueTabOnCheckOutPage;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstNameOption;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lasttNameOption;


    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailOption;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement phoneNumberOption;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement enterAddress;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement enterCity;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement enterPostcode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement clickOnCountry;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement enterCountry;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement inputState;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement enterRegion;

    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement clickOnContinueTabOnCheckOutPage1;

    @CacheLookup
    @FindBy(xpath = "//textarea[@class = 'form-control']")
    WebElement addCommentsOnCheckOutPage;

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement clickOnTermsAndConditions;

    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement clickOnContinueButtonPostCommentButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement verifyPaymentMethodRequiredText;

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        return getTextFromElement(model);
    }

    public String getTotal() {
        return getTextFromElement(total);
    }

    public void updateQuantityOption() {
        clickOnElement(quantityOption);
        sendTextToElement(quantityOption, Keys.CONTROL + "a");
        sendTextToElement(quantityOption, "2");
    }

    public void clickOnUpdateMacBookCart() {
        clickOnElement(updateMacBookCart);
    }

    public String getSuccessModifiedMessage() {
        return getTextFromElement(successModifiedMessage);
    }
    public void clickOnCheckOutButton(){
        clickOnElement(clickOnCheckOutButton);
    }
    public String verifyCheckOutText(){
        return getTextFromElement(verifyCheckOutText);

    }
    public String VerifyNewCustomerText() {
        return getTextFromElement(VerifyNewCustomerText);
    }
    public void clickOnGuestCheckoutRadioButton(){
        clickOnElement(clickOnGuestCheckoutRadioButton);
    }
    public void clickOnContinueTabOnCheckOutPage() {
        clickOnElement(clickOnContinueTabOnCheckOutPage);
    }
    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameOption, firstName);
    }
    public void enterlastName(String lastName) {
        sendTextToElement(lasttNameOption, lastName);
    }

    public void enterEmail(String email) {
        sendTextToElement(emailOption, email);
    }

    public void enterPhoneNumber(String phoneNumber) {
        sendTextToElement(phoneNumberOption, phoneNumber);
    }

    public void enterAddress(String address) {
        sendTextToElement(enterAddress, address);
    }
    public void enterCity(String city) {
        sendTextToElement(enterCity, city);
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(enterPostcode, postcode);
    }
    public void clickOnCountry(){
        clickOnElement(clickOnCountry);
    }
    public void enterCountry(String value) {
        selectByVisibleTextFromDropDown(enterCountry, value);//value is 222
    }
    public void inputState() {
        clickOnElement(inputState);
    }
    public void enterRegion(String name) {
        selectByVisibleTextFromDropDown(enterRegion, name);
    }
    public void clickOnContinueTabOnCheckOutPage1(){
        clickOnElement(clickOnContinueTabOnCheckOutPage1);
    }
    public void addCommentsOnCheckOutPage(String comment) {
        sendTextToElement(addCommentsOnCheckOutPage, comment);
    }
    public void clickOnTermsAndConditions(){
        clickOnElement(clickOnTermsAndConditions);
    }
    public void clickOnContinueButtonPostCommentButton(){
        clickOnElement(clickOnContinueButtonPostCommentButton);
    }
    public String verifyPaymentMethodRequiredText() {
        return getTextFromElement(verifyPaymentMethodRequiredText);
    }
}



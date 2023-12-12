package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage cartPage;
    LaptopsAndNoteBooksPage laptopsAndNotebooksPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
    }
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"sanity" , "smoke","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        homePage.mouseHoverOnCurrencyDropDownAndClick();
        homePage.mouseHoverOnPoundSterlingAndClick();
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenuBar("Show All Laptops & Notebooks");
        // Get all the products price and stored into array list
        List<Double> originalProductsPrice = laptopsAndNotebooksPage.getProductsPriceList();
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        // Select sort by Price (High > Low)
        laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        ArrayList<Double> afterSortByPrice = laptopsAndNotebooksPage.getProductsPriceList();
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on currency drop down and click
        homePage.mouseHoverOnCurrencyDropDownAndClick();

        //mouse hover on pound sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();

        //mouse hover on Laptops And Notebooks Link And Click
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();

        //Click on show all laptops and notebooks
        laptopsAndNotebooksPage.clickOnShowAllLaptopsAndNotebooks();

        //Sort by Price (High > Low) option
        laptopsAndNotebooksPage.selectSortByOption("Price (High > Low)");

        //Select product name Macbook
        laptopsAndNotebooksPage.selectProductByName("MacBook");

        //verify Macbook text
        Assert.assertEquals(productPage.getProductText(), "MacBook", "MacBook Product not display");

        //click on add to cart button
        productPage.clickOnAddToCartButton();

        //verify Success: You have added MacBook to your shopping cart!
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added MacBook to your shopping cart!"),
                "Product not added to cart");

        //click on shopping cart link
        productPage.clickOnShoppingCartLinkIntoMessage();

        //verify shopping cart text
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));

        //verify Macbook text
        Assert.assertEquals(cartPage.getProductName(), "MacBook", "Product name not matched");

        //Update quantity
        cartPage.updateQuantityOption();

        //click on update macbook cart to 2
        cartPage.clickOnUpdateMacBookCart();

        //Verify "Success: You have modified your shopping cart!"
        Assert.assertTrue(cartPage.getSuccessModifiedMessage().contains("Success: You have modified your shopping cart!"));

        //Verify cart total £737.45 text
        Assert.assertEquals(cartPage.getTotal(), "£737.45", "Total not matched");

        //click on checkout button
        cartPage.clickOnCheckOutButton();

        //verify checkout text
        String expected5 = "Checkout";
        Assert.assertEquals(cartPage.verifyCheckOutText(), expected5, "Error Message");
        Thread.sleep(2000);

        //verify New Customer text
        String expected6 = "New Customer";
        Assert.assertEquals(cartPage.VerifyNewCustomerText(), expected6, "Error Message");
        Thread.sleep(2000);

        //click on guest checkout radio button
        cartPage.clickOnGuestCheckoutRadioButton();

        //click on continue check out page
        cartPage.clickOnContinueTabOnCheckOutPage();

        //Enter first name
        cartPage.enterFirstName("Mahak");

        //enter last name
        cartPage.enterlastName("Agarwal");

        //enter email
        cartPage.enterEmail("mahak123@gmail.com");

        //enter phone number
        cartPage.enterPhoneNumber("07945889876");

        //enter address
        cartPage.enterAddress("123 Wayfair Street");

        //Enter city
        cartPage.enterCity("Tokyo");

        //enter postcode
        cartPage.enterPostcode("WX1 2SX");
        Thread.sleep(2000);

        //input state
        cartPage.inputState();

        //input region
        cartPage.enterRegion("Aberdeen");

        //click On Continue Tab On CheckOut Page
        cartPage.clickOnContinueTabOnCheckOutPage1();

        //Add comment on check out page
        cartPage.addCommentsOnCheckOutPage("Successful");

        //click on terms and conditions
        cartPage.clickOnTermsAndConditions();

        //clic on continue button post comment button
        cartPage.clickOnContinueButtonPostCommentButton();
        Thread.sleep(2000);

        //Verify "Warning: Payment method required! ×"
        String expected7 = "Warning: Payment method required!\n×";
        Assert.assertEquals(cartPage.verifyPaymentMethodRequiredText(), expected7, "Error Message");
    }
}


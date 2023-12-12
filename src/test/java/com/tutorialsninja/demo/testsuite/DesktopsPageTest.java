package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

@Listeners(CustomListeners.class)
public class DesktopsPageTest extends BaseTest {
    DesktopsPage deskTopsPage;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage cartPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        deskTopsPage = new DesktopsPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new ShoppingCartPage();

    }

    @Test (groups = {"sanity" ,"smoke", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {
        //Mouse hover on desktops link and click
        deskTopsPage.mouseHoverOnDesktopsAndClick();

        //click on show all desktops
        deskTopsPage.clickOnShowAllDeskTops();

        //sort desktops from Z to A
        deskTopsPage.sortingDesktopsFromZtoA(("Name (Z - A)"));
        ArrayList<String> originalProductsName = deskTopsPage.getProductsNameList();
        Collections.reverse(originalProductsName);
        ArrayList<String> afterSortByZToAProductsName = deskTopsPage.getProductsNameList();
    }

    @Test(groups = {"smoke" , "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //mouse hover on currency drop down and click
        homePage.mouseHoverOnCurrencyDropDownAndClick();

        //mouse hover on pound sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();

        //mouse hover on desktops link and click
        homePage.mouseHoverOnDesktopsLinkAndClick();

        //click on show all desktops
        homePage.clickOnShowAllDesktops();

        //sort Z to A
        deskTopsPage.sortingDesktopsFromZtoA("Name (A - Z)");

        //Select product HP LP3065 and verify
        deskTopsPage.selectProductByName("HP LP3065");
        Assert.assertEquals(productPage.getProductText(), "HP LP3065", "HP LP3065 Product not display");

        //select delivery date
        productPage.selectDeliveryDate("30", "November", "2025");

        //enter quantity 1
        productPage.enterQuantity("1");

        //click on add to cart button
        productPage.clickOnAddToCartButton();

        //Verify Success text
        Assert.assertTrue(productPage.getProductAddedSuccessMessage().contains("Success: You have added HP LP3065 to your shopping cart!"),
                "Product not added to cart");

        //click on shopping cart link into message
        productPage.clickOnShoppingCartLinkIntoMessage();

        //Get shopping cart text
        Assert.assertTrue(cartPage.getShoppingCartText().contains("Shopping Cart"));

        //Get Product text HP LP3065
        Assert.assertEquals(cartPage.getProductName(), "HP LP3065", "Product name not matched");

        //Verify delivery date
        Assert.assertTrue(cartPage.getDeliveryDate().contains("2025-11-30"), "Delivery date not matched");

        //verify product 21
        Assert.assertEquals(cartPage.getModel(), "Product 21", "Model not matched");

       //verify product total value = £
        Assert.assertEquals(cartPage.getTotal(), "£74.73", "Total not matched");
    }
}



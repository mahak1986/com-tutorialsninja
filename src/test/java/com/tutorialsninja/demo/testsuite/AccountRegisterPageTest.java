package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.AccountRegisterPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class AccountRegisterPageTest extends BaseTest {
    HomePage homePage;
    AccountRegisterPage accountRegisterPage;
    MyAccountPage accountPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //click on my account tab
        homePage.clickOnMyQAccountTab();

        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

        //verify Register Account text
        Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                "Register Account", "Register page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldRegisterAccountSuccessfully() throws InterruptedException {
        //mouse hover on currency drop down and click
        homePage.mouseHoverOnCurrencyDropDownAndClick();

        //mouse hover on pound sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();

        //click on my account tab
        homePage.clickOnMyQAccountTab();

        //Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

        //enter first name
        accountRegisterPage.enterFirstName("Mahak");

        //Enter last name
        accountRegisterPage.enterLastName("Agarwal");

        //Enter email
        accountRegisterPage.enterEmailAddress();

        //enter telephone number
        accountRegisterPage.enterTelephone("07988112233");

        //enter password
        accountRegisterPage.enterPassword("test123");

        //enter confirm password
        accountRegisterPage.enterConfirmPassword("test123");

        //click on subscribe yes button
        accountRegisterPage.subscribeYesRadioButton();

        //click on privacy policy checkbox
        accountRegisterPage.clickOnPrivacyPolicyCheckBox();

        //click on continue button
        accountRegisterPage.clickOnContinueButton();

        //verify "Your Account Has Been Created!" text
        Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                "Account not created");

        //click on continue button
        accountPage.clickOnContinueButton();

        Thread.sleep(2000);

        //click on my account tab
        homePage.clickOnMyQAccountTab();

        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");

        //Verify "Account Logout" text
        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
        accountPage.clickOnContinueButton();

    }
}



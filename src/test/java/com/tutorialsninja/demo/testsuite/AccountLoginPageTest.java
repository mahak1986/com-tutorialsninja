package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.AccountLoginPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class AccountLoginPageTest extends BaseTest {
    HomePage homePage;
    AccountLoginPage accountLoginPage;
    MyAccountPage accountPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountLoginPage = new AccountLoginPage();
        accountPage = new MyAccountPage();
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;
            }
        }
    }

    @Test(groups = {"sanity" ,"smoke" ,"regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //click on my account tab
        homePage.clickOnMyQAccountTab();

        //select my options method and pass parameter Login
        homePage.selectMyAccountOptions("Login");

        //Verify returning customer text
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test (groups = {"smoke","regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //Click on My Account Link
        homePage.clickOnMyQAccountTab();

        //Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");

        //Enter Email address
        accountLoginPage.enterEmailAddress("mahak123@gmail.com");

        //Enter Password
        accountLoginPage.enterPassword("mahak123");

        //Click on Login button
        accountLoginPage.clickOnLoginButton();

        //click on my account tab
        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //Verify the text “Account Logout”
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");

    }

}


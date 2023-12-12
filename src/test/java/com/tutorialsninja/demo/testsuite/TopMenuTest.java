package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopsPage deskTops;
    LaptopsAndNoteBooksPage laptopsAndNoteBooks;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        deskTops = new DesktopsPage();
        laptopsAndNoteBooks = new LaptopsAndNoteBooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity" , "smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //mouse hover on desktops and click
        deskTops.mouseHoverOnDesktopsAndClick();

        //call method and pass Show All Desktops
        homePage.selectMenuBar("Show AllDesktops");

        //Mouse hover on Laptops And NoteBooks And Click
        laptopsAndNoteBooks.mouseHoverOnLaptopsAndNoteBooksAndClick();

        //click On Show All Laptops And Notebooks
        laptopsAndNoteBooks.clickOnShowAllLaptopsAndNotebooks();

        //Mouse Over on component and click
        componentsPage.mouseHoverOnComponentsAndClick();

        //click on show all components
        componentsPage.clickOnShowAllComponents();
    }
}


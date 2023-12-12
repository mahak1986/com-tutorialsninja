package com.tutorialsninja.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestClass {


    @Test
    public void extentTest() throws IOException {
        //Create the object of Extent Report
        ExtentReports reports = new ExtentReports();
        //Spark reporter object
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");//html file will be generated

        //Report theme,report title and Report name
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Tutorials Ninja");
        spark.config().setDocumentTitle("Automation");

        //Attach the spark to report
        reports.attachReporter(spark);

        //Add system Information
        reports.setSystemInfo("Os",System.getProperty("os.name"));
        reports.setSystemInfo("Java Version",System.getProperty("java.version"));
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("Browser Version","119.1.2");



        //Create the test
        ExtentTest test = reports.createTest("Login Test").assignAuthor("Mahak").assignCategory("Smoke");
        test.pass("Login Test start successfully");
        test.info("Url is loaded");
        test.info("Values entered");
        test.pass("Tests completed successfully");

        // how to highlight the test
        test.pass(MarkupHelper.createLabel("Tests completed successfully", ExtentColor.GREEN));

        ExtentTest test1 = reports.createTest("HomePage Test").assignAuthor("Aarav").assignCategory("Sanity");
        test1.pass("HomePage Test start successfully");
        test1.info("Url is loaded");
        test1.info("Values entered");
        test1.pass("Tests completed successfully");
        // how to highlight the test
        test1.fail(MarkupHelper.createLabel("HomePage test completed successfully",ExtentColor.PINK));

        reports.flush();//Unless you call this method report will not write any logs.
        Desktop.getDesktop().browse(new File("extent.html").toURI());//this will open the file in the default browser


    }
}

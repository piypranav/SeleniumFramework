package com.automation.tests;

import com.automation.commons.BaseClass;
import com.automation.commons.ExcelData;
import com.automation.pages.LoginPage;
import com.automation.utilities.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends BaseClass {
    LoginPage loginPage;
    ExcelData excelData;
    ExtentReporterNG htmlReporter;
    ExtentReports reports;
    ExtentTest testResults;
    WebDriverWait wait;

    public LoginPageTests(){
        super();
    }

    @BeforeMethod
    public void common() {
        setUp();
        loginPage = new LoginPage();
        excelData = new ExcelData();
        htmlReporter = new ExtentReporterNG();
        wait = new WebDriverWait(driver, 15);
    }

    @Test(enabled = true)
    public void userLoginTest() {
        reports = htmlReporter.setHtmlReport();
        testResults = reports.createTest("User login test",
                "User Login to the System");
        
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//form[contains(@name, 'register')]"))));
        Assert.assertTrue(loginPage.userLoginToSite(),
                "Not able to log-in to the Home Page");
    }

    @Test(enabled = false, dataProvider = "ExcelSheetData", dataProviderClass = ExcelData.class)
    public void getDataFromExcel(Object[] oExcelData) {
        for(Object data: oExcelData) {
            System.out.println("Data from excel sheet is: " + data.toString());
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            testResults.log(Status.FAIL, "Testcase " +
                    result.getTestName() + " Failed, as user was not able to login to system");
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            testResults.log(Status.PASS, "Testcase " +
                    result.getTestName() + " Passed, as user was able to login to system");
        } else {
            testResults.log(Status.SKIP, "Testcase " +
                    result.getTestName() + " Skipped, as user was able to login to system");
        }
    }
}

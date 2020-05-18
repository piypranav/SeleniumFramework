package com.automation.tests;

import com.automation.commons.BaseClass;
import com.automation.commons.ExcelData;
import com.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends BaseClass {
    LoginPage loginPage;
    ExcelData excelData;
    WebDriverWait wait;

    public LoginPageTests(){
        super();
    }

    @BeforeMethod
    public void common() {
        setUp();
        loginPage = new LoginPage();
        excelData = new ExcelData();
        wait = new WebDriverWait(driver, 15);
    }

    @Test(enabled = true)
    public void userLoginTest() {
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
}

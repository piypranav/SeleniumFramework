package com.automation.tests;

import com.automation.commons.BaseClass;
import com.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTests extends BaseClass {
    LoginPage loginPage;
    WebDriverWait wait;

    public LoginPageTests(){
        super();
    }
    @BeforeMethod
    public void common() {
        setUp();
        loginPage = new LoginPage();
        wait = new WebDriverWait(driver, 15);
    }

    @Test(alwaysRun = true)
    public void userLogin() {
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//form[contains(@name, 'register')]"))));
        Assert.assertTrue(loginPage.userLoginToSite(),
                "Not able to log-in to the Home Page");
    }
}

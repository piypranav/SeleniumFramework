package com.automation.tests;

import com.automation.commons.BaseClass;
import com.automation.pages.ContactPage;
import com.automation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactPageTests extends BaseClass {
    WebDriverWait wait;
    ContactPage contactPage;
    LoginPage loginPage;

    public ContactPageTests() {
            super();
    }

    @BeforeMethod
    public void common() {
        setUp();
        wait = new WebDriverWait(driver, 15);
        contactPage = new ContactPage();
        loginPage = new LoginPage();
    }

    @Test(enabled = true, dependsOnMethods = "loginHomePage")
    public void checkContactPageTest() {
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//form[contains(@name, 'register')]"))));
        Assert.assertTrue(loginPage.userLoginToSite(),
                "Not able to login to the application");
        Assert.assertTrue(contactPage.userContactPage(),
                "Contact page not accessible");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

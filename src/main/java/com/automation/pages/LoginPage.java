package com.automation.pages;

import com.automation.commons.BaseClass;
import com.automation.locators.LoginPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass{
    LoginPageLocator loginLocator;
    WebDriverWait wait;

    public LoginPage(){
        wait = new WebDriverWait(driver, 15);
        loginLocator = new LoginPageLocator();
        PageFactory.initElements(driver, loginLocator);
    }

    public boolean userLoginToSite(){
        loginLocator.userName().sendKeys(properties.getProperty("username"));
        loginLocator.passwd().sendKeys(properties.getProperty("password"));
        loginLocator.loginBtn().click();

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//form[contains(@name, 'findflight')]"))));
        if((loginLocator.homePage().equalsIgnoreCase("sign-off"))) {
            return true;
        } else {
            return false;
        }
    }
}

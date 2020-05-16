package com.automation.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class LoginPageLocator {
    //Page Factory object Repository
    @FindBy(how=How.XPATH, using ="//input[@name='userName']")
    WebElement username;

    @FindBy(xpath="//input[@name='password']")
    WebElement userpasswd;

    @FindBy(xpath="//input[@name='login']")
    WebElement clickLoginBtn;

    @FindBy(how=How.XPATH, using="//a[contains(text(), 'SIGN-OFF')]")
    WebElement userHomePage;

    public WebElement userName() {
        return username;
    }

    public WebElement passwd() {
        return userpasswd;
    }

    public WebElement loginBtn() {
        return clickLoginBtn;
    }

    public String homePage() {
        return userHomePage.getText();
    }

}

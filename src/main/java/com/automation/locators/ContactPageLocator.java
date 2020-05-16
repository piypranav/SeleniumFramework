package com.automation.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactPageLocator {

    @FindBy(how= How.XPATH, using= "//a[contains(text(), 'CONTACT')]")
    WebElement contactLink;

    @FindBy(xpath="//img[contains(@src, '/images/forms/home.gif')]")
    WebElement contactPage;

    @FindBy(how=How.XPATH, using="//b[contains(text(), 'sign-in here')]")
    WebElement validateHomePage;

    public void clickContactLink(){
        contactLink.click();
    }

    public void contactPage() {
        contactPage.click();
    }

    public boolean homePageFromContactPage() {
        if(validateHomePage.getText().equalsIgnoreCase("sign-in here")) {
            return true;
        } else {
            return false;
        }
    }
}

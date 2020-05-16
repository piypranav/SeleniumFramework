package com.automation.pages;

import com.automation.commons.BaseClass;
import com.automation.locators.ContactPageLocator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BaseClass {
    WebDriverWait wait;
    ContactPageLocator contactPage;

    public ContactPage() {
        wait = new WebDriverWait(driver, 15);
        contactPage = new ContactPageLocator();
        PageFactory.initElements(driver, contactPage);
    }

    public boolean userContactPage(){
        contactPage.clickContactLink();
        contactPage.contactPage();
        return contactPage.homePageFromContactPage();
    }

}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    private WebDriver driver;

//    1. By Locators:

    private By accountSections = By.cssSelector("#center_column span");

//    2. Constructor:

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

//    3. Page actions: features (Behavior) of the page the form of methods:

    public String getAccountPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountsSectionsList() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);
        for (WebElement s: accountsHeaderList){
            String textSection = s.getText();
            System.out.println(textSection);
            accountList.add(textSection);
        }
        return accountList;
    }
}

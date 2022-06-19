package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

//    1. By Locators:

    private By accountSections = By.cssSelector("#center_column span");

//    2. Constructor:

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    3. Page actions: features (Behavior) of the page the form of methods:

    public String getAccountPageTitle() {
        System.out.println(" =====> My account page title is: " +driver.getTitle()+ " <===== ");
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

//    Order History Page:

    private WebElement getOrderHistoryLink(){
        By orderHistoryLocator = By.cssSelector("[title^='Orders']");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLocator));
        return driver.findElement(orderHistoryLocator);
    }

    public OrderHistoryPage clickOnOrderHistory(){
        getOrderHistoryLink().click();
        return new OrderHistoryPage(driver);
    }



//    My Credit Slips:

    private WebElement getMyCreditSlipsLink(){
        By myCreditSlipsLocator = By.cssSelector("[title^='Credit slips']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myCreditSlipsLocator));
        return driver.findElement(myCreditSlipsLocator);
    }

    public MyCreditSlipsPage clickOnMyCreditSlips(){
        getMyCreditSlipsLink().click();
        return new MyCreditSlipsPage(driver);
    }

//    My Addresses:

    private WebElement getMyAddressesLink(){
        By addressesLocator = By.cssSelector("[title^='Addresses']");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressesLocator));
        return driver.findElement(addressesLocator);
    }

    public MyAddressesPage clickOnMyAddresses(){
        getMyAddressesLink().click();
        return new MyAddressesPage(driver);
    }

//    Identity:

    private WebElement getIdentityLink(){
        By identityLocator = By.cssSelector("[title^='Information']");
        wait.until(ExpectedConditions.presenceOfElementLocated(identityLocator));
        return driver.findElement(identityLocator);
    }

    public IdentityPage clickOnIdentity(){
        getIdentityLink().click();
        return new IdentityPage(driver);
    }

//    My Wishes:

    private WebElement getMyWishesLink(){
        By myWishesLocator = By.cssSelector("[title^='My wishlists']");
        wait.until(ExpectedConditions.presenceOfElementLocated(myWishesLocator));
        return driver.findElement(myWishesLocator);
    }

    public MyWishesPage clickOnMyWishes(){
        getMyWishesLink().click();
        return new MyWishesPage(driver);
    }

//    Home:

    private WebElement getHome(){
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome(){
        getHome().click();
        return new MyStorePage(driver);
    }

}

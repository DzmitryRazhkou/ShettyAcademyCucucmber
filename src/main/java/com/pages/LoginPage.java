package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

//    1. By Locators:
    private By emailId = By.id("email");
    private By passwordId = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.xpath("//a[contains(text(),'Forgot your password?')]");

//    2. Constructor of the page class:

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

//    3. Page actions: features (Behavior) of the page the form of methods:

    public String getLoginPageTile(){
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist(){
       return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName (String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword (String password) {
        driver.findElement(passwordId).sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public AccountPage doLogin(String un, String pwd) {
        System.out.println("We going to log in using " +un+ " and " +pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(passwordId).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountPage(driver);
    }
}

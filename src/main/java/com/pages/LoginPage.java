package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

//    2. Constructor of the page class:

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


//    ALREADY REGISTERED?

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        try {
            By forgotPwdLink = By.cssSelector("[title^='Recover your forgotten password']");
            wait.until(ExpectedConditions.presenceOfElementLocated(forgotPwdLink));
            System.out.println(" =====> Forgot your password is displayed. <===== ");
            return driver.findElement(forgotPwdLink).isDisplayed();
        } catch (TimeoutException error) {
            System.out.println(" =====> Please provide an another locator. <===== ");
            return false;
        }
    }

//  1. Email:

    private WebElement getEmail() {
        By emailIdLocator = By.id("email");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailIdLocator));
        return driver.findElement(emailIdLocator);
    }

    public void enterEmail(String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

//    2. Password:

    private WebElement getPassword() {
        By passwordIdLocator = By.id("passwd");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordIdLocator));
        return driver.findElement(passwordIdLocator);
    }

    public void enterPassword(String password) {
        getPassword().clear();
        getPassword().sendKeys(password);
    }

//    3. Sign In Button:

    private WebElement getSignInBtn() {
        By signInButtonLocator = By.id("SubmitLogin");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));
        return driver.findElement(signInButtonLocator);
    }

    public AccountPage clickOnLogin() {
        getSignInBtn().click();
        return new AccountPage(driver);
    }

//    Error Form:

    public boolean getErrorForm() {
        By errorLocator = By.id("SubmitLogin");
        wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator));
        try {
            System.out.println(" =====> Error form is displayed. <===== ");
            return driver.findElement(errorLocator).isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" =====> Please provide an another locator. <===== ");
            return false;
        }
    }


//    CREATE AN ACCOUNT:

//    1. Email Create:

    private WebElement getEmailCreate() {
        By getEmailCreateIdLocator = By.id("email_create");
        wait.until(ExpectedConditions.presenceOfElementLocated(getEmailCreateIdLocator));
        return driver.findElement(getEmailCreateIdLocator);
    }

    private void enterEmailCreate(String emailCreate) {
        getEmailCreate().clear();
        getEmailCreate().sendKeys(emailCreate);
    }

//    2. Create An Account Button:

    private WebElement getCreateAccountBtn() {
        By getCreateAccountLocator = By.id("SubmitCreate");
        wait.until(ExpectedConditions.presenceOfElementLocated(getCreateAccountLocator));
        return driver.findElement(getCreateAccountLocator);
    }

    private void clickOnCreateAccount() {
        getCreateAccountBtn().click();
    }

//    Final Method:

    public void doCreateAccount(String emailCreateAccount) {
        enterEmailCreate(emailCreateAccount);
        clickOnCreateAccount();
    }

}

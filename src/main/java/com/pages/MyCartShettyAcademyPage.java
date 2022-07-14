package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyCartShettyAcademyPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public MyCartShettyAcademyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    VALIDATE CART PAGE:

    private WebElement getMyCartHeader() {
        By getMyCartHeaderLocator = By.cssSelector("div[class='heading cf'] h1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMyCartHeaderLocator));
        return driver.findElement(getMyCartHeaderLocator);
    }

    public boolean validateMyCartHeader() {
        try {
            System.out.println("=====> Confirmation message is: " + getMyCartHeader().getText() + " <=====");
            return getMyCartHeader().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    CONFIRMATION OF PRODUCT CART:

    private WebElement getProductMyCart() {
        By getProductMyCartLocator = By.cssSelector("div[class='cartSection']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getProductMyCartLocator));
        return driver.findElement(getProductMyCartLocator);
    }

    private WebElement getCheckOut() {
        By getCheckOutLocator = By.xpath("//*[contains(text(),'Checkout')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCheckOutLocator));
        return driver.findElement(getCheckOutLocator);
    }

    public PaymentShettyAcademyPage proceedToCheckOut(String product){
        getProductMyCart().getText().contains(product);
        System.out.println("My cart contains: " +product);
        getCheckOut().click();
        return new PaymentShettyAcademyPage(driver);
    }

}

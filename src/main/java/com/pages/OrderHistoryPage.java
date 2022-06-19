package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderHistoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement orderHistoryBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getOrderHistoryBreadcrumb() {
        try {
            System.out.println(" ===> Order history breadcrumb is displayed. <=== ");
            System.out.println(orderHistoryBreadcrumb().getText());
            return orderHistoryBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getOrderHistoryPageTitle() {
        System.out.println(" =====> Order history page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    ORDER REFERENCE:

    public boolean getOrderReference(String orderReferenceName){
        By orderReferenceLocator = By.cssSelector(".color-myaccount");
        wait.until(ExpectedConditions.presenceOfElementLocated(orderReferenceLocator));

        List<WebElement> orderReferenceList = driver.findElements(orderReferenceLocator);
        for (WebElement s: orderReferenceList){
            if (s.getText().trim().contains(orderReferenceName)){
                System.out.println("Order reference list contains: " +orderReferenceName);
                return true;
            }
        }
        return false;
    }

//    DATA:

    public boolean getDate(String dateValue){
        By dateLocator = By.xpath("//*[@class='history_date bold']");
        wait.until(ExpectedConditions.presenceOfElementLocated(dateLocator));

        List<WebElement> dateList = driver.findElements(dateLocator);
        for (WebElement s: dateList){
            if (s.getText().trim().contains(dateValue)){
                System.out.println("Date list contains: " +dateValue);
                return true;
            }
        }
        return false;
    }

//    TOTAL PRICE:

    public boolean getTotalPrice(String totalPrice){
        By totalPriceLocator = By.cssSelector(".history_price");
        wait.until(ExpectedConditions.presenceOfElementLocated(totalPriceLocator));

        List<WebElement> dateList = driver.findElements(totalPriceLocator);
        for (WebElement s: dateList){
            if (s.getText().trim().contains(totalPrice)){
                System.out.println("Date list contains: " +totalPrice);
                return true;
            }
        }
        return false;
    }

//    Back to your account:

    private WebElement getBackToYourAccount() {
        By getBackToYourAccountLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[10]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public AccountPage doClickBackToToYourAccount() {
        getBackToYourAccount().click();
        return new AccountPage(driver);
    }

//    Home:

    private WebElement getHome() {
        By getHomeLocator = By.xpath("(//*[@class='btn btn-default button button-small'])[11]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome() {
        getHome().click();
        return new MyStorePage(driver);
    }

}

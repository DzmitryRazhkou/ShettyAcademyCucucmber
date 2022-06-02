package com.pages;

import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WomenPage {

    private WebDriver driver;
    private WebDriverWait wait;

//    GET WOMEN PAGE ELEMENT:

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private WebElement womenBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector(".navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getWomenBreadcrumb() {
        try {
            System.out.println(" ===> Header women breadcrumb is displayed. <=== ");
            System.out.println(womenBreadcrumb().getText());
            return womenBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    FILTERING:

    private WebElement getDressesCategoryCheckbox() {
        By dressCategoryCheckboxLocator = By.cssSelector("#uniform-layered_category_8");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressCategoryCheckboxLocator));
        return driver.findElement(dressCategoryCheckboxLocator);
    }

    private WebElement getSizeCheckbox() {
        By sizeCheckboxLocator = By.cssSelector("#uniform-layered_id_attribute_group_3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeCheckboxLocator));
        return driver.findElement(sizeCheckboxLocator);
    }

    private WebElement getColorCheckbox() {
        By colorCheckboxLocator = By.cssSelector("#layered_id_attribute_group_13");
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorCheckboxLocator));
        System.out.println("Color has been selected");
        return driver.findElement(colorCheckboxLocator);
    }

    //    METHOD:

    public void doSorting() throws InterruptedException {
        getDressesCategoryCheckbox().click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uniform-layered_id_attribute_group_3")));
        getSizeCheckbox().click();
        getColorCheckbox().click();
        Thread.sleep(15000);
    }

    //    Validate Text:

    public String validateFilteringText() {
        By validateTextLocator = By.cssSelector("span.cat-name");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cat-name")));
        String validateSortingText = driver.findElement(validateTextLocator).getText();
        System.out.println(validateSortingText);
        return validateSortingText;
    }

    public String extractResultString() {
        List<WebElement> list = driver.findElements(By.cssSelector(".product-container"));
        for (int i = 0; i < list.size(); i++) {
            String extTemp = list.get(i).getText().replaceAll("\n", " ");
            System.out.println("Initial: " + extTemp);
            return extTemp;
        }
        return null;
    }

}

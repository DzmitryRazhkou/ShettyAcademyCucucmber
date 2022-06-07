package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginCreateAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginCreateAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private WebElement authenticationBreadcrumb() {
        By womenBreadcrumbLocator = By.cssSelector("span.navigation_page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenBreadcrumbLocator));
        return driver.findElement(womenBreadcrumbLocator);
    }

    public boolean getAuthenticationBreadcrumb() {
        try {
            System.out.println(" ===> Header authentication breadcrumb is displayed. <=== ");
            System.out.println(authenticationBreadcrumb().getText());
            return authenticationBreadcrumb().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    YOUR PERSONAL INFORMATION:

//    1. Title:

    public WebElement getMrMrsRadioBtn() {
        By getMrRadioBtnLocator = By.xpath("//*[@id='id_gender1']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMrRadioBtnLocator));
        return driver.findElement(getMrRadioBtnLocator);
    }

    //    First Name:

    public WebElement getFirstName() {
        By getFirstNameLocator = By.cssSelector("#customer_firstname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameLocator));
        return driver.findElement(getFirstNameLocator);
    }

//    Last Name:

    public WebElement getLastName() {
        By getLastNameLocator = By.cssSelector("#customer_lastname");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameLocator));
        return driver.findElement(getLastNameLocator);
    }

//    Password:

    public WebElement getPassword() {
        By getPasswordLocator = By.cssSelector("#passwd");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getPasswordLocator));
        return driver.findElement(getPasswordLocator);
    }

//    Date Of Birth:

//    1. Days

    public void selectDays(String dayValue) {
        By getDaysValuesLocator = By.xpath("(//*[@class='form-control'])[1]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getDaysValuesLocator));

        List<WebElement> list = driver.findElements(getDaysValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(dayValue)) {
                webElement.click();
                break;
            }
        }
    }

//    2. Months

    public void selectMonths(String monthValue) {

        By getMonthsValuesLocator = By.xpath("(//*[@class='form-control'])[2]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMonthsValuesLocator));

        List<WebElement> list = driver.findElements(getMonthsValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(monthValue)) {
                webElement.click();
                break;
            }
        }
    }


//    3. Years

    public void selectYears(String yearsValue) {
        By getYearsValuesLocator = By.xpath("(//*[@class='form-control'])[3]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getYearsValuesLocator));
        List<WebElement> list = driver.findElements(getYearsValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(yearsValue)) {
                webElement.click();
                break;
            }
        }
    }

//    YOUR ADDRESS:

//    1. First Name:

    public WebElement getFirstNameAddress() {
        By getFirstNameAddressLocator = By.cssSelector("#firstname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstNameAddressLocator));
        return driver.findElement(getFirstNameAddressLocator);
    }

//    2. Last Name:

    public WebElement getLastNameAddress() {
        By getLastNameAddressLocator = By.cssSelector("#lastname:nth-of-type(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getLastNameAddressLocator));
        return driver.findElement(getLastNameAddressLocator);
    }

//    3. Company:

    public WebElement getCompany() {
        By getCompanyLocator = By.cssSelector("#company");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCompanyLocator));
        return driver.findElement(getCompanyLocator);
    }

//    4. Address:

    //    First Line
    public WebElement getAddressFirstLine() {
        By getAddressFirstLineLocator = By.cssSelector("#address1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressFirstLineLocator));
        return driver.findElement(getAddressFirstLineLocator);
    }

    //    Second Line
    public WebElement getAddressSecondLine() {
        By getAddressSecondLineLocator = By.cssSelector("#address2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddressSecondLineLocator));
        return driver.findElement(getAddressSecondLineLocator);
    }

//    5. City:

    public WebElement getCity() {
        By getCityLocator = By.cssSelector("#city");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

//    6. State:

    public void selectStates(String stateValue) {
        By getStatesValuesLocator = By.xpath("(//*[@class='form-control'])[10]//option");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStatesValuesLocator));
        List<WebElement> list = driver.findElements(getStatesValuesLocator);

        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains(stateValue)) {
                webElement.click();
                break;
            }
        }
    }

//    7. ZIP/POSTAL CODE

    public WebElement getZipCode() {
        By getZipCodeLocator = By.cssSelector("#postcode");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getZipCodeLocator));
        return driver.findElement(getZipCodeLocator);
    }

//    8. Additional Info

    public WebElement getAddInfo() {
        By getAddInfoLocator = By.cssSelector("#other");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getAddInfoLocator));
        return driver.findElement(getAddInfoLocator);
    }

//    9. Mobile phone:

    public WebElement getMobilePhone() {
        By getMobilePhoneLocator = By.cssSelector("#phone_mobile");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getMobilePhoneLocator));
        return driver.findElement(getMobilePhoneLocator);
    }

//    11. REGISTER BUTTON

    public WebElement getRegisterBtn() {
        By getRegisterBtnLocator = By.cssSelector("#submitAccount");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getRegisterBtnLocator));
        return driver.findElement(getRegisterBtnLocator);
    }

    public AccountPage clickOnRegister(){
        getRegisterBtn().click();
        return new AccountPage(driver);
    }
}

package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MyAddressesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//    VALIDATE BREADCRUMB:

    private WebElement getMyAddresses() {
        By myAddressesLocator = By.xpath("//strong[contains(text(),'Your addresses are listed below.')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAddressesLocator));
        return driver.findElement(myAddressesLocator);
    }

    public boolean getMyAddressesParagraphMessage() {
        try {
            System.out.println(" =====> " + getMyAddresses().getText() + " <===== ");
            return getMyAddresses().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

//    VALIDATE PAGE TITLE:

    public String getMyAddressesPageTitle() {
        System.out.println(" =====> My addresses page title is: " + driver.getTitle() + " <===== ");
        return driver.getTitle();
    }

//    UPDATE:

    public WebElement getUpdateButton() {
        By getUpdateBtnLocator = By.cssSelector("[title^='Update']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getUpdateBtnLocator));
        return driver.findElement(getUpdateBtnLocator);
    }

    public WebElement getAddressFl() {
        By getAddressFlLocator = By.id("address1");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressFlLocator));
        return driver.findElement(getAddressFlLocator);
    }

    public WebElement getAddressSl() {
        By getAddressSlLocator = By.id("address2");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressSlLocator));
        return driver.findElement(getAddressSlLocator);
    }

    public WebElement getPhone() {
        By getPhoneLocator = By.id("phone");
        wait.until(ExpectedConditions.presenceOfElementLocated(getPhoneLocator));
        return driver.findElement(getPhoneLocator);
    }

    public WebElement getAdditionalInfo() {
        By getAdditionalInfoLocator = By.id("other");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAdditionalInfoLocator));
        return driver.findElement(getAdditionalInfoLocator);
    }

    public WebElement getSaveBtn() {
        By getSaveBtnLocator = By.id("submitAddress");
        wait.until(ExpectedConditions.presenceOfElementLocated(getSaveBtnLocator));
        return driver.findElement(getSaveBtnLocator);
    }


//    ADD A NEW ADDRESS:

    public WebElement getAddANewAddressButton() {
        By getAddANewAddressLocator = By.cssSelector("[title^='Add an address']");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddANewAddressLocator));
        return driver.findElement(getAddANewAddressLocator);
    }

    public WebElement getCity() {
        By getCityLocator = By.id("city");
        wait.until(ExpectedConditions.presenceOfElementLocated(getCityLocator));
        return driver.findElement(getCityLocator);
    }

    public void selectStates(String stateValue) {
        By getStatesValuesLocator = By.xpath("(//*[@class='form-control'])[1]/option");
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

    public WebElement getZipCode() {
        By getAddressSlLocator = By.id("postcode");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAddressSlLocator));
        return driver.findElement(getAddressSlLocator);
    }

    public WebElement getAlias() {
        By getAliasLocator = By.id("alias");
        wait.until(ExpectedConditions.presenceOfElementLocated(getAliasLocator));
        return driver.findElement(getAliasLocator);
    }


//    DELETE:

    public WebElement getDeleteBtn() {
        By deleteBtnLocator = By.xpath("(//*[@title='Delete'])[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtnLocator));
        return driver.findElement(deleteBtnLocator);
    }

    public void getAlert() {
        getDeleteBtn().click();
        Alert okDelete = driver.switchTo().alert();
        String textAlert = okDelete.getText();
        System.out.println("JS Pop up: " + textAlert);
        okDelete.accept();
    }

//    Back to your account:

    private WebElement getBackToYourAccount() {
        By getBackToYourAccountLocator = By.xpath("//*[contains(text(),' Back to your account')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getBackToYourAccountLocator));
        return driver.findElement(getBackToYourAccountLocator);
    }

    public AccountPage doClickBackToToYourAccount() {
        getBackToYourAccount().click();
        return new AccountPage(driver);
    }

//    Home:

    private WebElement getHome() {
        By getHomeLocator = By.xpath("//*[contains(text(),' Home')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(getHomeLocator));
        return driver.findElement(getHomeLocator);
    }

    public MyStorePage doClickHome() {
        getHome().click();
        return new MyStorePage(driver);
    }

}

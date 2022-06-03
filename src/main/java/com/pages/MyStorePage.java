package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStorePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

//  Logo:

    private WebElement logo() {
        By logoLocator = By.xpath("//*[@title='My Store']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
        return driver.findElement(logoLocator);
    }

    public boolean getLogo() {
        try {
            System.out.println(" ===> Header logo is displayed. <=== ");
            return logo().isDisplayed();
        } catch (TimeoutException y) {
            System.out.println(" ===> Please provide the correct locator. <===");
            return false;
        }
    }

    //    CONTACT US | SIGN OUT | USER:

    public ContactUsPage clickOnContactUsButton() {
        By contactUsButtonLocator = By.cssSelector("[title^='Contact Us']");
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsButtonLocator));
        driver.findElement(contactUsButtonLocator).click();
        return new ContactUsPage(driver);
    }


    public LoginPage clickOnSignInButton() {
        By signInButtonLocator = By.cssSelector("[title^='Log in to your customer account']");
        wait.until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));
        driver.findElement(signInButtonLocator);
        return new LoginPage(driver);
    }

//    SECTIONS:

    public List<String> getSections() {
        List<String> listOfSections = new ArrayList<>(Arrays.asList(getWomenSection(), getDressesSection(), getTShirtsSection()));
        for (String s: listOfSections){
            System.out.println(s);
        }
        return listOfSections;
    }

    //    WOMEN:

    private WebElement womenButton(){
        By womenSectionLocator = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenSectionLocator));
        return driver.findElement(womenSectionLocator);
    }

    public WomenPage clickOnWomen(){
        womenButton().click();
        return new WomenPage(driver);
    }

    //    DRESSES:

    private WebElement dressesButton(){
        By dressesSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesSectionLocator));
        return driver.findElement(dressesSectionLocator);
    }

    public DressesPage clickOnDresses(){
        dressesButton().click();
        return new DressesPage(driver);
    }


    public int getAmountOfSections(){
        List<String> listOfSections = new ArrayList<>(Arrays.asList(getWomenSection(), getDressesSection(), getTShirtsSection()));
        int amountOfSection = listOfSections.size();
        return amountOfSection;
    }

    private String getWomenSection() {
        By womenSectionLocator = By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenSectionLocator));
        return driver.findElement(womenSectionLocator).getText();
    }

    private String getDressesSection() {
        By dressesSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[2]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dressesSectionLocator));
        return driver.findElement(dressesSectionLocator).getText();
    }

    private String getTShirtsSection() {
        By t_shirtSectionLocator = By.xpath("(//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a)[3]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(t_shirtSectionLocator));
        return driver.findElement(t_shirtSectionLocator).getText();
    }

//    FOOTER:

    private WebElement getSpecials() {
        By getSpecialsLocator = By.cssSelector("[title^='Specials']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getSpecialsLocator));
        return driver.findElement(getSpecialsLocator);
    }

    private WebElement getNewProducts() {
        By getNewProductsLocator = By.cssSelector("[title^='New products']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getNewProductsLocator));
        return driver.findElement(getNewProductsLocator);
    }

    private WebElement getBestSellers() {
        By getBestSellersLocator = By.cssSelector("[title^='Best sellers']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getBestSellersLocator));
        return driver.findElement(getBestSellersLocator);
    }

    private WebElement getOurStores() {
        By getOurStoresLocator = By.cssSelector("[title^='Our stores']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getOurStoresLocator));
        return driver.findElement(getOurStoresLocator);
    }

    private WebElement getContactUs() {
        By getContactUsLocator = By.cssSelector("[title^='Contact us']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getContactUsLocator));
        return driver.findElement(getContactUsLocator);
    }

    private WebElement getTermsAndConditionsOfUse() {
        By getTermsAndConditionsOfUseLocator = By.cssSelector("[title^='Terms and conditions of use']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getTermsAndConditionsOfUseLocator));
        return driver.findElement(getTermsAndConditionsOfUseLocator);
    }

    private WebElement getAboutUs() {
        By getAboutUsLocator = By.cssSelector("[title^='About us']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getAboutUsLocator));
        return driver.findElement(getAboutUsLocator);
    }

    private WebElement getSitemap() {
        By getSitemapLocator = By.cssSelector("[title^='Sitemap']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getSitemapLocator));
        return driver.findElement(getSitemapLocator);
    }

    public List<String> getFooterInformation() {

        WebElement element = driver.findElement(By.cssSelector("#block_various_links_footer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);

        String getSpecialsText = getSpecials().getText().trim();
        String getNewProductsText = getNewProducts().getText().trim();
        String getBestSellersText = getBestSellers().getText().trim();
        String getOurStoresText = getOurStores().getText().trim();
        String getContactUsText = getContactUs().getText().trim();
        String getTermsAndConditionsText = getTermsAndConditionsOfUse().getText().trim();
        String getAboutUsText = getAboutUs().getText().trim();
        String getSideMapText = getSitemap().getText().trim();

        List<String> list = new ArrayList<>(Arrays.asList(getSpecialsText, getNewProductsText, getBestSellersText, getOurStoresText,
                getContactUsText, getTermsAndConditionsText, getAboutUsText, getSideMapText));
        list.forEach(s -> System.out.println(s));
        return list;
    }

    public int getAmountOfInfoFooter(){
        List<String> list = new ArrayList<>(Arrays.asList(getSpecials().getText().trim(), getNewProducts().getText().trim(), getBestSellers().getText().trim(),
                getOurStores().getText().trim(), getContactUs().getText().trim(), getTermsAndConditionsOfUse().getText().trim(),
                getAboutUs().getText().trim(), getSitemap().getText().trim()));
        int amountOfInfoFooter = list.size();
        return amountOfInfoFooter;
    }




}

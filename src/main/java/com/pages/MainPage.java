package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By sections = By.xpath("//*[@id='home-page-tabs']//li");
    private final By productList = By.xpath("//ul[@class='product_list grid row homefeatured tab-pane active']//li");
    private final By manageMyAccount = By.xpath("//*[@class='bullet']//li");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getMainPageTitle() {
        return driver.getTitle();
    }

    public Integer getAmountsOfProductCount() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productList));
        return driver.findElements(productList).size();
    }

    public void clickOnSection(String sectionName) {
        List<WebElement> list = driver.findElements(sections);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Best Sellers")) {
//                wait.until(ExpectedConditions.presenceOfElementLocated(sections));
                list.get(i).click();
                break;
            }
        }
    }

    public List<String> getProductList() {
        List<String> sectionList = new ArrayList<>();
        List<WebElement> sectionHeaderList = driver.findElements(productList);

        for (WebElement s : sectionHeaderList) {
            String contentOfProduct = s.getText();
            System.out.println(contentOfProduct);
            sectionList.add(contentOfProduct);
        }
        return sectionList;
    }

//    Footer:

    public void scrollDownPage() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@title='Manage my customer account']")));
    }

    public List<String> getManageMyAccountList() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> webElementList = driver.findElements(manageMyAccount);
        for (WebElement s : webElementList) {
            String contentOfMyAccount = s.getText();
            System.out.println(contentOfMyAccount);
            accountList.add(contentOfMyAccount);
        }
        return accountList;
    }

    public Integer getManageMyAccountListAmount() {
        List<WebElement> webElementList = driver.findElements(manageMyAccount);
        for (int i = 0; i < webElementList.size(); i++) {
            Integer size = webElementList.size();
            if (size > 1)
                return size;
        }
        return -1;
    }
}

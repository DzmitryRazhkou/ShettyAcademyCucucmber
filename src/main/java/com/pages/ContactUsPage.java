package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By subjectHeading = By.xpath("//*[@id='id_contact']");
    private By subjectList = By.xpath("//*[@id='id_contact']//option");

    private By email = By.id("email");

    private By orderRef = By.name("id_order");


    private By product = By.id("uniform-413540_order_products");
    private By productList = By.id("uniform-413540_order_products select option");

    private By messageText = By.id("message");

    private By sendButton = By.id("submitMessage");
    private By successMessage = By.cssSelector("div#center_column p");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getContactUsPageTitle() {
        return driver.getTitle();
    }

    public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {

//        Subject Heading:

        wait.until(ExpectedConditions.presenceOfElementLocated(subjectHeading));
        driver.findElement(subjectHeading).click();
        List<WebElement> subject_list = driver.findElements(subjectList);
        for (int i = 0; i < subject_list.size(); i++) {
            System.out.println(subject_list.get(i).getText());
            if (subject_list.get(i).getText().equalsIgnoreCase(heading)) {
                subject_list.get(i).click();
            }
        }
        System.out.println(" ________________ ");

//            Email:

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailId);

        System.out.println("Email has been entered");
        System.out.println("\n");

//            Order Reference:

        wait.until(ExpectedConditions.presenceOfElementLocated(orderRef));
        driver.findElement(orderRef).sendKeys(orderReference);

//        Message:

        wait.until(ExpectedConditions.presenceOfElementLocated(messageText));
        driver.findElement(messageText).sendKeys(message);
    }


    public void clickSend() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}



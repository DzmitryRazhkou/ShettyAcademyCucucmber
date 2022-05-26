package stepdefinitions;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsSteps {

    public ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getWebDriver());

    @Given("User navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
        DriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=contact");

        String actTitlePage = contactUsPage.getContactUsPageTitle();
        String expTitlePage = "Contact us - My Store";
        Assert.assertEquals(actTitlePage, expTitlePage);
    }

    @When("User fills the form from given sheet name {string} and row number {int}")
    public void user_fills_the_form_from_given_sheet_name_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("/Users/dzmitryrazhkou/Documents/Automation/CucumberMyStore/dataSheet.xlsx", sheetName);

        System.out.println("Excel Sheet is successful. ");
        System.out.println("\n ");

        String heading = testData.get(rowNumber).get("Subject heading");
        String email = testData.get(rowNumber).get("email");
        String orderRef = testData.get(rowNumber).get("Order reference");
        String message = testData.get(rowNumber).get("Message");

        contactUsPage.fillContactUsForm(heading, email, orderRef, message);
    }

    @When("User clicks on the send button")
    public void user_clicks_on_the_send_button() {
        contactUsPage.clickSend();
    }

    @Then("It shows a successful message {string}")
    public void it_shows_a_successful_message(String expMessage) {
        String actMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actMessage, expMessage);
    }
}

package stepdefinitions;

import com.pages.ContactUsPage;
import com.pages.LoginPage;
import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyStorePageSteps {

    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private ContactUsPage contactUsPage;
    private LoginPage loginPage;

//  Logo:

    @Given("User is on the MyStorePage")
    public void user_is_on_the_my_store_page() {
        DriverFactory.getWebDriver().get(ConfigReader.initProp().getProperty("url"));
        System.out.println("URL is:" + "\n" + DriverFactory.getWebDriver().getCurrentUrl());
    }

    @Then("Logo is displayed")
    public void logo_is_displayed() {
        Assert.assertTrue(myStorePage.getLogo());
        System.out.println("Logo has been displayed");
    }

//    CONTACT US/ SIGN IN:

    @When("User clicks on the contact us button")
    public void user_clicks_on_the_contact_us_button() {
        System.out.println(" =====> User clicks at the contact us button <=====");
        contactUsPage = myStorePage.clickOnContactUsButton();
    }

    @Then("User navigates on at the Contact us - My Store")
    public void user_navigates_on_at_the_contact_us_my_store() {
        System.out.println(" =====> User navigates on the contact us page <=====");
        String expTitlePage = ConfigReader.initProp().getProperty("pageTitleContactUs");
        String actTitlePage = contactUsPage.getContactUsPageTitle();
        Assert.assertEquals(actTitlePage, expTitlePage);
    }

    @When("User clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        System.out.println(" =====> User clicks at the sign in button <=====");
        loginPage = myStorePage.clickOnSignInButton();
    }

    @Then("User navigates on at the Login - My Store")
    public void user_navigates_on_at_the_login_my_store() {
        System.out.println(" =====> User navigates on the sign in page <=====");
        String expTitlePage = ConfigReader.initProp().getProperty("pageTitleSignIn");
        String actTitlePage = loginPage.getLoginPageTile();
        Assert.assertEquals(actTitlePage, expTitlePage);
    }

    @Then("User retrieves names of account section")
    public void user_retrieves_names_of_account_section(DataTable sectionsTable) {
        List<String> expAccountList = sectionsTable.asList();   // List from the feature file.
        System.out.println("Expected accounts section list: " + expAccountList + " (from AccountPage.feature). ");


        List<String> actualAccountList = myStorePage.getSections();   // List from the Selenium.
        System.out.println("Actual accounts section list: " + actualAccountList + " (from Selenium). ");
        Assert.assertTrue(expAccountList.containsAll(actualAccountList));
    }

    @And("Accounts section is {int}")
    public void accountsSectionIs(int actualSectionCount) {
        Assert.assertTrue(myStorePage.getAmountOfSections() == actualSectionCount);
    }

//    FOOTER:

    @Then("User gets section from information footer")
    public void user_gets_section_from_information_footer(DataTable dataTableList) {
        List<String> expInformationList = dataTableList.asList();   // List from the feature file.
        System.out.println("Expected accounts section list: " + expInformationList + " (from AccountPage.feature). ");

        List<String> actInformationList = myStorePage.getFooterInformation();   // List from the Selenium.
        System.out.println("Actual accounts section list: " + actInformationList + " (from Selenium). ");
        Assert.assertEquals(expInformationList, actInformationList);
    }

    @Then("Footer has {int} sections")
    public void footer_has_sections(Integer expAmountOfSections) {
        Assert.assertTrue(myStorePage.getAmountOfInfoFooter() == expAmountOfSections);
    }

}


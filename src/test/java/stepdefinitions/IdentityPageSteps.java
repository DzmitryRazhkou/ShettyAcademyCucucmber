package stepdefinitions;

import com.pages.AccountPage;
import com.pages.IdentityPage;
import com.pages.MyCreditSlipsPage;
import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class IdentityPageSteps {

    private IdentityPage identityPage = new IdentityPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());

    @When("User clicks on the my order history and details section")
    public void user_clicks_on_the_my_order_history_and_details_section() {
        System.out.println("User clicks on the my order history and details section. ");
        identityPage = accountPage.clickOnIdentity();
    }
    @Then("User navigates at the my identity page title")
    public void user_navigates_at_the_my_identity_page_title() {
        System.out.println("My personal information breadcrumb is displayed. ");
        Assert.assertTrue(identityPage.getIdentityBreadCrumb());
    }
    @Then("Page title of identity page should be {string}")
    public void page_title_of_identity_page_should_be(String expIdentityPageTitle) {
        String actIdentityPageTitle = identityPage.getIdentityPageTitle();
        Assert.assertEquals(expIdentityPageTitle, actIdentityPageTitle);
    }

    @Then("User receives personal data")
    public void user_receives_personal_data(DataTable table) {
        List<String> expPersonalInfoList = table.asList();
        System.out.println("Expected personal data: " +expPersonalInfoList);

        List<String> actPersonalInfoList = identityPage.getPersonalInfo();
        System.out.println("Actual extracted personal data: " +actPersonalInfoList);
        Assert.assertEquals(expPersonalInfoList, actPersonalInfoList);
    }
}

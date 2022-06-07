package stepdefinitions;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());

    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credentialTable) {
        List<Map<String, String>> credentialsList = credentialTable.asMaps();
        String username = credentialsList.get(0).get("username");  // get(0) - username row, get("username") = dimagadjilla@gmail.com
        String password = credentialsList.get(0).get("password");  // get(0) - username row, get("password") = 3036057Dr

        DriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        accountPage = loginPage.clickOnLogin();
    }

    @Given("User is on Account Page")
    public void user_is_on_account_page() {
        String title = accountPage.getAccountPageTitle();
        System.out.println("Account Page Tile is: " +title);
    }

    @Then("User gets account section")
    public void user_gets_account_section(DataTable sectionsTable) {
        List<String> expAccountList = sectionsTable.asList();   // List from the feature file.
        System.out.println("Expected accounts section list: " +expAccountList+ " (from AccountPage.feature). ");

        List<String> actualAccountList = accountPage.getAccountsSectionsList();   // List from the Selenium.
        System.out.println("Actual accounts section list: " +actualAccountList+ " (from Selenium). ");
        Assert.assertTrue(expAccountList.containsAll(actualAccountList));
    }

    @Then("Accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer actualSectionCount) {
        Assert.assertTrue(accountPage.getAccountsSectionCount() == actualSectionCount);
    }
}

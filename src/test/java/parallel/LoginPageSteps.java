package parallel;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());

    @Given("User is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTile();
        System.out.println("Page Tile is: " +title);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("Forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }
}

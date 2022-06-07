package stepdefinitions;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());

    @When("User clicks on the sign in")
    public void user_clicks_on_the_sign_in() {
        System.out.println(" =====> User clicks at the sign in button <=====");
        loginPage = myStorePage.clickOnSignIn();
    }

    @When("User gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("The Page title is: " +title);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expTitleName) {
        Assert.assertTrue(title.contains(expTitleName));
    }

//    FORGOT YOUR PASSWORD:

    @Then("Forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

//    ALREADY REGISTERED?

//    Correct Credentials:

    @When("User enters email {string}")
    public void user_enters_email(String email) {
        System.out.println("User enters an email. ");
        loginPage.enterEmail(email);
    }
    @When("User enters password {string}")
    public void user_enters_password(String password) {
        System.out.println("User enters an password. ");
        loginPage.enterPassword(password);
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        System.out.println(" =====> User clicks on login button and navigates on the account page. <===== ");
        accountPage = loginPage.clickOnLogin();
    }

//    Incorrect Credentials:

    @When("User enters email \\{gans}")
    public void user_enters_email() {
        loginPage.enterEmail("gans");
    }

    @When("User enters password \\{{int}}")
    public void user_enters_password(Integer int1) {
        loginPage.enterPassword("int1");
    }
    @Then("An error form is displayed")
    public void an_error_form_is_displayed() {
        Assert.assertTrue(loginPage.getErrorForm());
    }

//    CREATE AN ACCOUNT:

    @When("User enters create {string}")
    public void user_enters_create(String email) {
        System.out.println("User enters an create email. ");
        loginPage.doCreateAccount(email);
    }
    @When("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        loginPage.clickOnCreateAccount();
    }

}

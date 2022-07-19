package stepdefinitions;

import com.pages.ProductShettyAcademyPage;
import com.pages.RegisterShettyAcademyPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterShettyAcademyPageSteps {

    RegisterShettyAcademyPage registerShettyAcademyPage = new RegisterShettyAcademyPage(DriverFactory.getWebDriver());
    ProductShettyAcademyPage productShettyAcademyPage = new ProductShettyAcademyPage(DriverFactory.getWebDriver());

    @Given("User navigates at the register Shetty page")
    public void user_navigates_at_the_register_shetty_page() {
        DriverFactory.getWebDriver().get(ConfigReader.initProp().getProperty("url"));
        System.out.println("URL is:" + "\n" + DriverFactory.getWebDriver().getCurrentUrl());
    }

    @When("User is on the register Shetty page")
    public void user_is_on_the_register_shetty_page() {
        System.out.println(" =====> User is on the register Shetty page <===== ");
    }

    @Then("The login form should be displayed")
    public void the_login_form_should_be_displayed() {
        Assert.assertTrue(registerShettyAcademyPage.getLogInForm());
    }

    @Then("Register Shetty title page should be {string}")
    public void shetty_page_title_should_be(String expRegisterShettyTitlePage) {
        String actRegisterShettyTitlePage = registerShettyAcademyPage.getMyStorePageTitle();
        Assert.assertEquals(expRegisterShettyTitlePage, actRegisterShettyTitlePage);
    }

    @Then("Social media amounts should be {int}")
    public void social_media_amounts_should_be(int expAmountOfSocialMedia) {
       int actAmountOfSocialMedia = registerShettyAcademyPage.socialMedia();
       Assert.assertEquals(expAmountOfSocialMedia, actAmountOfSocialMedia);
    }

    @Then("The academy's email address should be {string}")
    public void the_academy_s_email_address_should_be(String expEmailAddress) {
        String actEmailAddress = registerShettyAcademyPage.shettyAcademyEmail();
        Assert.assertEquals(expEmailAddress, actEmailAddress);
    }

//    Login with correct credentials

    @When("User enters an email address into the email field on the register Shetty page {string}")
    public void user_enters_an_email_address_into_the_email_field_on_the_register_shetty_page(String email) {
        registerShettyAcademyPage.emailField().sendKeys(email);
    }

    @When("User enters a password into the password field on the register Shetty page {string}")
    public void user_enters_a_password_into_the_password_field_on_the_register_shetty_page(String password) {
        registerShettyAcademyPage.passwordField().sendKeys(password);
    }

    @When("User clicks on the login button on the register Shetty page")
    public void user_clicks_on_the_login_button_on_the_register_shetty_page() {
        productShettyAcademyPage = registerShettyAcademyPage.clickOnLoginBtn();
    }
    @Then("User navigates at the product Shetty page")
    public void user_navigates_at_the_product_shetty_page() {
        Assert.assertTrue(productShettyAcademyPage.validateGetLogInGreenConfirmationMessage());
    }

    @Then("Confirm success login pop up message should be {string}")
    public void confirm_success_login_pop_up_message_should_be(String expConfirmSuccessLoginPopUpMessage) {
        String actConfirmSuccessLoginPopUpMessage = productShettyAcademyPage.validateGetLogInGreenConfirmationMessageText();
        Assert.assertEquals(expConfirmSuccessLoginPopUpMessage, actConfirmSuccessLoginPopUpMessage);
    }

//    Login with incorrect credentials:

    @When("User enters an wrong email address into the email field on the register Shetty page {string}")
    public void user_enters_an_wrong_email_address_into_the_email_field_on_the_register_shetty_page(String wrong_email) {
        registerShettyAcademyPage.emailField().sendKeys(wrong_email);
    }

    @When("User enters a wrong password into the password field on the register Shetty page {string}")
    public void user_enters_a_wrong_password_into_the_password_field_on_the_register_shetty_page(String wrong_password) {
        registerShettyAcademyPage.passwordField().sendKeys(wrong_password);
    }

    @Then("User stays at the register Shetty page")
    public void user_stays_at_the_register_shetty_page() {
        Assert.assertTrue(registerShettyAcademyPage.validateIncorrectCredentialsRedConfirmation());
    }

    @Then("Incorrect email or password pop up message should be {string}")
    public void incorrect_email_or_password_pop_up_message_should_be(String expIncorrectPasswordOrEmailPopUpMessage) {
        String actIncorrectPasswordOrEmailPopUpMessage = registerShettyAcademyPage.validateIncorrectCredentialsRedConfirmationText();
        Assert.assertEquals(expIncorrectPasswordOrEmailPopUpMessage, actIncorrectPasswordOrEmailPopUpMessage);
    }
}

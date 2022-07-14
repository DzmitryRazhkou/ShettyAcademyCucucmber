package stepdefinitions;

import com.pages.RegisterShettyAcademyPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterShettyAcademyPageSteps {

    RegisterShettyAcademyPage registerShettyAcademyPage = new RegisterShettyAcademyPage(DriverFactory.getWebDriver());

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

}

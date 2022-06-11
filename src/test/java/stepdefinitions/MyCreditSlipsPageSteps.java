package stepdefinitions;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.pages.MyCreditSlipsPage;
import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyCreditSlipsPageSteps {

    private MyCreditSlipsPage myCreditSlipsPage = new MyCreditSlipsPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());

    @When("User clicks on the my credit slips section")
    public void user_clicks_on_the_my_credit_slips_section() {
        System.out.println("User clicks on the my credit slips section. ");
        myCreditSlipsPage = accountPage.clickOnMyCreditSlips();
    }
    @Then("User navigates at the my credit slips page title")
    public void user_navigates_at_the_my_credit_slips_page_title() {
        System.out.println("My credit slips breadcrumb is displayed. ");
        Assert.assertTrue(myCreditSlipsPage.getMyCreditSlipsBreadCrumb());
    }

    @Then("Page title of my credit slips page should be {string}")
    public void page_title_of_my_credit_slips_page_should_be(String expMyCreditSlipsPageTitle) {
        String actMyCreditSlipsPageTitle = myCreditSlipsPage.getMyCreditSlipsPageTitle();
        Assert.assertEquals(expMyCreditSlipsPageTitle, actMyCreditSlipsPageTitle);
    }

    @Then("User can see message {string}")
    public void user_can_see_message(String expMyStorePageTitle) {
        String actMyStorePageTitle = myCreditSlipsPage.getMessage();
        Assert.assertEquals(expMyStorePageTitle, actMyStorePageTitle);
    }

    @When("User clicks on the back to your account button")
    public void user_clicks_on_the_back_to_your_account_button() {
        System.out.println("User clicks at the back yo my account button. ");
        accountPage = myCreditSlipsPage.doClickBackToToYourAccount();
    }

    @When("User clicks on the home button")
    public void user_clicks_on_the_home_button() {
        System.out.println("User clicks at the home button. ");
        myStorePage = myCreditSlipsPage.doClickHome();
    }
}

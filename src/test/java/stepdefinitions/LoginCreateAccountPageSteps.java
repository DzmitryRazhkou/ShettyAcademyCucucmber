package stepdefinitions;

import com.pages.AccountPage;
import com.pages.LoginCreateAccountPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginCreateAccountPageSteps {

    private LoginCreateAccountPage loginCreateAccountPage = new LoginCreateAccountPage(DriverFactory.getWebDriver());


    @When("User enters into the title field")
    public void user_enters_into_the_title_field() {
        Assert.assertTrue(loginCreateAccountPage.getAuthenticationBreadcrumb());
        System.out.println("User selects a title. ");
        loginCreateAccountPage.getMrMrsRadioBtn().click();
    }

    @When("User enters into the firstname field {string}")
    public void user_enters_into_the_firstname_field(String firstName) {
        System.out.println("User enters first name. ");
        loginCreateAccountPage.getFirstName().sendKeys(firstName);
    }

    @When("User enters into the lastname field {string}")
    public void user_enters_into_the_lastname_field(String lastName) {
        System.out.println("User enters last name. ");
        loginCreateAccountPage.getLastName().sendKeys(lastName);
    }
    @When("User enters into the password field {string}")
    public void user_enters_into_the_password_field(String passwd) {
        System.out.println("User enters password. ");
        loginCreateAccountPage.getPassword().sendKeys(passwd);
    }
    @When("User enters into the days {string}")
    public void user_enters_into_the_days(String days) {
        System.out.println("User selects days in the drop down menu. ");
        loginCreateAccountPage.selectDays(days);
    }
    @When("User enters into the months {string}")
    public void user_enters_into_the_months(String months) {
        System.out.println("User selects months in the drop down menu. ");
        loginCreateAccountPage.selectMonths(months);
    }
    @When("User enters into the years {string}")
    public void user_enters_into_the_years(String years) {
        System.out.println("User selects years in the drop down menu. ");
        loginCreateAccountPage.selectYears(years);
    }

    @When("User enters into the company field {string}")
    public void user_enters_into_the_company_field(String company) {
        System.out.println("User enters company name. ");
        loginCreateAccountPage.getCompany().sendKeys(company);
    }

    @When("User enters into the first line address field {string}")
    public void user_enters_into_the_first_line_address_field(String addressFl) {
        System.out.println("User enters first line address. ");
        loginCreateAccountPage.getAddressFirstLine().sendKeys(addressFl);
    }
    @When("User enters into the last line address field {string}")
    public void user_enters_into_the_last_line_address_field(String addressSl) {
        System.out.println("User enters second line address. ");
        loginCreateAccountPage.getAddressSecondLine().sendKeys(addressSl);
    }
    @When("User enters into the city field {string}")
    public void user_enters_into_the_city_field(String city) {
        System.out.println("User enters city. ");
        loginCreateAccountPage.getCity().sendKeys(city);
    }
    @When("User enters into the state field {string}")
    public void user_enters_into_the_state_field(String state) {
        System.out.println("User enters state. ");
        loginCreateAccountPage.selectStates(state);
    }
    @When("User enters into the zipcode field {string}")
    public void user_enters_into_the_zipcode_field(String zip) {
        System.out.println("User enters zipcode. ");
        loginCreateAccountPage.getZipCode().sendKeys(zip);
    }
    @When("User enters into the additional info field {string}")
    public void user_enters_into_the_additional_info_field(String addInfo) {
        System.out.println("User enters additional information. ");
        loginCreateAccountPage.getAddInfo().sendKeys(addInfo);
    }
    @When("User enters into the mobile phone {string}")
    public void user_enters_into_the_mobile_phone(String phone) {
        System.out.println("User enters phone number. ");
        loginCreateAccountPage.getMobilePhone().sendKeys(phone);
    }
    @When("User clicks on the register button")
    public void user_clicks_on_the_register_button() {
        System.out.println("User clicks in the register button and navigates at the account page. ");
        AccountPage accountPage = loginCreateAccountPage.clickOnRegister();
        accountPage.getAccountPageTitle();
    }
}

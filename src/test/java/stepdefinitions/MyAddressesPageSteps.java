package stepdefinitions;

import com.github.javafaker.Faker;
import com.pages.AccountPage;
import com.pages.MyAddressesPage;
import com.pages.MyStorePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyAddressesPageSteps {

    private Faker faker = new Faker();

    private MyAddressesPage myAddressesPage = new MyAddressesPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());


    @When("User clicks on the my addresses section")
    public void user_clicks_on_the_my_addresses_section() {
        System.out.println("User clicks on the my addresses section. ");
        myAddressesPage = accountPage.clickOnMyAddresses();
    }

    @Then("User navigates at the my addresses page title")
    public void user_navigates_at_the_my_addresses_page_title() {
        System.out.println("My addresses message is displayed. ");
        Assert.assertTrue(myAddressesPage.getMyAddressesParagraphMessage());
    }
    @Then("Page title of my addresses page should be {string}")
    public void page_title_of_my_addresses_page_should_be(String expMyAddressesPageTitle) {
        String actMyAddressesPageTitle = myAddressesPage.getMyAddressesPageTitle();
        Assert.assertEquals(expMyAddressesPageTitle, actMyAddressesPageTitle);
    }

    @When("User clicks on the update button at the addresses page")
    public void user_clicks_on_the_update_button_at_the_addresses_page() {
        System.out.println("User clicks on the update button. ");
        myAddressesPage.getUpdateButton().click();
    }

    @When("User enters first line of address for updating")
    public void user_enters_first_line_of_address_for_updating() {
        String addressFl = faker.address().fullAddress();
        myAddressesPage.getAddressFl().clear();
        myAddressesPage.getAddressFl().sendKeys(addressFl);
    }

    @When("User enters second line of address for updating")
    public void user_enters_second_line_of_address_for_updating() {
        String addressSl = faker.address().secondaryAddress();
        myAddressesPage.getAddressSl().clear();
        myAddressesPage.getAddressSl().sendKeys(addressSl);
    }

    @When("User enters phone number for updating address")
    public void user_enters_phone_number_for_updating_address() {
        String phone = faker.phoneNumber().cellPhone();
        myAddressesPage.getPhone().clear();
        myAddressesPage.getPhone().sendKeys(phone);
    }

    @When("User enters additional data for updating address")
    public void user_enters_additional_data_for_updating_address() {
        String addInfo = faker.beer().style();
        myAddressesPage.getAdditionalInfo().clear();
        myAddressesPage.getAdditionalInfo().sendKeys(addInfo);
    }

    @When("User enters alias for updating address")
    public void user_enters_alias_for_updating_address() {
        String alias = faker.name().title();
        myAddressesPage.getAlias().clear();
        myAddressesPage.getAlias().sendKeys(alias);
    }

    @When("User clicks on the save button at the addresses page")
    public void user_clicks_on_the_save_button_at_the_addresses_page() {
        myAddressesPage.getSaveBtn().click();
    }

    @When("User clicks on the add new address button at the addresses page")
    public void user_clicks_on_the_add_new_address_button_at_the_addresses_page() {
        myAddressesPage.getAddANewAddressButton().click();
    }

    @When("User enters city name for creating new address")
    public void user_enters_city_name_for_creating_new_address() {
        String city = faker.address().city();
        myAddressesPage.getCity().clear();
        myAddressesPage.getCity().sendKeys(city);
    }

    @When("User selects state name for creating new address")
    public void user_selects_state_name_for_creating_new_address() {
        String state = faker.address().state();
        myAddressesPage.selectStates(state);
    }

    @When("User enters zipcode for creating new address")
    public void user_enters_zipcode_for_creating_new_address() {
        String zip = faker.address().zipCode();
        myAddressesPage.getZipCode().sendKeys(zip);
    }

    @When("User clicks on the back to your account button at the address page")
    public void user_clicks_on_the_back_to_your_account_button_at_the_address_page() {
        System.out.println("User clicks at the back yo my account button. ");
        accountPage = myAddressesPage.doClickBackToToYourAccount();
    }

    @When("User clicks on the home button at the address page")
    public void user_clicks_on_the_home_button_at_the_address_page() {
        System.out.println("User clicks at the home button. ");
        myStorePage = myAddressesPage.doClickHome();
    }
}

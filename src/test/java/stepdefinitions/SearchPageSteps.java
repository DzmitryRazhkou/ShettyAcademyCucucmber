package stepdefinitions;

import com.pages.*;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchPageSteps {

    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private SearchPage searchPage = new SearchPage(DriverFactory.getWebDriver());

    @When("User enters in the search field {string}")
    public void user_enters_in_the_search_field(String productType) {
        accountPage.getSearchField().sendKeys(productType);
    }
    @When("User clicks on the search button at the my account page")
    public void user_clicks_on_the_search_button_at_the_my_account_page() {
        searchPage = accountPage.doClickOnSearchBtn();
    }

    @When("User navigates at the search page")
    public void user_navigates_at_the_search_page() {
        Assert.assertTrue(searchPage.getSearchBreadCrumb());
    }

    @Then("Page title of the search page should be {string}")
    public void page_title_of_the_search_page_should_be(String expSearchPageTitle) {
        String actSearchPageTitle = searchPage.getSearchPageTitle();
        Assert.assertEquals(actSearchPageTitle, expSearchPageTitle);
    }

    @Then("User gets amount of search product")
    public void user_gets_amount_of_search_product() {
        Assert.assertTrue(searchPage.getProductCount());
    }

    @Then("Product name contains the {string}")
    public void product_name_contains_the(String searchedProduct) {
        Assert.assertTrue(searchPage.getProduct(searchedProduct));
    }

}

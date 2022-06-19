package stepdefinitions;

import com.pages.AccountPage;
import com.pages.MyAddressesPage;
import com.pages.MyStorePage;
import com.pages.OrderHistoryPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrderHistoryPageSteps {

    private MyAddressesPage myAddressesPage = new MyAddressesPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private OrderHistoryPage orderHistoryPage = new OrderHistoryPage(DriverFactory.getWebDriver());

    @When("User clicks on the order history and details section")
    public void user_clicks_on_the_order_history_and_details_section() {
        System.out.println("User clicks on the order history section. ");
        orderHistoryPage = accountPage.clickOnOrderHistory();
    }

    @When("User navigates at the order history page")
    public void user_navigates_at_the_order_history_page() {
        System.out.println("Order history breadcrumb is displayed. ");
        Assert.assertTrue(orderHistoryPage.getOrderHistoryBreadcrumb());
    }

    @Then("Page title of order history and details page should be {string}")
    public void page_title_of_order_history_and_details_page_should_be(String expMyAddressesPageTitle) {
        String actMyAddressesPageTitle = orderHistoryPage.getOrderHistoryPageTitle();
        Assert.assertEquals(expMyAddressesPageTitle, actMyAddressesPageTitle);
    }

    @Then("Order reference list contains {string}")
    public void order_reference_list_contains(String orderReference) {
        Assert.assertTrue(orderHistoryPage.getOrderReference(orderReference));
    }

}

package stepdefinitions;

import com.github.javafaker.Faker;
import com.pages.AccountPage;
import com.pages.MyAddressesPage;
import com.pages.MyStorePage;
import com.pages.MyWishesPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyWishesPageSteps {

    private Faker faker = new Faker();
    private int actAmountOfTopSellers;

    private MyAddressesPage myAddressesPage = new MyAddressesPage(DriverFactory.getWebDriver());
    private MyWishesPage myWishesPage = new MyWishesPage(DriverFactory.getWebDriver());
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());

    @When("User clicks on the my wishes section")
    public void user_clicks_on_the_my_wishes_section() {
        System.out.println("User clicks on the my wishes section. ");
        myWishesPage = accountPage.clickOnMyWishes();
    }

    @Then("User navigates at the my wishes page title")
    public void user_navigates_at_the_my_wishes_page_title() {
        System.out.println("My wishes breadcrumb is displayed. ");
        Assert.assertTrue(myWishesPage.getMyWishesBreadCrumb());
    }

    @Then("Page title of my wishes page should be {string}")
    public void page_title_of_my_wishes_page_should_be(String expMyWishesPageTitle) {
        String actMyWishesPageTitle = myWishesPage.getMyWishesPageTitle();
        Assert.assertEquals(expMyWishesPageTitle, actMyWishesPageTitle);
    }

    @When("User gets top seller products")
    public void user_gets_top_seller_products() {
        List<String> actTopSellersList = myWishesPage.getTopSellers();
        actAmountOfTopSellers = actTopSellersList.size();
    }

    @Then("Amount of the top seller products should be {int}")
    public void amount_of_the_top_seller_products_should_be(int expAmountOfTopSellers) {
        System.out.println(" =====> The amount of top sellers: " + actAmountOfTopSellers + " products <=====. ");
        Assert.assertEquals(expAmountOfTopSellers, actAmountOfTopSellers);
    }

    @Then("Top seller products should contain {string}")
    public void top_seller_products_should_contain(String result) {
        List<String> actTopSellersList = myWishesPage.getTopSellers();
        for (String s : actTopSellersList) {
            System.out.println(s);
            Assert.assertTrue(myWishesPage.validateTopSellers(result));
        }
    }
}

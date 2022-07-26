package stepdefinitions;

import com.github.javafaker.Faker;
import com.pages.MyCartShettyAcademyPage;
import com.pages.PaymentShettyAcademyPage;
import com.pages.ProductShettyAcademyPage;
import com.pages.RegisterShettyAcademyPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductShettyAcademyPageSteps {

    RegisterShettyAcademyPage registerShettyAcademyPage = new RegisterShettyAcademyPage(DriverFactory.getWebDriver());
    ProductShettyAcademyPage productShettyAcademyPage = new ProductShettyAcademyPage(DriverFactory.getWebDriver());
    MyCartShettyAcademyPage myCartShettyAcademyPage = new MyCartShettyAcademyPage(DriverFactory.getWebDriver());
    PaymentShettyAcademyPage paymentShettyAcademyPage = new PaymentShettyAcademyPage(DriverFactory.getWebDriver());
    Faker faker = new Faker();

    @When("Product Shetty title page should be {string}")
    public void product_shetty_title_page_should_be(String expProductPageTitle) {
        String actProductPageTitle = productShettyAcademyPage.getProductPageTitle();
        Assert.assertEquals(actProductPageTitle, expProductPageTitle);
    }

    @Then("User retrieves product on the product Shetty page")
    public void user_retrieves_product_on_the_product_shetty_page() {
        int amountOfProducts = productShettyAcademyPage.productAmount();
        System.out.println(" =====> Amount of the products: " +amountOfProducts+ " <===== ");
    }

    @Then("The amount of the products should be {int}")
    public void the_amount_of_the_products_should_be(Integer expAmountOfProducts) {
        Integer actAmountOfProducts = productShettyAcademyPage.productAmount();
        Assert.assertEquals(expAmountOfProducts, actAmountOfProducts);
    }

    @When("User enters product name at the product Shetty page {string}")
    public void user_enters_product_name_at_the_product_shetty_page(String productName) {
        productShettyAcademyPage.doSearch(productName);
    }
    @Then("Product name should be {string}")
    public void product_name_should_be(String productName) {
        Assert.assertTrue(productShettyAcademyPage.validateProduct(productName));
    }

    @When("User clicks on the add to cart button")
    public void user_clicks_on_the_add_to_cart_button() throws InterruptedException {
        productShettyAcademyPage.doAddToCart();
    }

    @Then("Add to cart green confirmation message is appeared")
    public void add_to_cart_green_confirmation_message_is_appeared() {
        Assert.assertTrue(productShettyAcademyPage.validateAddToCartGreenConfirmationMessage());
    }

    @When("User clicks on the cart button")
    public void user_clicks_on_the_cart_button() {
        myCartShettyAcademyPage = productShettyAcademyPage.doClickOnCart();
    }
    @Then("User navigates at the my cart Shetty page")
    public void user_navigates_at_the_my_cart_shetty_page() {
        Assert.assertTrue(myCartShettyAcademyPage.validateMyCartHeader());
    }

    @When("User clicks on the proceed to check out button {string}")
    public void user_clicks_on_the_proceed_to_check_out_button(String productName) {
        paymentShettyAcademyPage = myCartShettyAcademyPage.proceedToCheckOut(productName);
    }

    @Then("User navigates at the payment Shetty page")
    public void user_navigates_at_the_payment_shetty_page() {
        Assert.assertTrue(paymentShettyAcademyPage.validatePaymentHeader());
    }

    @When("User clicks at the log out button")
    public void user_clicks_at_the_log_out_button() {
        registerShettyAcademyPage = productShettyAcademyPage.doLogOut();
    }
    @Then("Log out green confirmation message is showed up")
    public void log_out_green_confirmation_message_is_showed_up() {
        Assert.assertTrue(registerShettyAcademyPage.validateGetLogOutGreenConfirmationMessage());
    }

}

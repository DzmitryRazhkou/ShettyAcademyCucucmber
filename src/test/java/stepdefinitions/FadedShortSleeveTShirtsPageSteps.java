package stepdefinitions;

import com.github.javafaker.Faker;
import com.pages.AccountPage;
import com.pages.FadedShortSleeveTShirtsPage;
import com.pages.MyStorePage;
import com.pages.SearchPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FadedShortSleeveTShirtsPageSteps {

    private Faker faker;
    private AccountPage accountPage = new AccountPage(DriverFactory.getWebDriver());
    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private SearchPage searchPage = new SearchPage(DriverFactory.getWebDriver());
    private FadedShortSleeveTShirtsPage fadedShortSleeveTShirtsPage = new FadedShortSleeveTShirtsPage(DriverFactory.getWebDriver());

    @When("User clicks on the showed product at the account page")
    public void user_clicks_on_the_showed_product_at_the_account_page() {
        System.out.println("User clicks on the product");
        fadedShortSleeveTShirtsPage = searchPage.clickOnMore();
    }

    @When("User navigates at the faded short sleeve t-shirts page")
    public void user_navigates_at_the_faded_short_sleeve_t_shirts_page() {
        Assert.assertTrue(fadedShortSleeveTShirtsPage.getFadedShortSleeveTShirtBreadCrumb());
    }

    @Then("Page title of the faded short sleeve t-shirts page should be {string}")
    public void page_title_of_the_faded_short_sleeve_t_shirts_page_should_be(String expFadedShortSleeveTShirtPageTitle) {
        String actFadedShortSleeveTShirtPageTitle = fadedShortSleeveTShirtsPage.getFadedShortSleeveTShirtPageTitle();
        Assert.assertEquals(expFadedShortSleeveTShirtPageTitle, actFadedShortSleeveTShirtPageTitle);
    }

    @When("User clicks on the write review button at the faded short sleeve t-shirts page")
    public void user_clicks_on_the_write_review_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getWriteReview().click();
    }

    @When("User selects star content quality at the faded short sleeve t-shirts page")
    public void user_selects_star_content_quality_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getStarContent().click();
    }

    @When("User enters the title of review in the text field at the faded short sleeve t-shirts page")
    public void user_enters_the_title_of_review_in_the_text_field_at_the_faded_short_sleeve_t_shirts_page() {
        faker = new Faker();
        String title = faker.artist().name();
        fadedShortSleeveTShirtsPage.getTitle().clear();
        fadedShortSleeveTShirtsPage.getTitle().sendKeys(title);
    }

    @When("User enters the comment in the text field at the faded short sleeve t-shirts page")
    public void user_enters_the_comment_in_the_text_field_at_the_faded_short_sleeve_t_shirts_page() {
        faker = new Faker();
        String comment = faker.medical().symptoms();
        fadedShortSleeveTShirtsPage.getContent().clear();
        fadedShortSleeveTShirtsPage.getContent().sendKeys(comment);
    }

    @When("User clicks on the send review button at the faded short sleeve t-shirts page")
    public void user_clicks_on_the_send_review_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getSendReviewBtn().click();
    }

    @Then("New review comment message should be {string}")
    public void new_review_comment_message_should_be(String expMessage) {
        String actMessage = fadedShortSleeveTShirtsPage.getReviewMessageText();
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newReviewComment());
    }

    @When("User clicks on the send to friend button at the faded short sleeve t-shirts page")
    public void user_clicks_on_the_send_to_friend_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getSendToFriendBtn().click();
    }

    @When("User enters the name of the friend in the text field at the faded short sleeve t-shirts page")
    public void user_enters_the_name_of_the_friend_in_the_text_field_at_the_faded_short_sleeve_t_shirts_page() {
        faker = new Faker();
        String name = faker.name().fullName();
        fadedShortSleeveTShirtsPage.getFriendNameField().clear();
        fadedShortSleeveTShirtsPage.getFriendNameField().sendKeys(name);
    }

    @When("User enters the email address of your friend in the text field at the faded short sleeve t-shirts page")
    public void user_enters_the_email_address_of_your_friend_in_the_text_field_at_the_faded_short_sleeve_t_shirts_page() {
        faker = new Faker();
        String email = faker.internet().emailAddress();
        fadedShortSleeveTShirtsPage.getFriendEmailField().clear();
        fadedShortSleeveTShirtsPage.getFriendEmailField().sendKeys(email);
    }

    @When("User clicks on the send email button at the faded short sleeve t-shirts page")
    public void user_clicks_on_the_send_email_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getSendEmailBtn().click();
    }

    @Then("New review email message should be {string}")
    public void new_review_email_message_should_be(String expMessage) {
        String actMessage = fadedShortSleeveTShirtsPage.getEmailMessageText();
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newEmailComment());
    }

    @When("User clicks on the add to wishlist button at the faded short sleeve t-shirts page")
    public void user_clicks_on_the_add_to_wishlist_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getAddToWishBtn();
    }
    @Then("New wish list message should be {string}")
    public void new_wish_list_message_should_be(String expMessage) {
        String actMessage = fadedShortSleeveTShirtsPage.getWishMessageText();
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newAddToWish());
    }

    @When("User selects quantity of product at the faded short sleeve t-shirts page {string}")
    public void user_selects_quantity_of_product_at_the_faded_short_sleeve_t_shirts_page(String quantity) {
        fadedShortSleeveTShirtsPage.getQuantity().clear();
        fadedShortSleeveTShirtsPage.getQuantity().sendKeys(quantity);
        fadedShortSleeveTShirtsPage.getPlusBtn().click();
        fadedShortSleeveTShirtsPage.getMinusBtn().click();
    }

    @When("User selects size of product at the faded short sleeve t-shirts page {string}")
    public void user_selects_size_of_product_at_the_faded_short_sleeve_t_shirts_page(String index) {
        fadedShortSleeveTShirtsPage.getSize(index);
    }

    @When("User selects color of product at the faded short sleeve t-shirts page")
    public void user_selects_color_of_product_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getColor().click();
    }

    @When("User clicks at the add to cart button at the faded short sleeve t-shirts page")
    public void user_clicks_at_the_add_to_cart_button_at_the_faded_short_sleeve_t_shirts_page() {
        fadedShortSleeveTShirtsPage.getAddToCartBtn();
    }

    @Then("Success message should be show up")
    public void success_message_should_be_show_up() {
        Assert.assertTrue(fadedShortSleeveTShirtsPage.getSuccessMessage());
    }

}

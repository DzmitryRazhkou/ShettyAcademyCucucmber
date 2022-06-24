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
        System.out.println("User clcicks on the product");
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
        String actMessage = fadedShortSleeveTShirtsPage.getMessageText();
        Assert.assertEquals(expMessage, actMessage);
        Assert.assertTrue(fadedShortSleeveTShirtsPage.newReviewComment());
    }

}

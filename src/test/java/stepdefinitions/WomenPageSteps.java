package stepdefinitions;

import com.pages.ContactUsPage;
import com.pages.LoginPage;
import com.pages.MyStorePage;
import com.pages.WomenPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Locale;

public class WomenPageSteps {

    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private WomenPage womenPage;

//    VALIDATE WOMEN PAGE:

    @Given("User is on the My store page")
    public void user_is_on_the_my_store_page() {
        DriverFactory.getWebDriver().get(ConfigReader.initProp().getProperty("url"));
        System.out.println("URL is:" + "\n" + DriverFactory.getWebDriver().getCurrentUrl());
    }

    @When("User clicks on the Women section")
    public void user_clicks_on_the_women_section() {
        System.out.println(" =====> User clicks at the women section <=====");
        womenPage = myStorePage.clickOnWomen();
    }

    @Then("User lands on the Women page")
    public void user_lands_on_the_women_page() {
        Assert.assertTrue(womenPage.getWomenBreadcrumb());
    }

//    FILTERING:

    @When("User makes check boxes checked on the women page")
    public void user_makes_check_boxes_checked_on_the_women_page() throws InterruptedException {
        System.out.println(" =====> User sets up the boxes at the women section <=====");
        womenPage.doSorting();
    }
    @Then("Women result is {string}")
    public void women_result_is(String expSortingResult) {
        String actSortingResult = womenPage.validateFilteringText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(actSortingResult, expSortingResult);
    }

    @Then("Women search result is {string}")
    public void women_search_result_is(String expList) {
        String actList = womenPage.extractResultString();
        Assert.assertEquals(actList, expList);
    }

//    SLIDERS:

    @When("User adjusts price using sliders on the women page")
    public void user_adjusts_price_using_sliders_on_the_women_page() throws InterruptedException {
        System.out.println(" =====> User adjusts sliders at the women page <=====");
        womenPage.moveSlider();
    }

    @Then("Women adjusted result is {string}")
    public void women_adjusted_result_is(String expResult) {
        String actResult = womenPage.extractResultString();
        Assert.assertEquals(actResult, expResult);
    }

    @Then("Women adjusted search result is {string}")
    public void women_adjusted_search_result_is(String expOutOf) {
        String actOutOf = womenPage.getShowingOut();
        Assert.assertEquals(actOutOf, expOutOf);
    }

//    SORTING:

    @When("User selects sorting by on the women page")
    public void user_selects_sorting_by_on_the_women_page() throws InterruptedException {
        System.out.println(" =====> User makes sorting at the women page <=====");
        womenPage.selectSort();
    }

    @Then("Women sorted result is {string}")
    public void women_sorted_result_is(String expResult) {
        String actResult = womenPage.extractSortString();
        Assert.assertEquals(actResult, expResult);
    }

}

package stepdefinitions;

import com.pages.DressesPage;
import com.pages.MyStorePage;
import com.pages.TShirtsPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Locale;

public class TShirtsPageSteps {

    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private TShirtsPage tShirtsPage;

    @When("User clicks on the t-shirts section")
    public void user_clicks_on_the_t_shirts_section() {
        System.out.println(" =====> User clicks at the t-shirts section <=====");
        tShirtsPage = myStorePage.clickOnTShirts();
    }
    @Then("User lands on the T-shirts page")
    public void user_lands_on_the_t_shirts_page() {
        Assert.assertTrue(tShirtsPage.getT_shirtBreadcrumb());
    }

//    FILTERING:

    @When("User makes check boxes checked on the t-shirts page")
    public void user_makes_check_boxes_checked_on_the_t_shirts_page() throws InterruptedException {
        System.out.println(" =====> User sets up the boxes at the t-shirts section <=====");
        tShirtsPage.doSorting();
    }

    @Then("T-shirts result is {string}")
    public void t_shirts_result_is(String expSortingResult) {
        String actSortingResult = tShirtsPage.validateFilteringText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(actSortingResult, expSortingResult);
    }

    @Then("T-shirts search result is {string}")
    public void t_shirts_search_result_is(String expList) {
        String actList = tShirtsPage.extractResultString();
        Assert.assertEquals(actList, expList);
    }

//    SLIDERS:

    @When("User adjusts price using sliders on the t-shirts page")
    public void user_adjusts_price_using_sliders_on_the_t_shirts_page() throws InterruptedException {
        System.out.println(" =====> User adjusts sliders at the t-shirts page <=====");
        tShirtsPage.moveSlider();
    }
    @Then("T-shirts adjusted result is {string}")
    public void t_shirts_adjusted_result_is(String expResult) {
        String actResult = tShirtsPage.extractResultString();
        Assert.assertEquals(actResult, expResult);
    }
    @Then("T-shirts adjusted search result is {string}")
    public void t_shirts_adjusted_search_result_is(String expOutOf) {
        String actOutOf = tShirtsPage.getShowingOut();
        Assert.assertEquals(actOutOf, expOutOf);
    }

//    SORTING:

    @When("User selects sorting by on the t-shirts page")
    public void user_selects_sorting_by_on_the_t_shirts_page() throws InterruptedException {
        System.out.println(" =====> User makes sorting at the t-shirts page <=====");
        tShirtsPage.selectSort();
    }
    @Then("T-shirts sorted result is {string}")
    public void t_shirts_sorted_result_is(String expResult) {
        String actResult = tShirtsPage.extractSortString();
        Assert.assertEquals(actResult, expResult);
    }

}

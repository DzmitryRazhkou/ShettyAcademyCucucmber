package stepdefinitions;

import com.pages.DressesPage;
import com.pages.MyStorePage;
import com.pages.WomenPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Locale;

public class DressesPageSteps {

    private MyStorePage myStorePage = new MyStorePage(DriverFactory.getWebDriver());
    private DressesPage dressesPage;

    @When("User clicks on the Dresses section")
    public void user_clicks_on_the_dresses_section() {
        System.out.println(" =====> User clicks at the dresses section <=====");
        dressesPage = myStorePage.clickOnDresses();
    }

    @Then("User lands on the Dresses page")
    public void user_lands_on_the_dresses_page() {
        Assert.assertTrue(dressesPage.getDressesBreadcrumb());
    }

//    FILTERING:

    @When("User makes check boxes checked on the dresses page")
    public void user_makes_check_boxes_checked_on_the_dresses_page() throws InterruptedException {
        System.out.println(" =====> User sets up the boxes at the dresses section <=====");
        dressesPage.doSorting();
    }

    @Then("Dresses result is {string}")
    public void dresses_result_is(String expSortingResult) {
        String actSortingResult = dressesPage.validateFilteringText().toUpperCase(Locale.ROOT);
        Assert.assertEquals(actSortingResult, expSortingResult);
    }

    @Then("Dresses search result is {string}")
    public void dresses_search_result_is(String expList) {
        String actList = dressesPage.extractResultString();
        Assert.assertEquals(actList, expList);
    }

//    SLIDERS:

    @When("User adjusts price using sliders on the dresses page")
    public void user_adjusts_price_using_sliders_on_the_dresses_page() throws InterruptedException {
        System.out.println(" =====> User adjusts sliders at the dresses page <=====");
        dressesPage.moveSlider();
    }

    @Then("Dresses adjusted result is {string}")
    public void dresses_adjusted_result_is(String expResult) {
        String actResult = dressesPage.extractResultString();
        Assert.assertEquals(actResult, expResult);
    }

    @Then("Dresses adjusted search result is {string}")
    public void dresses_adjusted_search_result_is(String expOutOf) {
        String actOutOf = dressesPage.getShowingOut();
        Assert.assertEquals(actOutOf, expOutOf);
    }

//    SORTING:

    @When("User selects sorting by on the dresses page")
    public void user_selects_sorting_by_on_the_dresses_page() throws InterruptedException {
        System.out.println(" =====> User makes sorting at the dresses page <=====");
        dressesPage.selectSort();
    }
    @Then("Dresses sorted result is {string}")
    public void dresses_sorted_result_is(String expResult) {
        String actResult = dressesPage.extractSortString();
        Assert.assertEquals(actResult, expResult);
    }

}

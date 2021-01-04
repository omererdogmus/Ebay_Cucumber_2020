package steps;

import actions.Common_Actions;
import actions.EbayHome_Action;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.fail;

public class EbayHome_Steps {

    Common_Actions common_actions;
    EbayHome_Action ebayHome_action;

    public EbayHome_Steps(Common_Actions common_actions, EbayHome_Action ebayHome_action){
        this.common_actions = common_actions;
        this.ebayHome_action = ebayHome_action;
    }

    @Given("I am on Ebay home page")
    public void i_am_on_ebay_home_page() {
        common_actions.goToUrl("https://www.ebay.com");
    }

    @When("I click on advanced link")
    public void i_click_on_advanced_link() {
        ebayHome_action.clickAdvancedLink();
    }

    @Then("I navigate to advanced search page")
    public void i_navigate_to_advanced_search_page() {
        String expUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actUrl = common_actions.getCurrentPageUrl();
        Assert.assertEquals(actUrl,expUrl);
    }

    @When("I search for {string}")
    public void i_search_for_i_phone(String str) {
        ebayHome_action.searchAnItem(str);
        ebayHome_action.clickSearchButton();
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int count) {
        int itemCountInt = ebayHome_action.getSearchItemCount();
        if(itemCountInt <= count){
            fail("Less than 1000 result shown");
        }
    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String string, String string2) throws Exception {
        ebayHome_action.searchAnItem(string);
        ebayHome_action.selectCategoryOption(string2);
        ebayHome_action.clickSearchButton();
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws Exception {
        ebayHome_action.clickOnLinkByText(string);
        Thread.sleep(1000);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String url, String title) {
       String actUrl = common_actions.getCurrentPageUrl();
       String actTitle = common_actions.getCurrentPageTitle();
       if(!actUrl.equals(url)){
           fail("Page does not navigate to expected url" + url);
       }
       if(!actTitle.contains(title)){
           fail("Title mismatch");
       }
    }

}

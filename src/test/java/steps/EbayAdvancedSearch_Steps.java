package steps;

import actions.Common_Actions;
import actions.EbayAdvancedSearch_Action;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.fail;

public class EbayAdvancedSearch_Steps {

    Common_Actions common_actions;
    EbayAdvancedSearch_Action ebayAdvancedSearch_action;

    public EbayAdvancedSearch_Steps(Common_Actions common_actions,EbayAdvancedSearch_Action ebayAdvancedSearch_action){
       this.common_actions = common_actions;
       this.ebayAdvancedSearch_action = ebayAdvancedSearch_action;
    }

    @Given("I am on Ebay advanced search page")
    public void i_am_on_ebay_advanced_search_page() {
        common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");
    }

    @When("I click on Ebay logo")
    public void i_click_on_ebay_logo() {
        ebayAdvancedSearch_action.clickOnEbayLogo();
    }

    @Then("I am navigated to Ebay home page")
    public void i_am_navigated_to_ebay_home_page() {
        String expUrl = "https://www.ebay.com/";
        String actUrl = common_actions.getCurrentPageUrl();
        if(!expUrl.equals(actUrl)){
            fail("Page does not navigate to home page");
        }
    }

    @When("I advanced search an item")
    public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
        ebayAdvancedSearch_action.enterSearchString(dataTable.cell(1,0));
        ebayAdvancedSearch_action.enterExcludeString(dataTable.cell(1,1));
        ebayAdvancedSearch_action.enterMinPrice(dataTable.cell(1,2));
        ebayAdvancedSearch_action.enterMaxPrice(dataTable.cell(1,3));
        ebayAdvancedSearch_action.clickOnSearchBtn();
    }
}

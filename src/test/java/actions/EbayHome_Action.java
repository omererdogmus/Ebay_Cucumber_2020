package actions;

import elements.EbayHome_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.Common_Steps;

import java.util.List;

public class EbayHome_Action {

    private WebDriver driver;
    EbayHome_Elements ebayHome_elements;

    public EbayHome_Action(Common_Steps common_steps){
        this.driver = common_steps.getDriver();
        ebayHome_elements = new EbayHome_Elements(driver);
    }

    public void clickAdvancedLink(){
        ebayHome_elements.advancedLink.click();
    }

    public void searchAnItem(String searchItem){
        ebayHome_elements.searchBox.sendKeys(searchItem);
    }

    public void clickSearchButton(){
        ebayHome_elements.searchBtn.click();
    }

    public int getSearchItemCount(){
        String itemCount = ebayHome_elements.numOfItems.getText().trim();
        String itemCount2 = itemCount.replace(",","");
        int itemCountInt = Integer.parseInt(itemCount2);
        return itemCountInt;
    }

    public void selectCategoryOption(String option){
        List<WebElement> cat = ebayHome_elements.catOptions;
        for(WebElement x : cat){
            if(x.getText().trim().toLowerCase().equals(option.toLowerCase())){
                x.click();
                break;
            }
        }
    }

    public void clickOnLinkByText(String text){
        driver.findElement(By.linkText(text)).click();
    }

}

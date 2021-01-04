package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbayHome_Elements {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='gh-as-a']") public WebElement advancedLink;
    @FindBy(xpath = "//input[@id='gh-ac']") public WebElement searchBox;
    @FindBy(id = "gh-btn") public WebElement searchBtn;
    @FindBy(css = "h1.srp-controls__count-heading>span.BOLD:first-child") public WebElement numOfItems;
    @FindBy(xpath = "//select[@id='gh-cat']/option") public List<WebElement> catOptions;

    public EbayHome_Elements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Steps {

    private WebDriver driver;

    @Before(order = 1)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Global Before Hook Executed");
    }

    @After(order = 1)
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("Global After Hook Executed");
        Thread.sleep(1000);
    }

    public WebDriver getDriver(){
        return driver;
    }

}

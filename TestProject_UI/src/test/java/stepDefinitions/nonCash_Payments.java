package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import runners.CucumberTestRunner;
import utils.ConfigManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utils.ExtentManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class nonCash_Payments {
    WebDriver driver;
    String baseUrl = CucumberTestRunner.getBaseUrl();
    private ExtentReports extent = ExtentManager.getInstance();
    private ExtentTest test = extent.createTest("TestName");

    @Given("I am on the homepage of the website")
    public void i_navigate_to() throws InterruptedException {

         driver.get(baseUrl);
//        System.out.println("url = " +url);
//        WebDriverManager.chromedriver().setup();
        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(100);
      //  ChromeOptions options = new ChromeOptions();
        String url = "www.google.com";
        driver.get(url);
        test.log(Status.INFO, "Performed action");
    }

    @When("^I click on the \"([^\"]*)\" link$")
    public void i_click_on(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));
        element.click();
    }

    @Then("^I should see the page with the title \"([^\"]*)\"$")
    public void i_verify_that_the_page_displays(String expectedText) {
        // Implementation to verify that the page title contains the specified text
        String actualText = driver.findElement(By.tagName("body")).getText();
        assertEquals(expectedText, actualText);
        test.log(Status.INFO, "Verified result");
    }

    @Then("^I verify that I am taken to the \"([^\"]*)\" section$")
    public void i_verify_that_I_am_taken_to_the_section(String expectedSection) {
        WebElement section = driver.findElement(By.id(expectedSection.toLowerCase().replace(" ", "-")));
        assertTrue(section.isDisplayed());
        test.log(Status.INFO, "Verified result");
    }

    // Implementations for other steps...
}

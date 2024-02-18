package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ConfigManager;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@UI or @API"
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    private static String baseUrl;

    @BeforeClass
    public void setUp() {
        String env = System.getProperty("env");
        baseUrl = ConfigManager.getBaseUrl(env);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}

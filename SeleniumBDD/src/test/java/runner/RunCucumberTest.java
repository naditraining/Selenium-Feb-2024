package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features", // Specify the path to your feature files
        glue = {"org.example.steps","org.example.hooks"}, // Specify the package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        strict = true,
        dryRun = false,
        tags = "@regression"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("testng before method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("my new after method");
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

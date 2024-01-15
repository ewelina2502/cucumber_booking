import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = "C:/Users/EwelinaPajor/IdeaProjects/cucumber_booking/src/test/resources/features")
public class CucumberRunner {
}

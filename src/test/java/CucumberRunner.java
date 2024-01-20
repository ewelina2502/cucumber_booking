import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = "C:/Users/EwelinaPajor/IdeaProjects/cucumber_booking/src/test/resources/features")

//        plugin = {"pretty", "html:target/cucumber-report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
//        features = {"C:/Users/EwelinaPajor/IdeaProjects/cucumber_booking/src/test/resources/features"},
//        tags = ("@Gets"))

public class CucumberRunner {
}

// mvn clean test
// allure serve allure-results
// mvn clean test -Dcucumber.filter.tags="@Gets"
// mvn clean test -Dcucumber.filter.tags="@Gets and @Posts"

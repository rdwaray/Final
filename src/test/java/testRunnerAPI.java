import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            glue = {"API"},
            features = {"src/test/resources/API"},
            plugin = {
                    "pretty",
                    "html:reports/test-report.html",
                    "json:reports/test-report.json"
            }
    )

public class testRunnerAPI {
    }


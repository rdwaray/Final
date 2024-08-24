import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"Web"},
        features = {"src/test/resources/Web"},
        plugin ={
                "pretty",
                "html:build/test-results/webTest/test-report.html",
                "json:build/test-results/webTest/test-report.json"
        }
)

public class testRunnerWeb {

}

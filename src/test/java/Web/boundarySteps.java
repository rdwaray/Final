package Web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class boundarySteps {
    private WebDriver driver = baseTestWeb.getDriver();
    private WebDriverWait wait = baseTestWeb.getWait();


    @Given("User is on register page")
    public void userIsOnRegisterPage() {

        driver.get("https://www.demoblaze.com");
        WebElement signUp = driver.findElement(By.id("signin2"));
        try {
            signUp.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUp);
        }
    }

    @And("User input boundary username with {string}")
    public void userInputBoundaryUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        usernameField.sendKeys(username);
        System.out.println("Request sent with username : " + username);

    }

    @And("User input boundary password with {string}")
    public void userInputBoundaryPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys(password);
        System.out.println("Request sent with password : " + password);
    }

    @When("User click on register button")
    public void userClickOnRegisterButton() {
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
        signUpButton.click();
    }
}

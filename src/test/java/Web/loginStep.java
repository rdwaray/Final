package Web;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginStep extends baseTestWeb {

    private WebDriver driver = baseTestWeb.getDriver();
    private WebDriverWait wait = baseTestWeb.getWait();

    @Given("User in on login form")
    public void userInOnLoginForm() {
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        try {
            loginButton.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton); // Use JavaScript click as fallback
        }

    }

    @And("User input correct username with {string}")
    public void userInputCorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
        System.out.println("Request sent with username : " + username);
    }

    @And("User input correct password with {string}")
    public void userInputCorrectPasswordWith(String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        usernameField.sendKeys(password);
        System.out.println("Request sent with password : " + password);

    }

    @When("User click on login button")
    public void userClickOnLoginButton() {
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#logInModal .btn-primary"));
        loginSubmitButton.click();
    }

    @Then("User is on homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.titleIs("STORE"));
        String title = driver.getTitle();
        System.out.println(title);
    }

    @And("User input incorrect username with {string}")
    public void userInputIncorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
        System.out.println("Request sent with username : " + username);
    }

    @And("User input incorrect password with {string}")
    public void userInputIncorrectPasswordWith(String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        usernameField.sendKeys(password);
        System.out.println("Request sent with password : " + password);
    }

    @And("User see error message")
    public void userSeeErrorMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert = alert.getText();
        System.out.println(textAlert);
        alert.accept();
    }

    @Then("User back to login form")
    public void userBackToLoginForm() {
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModalLabel")));
        System.out.println(loginForm);
    }
}

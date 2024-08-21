package Web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginStep extends baseTest {
    @Before public void setUp(){
        super.setUp();
    }
    @After public void teardown(){
        super.tearDown();
    }

    @Given("User in on login form")
    public void userInOnLoginForm() {
        driver.get("https://www.demoblaze.com/");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginButton.click();
    }

    @And("User input correct username with {string}")
    public void userInputCorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
    }

    @And("User input correct password with {string}")
    public void userInputCorrectPasswordWith(String password) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        usernameField.sendKeys(password);
    }

    @When("User click on login button")
    public void userClickOnLoginButton() {
        WebElement loginSubmitButton = driver.findElement(By.cssSelector("#logInModal .btn-primary"));
        loginSubmitButton.click();
    }

    @Then("User is on homepage")
    public void userIsOnHomepage() {
        wait.until(ExpectedConditions.titleIs("STORE"));
        String title = driver.getTitle();
        System.out.println(title);
    }

    @And("User input incorrect username with {string}")
    public void userInputIncorrectUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys(username);
    }

    @And("User input incorrect password with {string}")
    public void userInputIncorrectPasswordWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        usernameField.sendKeys(username);
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

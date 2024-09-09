package Web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerStep {

    private WebDriver driver = baseTestWeb.getDriver();
    private WebDriverWait wait = baseTestWeb.getWait();

    @Given("User is on the register page")
    public void userIsOnTheRegisterPage() {
        driver.get("https://www.demoblaze.com");
        WebElement signUp = driver.findElement(By.id("signin2"));
        try {
            signUp.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUp);
        }
    }

    @And("Register username with {string}")
    public void registerUsernameWith(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        usernameField.sendKeys(username);
        System.out.println("Request sent with usename : " + username);

    }

    @And("Register password with {string}")
    public void registerPasswordWith(String password) {
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys(password);
        System.out.println("Request sent with password : " + password);

    }

    @When("User click  register button")
    public void userClickRegisterButton() {
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
        signUpButton.click();
    }

    @Then("User receives alert register successfull")
    public void userReceivesAlertRegisterSuccessfull() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert2 = alert.getText();
        System.out.println(textAlert2);
        alert.accept();
    }

    @And("User see error register message")
    public void userSeeErrorRegisterMessage() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String textAlert2 = alert.getText();
        System.out.println(textAlert2);
        alert.accept();
    }
}

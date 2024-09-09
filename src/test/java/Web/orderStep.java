package Web;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class orderStep {

    private WebDriver driver = baseTestWeb.getDriver();
    private WebDriverWait wait = baseTestWeb.getWait();


    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[contains(text(), 'Purchase')]");
    private By alert = By.xpath("//div[contains(@class, 'alert')]");


    @Given("User is on the order page")
    public void userIsOnTheOrderPage() {
        driver.get("https://www.demoblaze.com/cart.html");
        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
        try {
            signUp.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUp);
        }

    }

    @Then("User places an order with details:")
    public void userPlacesAnOrderWithDetails(DataTable dataTable) {
        // Extract data from the table
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);

        String name = data.get("Name");
        String country = data.get("Country");
        String city = data.get("City");
        String card = data.get("CreditCardNumber");
        String month = data.get("ExpiryMonth");
        String year = data.get("ExpiryYear");

        WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        if (name != null && !name.isEmpty()) {
            nameFieldElement.sendKeys(name);
        }

        WebElement countryFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countryField));
        countryFieldElement.sendKeys(country);
        if (country != null && !country.isEmpty()) {
            countryFieldElement.sendKeys(country);
        }

        WebElement cityFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        if (city != null && !city.isEmpty()) {
            cityFieldElement.sendKeys(city);
        }
        WebElement cardFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cardField));
        if (card != null && !card.isEmpty()) {
            cardFieldElement.sendKeys(card);
        }
        WebElement monthFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(monthField));
        if (month != null && !month.isEmpty()) {
            monthFieldElement.sendKeys(month);
        }
        WebElement yearFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(yearField));
        if (year != null && !year.isEmpty()) {
            yearFieldElement.sendKeys(year);
        }
        System.out.println("Request sent with name : " + name);
        System.out.println("Request sent with country : " + country);
        System.out.println("Request sent with city : " + city);
        System.out.println("Request sent with card : " + card);
        System.out.println("Request sent with month : " + month);
        System.out.println("Request sent with year : " + year);

    }

    @And("User click on order button")
    public void userClickOnOrderButton() {
        WebElement purchaseButtonElement = driver.findElement(purchaseButton);
        purchaseButtonElement.click();
    }

    @Then("User receives message order succesfull")
    public void userReceivesMessageOrderSuccesfull() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/h2")));
        String text = element.getText();
        System.out.println("Alert : " + text);
    }

    @Then("User receives message order unsuccesfull")
    public void userReceivesMessageOrderUnsuccesfull() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
    }
}

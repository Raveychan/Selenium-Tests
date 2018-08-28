package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/google.feature"
        ,glue= {"src/test/java/steps/google_steps.js"}
)

public class google_steps {

    private JavascriptExecutor jse;
    public static WebDriver driver;

    @Given("^I enter the website googlemail$")
    public void i_enter_the_website_googlemail() throws Throwable {
        System.setProperty("webdriver.gecko.driver","D:/QA/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/gmail/");
    }

    @When("^I fill in login form$")
    public void i_fill_in_login_form() throws Throwable {
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
        email.click();
        email.sendKeys("youremail");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
        submitButton.click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        Thread.sleep(1000);
        password.click();
        password.sendKeys("yourpassword");
        Thread.sleep(1000);
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]"));
        nextButton.click();
    }

    @Then("^I am logged in$")
    public void i_am_logged_in_on_googlemail() throws Throwable {
        Thread.sleep(1500);
        boolean isTheTextPresent = driver.getPageSource().contains("#inbox");
        assertTrue(isTheTextPresent);
    }
    /*````````````````````````````````````````````````````````````````````````````````````````````````````````````````*/
    @Given("^I am logged in on googlemail$")
    public void i_am_logged_in_on_googlemail2() throws Throwable {
        Thread.sleep(1000);
        boolean isTheTextPresent = driver.getPageSource().contains("#inbox");
        assertTrue(isTheTextPresent);
    }

    @When("^I compose and send an email$")
    public void i_compose_and_send_an_email() throws Throwable {
        Thread.sleep(1000);
        WebElement newMail = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div"));
        newMail.click();
        Thread.sleep(1000);
        WebElement mailTo = driver.findElement(By.id(":cd"));
        Thread.sleep(500);
        mailTo.click();
        mailTo.clear();
        Thread.sleep(500);
        mailTo.sendKeys("mailtoEMAIL");
        WebElement mailToPerson = driver.findElement(By.id(":fv"));
        Thread.sleep(500);
        mailToPerson.click();
        WebElement mailSubject = driver.findElement(By.id(":bv"));
        Thread.sleep(500);
        mailSubject.click();
        mailSubject.clear();
        Thread.sleep(500);
        mailSubject.sendKeys("Selenium test");
        WebElement mailText = driver.findElement(By.id(":d0"));
        Thread.sleep(500);
        mailText.click();
        mailText.clear();
        Thread.sleep(500);
        mailText.sendKeys("Just a test.");
        WebElement buttonSend = driver.findElement(By.id(":bl"));
        Thread.sleep(500);
        buttonSend.click();
    }

    @Then("^I am shown a success message$")
    public void i_am_shown_a_success_message() throws Throwable {
        Thread.sleep(1000);
        WebElement successMessage = driver.findElement(By.className("vh"));
        successMessage.isDisplayed();
        Thread.sleep(1500);
        String expected = "Wiadomość została wysłana.";
        String actual = successMessage.getText();
        assertTrue(actual.contains(expected));
    }
}


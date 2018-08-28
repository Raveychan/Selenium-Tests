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

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/mossery.feature"
        ,glue= {"src/test/java/steps/mossery_steps.js"}
)

public class mossery_steps {

    private JavascriptExecutor jse;
    public static WebDriver driver;

    @Given("^I enter the website$")
    public void i_enter_the_website() throws Throwable {
        System.setProperty("webdriver.gecko.driver","D:/QA/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mossery.co/");
    }

    @When("^I search for an item and select it$")
    public void i_search_for_an_item_and_select_it() throws Throwable {
        Thread.sleep(1500);
        WebElement buttonShop = driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul[1]/li[1]/a"));
        buttonShop.click();
        Thread.sleep(1000);
        WebElement submenuSketchbook = driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul[1]/li[1]/ul/li[2]/a"));
        submenuSketchbook.click();
        Thread.sleep(1000);
        jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 800)");
        Thread.sleep(1000);
        WebElement item = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div/div/div/div[10]/div/a"));
        Thread.sleep(1000);
        item.click();
    }

    @Then("^I choose preferred options$")
    public void i_choose_preferred_options() throws Throwable {
        WebElement textPaper = driver.findElement(By.xpath("//*[@id=\"product-select-option-1\"]"));
        textPaper.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[1]/div[2]/div[2]/form/div[1]/div/div[2]/select/option[2]")).click();
        WebElement namePersona = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[1]/div[2]/div[2]/form/div[2]/div/div[2]/label/span[2]/input"));
        namePersona.click();
        namePersona.sendKeys("Gotven");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[1]/div[2]/div[2]/form/div[2]/div/div[3]/span[2]/span[1]/label/span[1]/input")).click();
    }

    @Then("^I add item to cart$")
    public void i_add_item_to_cart() throws Throwable {
        WebElement buttonAddToCart = driver.findElement(By.xpath("//*[@id=\"purchase\"]"));
        buttonAddToCart.submit();
        WebElement buttonPopup = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/button"));
        buttonPopup.click();
        WebElement buttonCart = driver.findElement(By.xpath("/html/body/div[1]/nav/div/div[2]/ul[2]/li[2]/a"));
        buttonCart.click();
        WebElement item_exist = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div[1]/form/div[1]/div/table/tbody/tr"));
        item_exist.isDisplayed();
    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Given("^I am in a cart and click checkout$")
    public void i_am_in_a_cart_and_click_checkout() throws Throwable {
        WebElement buttonCheckout = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section/div/div[1]/form/div[2]/div[2]/input"));
        Thread.sleep(1500);
        buttonCheckout.click();
    }

    @When("^I fill in checkout form$")
    public void i_fill_in_checkout_form() throws Throwable {
        Thread.sleep(2000);
        WebElement formEmail = driver.findElement(By.xpath("//*[@id=\"checkout_email\"]"));
        formEmail.click();
        formEmail.clear();
        Thread.sleep(500);
        formEmail.sendKeys("sara.testingqa@gmail.com");
        WebElement formFirstName = driver.findElement(By.id("checkout_shipping_address_first_name"));
        formFirstName.click();
        formFirstName.clear();
        Thread.sleep(500);
        formFirstName.sendKeys("Sara");
        WebElement formLastName = driver.findElement(By.id("checkout_shipping_address_last_name"));
        formLastName.click();
        formLastName.clear();
        Thread.sleep(500);
        formLastName.sendKeys("Testing");
        WebElement formCompany = driver.findElement(By.id("checkout_shipping_address_company"));
        formCompany.click();
        formCompany.clear();
        Thread.sleep(500);
        formCompany.sendKeys("Selenium");
        WebElement formAddress1 = driver.findElement(By.id("checkout_shipping_address_address1"));
        formAddress1.click();
        formAddress1.clear();
        Thread.sleep(500);
        formAddress1.sendKeys("4 Argyle Street");
        WebElement formAddress2 = driver.findElement(By.id("checkout_shipping_address_address2"));
        formAddress2.click();
        formAddress2.clear();
        Thread.sleep(500);
        formAddress2.sendKeys("Home");
        WebElement formCity = driver.findElement(By.id("checkout_shipping_address_city"));
        formCity.click();
        formCity.clear();
        Thread.sleep(500);
        formCity.sendKeys("Rugby");
        WebElement formCountry = driver.findElement(By.id("checkout_shipping_address_country"));
        formCountry.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/form/div[1]/div[2]/div[2]/div/div[7]/div/select/option[1]")).click();
        Thread.sleep(1000);
        formCountry.click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/form/div[1]/div[2]/div[2]/div/div[7]/div/select/option[2]")).click();
        Thread.sleep(500);
        WebElement formZip = driver.findElement(By.id("checkout_shipping_address_zip"));
        formZip.click();
        formZip.clear();
        Thread.sleep(500);
        formZip.sendKeys("CV21 3NB");
        WebElement formPhone = driver.findElement(By.id("checkout_shipping_address_phone"));
        formPhone.click();
        formPhone.clear();
        Thread.sleep(500);
        formPhone.sendKeys("7426879327");
        WebElement buttonSubmit = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/button"));
        Thread.sleep(1000);
        buttonSubmit.submit();
    }

    @Then("^I choose my shipping method$")
    public void i_choose_my_shipping_method() throws Throwable {
        Thread.sleep(1500);
        WebElement shipping = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/form/div[1]/div[2]/div[2]/fieldset/div[1]/div/label/span[1]"));
        shipping.click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/form/div[2]/button")).submit();
    }

    @Then("^I am redirected to pay form$")
    public void i_am_redirected_to_pay_form() throws Throwable {
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/form/div[2]/div[2]/fieldset/div[1]/label")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/form/div[3]/div[1]/button")).submit();
        WebElement paypalLogo = driver.findElement(By.className("paypal-logo"));
        Thread.sleep(1000);
        paypalLogo.isDisplayed();
    }
}

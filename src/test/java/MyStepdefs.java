import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class MyStepdefs {


    private WebDriver driver;
    private WebDriverWait wait;

    private void sendKeys(WebDriver driver, By by, String text) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

        element.sendKeys(text);

    }

    private String randomEmail(String Mail) {
        Mail = "@gmail.com";
        StringBuilder string = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

        for (int i = 0; i < letters.length(); i++) {
            string.append(letters.charAt((int) Math.floor(Math.random() * letters.length())));
        }
        return string.toString() + Mail;


    }

    private String randomusername() {
        StringBuilder string = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

        for (int i = 0; i < letters.length(); i++) {
            string.append(letters.charAt((int) Math.floor(Math.random() * letters.length())));
        }
        return string.toString();
    }

    @Given("user start a {string}")
    public void iStartA(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\selenium\\edgedriver.exe");
            driver = new EdgeDriver();

        }

    }

    @And("user navigate to {string}")
    public void iNavigateTo(String webSite) {
        driver.get(webSite);
        driver.manage().window().maximize();

    }

    @When("user types in a email {string}")
    public void userTypesInAEmail(String Mail) throws InterruptedException {
        sendKeys(driver, By.id("email"), Mail);
        if (Mail.equalsIgnoreCase("apa")) {
            sendKeys(driver, By.id("email"), randomEmail(Mail));
        }
        if (Mail.equalsIgnoreCase("")) {

            sendKeys(driver, By.id("email"), Mail);

        }

    }

    @When("user types in a username {}\"")
    public void userTypesInAUsername(String Username) throws InterruptedException {
        WebElement clear = driver.findElement(By.id("new_username"));
        clear.click();
        clear.clear();
        sendKeys(driver, By.id("new_username"), Username);
        if (Username.equalsIgnoreCase("dfgdfghfdghcvb")) {

            sendKeys(driver, By.id("new_username"), randomusername());
        }

        if (Username.equalsIgnoreCase("EEEEEEEEElektrifieradeDrakensFlammaSprakarHogtOchBelyserMorkretrSomEnMajestatiskFyrverkeriShow")) {

            sendKeys(driver, By.id("new_username"), Username);

        }
        if (Username.equalsIgnoreCase("jkadjkajsjdkajsh")) {

            sendKeys(driver, By.id("new_username"), Username);

        }
        if (Username.equalsIgnoreCase("jkadjkajsdkfdgajs")) {

            sendKeys(driver, By.id("new_username"), randomusername());

        }
    }


    @When("user types in a password {}\"")
    public void userTypesInAPassword(String password) {
        sendKeys(driver, By.id("new_password"), password);

    }


    @Then("user can {string}")
    public void userCan(String Signup) throws InterruptedException {
        WebElement signup = driver.findElement(By.cssSelector("#create-account-enabled"));
        signup.click();
        signup.click();


        if (Signup.equalsIgnoreCase("yes")) {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resend-email-link")));
            String expected = "Check your email";
            String actual = driver.findElement(By.cssSelector("#signup-success > div > div.content.line.section > section > div > h1")).getText();

            assertEquals(expected, actual);
        }
        if (Signup.equalsIgnoreCase("no")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")));
            String expected = "Enter a value less than 100 characters long";
            String actual = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span")).getText();

            assertEquals(expected, actual);
        }
        if (Signup.equalsIgnoreCase("fail")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span > a")));
            String expected = "log in";
            String actual = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span > a")).getText();

            assertEquals(expected, actual);
        }
        if (Signup.equalsIgnoreCase("nej")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#signup-form > fieldset > div:nth-child(1) > div > span")));
            String expected = "An email address must contain a single @.";
            String actual = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(1) > div > span")).getText();
            assertEquals(expected, actual);

        }
    }

    @After
    public void exit() {
        driver.close();
        driver.quit();

    }

}
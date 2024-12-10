package stepDefinitions;




import helperFunctions.StartStop;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Login_Steps {
    private ChromeDriver testDriver;

    @Before("@loginFeature")
    public void before() {
        testDriver = StartStop.createDriver(testDriver);

    }

    @After("@loginFeature")
    public void tearDown() {

        StartStop.closeDriver(testDriver);
    }


    @Given("access the webdriver university login page")
    public void access_the_webdriver_university_login_page() {
        testDriver.get("https://www.webdriveruniversity.com/Login-Portal/index.html");

    }
    @When("insert correct user name {word}")
    public void insert_correct_user_name_webdriver(String userName) {
       testDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
    }
    @And("insert correct password {word}")
    public void insert_correct_password_webdriver123(String userPassword) {
        testDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(userPassword);
    }
    @And("click Login button")
    public void click_login_button() {
        testDriver.findElement(By.xpath("//button[@id='login-button']")).click();
    }
    @Then("verify message {string} is present")
    public void verify_message_is_present(String string) {
        Assert.assertEquals(string,testDriver.switchTo().alert().getText());
        testDriver.switchTo().alert().accept();

    }
    @Then("verify message is present {}")
    public void verify_message_is_present_validation_succeeded(String expectedMessage) {
        Assert.assertEquals(expectedMessage,testDriver.switchTo().alert().getText());
        testDriver.switchTo().alert().accept();
    }



}

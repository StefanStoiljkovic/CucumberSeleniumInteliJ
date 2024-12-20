package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private ChromeDriver driver;



    @Before("@contact-us")
    public void before() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @After("@contact-us")
    public void tearDown() throws InterruptedException {
        driver.quit();
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN");
    }

    @And("I enter unique last name")
    public void i_enter_unique_last_name() {
        String no = generateRandomNumber(10);
        System.out.println(no);
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + no );
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys( "AutoEmail" + generateRandomNumber(10)+ "@mail.com");
    }

    @And("I enter unique comment")
    public void i_enter_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys( "Comment" + generateRandomNumber(10));
    }

    @And("I enter a specific name {word}")
    public void i_enter_a_specific_name_word(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_word(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName );
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_word(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys( email);
    }
    @And("I enter a specific message {string}")
    public void i_enter_a_specific_message(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(message.getText(), "Thank You for your Message!");
    }


}

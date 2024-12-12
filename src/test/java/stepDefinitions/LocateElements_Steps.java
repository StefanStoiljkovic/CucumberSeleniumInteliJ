
package stepDefinitions;

import helperFunctions.ElementsFunctions;
import helperFunctions.StartStop;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import data.ElementsPaths;

public class LocateElements_Steps {
    private ChromeDriver testDriver;

    @Before("@ElementsFeature")
    public void before() {
        testDriver = StartStop.createDriver(testDriver);
    }

    @After("@ElementsFeature")
    public void tearDown() {
        StartStop.closeDriver(testDriver);
    }

    @Given("access the webdriver letskodeit page")
    public void access_the_webdriver_university_login_page() {
        testDriver.get(ElementsPaths.url);
    }
    @And("Get name by element option")
    public void get_name_by_element_option() {
        //find by id
        System.out.println("-->Role:" + ElementsFunctions.getWebElement(testDriver,By::id,ElementsPaths.idFormButtons).getAriaRole());

        //find by name
        System.out.println("-->Role:" + ElementsFunctions.getWebElement(testDriver,By::name,ElementsPaths.inputEnterName).getAriaRole());

        // by css xpath with id #
        System.out.println("-->Role:" + ElementsFunctions.getWebElement(testDriver,By::cssSelector,ElementsPaths.xpathCSSInputDisplayedText).getAriaRole());

        // by css xpath with className .
        System.out.println("-->Role:" + ElementsFunctions.getWebElement(testDriver,By::cssSelector,ElementsPaths.xpathCSSInputDisplayedClass).getAriaRole());

    }
}

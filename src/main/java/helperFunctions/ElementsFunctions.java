package helperFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsFunctions {

    public static WebElement getWebElement(WebDriver driver, LocatorFunction locatorFunction, String elementDefinition) {
        return driver.findElement(locatorFunction.apply(elementDefinition));
    }

    public interface LocatorFunction {
        By apply(String value);
    }
}

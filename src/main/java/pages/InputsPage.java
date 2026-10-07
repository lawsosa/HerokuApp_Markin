package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputsPage {

    private final WebDriver browserDriver;
    private final WebDriverWait explicitWait;

    private static final String PAGE_LINK = "http://the-internet.herokuapp.com/inputs";

    private final By inputFieldLocator = By.cssSelector("div.example input");

    public InputsPage(WebDriver driverInstance) {
        this.browserDriver = driverInstance;
        this.explicitWait = new WebDriverWait(driverInstance, Duration.ofSeconds(10));
    }

    public void open() {
        browserDriver.get(PAGE_LINK);
    }

    private WebElement getInputElement() {
        return browserDriver.findElement(inputFieldLocator);
    }

    public void enterValue(String value) {
        getInputElement().sendKeys(value);
    }

    public String getValue() {
        return getInputElement().getAttribute("value");
    }

    public void pressArrowUp() {
        getInputElement().sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        getInputElement().sendKeys(Keys.ARROW_DOWN);
    }

    public void clearInput() {
        getInputElement().clear();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private final WebDriver webDriver;
    private final WebDriverWait waitTimer;
    private static final String SITE_URL = "http://the-internet.herokuapp.com/dropdown";

    private final By selectElement = By.cssSelector("select#dropdown");

    public DropdownPage(WebDriver driverInstance) {
        this.webDriver = driverInstance;
        this.waitTimer = new WebDriverWait(driverInstance, Duration.ofSeconds(10));
    }

    public void open() {
        webDriver.get(SITE_URL);
    }

    private Select getSelectComponent() {
        return new Select(webDriver.findElement(selectElement));
    }

    public List<String> getAllOptions() {
        return getSelectComponent().getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectOption1() {
        getSelectComponent().selectByValue("1");
    }

    public void selectOption2() {
        getSelectComponent().selectByValue("2");
    }

    public boolean isOption1Selected() {
        WebElement selectedOpt = getSelectComponent().getFirstSelectedOption();
        return "1".equals(selectedOpt.getAttribute("value"));
    }

    public boolean isOption2Selected() {
        WebElement selectedOpt = getSelectComponent().getFirstSelectedOption();
        return "2".equals(selectedOpt.getAttribute("value"));
    }
}
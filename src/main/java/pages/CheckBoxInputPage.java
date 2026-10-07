package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBoxInputPage {
    private final WebDriver browser;
    private final WebDriverWait waiter;

    private static final String PAGE_URL = "http://the-internet.herokuapp.com/checkboxes";

    private final By firstCheckbox = By.xpath("(//input[@type='checkbox'])[1]");
    private final By secondCheckbox = By.xpath("(//input[@type='checkbox'])[2]");

    public CheckBoxInputPage(WebDriver driver) {
        this.browser = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        browser.get(PAGE_URL);
    }

    public boolean isFirstCheckBoxChecked() {
        return browser.findElement(firstCheckbox).isSelected();
    }

    public void clickFirstBox() {
        waiter.until(ExpectedConditions.elementToBeClickable(firstCheckbox)).click();
    }

    public boolean isSecondCheckBoxChecked() {
        return browser.findElement(secondCheckbox).isSelected();
    }

    public void clickSecondBox() {
        waiter.until(ExpectedConditions.elementToBeClickable(secondCheckbox)).click();
    }
}
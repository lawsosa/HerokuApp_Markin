package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRemoveElementsPage {
    private final WebDriver webDriver;
    private final WebDriverWait waitDriver;
    private static final String PAGE_URL = "http://the-internet.herokuapp.com/add_remove_elements/";

    private final By addBtn = By.cssSelector("button[onclick='addElement()']");
    private final By deleteBtn = By.xpath("//button[contains(@class, 'added-manually')]");

    public AddRemoveElementsPage(WebDriver driverInstance) {
        this.webDriver = driverInstance;
        this.waitDriver = new WebDriverWait(driverInstance, Duration.ofMillis(10000));
    }

    public void navigateToPage() {
        webDriver.get(PAGE_URL);
    }

    public void clickAddButton() {
        WebElement button = waitDriver.until(ExpectedConditions.elementToBeClickable(addBtn));
        button.click();
    }

    public int getDeleteButtonsCount() {
        return webDriver.findElements(deleteBtn).size();
    }
}
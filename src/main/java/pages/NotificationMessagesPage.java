package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationMessagesPage {

    private final WebDriver browserInstance;
    private final WebDriverWait pageWait;

    private static final String NOTIFICATION_URL = "http://the-internet.herokuapp.com/notification_message";

    private final By actionLink = By.xpath("//div[@class='example']//a[text()='Click here']");
    private final By flashMessage = By.xpath("//div[@id='flash']");

    public NotificationMessagesPage(WebDriver driver) {
        this.browserInstance = driver;
        this.pageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        browserInstance.get(NOTIFICATION_URL);
    }

    public void clickNotificationLink() {
        pageWait.until(ExpectedConditions.elementToBeClickable(actionLink)).click();
    }

    public String getNotificationText() {
        WebElement messageElement = pageWait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return messageElement.getText();
    }
}
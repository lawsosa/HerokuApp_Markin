package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TyposPage {

    private final WebDriver browser;
    private final WebDriverWait waiter;

    private static final String PAGE_ADDRESS = "http://the-internet.herokuapp.com/typos";

    private final By paragraphSelector = By.xpath("//div[@class='example']/p[2]");

    public TyposPage(WebDriver driverInstance) {
        this.browser = driverInstance;
        this.waiter = new WebDriverWait(driverInstance, Duration.ofSeconds(10));
    }

    public void open() {
        browser.get(PAGE_ADDRESS);
    }

    public String getTypoParagraphText() {
        WebElement targetParagraph = waiter.until(
                ExpectedConditions.visibilityOfElementLocated(paragraphSelector)
        );
        return targetParagraph.getText();
    }
}
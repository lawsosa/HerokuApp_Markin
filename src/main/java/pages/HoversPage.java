package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoversPage {

    private final WebDriver webDriver;
    private final WebDriverWait jsWait;
    private final Actions mouseActions;

    private static final String PAGE_ADDRESS = "http://the-internet.herokuapp.com/hovers";

    private final By avatarFigures = By.xpath("//div[@class='figure']");

    public HoversPage(WebDriver browserDriver) {
        this.webDriver = browserDriver;
        this.jsWait = new WebDriverWait(browserDriver, Duration.ofSeconds(10));
        this.mouseActions = new Actions(browserDriver);
    }

    public void open() {
        webDriver.get(PAGE_ADDRESS);
    }

    public void hoverOverProfile(int number) {
        WebElement targetFigure = webDriver.findElements(avatarFigures).get(number);
        mouseActions.moveToElement(targetFigure).perform();
    }

    public String getProfileName(int number) {
        String nameSelector = String.format("div.figure:nth-of-type(%d) .figcaption h5", number + 1);
        return jsWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(nameSelector))).getText();
    }

    public void clickProfileLink(int number) {
        String linkSelector = String.format("div.figure:nth-of-type(%d) .figcaption a", number + 1);
        jsWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(linkSelector))).click();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }
}
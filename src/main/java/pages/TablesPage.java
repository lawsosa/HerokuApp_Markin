package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TablesPage {

    private final WebDriver browserRef;
    private final WebDriverWait timeOut;

    private static final String TARGET_URL = "http://the-internet.herokuapp.com/tables";

    public TablesPage(WebDriver driver) {
        this.browserRef = driver;
        this.timeOut = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        browserRef.get(TARGET_URL);
    }

    public String getCell(int row, int column) {
        String cellCssSelector = String.format("table:nth-of-type(1) tr:nth-child(%d) td:nth-child(%d)", row, column);

        return browserRef.findElement(By.cssSelector(cellCssSelector)).getText();
    }
}
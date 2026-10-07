package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver webDriver;
    protected WebDriverWait explicitWait;

    @BeforeMethod
    public void initBrowser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

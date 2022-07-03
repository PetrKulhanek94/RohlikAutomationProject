package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SeleniumDriver {

    protected final ConfigurationManager configurationManager = ConfigurationManager.getInstance();

    public WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    protected Actions getActions() {
        return new Actions(driver);
    }

    protected WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
}

package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.SeleniumDriver;

import java.time.Duration;

import static pages.mainPage.MAIN_PAGE_COOKIEBOX_XPATH;

public class BuyProduct extends SeleniumDriver {

    @BeforeTest
    void dataClear(){
        driver.get(url);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_COOKIEBOX_XPATH)));
        WebElement cookieBoxAllow = driver.findElement(By.xpath(MAIN_PAGE_COOKIEBOX_XPATH));
        actions.doubleClick(cookieBoxAllow).perform();
    }

    @Test
    void BuyProduct(){

    }
}

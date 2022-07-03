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
import java.util.List;

import static pages.mainPage.*;
import static pages.rohlicekPage.*;

public class BuyProduct extends SeleniumDriver {

    @BeforeTest
    void dataClear() throws InterruptedException {
        driver.get(configurationManager.getUrl());
        var actions = getActions();
        var wait = getWait(10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_COOKIEBOX_XPATH)));
        WebElement cookieBoxAllow = driver.findElement(By.xpath(MAIN_PAGE_COOKIEBOX_XPATH));
        actions.doubleClick(cookieBoxAllow).perform();

        driver.findElement(By.xpath(MAIN_PAGE_LOGIN_XPATH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_LOGIN_MODAL_XPATH)));

        driver.findElement(By.id(MINA_PAGE_LOGIN_USERNAME_ID)).sendKeys(configurationManager.getUserName());
        driver.findElement(By.id(MINA_PAGE_LOGIN_PASSWORD_ID)).sendKeys(configurationManager.getPassword());
        driver.findElement(By.xpath(MAIN_PAGE_LOGIN_BTN_XPATH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_AVATAR_XPATH)));

        //POKUD EXISTUJE MEMBERSHIP, PROVEDE SE CANCEL
        List<WebElement> element = driver.findElements(By.xpath(MAIN_PAGE_MEMBERSHIP_ACTIVE_XPATH));
        System.out.println(element.size());
        if (element.size()==0) {
            System.out.println("No active membership");
        } else {
            driver.get(configurationManager.getUrlRohlicek());
            driver.findElement(By.xpath(ROHLICEK_CANCELATION_OF_MEMBERSHIP_XPATH)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ROHLICEK_CONFIRMATION_OF_CANCELATION_XPATH))).click();
        }
    }

    @Test
    void BuyProduct(){

    }
}

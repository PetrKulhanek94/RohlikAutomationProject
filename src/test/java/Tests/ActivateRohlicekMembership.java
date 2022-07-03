package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.SeleniumDriver;

import java.util.List;

import static pages.mainPage.*;
import static pages.myProfile.MY_PROFILE_ROHLICEK_STATUS;
import static pages.rohlicekPage.*;

public class ActivateRohlicekMembership extends SeleniumDriver {

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
    void membershipActivation (){
        driver.get(configurationManager.getUrlRohlicek());
        var wait = getWait(10);
        driver.findElement(By.xpath(ROHLICEK_GET_MEMBERSHIP_XPATH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ROHLICEK_MODAL_AFTER_MEMBERSHIP_XPATH))).click();
        driver.findElement(By.xpath(ROHLICEK_I_HAVE_KIDS_UNDER_12_XPATH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ROHLICEK_I_HAVE_A_BOY_XPATH))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ROHLICEK_CHILD_FORM_XPATH)));
        driver.findElement(By.id(ROHLICEK_CHILD_NAME_ID)).sendKeys(configurationManager.getChildName());
        driver.findElement(By.name(ROHLICEK_CHILD_DOB_XPATH)).click();
        driver.findElement(By.name(ROHLICEK_CHILD_DOB_XPATH)).sendKeys(configurationManager.getDateOfBirth());
        driver.findElement(By.id(ROHLICEK_CHILD_NAME_ID)).click();
        driver.findElement(By.xpath(ROHLICEK_REGISTER_BTN_XPATH)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ROHLICEK_CONFIRMATION_MODAL_BTN_GO_SHOPPING_XPATH))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_AVATAR_XPATH))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIN_PAGE_MY_PROFILE_XPATH))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MY_PROFILE_ROHLICEK_STATUS)));
        WebElement activeRohlicek = driver.findElement(By.xpath(MY_PROFILE_ROHLICEK_STATUS));
        Assert.assertEquals(true, activeRohlicek.isDisplayed());
        driver.quit();
    }
}

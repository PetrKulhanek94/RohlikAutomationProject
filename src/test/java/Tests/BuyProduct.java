package Tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.SeleniumDriver;

public class BuyProduct extends SeleniumDriver {



    @BeforeTest
    void dataClear(){
        driver.get(url);
        var actions = new Actions(driver);
    }

    @Test
    void BuyProduct(){

    }
}

package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebPageUtilities {


//    public WebDriverWait wait;
    private WebDriver driver;

    public WebPageUtilities(WebDriver driver){
        this.driver=driver;
    }


    public void waitForElementPresent(WebElement element,long timeInSec){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementPresent(By by, long timeInSec){

        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
}

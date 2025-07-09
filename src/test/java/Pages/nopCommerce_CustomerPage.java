package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class nopCommerce_CustomerPage {

    WebDriver driver;
    WebDriverWait wb;

    By CustomerDropdownleftnav=By.xpath("(//div[@class='sidebar']//p[contains(text(),'Customers')])[1]");
    By customerOPtions=By.xpath("(//div[@class='sidebar']//ul[@class='nav nav-treeview']//p[contains(text(),'Customers')])[1]");


    public nopCommerce_CustomerPage(WebDriver driver){
             this.driver=driver;
             wb= new WebDriverWait(driver, Duration.ofSeconds(3000));
    }

    public void navigateToCustomerPage(){

        driver.findElement(CustomerDropdownleftnav).click();
        wb.until(ExpectedConditions.visibilityOfElementLocated(customerOPtions)).click();


    }
}

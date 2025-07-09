package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class nopCommerce_LoginPage extends BasePage{


     By usernamelocator=By.cssSelector("input#Email");
     By pwdlocator=By.cssSelector("input#Password");
     By signInBtnlocator =By.xpath("//button[text()='Log in']");


     public nopCommerce_LoginPage(WebDriver driver){
          this.driver=driver;
//          wait= new WebDriverWait(driver, Duration.ofSeconds(3000));
     }


     public void lanchnopCommerceApp(String url){

          driver.get(url);
     }


     public void loginTonopCommerce(String username, String pwd){

             driver.findElement(usernamelocator).clear();
             driver.findElement(usernamelocator).sendKeys(username);
             driver.findElement(pwdlocator).clear();
             driver.findElement(pwdlocator).sendKeys(pwd);
             driver.findElement(signInBtnlocator).click();
     }

     public String getTitle(){
         return driver.getTitle();
     }


}

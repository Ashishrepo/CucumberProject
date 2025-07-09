package Pages;

import Utilities.WebPageUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoWebShopHomePage {

    private final WebDriver driver;
    private WebPageUtilities wp;
   private Properties prop = null;



    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginLink;

    By ll=By.xpath("//a[@class='ico-login']");

    @FindBy(xpath = "//input[@class=\"email\"]")
    WebElement usernameTxt;

      By ur=By.xpath("//input[@class=\"email\"]");

    @FindBy(xpath = "//input[@class=\"password\"]")
    WebElement passwdTxt;

    @FindBy(xpath = "//input[@class=\"button-1 login-button\"]")
    WebElement LoginBtn;


    @FindBy(css = "a.ico-logout")
    WebElement logoutBtn;


    public DemoWebShopHomePage(WebDriver driver) throws IOException {
        this.driver=driver;
        wp= new WebPageUtilities(driver);
        prop=new Properties();
        prop.load(new FileInputStream("src/test/Resource/config.properties"));

        PageFactory.initElements(driver,this);

    }

    public void launchDemoApp(){

        driver.get(prop.getProperty("DemoWebShopURL"));
    }

    public void loginToDemoApp() throws InterruptedException {

        loginLink.click();
        new WebPageUtilities(driver).waitForElementPresent(ur,5);
        usernameTxt.sendKeys("lakshit2025@gmail.com");
        passwdTxt.sendKeys("Lakshit@2025");
        LoginBtn.click();

    }

    public void logoutFromDemoApp() throws InterruptedException {

       logoutBtn.click();
        new WebPageUtilities(driver).waitForElementPresent(ll,5);
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }

}

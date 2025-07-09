package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.*;

import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public static Logger logger;
    public Properties properties;



    public String generateRandomString(){

        return RandomStringUtils.randomAlphabetic(6);
    }

}

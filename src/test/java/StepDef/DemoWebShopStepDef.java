package StepDef;

import Pages.BasePage;
import Pages.DemoWebShopHomePage;
import Pages.DemoWebShopRegisterPage;
import Utilities.WebPageUtilities;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DemoWebShopStepDef extends BasePage {

    private DemoWebShopHomePage ds;
    public WebPageUtilities webPageUtilities;
    private DemoWebShopRegisterPage demoWebShopRegisterPage;

    @Before
    public void setup() throws IOException {

        logger = Logger.getLogger(DemoWebShopStepDef.class);
        PropertyConfigurator.configure("log4j.properties");

        properties = new Properties();
        properties.load(new FileInputStream("src/test/Resource/config.properties"));


        // browser from Properties file

        if (properties.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (properties.getProperty("browser").equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser");
        }

        // Initialize object for WebPage Utility class

        webPageUtilities = new WebPageUtilities(driver);
    }


    @Given("User is at DemoWebShop Home Page")
    public void user_is_at_demo_web_shop_home_page() throws IOException {

        logger.info("********* Launch Demo Web shop**************");
        ds = new DemoWebShopHomePage(driver);
        ds.launchDemoApp();


    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {

        logger.info("****************** Login Demo Web Shop********************888");
        ds.loginToDemoApp();
    }

    @Then("User verify Application logo")
    public void user_verify_application_logo() {

        logger.info("****************** Demo Web Shop Home Page ********************888");
        webPageUtilities.waitForElementPresent(driver.findElement(By.xpath("(//a[@class='account'])[1]")), 3000);
        Assert.assertEquals("Demo Web Shop", ds.getTitle());
    }

    @Then("User logut from DemoWeb shop")
    public void user_logut_from_demo_web_shop() throws InterruptedException {
        ds.logoutFromDemoApp();
    }




    @When("User navigate to Register Page")
    public void user_navigate_to_register_page() {

        logger.info("*********Navigate to Register Page ************");
        demoWebShopRegisterPage = new DemoWebShopRegisterPage(driver);
        demoWebShopRegisterPage.navigateToRegisterPage();


    }
    @When("user Enters the Registration Details for Gender {string}")
    public void user_enters_the_registration_details_for_gender(String gender) {

        logger.info("*********** register new User ************************");

        demoWebShopRegisterPage.navigateToRegisterPage();

        String randnomName= generateRandomString();
        String randomEmail=randnomName+"@gmail.com";
        demoWebShopRegisterPage.enterPersonalDetails(gender,randnomName,randnomName,randomEmail);

        demoWebShopRegisterPage.enterPassword(randnomName);

        demoWebShopRegisterPage.clickRegisterBtn();
    }

    @Then("User verify new user is registered")
    public void user_verify_new_user_is_registered() {

        Assert.assertTrue(demoWebShopRegisterPage.successMessage()
                .contains("Your registration completed"));


    }

}

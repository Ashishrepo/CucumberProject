package StepDef;

import Pages.BasePage;
import Pages.nopCommerce_CustomerPage;
import Pages.nopCommerce_LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class nopCommerceStepDef extends BasePage {
    nopCommerce_LoginPage lp;
    nopCommerce_CustomerPage cp;

    @Given("User open URL {string}")
    public void user_open_url(String url) {

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--incognito");
//        driver = new ChromeDriver(co);

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        lp= new nopCommerce_LoginPage(driver);
        driver.get(url);
    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String pwd) {

       lp.loginTonopCommerce(email,pwd);



    }
    @When("user click on signIN btn")
    public void user_click_on_sign_in_btn() {

    }
    @Then("user verify login is successfull")
    public void user_verify_login_is_successfull() {

    }


}

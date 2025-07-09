package Pages;


import Utilities.WebPageUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopRegisterPage {


    private final WebDriver driver;

      @FindBy(css = "a.ico-register")
      WebElement registerLink;

     String gender="//input[contains(@id,'%s')]";


      @FindBy(css = "input#FirstName")
      WebElement firstName;

      @FindBy(css = "input#LastName")
      WebElement lastName;

      @FindBy(css = "input#Email")
      WebElement emailID;

      @FindBy(css = "input#Password")
      WebElement password;

      @FindBy(css = "input#ConfirmPassword")
      WebElement confirmPassword;

      @FindBy(css = "input#register-button")
      WebElement registerBtn;

      @FindBy(css = "div.result")
      WebElement registerSuccessMessage;


      public DemoWebShopRegisterPage(WebDriver driver){
          this.driver=driver;
          PageFactory.initElements(driver,this);
      }



      public void enterPersonalDetails(String genderValue,String firstName,String lastName, String email){

          By genderLocator= By.xpath(String.format(gender,genderValue));
          driver.findElement(genderLocator).click();

          this.firstName.sendKeys(firstName);
          this.lastName.sendKeys(lastName);
          emailID.sendKeys(email);
    }

     public void enterPassword(String pwd){

          password.sendKeys(pwd);
          confirmPassword.sendKeys(pwd);

    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public void navigateToRegisterPage(){
          registerLink.click();
    }

    public String successMessage(){

        new WebPageUtilities(driver).waitForElementPresent(registerSuccessMessage,4);

          return registerSuccessMessage.getText();
    }

}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class LogIn {
    WebDriver chromeDriver;
    By userName = By.id("input-email");
    By password = By.id("input-password");
    By login = By.cssSelector("input[type='submit']");
    public LogIn(WebDriver driver){
        this.chromeDriver = driver;
    }

    public void setUserName(String strUserName){
        chromeDriver.findElement(userName).sendKeys(strUserName);
    }
    public void setPassword(String strPassword){
        chromeDriver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        chromeDriver.findElement(login).sendKeys(Keys.RETURN);
    }

        /**
         * This POM method will be exposed in test case to login in the application
         * @param strUserName
         * @param strPassword
         * @return
         **/
    public void loginToOpencart(String strUserName,String strPassword){
       this.setUserName(strUserName);
       this.setPassword(strPassword);
    }




}

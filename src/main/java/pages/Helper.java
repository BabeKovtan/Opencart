package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Helper {
    WebDriver chromeDriver;
    public Helper(WebDriver driver){
        this.chromeDriver = driver;
    }
    By searchName = By.xpath("//div[@id='search']/input[@name='search']");
    By searchButton = By.xpath("//div[@id='search']/span/button[@class='btn btn-default btn-lg']");

    By goodName = By.linkText("MacBook");
    By wishListPicture = By.xpath("//div[@class='button-group']//button[@data-original-title='Add to Wish List']");
    By alertMessage = By.className("alert alert-success alert-dismissible");
    By btnName = By.xpath("//body//div[@class='account-wishlist']//div[@class='row']//div[@class='table-responsive']//" +
            "//table[@class='table table-bordered table-hover']/tbody//tr//td/a[@class='btn btn-danger']");

    public void findAMac(String searchFor){ chromeDriver.findElement(searchName).sendKeys( "MacBook"); }
    public void findTheGoodIntoWishList(){ chromeDriver.findElement(goodName); }
    public void clickSearchButton(){
        chromeDriver.findElement(searchButton).sendKeys(Keys.RETURN);
    }
    public void clickOnGoodName(){ chromeDriver.findElement(By.xpath("//div[@id='search']/span/button[@class='btn btn-default btn-lg']")).sendKeys(Keys.RETURN); }
    public void addGoodToWishList(){ chromeDriver.findElement(By.xpath("//div[@class='button-group']//button[@data-original-title='Add to Wish List']")).click(); }
    public void clickOnRemoveFromWishList(){ chromeDriver.findElement(btnName).click(); }
    public void searchGood(String searchFor){
        this.findAMac(searchFor);
        this.clickSearchButton();
        this.clickOnGoodName();
        this.addGoodToWishList();
    }

}

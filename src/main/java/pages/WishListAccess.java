package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WishListAccess {
    private WebDriver chromeDriver;
    By idWish= By.id("wishlist-total");

    public WishListAccess(WebDriver driver) {
        this.chromeDriver = driver;
    }

    public String getIntoWishList(WebDriver chromeDriver){


        //chromeDriver.navigate().to(chromeDriver.findElement(idWish).getAttribute("href"));
        chromeDriver.findElement(By.id("wishlist-total")).click();
        return chromeDriver.getCurrentUrl();


    }
}

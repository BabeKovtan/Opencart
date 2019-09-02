package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListFind {

    private WebDriver chromeDriver;
    By wishListId = By.id("wishlist-total");

    public WishListFind(WebDriver driver){
        this.chromeDriver = driver;
    }
    public boolean getWishList(WebDriver chromeDriver){
        WebElement w = chromeDriver.findElement(wishListId);
        return true;

    }
    public boolean ifGetWishList(){
        WishListFind wishList = new WishListFind(chromeDriver);
        if (wishList.getWishList(chromeDriver)) {
            return true;
        }
        else {
            return false;
        }


    }





}

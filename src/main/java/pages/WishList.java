package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WishList {
    WebDriver driver;

    public WishList(WebDriver driver) {
        this.driver = driver;
    }
    WebElement table = driver.findElement(By.tagName("table"));

    public List<WebElement> createdList(){

        List <WebElement> rows = (List<WebElement>) table.findElement(By.tagName("tr"));
        List <WebElement> columns = (List<WebElement>) table.findElement(By.tagName("td"));
        for(WebElement eachRow : rows){
            List<WebElement> eachColumn = (List<WebElement>) eachRow.findElement(By.tagName("td"));
            System.out.println(eachColumn);
        }

        return null;
    }

}

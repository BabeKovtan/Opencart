package OpencartTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

    public class WhishListTest {
        private WebDriver driver;
        private LogIn objLogin;
        private WishListFind find;
        private WishListAccess access;
        private Helper helper;
        private WebElement e;
        private WishList w;

        @BeforeSuite
        public void setup(){
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\1\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://demo.opencart.com/index.php?route=account/login");
            objLogin = new LogIn(driver);
            objLogin.loginToOpencart("beatka994@mail.ru", "qwerty12");
            objLogin.clickLogin();
        }
        @Test
        public void searchWishList() throws Exception {
            access = new WishListAccess(driver);
            find = new WishListFind(driver);
            Assert.assertTrue(find.ifGetWishList());

        }
        @Test
        public void lookIntoWishList() throws Exception {
            access = new WishListAccess(driver);
            Assert.assertEquals(access.getIntoWishList(driver),"https://demo.opencart.com/index.php?route=account/wishlist");

        }

        @Test
        public void addToWishList() {
            driver.findElement(By.xpath("//div[@id='search']/input[@name='search']")).sendKeys("MacBook");
            driver.findElement(By.xpath("//div[@id='search']/span/button[@class='btn btn-default btn-lg']")).sendKeys(Keys.RETURN);
            driver.findElement(By.xpath("//div[@class='button-group']//button[@data-original-title='Add to Wish List']")).sendKeys(Keys.RETURN);
            driver.navigate().to(driver.findElement(By.id("wishlist-total")).getAttribute("href"));
            Assert.assertTrue(driver.findElement(By.linkText("MacBook")).isDisplayed());
        }

        //@Test
        public void deleteFromWishList(){
            driver.navigate().to(driver.findElement(By.id("wishlist-total")).getAttribute("href"));
            driver.findElement(By.linkText("MacBook"));
            //driver.findElement(By.xpath("//a[@title class='btn btn danger']")).getAttribute("href");
            //Assert.assertEquals(driver.findElement(By.linkText("MacBook")), new NullPointerException());
            WebElement table = driver.findElement(By.tagName("table"));
            List <WebElement> rows = table.findElements(By.tagName("tr"));
            List <WebElement> columns =  table.findElements(By.tagName("td"));
            for(WebElement eachRow : columns){
                List<WebElement> eachColumn = eachRow.findElements(By.tagName("a"));
                //eachColumn.get(1).getAttribute("href");
                System.out.println(eachColumn);
            }
            //columns.get(6).findElement(By.tagName("a")).getAttribute("href");


        }











    }
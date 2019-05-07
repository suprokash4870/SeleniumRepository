package ebay;

import Initialization.Setup;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class HomePage extends Setup {

    @Test
    public void homePageTitleTest(){
    SetupDriver("windows","https://www.ebay.com","chrome");
    String actualTitle = driver.getTitle();
    System.out.println(actualTitle );
    String expectedTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Passed");
        }
        else{
            System.out.println("Failed");
        }
    }

    @Test
    public void ebayLogoVerificationTest(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        boolean b = driver.findElement(By.xpath("//img[@id='gh-logo']")).isDisplayed();
        Assert.assertTrue(b);

    }

    @Test
    public void GetCurrentUrl() {
        SetupDriver("windows","https://www.ebay.com","chrome");
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        String expectedURL = "https://www.ebay.com/";

            if(actualURL.equalsIgnoreCase(expectedURL)){
                System.out.println("Passed");
            }
            else{
                System.out.println("Failed");
            }
    }

    @Test
    public void PageSource(){
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");
        String pagesource = driver.getPageSource();
        System.out.println(pagesource);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SearchItem(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Books");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }


    @Test(priority = 1)
    public void BrowserBackNavigationCheck() throws InterruptedException {
        SetupDriver("windows", "https://www.ebay.com", "chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Books");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        driver.navigate().back();
    }

    @Test(priority=2)
     public void BrowserForwardNavigationCheck() throws InterruptedException {
        SetupDriver("windows", "https://www.ebay.com", "chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Books");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        }

     @Test
    public void CheckNavigationToDifferentUrl() throws InterruptedException {
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        driver.navigate().back();
    }

    @Test
    public void DropDownBoxVrification() throws InterruptedException {
        SetupDriver("windows","https://www.ebay.com","chrome");
        Select select = new Select(driver.findElement(By.id("gh-cat")));
        select.selectByVisibleText("Art");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    @Test
    public void ShopByCategory (){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@id='gh-shop-a']")).click();
    }

    @Test
    public void SelectItem() {
        SetupDriver("windows", "https://www.ebay.com", "chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tv");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.className("s-item__title")).click();
    }

    @Test
    public void ClearFieldTest() throws InterruptedException {
        SetupDriver("windows", "https://www.ebay.com", "chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tv");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.className("s-item__title")).click();
        driver.findElement(By.id("qtyTextBox")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("qtyTextBox")).sendKeys("2");
    }

    @Test
    public void AddToCart() {
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tv");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.className("s-item__title")).click();
        driver.findElement(By.id("isCartBtn_btn")).click();
        driver.findElement(By.xpath("//button[text()='No thanks']")).click();

    }

    @Test
    public void CheckOutVerification(){
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://cart.ebay.com");
        driver.findElement(By.xpath("//*[@type='button']")).click();
    }

    @Test

    public void VerifyAddPlanButton(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tv");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.findElement(By.className("s-item__title")).click();
        driver.findElement(By.id("isCartBtn_btn")).click();
        driver.findElement(By.xpath("//button[text()='Add plan']")).click();
    }

    @Test
    public void SignInButtonTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
    }


    @Test
    public void SignInWithValidCredentials() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("userid")).sendKeys("ssanyalashok");
        driver.findElement(By.name("pass")).sendKeys("suprokash8071");
        driver.findElement(By.id("sgnBt")).click();
        driver.findElement(By.name("userid")).sendKeys("abcd");
        driver.findElement(By.name("pass")).sendKeys("abcd1234");
    }

    @Test
    public void SignInWithInvalidCredentials() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("sgnBt")).click();
    }

    @Test
    public void SignOutVerification() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("userid")).sendKeys("ssanyalashok");
        driver.findElement(By.name("pass")).sendKeys("suprokash8071");
        driver.findElement(By.id("sgnBt")).click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"gh-ug\"]"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();

    }

    @Test
    public void MouseMovementTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.ebay.com");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Electronics"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Laptops")).click();
    }

    @Test
    public void FashionLinkTest(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.linkText("Fashion")).click();
    }

    @Test
    public void RegistrationButtonCheck(){
        SetupDriver("windows","https://www.ebay.com","chrome");
        driver.findElement(By.xpath("//a[text()='register']")).click();
    }

    @Test
    public void RegistrationFieldValidation(){
        SetupDriver("windows","https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F","chrome");
        driver.findElement(By.name("firstname")).sendKeys("Tom");
        driver.findElement(By.name("lastname")).sendKeys("Peter");
        driver.findElement(By.name("email")).sendKeys("tompeter@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("tomp12345");
        driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
    }

   @Test
    public void DailyDealsLinkTest(){
       SetupDriver("windows","https://www.ebay.com","chrome");
       driver.findElement(By.linkText("Daily Deals")).click();
    }

    @AfterTest
    public void CloseApp(){
        driver.quit();
    }


    }











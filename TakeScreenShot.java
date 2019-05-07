package Initialization;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot extends Setup {

    public static void main(String[] args) {
        SetupDriver("windows", "https://cart.ebay.com/", "Chrome");
        getScreenShot(driver);

    }

        public static void getScreenShot (WebDriver driver){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        String name = df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File ("src\\main\\resources\\ScreenShot\\"+name+".png"));
        } catch (IOException e) {
                e.printStackTrace();
        }
        driver.quit();
        }
    }


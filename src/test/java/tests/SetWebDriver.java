package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetWebDriver {
    private static WebDriver driver;
    public static void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}

package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SetWebDriver {
    private static org.openqa.selenium.WebDriver driver;

    static org.openqa.selenium.WebDriver getDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

package tests;

import org.openqa.selenium.chrome.ChromeDriver;

public class SetWebDriver {
    private static org.openqa.selenium.WebDriver driver;

    static org.openqa.selenium.WebDriver getDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

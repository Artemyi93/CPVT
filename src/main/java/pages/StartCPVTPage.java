package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartCPVTPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputUser;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//span[starts-with(@class,'ui-button-text') and text()='Войти']")
    private WebElement enterButton;

    public StartCPVTPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterLogin(String user){
        inputUser.sendKeys(user);
    }

    public void enterPassword(String pwd){
        inputPassword.sendKeys(pwd);
    }

    public CPVT_MainPage clickOnEnterButton() {
        enterButton.click();
        return new CPVT_MainPage(driver);
    }
}
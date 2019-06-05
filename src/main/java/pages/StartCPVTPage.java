package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.click();
        return new CPVT_MainPage(driver);
    }
}
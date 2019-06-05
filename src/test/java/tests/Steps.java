package tests;

import cucumber.api.java.ru.*;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.util.Map;

public class Steps {
    private WebDriver driver = SetWebDriver.getDriver();
    private StartCPVTPage startPage;
    private CPVT_MainPage cpvt_main;
    private CPVTCreatePersoProfile create_pers_prof;
    private ListProfilePage list_prof;
    private final String START_URL = "http://msk1-devcpvtapp01.unix.nspk.ru/CPVT/";

    @Пусть("открыта страница авторизации CPVT")
    public void open_authpage_CPVT() {
        driver.get(START_URL);
        startPage = new StartCPVTPage(driver);
    }

    @И("поле \"Логин\" заполнено значением {string}")
    public void enterLogin(String login) {
        startPage.enterLogin(login);
    }

    @И("поле \"Пароль\" заполнено значением {string}")
    public void enterPwd(String pwd) {
        startPage.enterPassword(pwd);
    }

    @Допустим("нажата кнопка \"Войти\"")
    public void pressEnterButton() throws InterruptedException {
        cpvt_main = startPage.clickOnEnterButton();
    }

    @Допустим("нажата кнопка \"Персопрофили\"")
    public void pressPersoProfilesButton() throws InterruptedException {
        cpvt_main.clickPersoProfiles();
    }

    @Допустим("нажата кнопка \"Создать персопрофиль\"")
    public void pressCreatePersoProfileButton() throws InterruptedException {
        create_pers_prof=cpvt_main.clickCreatePersoProfileButton();
    }

    @Тогда("на странице \"Продукт ПС МИР\" заполняем поля <селектор> <значение>")
    public void selectElements(DataTable dataTable) throws InterruptedException {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ng-star-inserted']/div[@class='dropdown-b grid']/div/*")));
        for (Map.Entry<String,String> entry: map.entrySet()) {
            create_pers_prof.selector(entry.getKey(),entry.getValue());
        }
    }

    @Допустим("в правом меню нажимаем на поле \"Подтверждение данных\"")
    public void pressDataConfirmButton() throws InterruptedException {
        create_pers_prof.clickDataConfirmButton();
    }

    @Допустим("нажимаем на кнопку \"Создать профиль\"")
    public void pressCreateProfileButton() throws InterruptedException {
        create_pers_prof.clickCreateProfileButton();
        Wait wait = new WebDriverWait(driver, 10);
        //ждем, когда сообщение, о том, что профиль успешно создан появится и затем исчезнет
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-growl ui-widget']/div")));
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-growl ui-widget']/div"))));
    }
    @Допустим("в левом меню нажимаем на кнопку на \"Список профилей\"")
    public void pressProfileListButton() throws InterruptedException {
        list_prof=create_pers_prof.clickProfileListButton();
    }
    @И("фильтруем таблицу по полю \"Имя профиля\" со значением {string}")
    public void filterTableByName(String value) throws InterruptedException {
        list_prof.setUserNameField(value);
        list_prof.clickSortByUserProfile();
    }
    @Тогда("проверяем, что полученный список профилей не пустой")
    public void checkProfileList() {
        Assert.assertTrue("Ошибка! Список пустой!", list_prof.tableProfilesSize()>0);
    }
}

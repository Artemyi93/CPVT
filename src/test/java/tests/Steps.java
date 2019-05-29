package tests;


import cucumber.api.java.ru.*;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.Map;


public class Steps {
    private WebDriver driver = SetWebDriver.getDriver();
    private StartCPVTPage startPage;
    private CPVT_MainPage cpvt_main;
    private CPVTCreatePersoProfile create_pers_prof;
    private ListProfilePage list_prof;
    private final String starturl = "http://msk1-devcpvtapp01.unix.nspk.ru/CPVT/";

    @Допустим("открыта страница авторизации CPVT")
    public void open_authpage_CPVT() {
        driver.get(starturl);
        startPage = new StartCPVTPage(driver);
    }

    @Допустим("поле \"Логин\" заполнено значением {string}")
    public void EnterLogin(String login) {
        startPage.EnterLogin(login);
    }

    @Допустим("поле \"Пароль\" заполнено значением {string}")
    public void EnterPwd(String pwd) {
        startPage.EnterPassword(pwd);
    }

    @Допустим("нажата кнопка \"Войти\"")
    public void pressEnterButton() throws InterruptedException {
        cpvt_main = startPage.clickOnEnterButton();
        Thread.sleep(1000);
    }

    @Допустим("нажата кнопка \"Персопрофили\"")
    public void pressPersoProfilesButton() throws InterruptedException {
        cpvt_main.clickPersoProfiles();
        Thread.sleep(500);
    }

    @Допустим("нажата кнопка \"Создать персопрофиль\"")
    public void pressCreatePersoProfileButton() throws InterruptedException {
        create_pers_prof=cpvt_main.clickCreatePersoProfileButton();
        Thread.sleep(500);
    }

    @Допустим("на странице \"Продукт ПС МИР\" заполняем поля <селектор> <значение>")
    public void selectElements(DataTable dataTable) throws InterruptedException {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String,String> entry: map.entrySet()) {
            create_pers_prof.selector(entry.getKey(),entry.getValue());
        }
    }

    @Допустим("в правом меню нажимаем на поле \"Подтверждение данных\"")
    public void pressDataConfirmButton() throws InterruptedException {
        create_pers_prof.clickDataConfirmButton();
        Thread.sleep(500);
    }

    @Допустим("нажимаем на кнопку \"Создать профиль\"")
    public void pressCreateProfileButton() throws InterruptedException {
        create_pers_prof.clickCreateProfileButton();
        Thread.sleep(1000);
    }
    @Допустим("в левом меню нажимаем на кнопку на \"Список профилей\"")
    public void pressProfileListButton() throws InterruptedException {
        list_prof=create_pers_prof.clickProfileListButton();
        Thread.sleep(500);
    }
    @Допустим("фильтруем таблицу по полю \"Имя профиля\" со значением {string}")
    public void filterTableByName(String value) throws InterruptedException {
        list_prof.setUserNameField(value);
        list_prof.clickSortByUserProfile();
    }
    @Допустим("проверяем, что полученный список профилей не пустой")
    public void checkProfileList() {
        Assert.assertTrue("Ошибка! Список пустой!", list_prof.tableProfilesSize()>0);
        driver.close();
    }
}

package ru.amg.unisflint.source.frontend.pages.service;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.service.ServicePageAssertions;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import static com.codeborne.selenide.Selenide.$;

public class ServicePage {

    public ServicePageAssertions assertions() {return new ServicePageAssertions();}

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);

    //Элементы главной страницы Сервисного модуля

    @FindBy(xpath = "//a[@class='sidebar__item sidebar__item_active']//span[contains(normalize-space(),'Приложения')]")
    private SelenideElement applicationsSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Роли')]")
    private SelenideElement rolesSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Пользователи')]")
    private SelenideElement usersSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Аудит')]")
    private SelenideElement auditSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Уведомления')]")
    private SelenideElement notificationsSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Источники данных')]")
    private SelenideElement datasourceSideBar;

    @FindBy (xpath = "//span[contains(normalize-space(),'Настройки')]")
    private SelenideElement settingsSideBar;

    @FindBy(xpath = "//span[contains(text(),'Аудит')]")
    private SelenideElement audit_section;

    @FindBy (xpath = "//img[@alt='exit icon']")
    private SelenideElement unathorized;

    //Шаги тестовых методов

    @Step("Выбрать раздел 'Аудит' в сервисном модуле")
    public ServicePage changeAuditSection () {
        $ (audit_section).click();return this;
    }

    @Step ("Деавторизация пользователя")
    public ServicePage logOut () {
        $ (unathorized).click();return this;
    }

    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getApplicationsSideBar () {
        return applicationsSideBar;
    }

    public SelenideElement getRolesSideBar () {
        return rolesSideBar;
    }

    public SelenideElement getUsersSideBar () {
        return usersSideBar;
    }

    public SelenideElement getAuditSideBar () {
        return auditSideBar;
    }

    public SelenideElement getNotificationsSideBar () {
        return notificationsSideBar;
    }

    public SelenideElement getDatasourceSideBar () {
        return datasourceSideBar;
    }

    public SelenideElement getSettingsSideBar () {
        return settingsSideBar;
    }

}

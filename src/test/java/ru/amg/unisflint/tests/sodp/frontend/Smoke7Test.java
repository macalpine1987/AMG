package ru.amg.unisflint.tests.sodp.frontend;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.frontend.configuration.TestSetup7stand;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import ru.amg.unisflint.source.frontend.pages.app.AppPage;
import ru.amg.unisflint.source.frontend.pages.configurator.ConfiguratorPage;
import ru.amg.unisflint.source.frontend.pages.configurator.sections.ApplicationsSection;
import ru.amg.unisflint.source.frontend.pages.service.ServicePage;


public class Smoke7Test extends TestSetup7stand {

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);
    ConfiguratorPage configuratorPage = Selenide.page(ConfiguratorPage.class);
    ServicePage servicePage = Selenide.page(ServicePage.class);
    AppPage appPage = Selenide.page(AppPage.class);
    ApplicationsSection applicationsSection = Selenide.page(ApplicationsSection.class);


    @Test(priority = 1, groups = "sodp_smoke", description = "Проверка загрузки главной страницы Web-приложения")
    public void loadMainPage() {
        mainPage.open();
        mainPage.assertions().assertLoadMainPage();
    }

    @Test(priority = 2, groups = "sodp_smoke", description = "Проверка перехода на страницу авторизации при нажатии кнопки \"Конфигуратор\"")
    public void clickConfiguratorButton() {
        mainPage.open().clickConfiguratorButton();
        authPage.assertions().assertLoadAuthPage();
    }

    @Test(priority = 3, groups = "sodp_smoke", description = "Проверка перехода на страницу авторизации при нажатии кнопки \"Сервисный\"")
    public void clickServiceButton() {
        mainPage.open().clickServiceButton();
        authPage.assertions().assertLoadAuthPage();
    }

    @Test(priority = 4, groups = "sodp_smoke", description = "Проверка перехода на страницу авторизации при нажатии кнопки \"Исполнительный\"")
    public void clickAppButton() {
        mainPage.open().clickAppButton();
        authPage.assertions().assertLoadAuthPage();
    }

    @Test(priority = 5, groups = "sodp_smoke", description = "Проверка авторизации пользователя 'test_a' в модуле \"Конфигуратор\"")
    public void enterToConfiguratorModule() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("test_a", "1-1").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 6, groups = "sodp_smoke", description = "Проверка авторизации пользователя 'test_a' в модуле \"Сервисный\"")
    public void enterToServiceModule() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("test_a", "1-1").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 7, groups = "sodp_smoke", description = "Проверка авторизации пользователя 'test_a' в модуле \"Исполнительный\"")
    public void enterToAppModule() {
        mainPage.open().clickAppButton();
        authPage.loginUser("test_a", "1-1").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 8, groups = "sodp_smoke", description = "Проверка наличия необходимых элементов во вкладке \"Приложения\" модуля \"Конфигуратор\"")
    public void applicationSideBar() {
        configuratorPage.enterToConfiguratorModule();
        applicationsSection.assertions().assertElementsApplicationsSideBar();
        applicationsSection.logOut();
    }

}
package ru.amg.unisflint.source.frontend.pages.configurator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.configurator.ConfiguratorPageAssertions;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import ru.amg.unisflint.source.frontend.pages.configurator.sections.ApplicationsSection;
import static com.codeborne.selenide.Selenide.$;

public class ConfiguratorPage {

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);

    public ConfiguratorPageAssertions assertions() {return new ConfiguratorPageAssertions();}
    public ApplicationsSection applicationsSection () {return new ApplicationsSection();}

    //Элементы главной страницы модуля "Конфигуратор"

    @FindBy(xpath = "//a[@class='sidebar__item sidebar__item_active']//span[contains(normalize-space(),'Приложения')]")
    private SelenideElement applicationsSideBar;

    @FindBy(xpath = "//span[contains(normalize-space(),'Репозитории')]")
    private SelenideElement repositorySideBar;

    @FindBy(xpath = "//span[contains(normalize-space(),'Роли')]")
    private SelenideElement rolesSideBar;

    @FindBy(xpath = "//span[contains(normalize-space(),'Аналитики')]")
    private SelenideElement analyticsSideBar;

    @FindBy(xpath = "//span[contains(normalize-space(),'Инструментарий')]")
    private SelenideElement toolsSideBar;

    @FindBy(xpath = "//img[@alt='exit icon']")
    private SelenideElement unathorized;

    //Шаги тестовых методов

    @Step("Деавторизация пользователя")
    public ConfiguratorPage logOut() {
        $(unathorized).click();
        return this;
    }
    @Step("Авторизоваться в модуле \"Конфигуратор\" под пользователем \"test_a\"")
    public ConfiguratorPage enterToConfiguratorModule() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("test_a", "1-1").clickLoginButton();
        return this;
    }
    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getApplicationsSideBar() {
        return applicationsSideBar;
    }

    public SelenideElement getRepositorySideBar() {
        return repositorySideBar;
    }

    public SelenideElement getRolesSideBar() {
        return rolesSideBar;
    }

    public SelenideElement getAnalyticsSideBar() {
        return analyticsSideBar;
    }

    public SelenideElement getToolsSideBar() {
        return toolsSideBar;
    }



}

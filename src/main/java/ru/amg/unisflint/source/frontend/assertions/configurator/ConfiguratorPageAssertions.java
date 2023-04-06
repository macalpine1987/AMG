package ru.amg.unisflint.source.frontend.assertions.configurator;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.configurator.ConfiguratorPage;
import static com.codeborne.selenide.Selenide.$;

public class ConfiguratorPageAssertions {

    ConfiguratorPage configuratorPage = Selenide.page(ConfiguratorPage.class);

    //Проверки для главной страницы модуля "Конфигуратор"

    @Step("Проверка загрузки главной страницы модуля 'Конфигуратор'")
    public ConfiguratorPageAssertions assertEnterToConfiguratorModule () {
        $ (configuratorPage.getApplicationsSideBar()).shouldBe(Condition.visible);
        $ (configuratorPage.getRepositorySideBar()).shouldBe(Condition.visible);
        $ (configuratorPage.getRolesSideBar()).shouldBe(Condition.visible);
        $ (configuratorPage.getAnalyticsSideBar()).shouldBe(Condition.visible);
        $ (configuratorPage.getToolsSideBar()).shouldBe(Condition.visible); return this;
    }

    @Step("Проверка отсутствия доступа пользователя на страницу модуля Конфигуратор")
    public ConfiguratorPageAssertions assertNoEnterToConfiguratorModule() {
        $ (configuratorPage.getApplicationsSideBar()).shouldNotBe(Condition.visible);
        $ (configuratorPage.getRepositorySideBar()).shouldNotBe(Condition.visible);
        $ (configuratorPage.getRolesSideBar()).shouldNotBe(Condition.visible);
        $ (configuratorPage.getAnalyticsSideBar()).shouldNotBe(Condition.visible);
        $ (configuratorPage.getToolsSideBar()).shouldNotBe(Condition.visible);
        return this;
    }

}

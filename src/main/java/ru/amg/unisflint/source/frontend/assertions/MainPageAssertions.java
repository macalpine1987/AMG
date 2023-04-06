package ru.amg.unisflint.source.frontend.assertions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import static com.codeborne.selenide.Selenide.$;

public class MainPageAssertions  {

   MainPage mainPage = Selenide.page(MainPage.class);

   //Проверки для главной страницы Web-приложения
    @Step("Проверка загрузки главной страницы Web-приложения")
    public MainPageAssertions assertLoadMainPage () {
        $ (mainPage.getConfiguratorButton()).shouldBe(Condition.visible);
        $ (mainPage.getServiceButton()).shouldBe(Condition.visible);
        $ (mainPage.getAppButton()).shouldBe(Condition.visible);return this;
    }
}

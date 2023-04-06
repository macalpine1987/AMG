package ru.amg.unisflint.source.frontend.assertions.app;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.app.AppPage;
import static com.codeborne.selenide.Selenide.$;

public class AppPageAssertions {

    AppPage appPage = Selenide.page(AppPage.class);

    //Проверки для главной страницы Исполнительного модуля

    @Step("Проверка загрузки главной страницы Исполнительного модуля")
    public AppPageAssertions assertEnterToAppModule () {
        $ (appPage.getMyReports()).shouldBe(Condition.visible);
        $ (appPage.getMyRequests()).shouldBe(Condition.visible);
        $ (appPage.getOtherFunctions()).shouldBe(Condition.visible);
        $ (appPage.getMainLink()).shouldBe(Condition.visible); return this;
    }

    @Step ("Проверка отсутствия доступа пользователя на страницу Исполнительного модуля")
    public AppPageAssertions assertNoEnterToAppModule () {
        $ (appPage.getMyReports()).shouldNotBe(Condition.visible);
        $ (appPage.getMyRequests()).shouldNotBe(Condition.visible);
        $ (appPage.getOtherFunctions()).shouldNotBe(Condition.visible);
        $ (appPage.getMainLink()).shouldNotBe(Condition.visible);
        return this;
    }

}

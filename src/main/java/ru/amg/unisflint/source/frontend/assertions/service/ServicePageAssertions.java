package ru.amg.unisflint.source.frontend.assertions.service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.service.ServicePage;
import static com.codeborne.selenide.Selenide.$;

public class ServicePageAssertions {

    ServicePage servicePage = Selenide.page(ServicePage.class);

    //Проверки для главной страницы Сервисного модуля

    @Step("Проверка загрузки главной страницы Сервисного модуля")
    public ServicePageAssertions assertEnterToServiceModule () {
        $ (servicePage.getApplicationsSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getRolesSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getUsersSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getAuditSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getNotificationsSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getDatasourceSideBar()).shouldBe(Condition.visible);
        $ (servicePage.getSettingsSideBar()).shouldBe(Condition.visible); return this;
    }

    @Step ("Проверка отсутствия доступа пользователя на страницу Сервисного модуля")
    public ServicePageAssertions assertNoEnterToServiceModule () {
        $ (servicePage.getApplicationsSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getRolesSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getUsersSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getAuditSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getNotificationsSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getDatasourceSideBar()).shouldNotBe(Condition.visible);
        $ (servicePage.getSettingsSideBar()).shouldNotBe(Condition.visible);
        return this;
    }

}

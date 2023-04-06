package ru.amg.unisflint.tests.ovd.frontend;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.frontend.configuration.TestSetup207stand;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import ru.amg.unisflint.source.frontend.pages.app.AppPage;
import ru.amg.unisflint.source.frontend.pages.configurator.ConfiguratorPage;
import ru.amg.unisflint.source.frontend.pages.service.ServicePage;
import ru.amg.unisflint.source.frontend.pages.service.sections.AuditSection;

public class Stand207Test extends TestSetup207stand {

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);
    ConfiguratorPage configuratorPage = Selenide.page(ConfiguratorPage.class);
    ServicePage servicePage = Selenide.page(ServicePage.class);
    AppPage appPage = Selenide.page(AppPage.class);
    AuditSection auditSection = Selenide.page(AuditSection.class);

//Группа тестов №1
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "Ruk1" с ролью "Руководитель подразделения"
//Полномочия пользователя:
//Пользователь Ruk1 (приложения ОВД ПЗ, ФИС ГИБДД-М, доступ: только Исполнительный модуль)

    @Test(priority = 1, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest1() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Ruk1", "b72").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 2, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest2() {
        mainPage.open().clickAppButton();
        authPage.loginUser("ruk1", "b72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 3, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest3() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Ruk1", "c72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 4, groups = "ruk1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"Ruk1\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest4() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleRuk1_test();
        auditSection.logOut();
    }

    @Test(priority = 5, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest5() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 6, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest6() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" Ruk1", "b72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 7, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" с валидными логином и паролем, но с пробелом в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest7() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Ruk1", " b72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 8, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в сервисном модуле с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest8() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-sd-test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 9, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest9() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Ruk1", "b72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 10, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest10() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "b72").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 11, groups = "ruk1",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest11() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Ruk1", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 12, groups = "ruk1",
            description = "Проверка формирования отчета в жрунале аудита по пользователю \"Ruk1\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest12() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_Ruk1();
        auditSection.assertions().assertReport_Ruk1();
        auditSection.logOut();
    }

    @Test(priority = 13, groups = "ruk1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest13() {
        mainPage.open().clickAppButton();
        authPage.loginUser("ruk1", "User123").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 14, groups = "ruk1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest14() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Ruk1", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 15, groups = "ruk1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest15() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "b72").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 16, groups = "ruk1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest16() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №2
// Серия тестовых сценариев на авторизацию/деавторизацию в модулях: конфигуратор, сервисный от имени пользователя "Bez1" с ролью "Администратор безопасности"
// Полномочия системного администратора:
// Пользователь "Bez1" (роль "Администратор безопасности", доступ: только модули Сервисный и Конфигуратор)

    @Test(priority = 17, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в модуле Конфигуратор с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest17() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 18, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в модуле Конфигуратор с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest18() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("bez1", "e75").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 19, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в модуле Конфигуратор с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest19() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Bez1", "v75").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 20, groups = "bez1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"Bez1\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest20() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleBez1();
        auditSection.logOut();
    }

    @Test(priority = 21, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в модуле \"Конфигуратор\" с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest21() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 22, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в модуле \"Конфигуратор\" с добавлением пробела в поле 'Логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest22() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser(" Bez1", "e75").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 23, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в Конфигураторе с добавлением одиночного пробела в поле 'Пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest23() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Bez1", " e75").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 24, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest24() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 25, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в cервисном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest25() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 26, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest26() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "e75").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 27, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest27() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 28, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest28() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 29, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest29() {
        mainPage.open().clickServiceButton();
        authPage.loginUser(" Bez1", "e75").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 30, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в Конфигураторе при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest30() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Bez1", " e75").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 31, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest31() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("bez1", "e75").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 32, groups = "bez1",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest32() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "j75").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 33, groups = "bez1",
            description = "Формирование отчета из журнала аудита по пользователю \"Bez1\" (вход/выход пользователя,результат,модуль,примечания,события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest33() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "e75").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_Bez1();
        auditSection.assertions().assertReport_Bez1();
        auditSection.logOut();
    }

    @Test(priority = 34, groups = "bez1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest34() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("bez1", "j72").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 35, groups = "bez1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest35() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Bez1", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 36, groups = "bez1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest36() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "e75").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 37, groups = "bez1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest37() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №3
//Серия тестовых сценариев на авторизацию/деавторизацию в модулях: исполнительный, сервисный, конфигуратор от имени пользователя "Adm1" с ролью "Администратор СПО".
//Полномочия пользователя: добавлены полномочия аналитика
//Пользователь Adm1 (роль "Администратор СПО", доступ: Исполнительный, Сервисный, Конфигуратор)

    @Test(priority = 38, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest38() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 39, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest39() {
        mainPage.open().clickAppButton();
        authPage.loginUser("adm1", "d74").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 40, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest40() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Adm1", "c74").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 41, groups = "adm1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"Adm1\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest41() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleAdm1();
        auditSection.logOut();
    }

    @Test(priority = 42, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest42() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 43, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest43() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" Adm1", "d74").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 44, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest44() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Adm1", " d74").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 45, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в сервисном модуле при введении валидных Логина и Пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest45() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 46, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" (в качестве аналитика) в модуле \"Конфигуратор\", используя валидный логин и пароль")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest46() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 47, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле, с введением валидных данных только в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest47() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "d74").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 48, groups = "adm1",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле, с введением валидных данных только в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest48() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Adm1", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 49, groups = "adm1",
            description = "Формирование отчета из журнала аудита по пользователю \"Adm1\" (вход/выход пользователя, результат, модуль, примечания, события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest49() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_Adm1();
        auditSection.assertions().assertReport_Adm1();
        auditSection.logOut();
    }

    @Test(priority = 50, groups = "adm1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest50() {
        mainPage.open().clickAppButton();
        authPage.loginUser("adm1", "f56").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 51, groups = "adm1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest51() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Adm1", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 52, groups = "adm1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest52() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "d74").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 53, groups = "adm1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest53() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №4
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "Sotr1" с ролью "Сотрудник подразделения"
//Полномочия пользователя:
//Пользователь "Sotr1" (приложение ОВД ПЗ, доступ "Исполнительный модуль")

    @Test (priority = 54, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest54() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr1", "a71").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test (priority = 55, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest55() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sotr1", "a71").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 56, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest56 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr1", "f71").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 57, groups = "sotr1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"Sotr1\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest57() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSotr1();
        auditSection.logOut();
    }

    @Test (priority = 58, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest58() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 59, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest59() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" Sotr1", "a71").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 60, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest60 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr1", " a71").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 61, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в сервисном модуле при использовании валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest61 () {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Sotr1", "a71").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test (priority = 62, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest62 () {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Sotr1", "a71").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test (priority = 63, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest63 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "a71").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 64, groups = "sotr1",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest64 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr1", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 65, groups = "sotr1",
            description = "Формирование отчета из журнала аудита по пользователю \"Sotr1\" (вход/выход пользователя)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest65 () {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Adm1", "d74").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_Sotr1();
        auditSection.assertions().assertReport_Sotr1();
        auditSection.logOut();
    }

    @Test(priority = 66, groups = "sotr1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest66() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr2", "a72").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 67, groups = "sotr1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest67() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sotr1", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 68, groups = "sotr1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest68() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "a71").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();
    }

    @Test(priority = 69, groups = "sotr1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest69() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

}

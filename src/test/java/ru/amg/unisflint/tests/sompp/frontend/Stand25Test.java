package ru.amg.unisflint.tests.sompp.frontend;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.frontend.configuration.TestSetup25stand;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import ru.amg.unisflint.source.frontend.pages.app.AppPage;
import ru.amg.unisflint.source.frontend.pages.configurator.ConfiguratorPage;
import ru.amg.unisflint.source.frontend.pages.service.ServicePage;
import ru.amg.unisflint.source.frontend.pages.service.sections.AuditSection;

public class Stand25Test extends TestSetup25stand {

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);
    ConfiguratorPage configuratorPage = Selenide.page(ConfiguratorPage.class);
    ServicePage servicePage = Selenide.page(ServicePage.class);
    AppPage appPage = Selenide.page(AppPage.class);
    AuditSection auditSection = Selenide.page(AuditSection.class);

//Группа тестов №1
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sompp-sd-test" с ролью "Пользователь ЦА СОМПП"
//Полномочия пользователя:
//Пользователь sompp-sd-test (роль "Пользователь ЦА СОМПП", доступ: только Исполнительный модуль)

    @Test(priority = 1, groups = "sompp_ca",
            description = "Авторизация и деавторизация пользователя \"sompp-sd-test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest1() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-sd-test", "user123").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 2, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest2() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-SD-test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 3, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest3() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-sd-test", "User123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 4, groups = "sompp_ca",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sompp-sd-test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest4() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSompp_sd_test();
        auditSection.logOut();
    }

    @Test(priority = 5, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest5() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 6, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest6() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sompp-sd-test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 7, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" с валидными логином и паролем, но с пробелом в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest7() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-sd-test", " user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 8, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в сервисном модуле с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest8() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-sd-test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 9, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в модуле \"Конфигуратор\" с использованием валидного логига и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest9() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp-sd-test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 10, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest10() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 11, groups = "sompp_ca",
            description = "Авторизация пользователя \"sompp-sd-test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest11() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-sd-test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 12, groups = "sompp_ca",
            description = "Проверка формирования отчета в журнале аудита по пользователю \"sompp-sd-test\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest12() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sompp_sd_test();
        auditSection.assertions().assertReport_sompp_sd_test();
        auditSection.logOut();
    }

    @Test(priority = 13, groups = "sompp_ca",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest13() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_sd_test", "User123").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 14, groups = "sompp_ca",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest14() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_sd_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 15, groups = "sompp_ca",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest15() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 16, groups = "sompp_ca",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest16() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №2
// Серия тестовых сценариев на авторизацию/деавторизацию в модулях: конфигуратор, сервисный от имени пользователя "sompp_0_test" с ролью "Системный администратор"
// Полномочия системного администратора:
// Пользователь "sompp_0_test" (роль "Системный администратор", доступ: только модули Сервисный и Конфигуратор)

    @Test(priority = 17, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в модуле Конфигуратор с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest17() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 18, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в модуле Конфигуратор с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest18() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Sompp_0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 19, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в модуле Конфигуратор с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest19() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp_0_test", "admin124").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 20, groups = "sompp_0",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sompp_0_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest20() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSompp_0_test();
        auditSection.logOut();
    }

    @Test(priority = 21, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в модуле \"Конфигуратор\" с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest21() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 22, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в модуле \"Конфигуратор\" с добавлением пробела в поле 'Логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest22() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser(" sompp_0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 23, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в Конфигураторе с добавлением одиночного пробела в поле 'Пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest23() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp_0_test", " admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 24, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest24() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 25, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в cервисном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest25() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 26, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest26() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 27, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest27() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 28, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest28() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 29, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest29() {
        mainPage.open().clickServiceButton();
        authPage.loginUser(" sompp_0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 30, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в Конфигураторе при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest30() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp_0_test", " admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 31, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest31() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Sompp_0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 32, groups = "sompp_0",
            description = "Авторизация пользователя \"sompp_0_test\" в сервисном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest32() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin124").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 33, groups = "sompp_0",
            description = "Формирование отчета из журнала аудита по пользователю \"sompp_0_test\" (вход/выход пользователя,результат,модуль,примечания,события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest33() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sompp_0_test();
        auditSection.assertions().assertReport_sompp_0_test();
        auditSection.logOut();
    }

    @Test(priority = 34, groups = "sompp_0",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest34() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "admin100").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 35, groups = "sompp_0",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest35() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_0_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 36, groups = "sompp_0",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest36() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 37, groups = "sompp_0",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest37() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №3
//Серия тестовых сценариев на авторизацию/деавторизацию в модулях: исполнительный, сервисный, конфигуратор от имени пользователя "sompp-admin-test" с ролью "Администратор СОММП".
//Полномочия пользователя: добавлены полномочия аналитика
//Пользователь sompp-admin-test (роль "Администратор СОМПП", доступ: Исполнительный, Сервисный, Конфигуратор)

    @Test(priority = 38, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest38() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 39, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest39() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sompp-admin-test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 40, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest40() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-admin-test", "Admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 41, groups = "sompp_admin",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sompp-admin-test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest41() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSompp_admin_test();
        auditSection.logOut();
    }

    @Test(priority = 42, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest42() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 43, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest43() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sompp-admin-test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 44, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest44() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-admin-test", " admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 45, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в сервисном модуле при введении валидных Логина и Пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest45() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 46, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" (в качестве аналитика) в модуле \"Конфигуратор\", используя валидный логин и пароль")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest46() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 47, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполнительном модуле, с введением валидных данных только в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest47() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 48, groups = "sompp_admin",
            description = "Авторизация пользователя \"sompp-admin-test\" в исполнительном модуле, с введением валидных данных только в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest48() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp-admin-test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 49, groups = "sompp_admin",
            description = "Формирование отчета из журнала аудита по пользователю \"sompp-admin-test\" (вход/выход пользователя, результат, модуль, примечания, события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest49() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sompp_admin_test();
        auditSection.assertions().assertReport_sompp_admin_test();
        auditSection.logOut();
    }

    @Test(priority = 50, groups = "sompp_admin",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest50() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_sd_test", "User123").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 51, groups = "sompp_admin",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest51() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_sd_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 52, groups = "sompp_admin",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest52() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 53, groups = "sompp_admin",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest53() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №4
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sompp_isp1_test" с ролью "Пользователь регионального отделения"
//Полномочия пользователя:
//Пользователь "sompp_isp1_test" (роль "Пользователь регионального отделения", доступ "Исполнительный модуль")

    @Test (priority = 54, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest54() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_isp1_test", "user100").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test (priority = 55, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest55() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sompp_isp1_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 56, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest56 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_isp1_test", "User100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 57, groups = "sompp_reg1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sompp_isp1_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest57() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSompp_isp1_test();
        auditSection.logOut();
    }

    @Test (priority = 58, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest58() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 59, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest59() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sompp_isp1_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 60, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest60 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_isp1_test", " user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 61, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в сервисном модуле при использовании валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest61 () {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp_isp1_test", "user100").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test (priority = 62, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest62 () {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sompp_isp1_test", "user100").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test (priority = 63, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest63 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 64, groups = "sompp_reg1",
            description = "Авторизация пользователя \"sompp_isp1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest64 () {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_isp1_test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test (priority = 65, groups = "sompp_reg1",
            description = "Формирование отчета из журнала аудита по пользователю \"sompp_isp1_test\" (вход/выход пользователя)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest65 () {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sompp-admin-test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sompp_isp1_test();
        auditSection.assertions().assertReport_sompp_isp1_test();
        auditSection.logOut();
    }

    @Test(priority = 66, groups = "sompp_reg1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest66() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sompp_isp1_test", "user101").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 67, groups = "sompp_reg1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest67() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sompp_isp1_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 68, groups = "sompp_reg1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest68() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 69, groups = "sompp_reg1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest69() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

}
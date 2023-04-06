package ru.amg.unisflint.tests.sodp.frontend;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.frontend.configuration.TestSetup133stand;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import ru.amg.unisflint.source.frontend.pages.app.AppPage;
import ru.amg.unisflint.source.frontend.pages.configurator.ConfiguratorPage;
import ru.amg.unisflint.source.frontend.pages.service.ServicePage;
import ru.amg.unisflint.source.frontend.pages.service.sections.AuditSection;

public class Stand133Test extends TestSetup133stand {

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);
    ConfiguratorPage configuratorPage = Selenide.page(ConfiguratorPage.class);
    ServicePage servicePage = Selenide.page(ServicePage.class);
    AppPage appPage = Selenide.page(AppPage.class);
    AuditSection auditSection = Selenide.page(AuditSection.class);

//Группа тестов
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_ca_test" с ролью "Пользователь ЦА СОДП СБ"
//Полномочия пользователя:
//Пользователь sodp_ca_test (роль "Пользователь ЦА СОДП СБ", доступ: только Исполнительный модуль)

    @Test(priority = 1, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest1() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ca_test", "user123").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 2, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest2() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_CA_test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 3, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest3() {
        mainPage.open().
                clickAppButton();
        authPage.loginUser("sodp_ca_test", "User123")
                .clickLoginButton();
        appPage.assertions()
                .assertNoEnterToAppModule();
    }

    @Test(priority = 4, groups = "sodp_ca",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sodp_ca_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest4() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSodp_ca_test();
        auditSection.logOut();
    }

    @Test(priority = 5, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest5() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 6, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest6() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sodp_ca_test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 7, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" с валидными логином и паролем, но с пробелом в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest7() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ca_test", " user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 8, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в сервисном модуле с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest8() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_ca_test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 9, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest9() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp_ca_test", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 10, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest10() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 11, groups = "sodp_ca",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest11() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ca_test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 12, groups = "sodp_ca",
            description = "Проверка формирования отчета в жрунале аудита по пользователю \"sodp_ca_test\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest12() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sodp_ca_test();
        auditSection.assertions().assertReport_sodp_ca_test();
        auditSection.logOut();
    }

    @Test(priority = 13, groups = "sodp_ca",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest13() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sodp_ca_test", "user123").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 14, groups = "sodp_ca",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest14() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ca_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 15, groups = "sodp_ca",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest15() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 16, groups = "sodp_ca",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest16() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №2
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_ogr_test" с ролью "Пользователь ЦА" с ограничениями СОДП СБ"
//Полномочия пользователя:
//Пользователь sodp_ogr_test (роль "Пользователь ЦА с ограничениями СОДП СБ ", доступ: только Исполнительный модуль, отсутствие возможности редактирования карточек "Лицо" и "Преступление")

    @Test(priority = 17, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest17() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_test", "user100").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 18, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest18() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sOdp_ogr_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 19, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest19() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_test", "User100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 20, groups = "sodp_ogr",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sodp_ogr_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest20() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("adminCA", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSodp_ogr_test();
        auditSection.logOut();
    }

    @Test(priority = 21, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest21() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 22, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest22() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sodp_ogr_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 23, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" с валидными логином и паролем, но с пробелом в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest23() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_test", " user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 24, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в сервисном модуле с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest24() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_ogr_test", "user100").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 25, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest25() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp_ogr_test", "user100").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 26, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest26() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 27, groups = "sodp_ogr",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest27() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 28, groups = "sodp_ogr",
            description = "Проверка формирования отчета в журнале аудита по пользователю \"sodp_ogr_test\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest28() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sodp_ogr_test();
        auditSection.assertions().assertReport_sodp_ogr_test();
        auditSection.logOut();
    }

    @Test(priority = 29, groups = "sodp_ogr",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest29() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_Test", "user100").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 30, groups = "sodp_ogr",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest30() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_ogr_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 31, groups = "sodp_ogr",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest31() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 32, groups = "sodp_ogr",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest32() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №3
//Серия тестовых сценариев на авторизацию/деавторизацию в модулях: исполнительный, сервисный, конфигуратор от имени пользователя "sodp_admin_test" с ролью "Администратор СОДП СБ"
//Полномочия пользователя: добавлены полномочия аналитика
//Пользователь sodp_admin_test (роль "Администратор СОДП СБ", доступ: Исполнительный, Сервисный, Конфигуратор)

    @Test(priority = 33, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest33() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 34, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest34() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sodp_admin_test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 35, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest35() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", "Admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 36, groups = "sodp_admin",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sodp_admin_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest36() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSodp_admin_test();
        auditSection.logOut();
    }

    @Test(priority = 37, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest37() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 38, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest38() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sodp_admin_test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 39, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest39() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", " admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 40, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в сервисном модуле при введении валидных Логина и Пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest40() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 41, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" (в качестве аналитика) в модуле \"Конфигуратор\", используя валидный логин и пароль")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest41() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 42, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле, с введением валидных данных только в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest42() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 43, groups = "sodp_admin",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле, с введением валидных данных только в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest43() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 44, groups = "sodp_admin",
            description = "Формирование отчета из журнала аудита по пользователю \"sodp_admin_test\" (вход/выход пользователя, результат, модуль, примечания, события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest44() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sodp_admin_test();
        auditSection.assertions().assertReport_sodp_admin_test();
        auditSection.logOut();
    }

    @Test(priority = 45, groups = "sodp_admin",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest45() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", "admin124").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 46, groups = "sodp_admin",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest46() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_admin_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 47, groups = "sodp_admin",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest47() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 48, groups = "sodp_admin",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest48() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №4
// Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_reg1_test" с ролью "Региональный пользователь СОДП СБ"
// Полномочия пользователя:
// Пользователь sodp_reg1_test (роль "Региональный пользователь СОДП СБ", доступ: Исполнительный модуль)

    @Test(priority = 49, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest49() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", "user100").clickLoginButton();
        appPage.assertions().assertEnterToAppModule();
        appPage.logOut();
    }

    @Test(priority = 50, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest50() {
        mainPage.open().clickAppButton();
        authPage.loginUser("Sodp_reg1_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 51, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest51() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", "User100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 52, groups = "sodp_reg1",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sodp_reg1_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest52() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSodp_reg1_test();
        auditSection.logOut();
    }

    @Test(priority = 53, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest53() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 54, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest54() {
        mainPage.open().clickAppButton();
        authPage.loginUser(" sodp_reg1_test", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 55, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest55() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", " user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 56, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в сервисном модуле при использовании валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest56() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_reg1_test", "user100").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 57, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в модуле \"Конфигуратор\" с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest57() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp_reg1_test", "user100").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 58, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest58() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 59, groups = "sodp_reg1",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest59() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", "").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 60, groups = "sodp_reg1",
            description = "Формирование отчета из журнала аудита по пользователю \"sodp_reg1_test\" (вход/выход пользователя)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest60() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp_admin_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sodp_reg1_test();
        auditSection.assertions().assertReport_sodp_reg1_test();
        auditSection.logOut();
    }

    @Test(priority = 61, groups = "sodp_reg1",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest61() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", "user101").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 62, groups = "sodp_reg1",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest62() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp_reg1_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 63, groups = "sodp_reg1",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest63() {
        mainPage.open().clickAppButton();
        authPage.loginUser("", "user100").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 64, groups = "sodp_reg1",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest64() {
        mainPage.open().clickAppButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

//Группа тестов №5
// Серия тестовых сценариев на авторизацию/деавторизацию в модулях: конфигуратор, сервисный от имени пользователя "sodp0_test с ролью "Системный администратор"
// Полномочия системного администратора:
// Пользователь sodp0_test (роль "Системный администратор", доступ: только модули Сервисный и Конфигуратор)

    @Test(priority = 65, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в модуле Конфигуратор с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest65() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertEnterToConfiguratorModule();
        configuratorPage.logOut();
    }

    @Test(priority = 66, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в модуле Конфигуратор с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest66() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("Sodp0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 67, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в модуле Конфигуратор с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest67() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp0_test", "admin124").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 68, groups = "sodp_0",
            description = "Проверка факта регистрации событий безопасности (авторизации/деавторизации пользователя \"sodp0_test\") в разделе \"Аудит\" (Сервисный модуль)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest68() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.assertions().assertVisibleSodp0_test();
        auditSection.logOut();
    }

    @Test(priority = 69, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в модуле \"Конфигуратор\" с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest69() {
        mainPage.open().clickConfiguratorButton();
        authPage.clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 70, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в модуле \"Конфигуратор\" с добавлением пробела в поле 'Логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest70() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser(" sodp0_test", "admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 71, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в Конфигураторе с добавлением одиночного пробела в поле 'Пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest71() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp0_test", " admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 72, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest72() {
        mainPage.open().clickAppButton();
        authPage.loginUser("sodp0_test", "admin123").clickLoginButton();
        appPage.assertions().assertNoEnterToAppModule();
    }

    @Test(priority = 73, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в cервисном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest73() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertEnterToServiceModule();
        servicePage.logOut();
    }

    @Test(priority = 74, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest74() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 75, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest75() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 76, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest76() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 77, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest77() {
        mainPage.open().clickServiceButton();
        authPage.loginUser(" sodp0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 78, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в Конфигураторе при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest78() {
        mainPage.open().clickConfiguratorButton();
        authPage.loginUser("sodp0_test", " admin123").clickLoginButton();
        configuratorPage.assertions().assertNoEnterToConfiguratorModule();
    }

    @Test(priority = 79, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest79() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Sodp0_test", "admin123").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 80, groups = "sodp_0",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest80() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "admin124").clickLoginButton();
        servicePage.assertions().assertNoEnterToServiceModule();
    }

    @Test(priority = 81, groups = "sodp_0",
            description = "Формирование отчета из журнала аудита по пользователю \"sodp0_test\" (вход/выход пользователя,результат,модуль,примечания,события)")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest81() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "admin123").clickLoginButton();
        servicePage.changeAuditSection();
        auditSection.reportGeneration_sodp0_test();
        auditSection.assertions().assertReport_sodp0_test();
        auditSection.logOut();
    }

    @Test(priority = 82, groups = "sodp_0",
            description = "Проверка появления информационного сообщения о неудачной попытке авторизации при вводе невалидных логина или пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest82() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("Sodp0_test", "admin123").clickLoginButton();
        authPage.assertions().assertAuthErrorMessage();

    }

    @Test(priority = 83, groups = "sodp_0",
            description = "Проверка появления предупреждающего сообщения 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest83() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("sodp0_test", "").clickLoginButton();
        authPage.assertions().assertEnterPasswordMessage();
    }

    @Test(priority = 84, groups = "sodp_0",
            description = "Проверка появление предупреждающего сообщения 'Введите логин'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest84() {
        mainPage.open().clickServiceButton();
        authPage.loginUser("", "admin123").clickLoginButton();
        authPage.assertions().assertEnterLoginMessage();

    }

    @Test(priority = 85, groups = "sodp_0",
            description = "Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest85() {
        mainPage.open().clickServiceButton();
        authPage.clickLoginButton();
        authPage.assertions().assertWarnMessage();
    }

}


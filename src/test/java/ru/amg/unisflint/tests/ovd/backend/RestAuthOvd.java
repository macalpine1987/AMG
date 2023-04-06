package ru.amg.unisflint.tests.ovd.backend;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.backend.configuration.Ovd207RestSetup;
import ru.amg.unisflint.source.backend.requiests.EndPoints;
import ru.amg.unisflint.source.backend.requiests.pojo.AuthPojo;
import ru.amg.unisflint.source.utilities.loggerFilters.RestAssuredRequestFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAuthOvd extends Ovd207RestSetup {

//Группа тестов №1
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "Ruk1" с ролью "Руководитель подразделения"
//Полномочия пользователя:
//Пользователь Ruk1 (приложения ОВД ПЗ, ФИС ГИБДД-М, доступ: только Исполнительный модуль)

    @Test(priority = 1, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest1() {
        AuthPojo authPojo1 = new AuthPojo("Ruk1","b72");
        given().contentType(ContentType.JSON)
                .body(authPojo1).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("Ruk1"))
                .body("name", equalTo("Руководитель подразделения"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(false))
                .body ("permissions.pub", equalTo(false));
    }

    @Test(priority = 2, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest2 () {
        AuthPojo authPojo2 = new AuthPojo("ruk1","b72");
        given().contentType(ContentType.JSON)
                .body(authPojo2).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 3, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest3 () {
        AuthPojo authPojo3 = new AuthPojo("Ruk1","c72");
        given().contentType(ContentType.JSON)
                .body(authPojo3).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 4, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest4 () {
        AuthPojo authPojo4 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo4).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 5, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest5 () {
        AuthPojo authPojo5 = new AuthPojo(" Ruk1","b72");
        given().contentType(ContentType.JSON)
                .body(authPojo5).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 6, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" с валидными логином и паролем, но с пробелом в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest6 () {
        AuthPojo authPojo6 = new AuthPojo("Ruk1"," b72");
        given().contentType(ContentType.JSON)
                .body(authPojo6).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 7, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в сервисном модуле и конфигураторе с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest7 () {
        AuthPojo authPojo7 = new AuthPojo("Ruk1","b72");
        given().contentType(ContentType.JSON)
                .body(authPojo7).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User Руководитель подразделения haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

    @Test (priority = 8, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest8 () {
        AuthPojo authPojo8 = new AuthPojo("","b72");
        given().contentType(ContentType.JSON)
                .body(authPojo8).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 9, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Ruk1\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest9 () {
        AuthPojo authPojo9 = new AuthPojo("Ruk1","");
        given().contentType(ContentType.JSON)
                .body(authPojo9).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №2
// Серия тестовых сценариев на авторизацию/деавторизацию в модулях: конфигуратор, сервисный от имени пользователя "Bez1" с ролью "Администратор безопасности"
// Полномочия системного администратора:
// Пользователь "Bez1" (роль "Администратор безопасности", доступ: только модули Сервисный и Конфигуратор)

    @Test(priority = 10, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле и модуле \"Конфигуратор\" с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest10() {
        AuthPojo authPojo10 = new AuthPojo("Bez1","e75");
        given().contentType(ContentType.JSON)
                .body(authPojo10).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("Bez1"))
                .body("name", equalTo("Администратор безопасности"))
                .body ("permissions.wrk", equalTo(false))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 11, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле и модуле \"Конфигуратор\" с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest11 () {
        AuthPojo authPojo11 = new AuthPojo("bez1","e75");
        given().contentType(ContentType.JSON)
                .body(authPojo11).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 12, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в сервисном модуле и модуле \"Конфигуратор\" с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest12 () {
        AuthPojo authPojo12 = new AuthPojo("Bez1","v75");
        given().contentType(ContentType.JSON)
                .body(authPojo12).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 13, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в модулях \"Конфигуратор\" и \"Сервисный\"  с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest13 () {
        AuthPojo authPojo13 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo13).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 14, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в модулях \"Конфигуратор\" и \"Сервисный\" с добавлением пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest14 () {
        AuthPojo authPojo14 = new AuthPojo(" Bez1","e75");
        given().contentType(ContentType.JSON)
                .body(authPojo14).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 15, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в модулях \"Конфигуратор\" и \"Сервисный\" с добавлением пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest15 () {
        AuthPojo authPojo15 = new AuthPojo("Bez1"," e75");
        given().contentType(ContentType.JSON)
                .body(authPojo15).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test (priority = 16, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Bez1\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest16 () {
        AuthPojo authPojo16 = new AuthPojo("Bez1","e75");
        given().contentType(ContentType.JSON)
                .body(authPojo16).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User Bez1 haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

//Группа тестов №3
//Серия тестовых сценариев на авторизацию/деавторизацию в модулях: исполнительный, сервисный, конфигуратор от имени пользователя "Adm1" с ролью "Администратор СПО".
//Полномочия пользователя: добавлены полномочия аналитика
//Пользователь Adm1 (роль "Администратор СПО", доступ: Исполнительный, Сервисный, Конфигуратор)

    @Test(priority = 19, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest19() {
        AuthPojo authPojo19 = new AuthPojo("Adm1","d74");
        given().contentType(ContentType.JSON)
                .body(authPojo19).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("Adm1"))
                .body("name", equalTo("Администратор СПО"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 20, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest20 () {
        AuthPojo authPojo20 = new AuthPojo("adm1","d74");
        given().contentType(ContentType.JSON)
                .body(authPojo20).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 21, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest21 () {
        AuthPojo authPojo21 = new AuthPojo("Adm1","c74");
        given().contentType(ContentType.JSON)
                .body(authPojo21).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 22, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest22 () {
        AuthPojo authPojo22 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo22).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 23, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest23 () {
        AuthPojo authPojo23 = new AuthPojo(" Adm1","d74");
        given().contentType(ContentType.JSON)
                .body(authPojo23).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 24, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest24 () {
        AuthPojo authPojo24 = new AuthPojo("Adm1"," d74");
        given().contentType(ContentType.JSON)
                .body(authPojo24).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 25, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в сервисном модуле и модуле \"Конфигуратор\" при введении валидных Логина и Пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest25() {
        AuthPojo authPojo25 = new AuthPojo("Adm1","d74");
        given().contentType(ContentType.JSON)
                .body(authPojo25).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("Adm1"))
                .body("name", equalTo("Администратор СПО"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 26, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле, с введением валидных данных только в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest26 () {
        AuthPojo authPojo26 = new AuthPojo("","d74");
        given().contentType(ContentType.JSON)
                .body(authPojo26).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 27, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Adm1\" в исполнительном модуле, с введением валидных данных только в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest27 () {
        AuthPojo authPojo27 = new AuthPojo("Adm1","");
        given().contentType(ContentType.JSON)
                .body(authPojo27).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №4
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "Sotr1" с ролью "Сотрудник подразделения"
//Полномочия пользователя:
//Пользователь "Sotr1" (приложение ОВД ПЗ, доступ "Исполнительный модуль")

    @Test(priority = 28, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest28() {
        AuthPojo authPojo28 = new AuthPojo("Sotr1","a71");
        given().contentType(ContentType.JSON)
                .body(authPojo28).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("Sotr1"))
                .body("name", equalTo("Сотрудник подразделения"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(false))
                .body ("permissions.pub", equalTo(false));
    }

    @Test(priority = 29, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest29 () {
        AuthPojo authPojo29 = new AuthPojo("sotr1","a71");
        given().contentType(ContentType.JSON)
                .body(authPojo29).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 30, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest30 () {
        AuthPojo authPojo30 = new AuthPojo("Sotr1","f71");
        given().contentType(ContentType.JSON)
                .body(authPojo30).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 31, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest31 () {
        AuthPojo authPojo31 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo31).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 32, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest32 () {
        AuthPojo authPojo32 = new AuthPojo(" Sotr1","a71");
        given().contentType(ContentType.JSON)
                .body(authPojo32).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 33, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest33 () {
        AuthPojo authPojo33 = new AuthPojo("Sotr1"," a71");
        given().contentType(ContentType.JSON)
                .body(authPojo33).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 34, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в сервисном модуле и модуле \"Конфигуратор\" при использовании валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest34 () {
        AuthPojo authPojo34 = new AuthPojo("Sotr1","a71");
        given().contentType(ContentType.JSON)
                .body(authPojo34).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User Сотрудник подразделения haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

    @Test(priority = 35, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest35 () {
        AuthPojo authPojo35 = new AuthPojo("","a71");
        given().contentType(ContentType.JSON)
                .body(authPojo35).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 36, groups = "RestAuthOvd",
            description = "Авторизация пользователя \"Sotr1\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest36 () {
        AuthPojo authPojo36 = new AuthPojo("Sotr1","");
        given().contentType(ContentType.JSON)
                .body(authPojo36).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

}

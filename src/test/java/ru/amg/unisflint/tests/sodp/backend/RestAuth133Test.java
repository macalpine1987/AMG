package ru.amg.unisflint.tests.sodp.backend;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import ru.amg.unisflint.source.backend.configuration.Sodp133RestSetup;
import ru.amg.unisflint.source.backend.requiests.EndPoints;
import ru.amg.unisflint.source.backend.requiests.pojo.AuthPojo;
import ru.amg.unisflint.source.utilities.loggerFilters.RestAssuredRequestFilter;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAuth133Test extends Sodp133RestSetup {


//Группа тестов №1
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_ca_test" с ролью "Пользователь ЦА СОДП СБ"
//Полномочия пользователя:
//Пользователь sodp_ca_test (роль "Пользователь ЦА СОДП СБ", доступ: только Исполнительный модуль)


    @Test(priority = 1, groups = "RestAuthSodp",
            description = "\"Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с валидным логином и паролем\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest1() {
        AuthPojo authPojo1 = new AuthPojo("sodp_ca_test","user123");
        given().contentType(ContentType.JSON)
                .body(authPojo1).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp_ca_test"))
                .body("name", equalTo("sodp_ca"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(false))
                .body ("permissions.pub", equalTo(false));
    }

    @Test(priority = 2, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest2 () {
        AuthPojo authPojo2 = new AuthPojo("sodp_CA_test","user123");
        given().contentType(ContentType.JSON)
                .body(authPojo2).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 3, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest3 () {
        AuthPojo authPojo3 = new AuthPojo("sodp_ca_test","User123");
        given().contentType(ContentType.JSON)
                .body(authPojo3).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 4, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
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

    @Test (priority = 5, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest5 () {
        AuthPojo authPojo5 = new AuthPojo(" sodp_ca_test","user123");
        given().contentType(ContentType.JSON)
                .body(authPojo5).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 6, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" с валидными логином и паролем, но с пробелом в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest6 () {
        AuthPojo authPojo6 = new AuthPojo("sodp_ca_test"," user123");
        given().contentType(ContentType.JSON)
                .body(authPojo6).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 7, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в сервисном модуле и конфигураторе с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest7 () {
        AuthPojo authPojo7 = new AuthPojo("sodp_ca_test","user123");
        given().contentType(ContentType.JSON)
                .body(authPojo7).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User sodp_ca haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

    @Test (priority = 8, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле с заполнением валидными данными поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest8 () {
        AuthPojo authPojo8 = new AuthPojo("","user123");
        given().contentType(ContentType.JSON)
                .body(authPojo8).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 9, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ca_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest9 () {
        AuthPojo authPojo9 = new AuthPojo("sodp_ca_test","");
        given().contentType(ContentType.JSON)
                .body(authPojo9).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №2
//Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_ogr_test" с ролью "Пользователь ЦА" с ограничениями СОДП СБ"
//Полномочия пользователя:
//Пользователь sodp_ogr_test (роль "Пользователь ЦА с ограничениями СОДП СБ ", доступ: только Исполнительный модуль, отсутствие возможности редактирования карточек "Лицо" и "Преступление")

    @Test(priority = 10, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest10() {
        AuthPojo authPojo10 = new AuthPojo("sodp_ogr_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo10).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp_ogr_test"))
                .body("name", equalTo("sodp_ogr_test"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(false))
                .body ("permissions.pub", equalTo(false));
    }

    @Test(priority = 11, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest11 () {
        AuthPojo authPojo11 = new AuthPojo("sOdp_ogr_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo11).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 12, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполнительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest12 () {
        AuthPojo authPojo12 = new AuthPojo("sodp_ogr_test","User100");
        given().contentType(ContentType.JSON)
                .body(authPojo12).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 13, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest13 () {
        AuthPojo authPojo13 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo13).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 14, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest14 () {
        AuthPojo authPojo14 = new AuthPojo(" sodp_ogr_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo14).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 15, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest15 () {
        AuthPojo authPojo15 = new AuthPojo("sodp_ogr_test"," user100");
        given().contentType(ContentType.JSON)
                .body(authPojo15).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 16, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" в сервисном модуле и конфигураторе с использованием валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest16 () {
        AuthPojo authPojo16 = new AuthPojo("sodp_ogr_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo16).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User sodp_ogr_test haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

    @Test(priority = 17, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest17 () {
        AuthPojo authPojo17 = new AuthPojo("","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo17).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 18, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_ogr_test\" при использовании валидных логина и пароля (с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest18 () {
        AuthPojo authPojo18 = new AuthPojo("sodp_ogr_test","");
        given().contentType(ContentType.JSON)
                .body(authPojo18).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №3
//Серия тестовых сценариев на авторизацию/деавторизацию в модулях: исполнительный, сервисный, конфигуратор от имени пользователя "sodp_admin_test" с ролью "Администратор СОДП СБ"
//Полномочия пользователя: добавлены полномочия аналитика
//Пользователь sodp_admin_test (роль "Администратор СОДП СБ", доступ: Исполнительный, Сервисный, Конфигуратор)

    @Test(priority = 19, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest19() {
        AuthPojo authPojo19 = new AuthPojo("sodp_admin_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo19).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp_admin_test"))
                .body("name", equalTo("sodp_admin_test"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 20, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest20 () {
        AuthPojo authPojo20 = new AuthPojo("Sodp_admin_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo20).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 21, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest21 () {
        AuthPojo authPojo21 = new AuthPojo("sodp_admin_test","Admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo21).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 22, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
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

    @Test(priority = 23, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest23 () {
        AuthPojo authPojo23 = new AuthPojo(" sodp_admin_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo23).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 24, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest24 () {
        AuthPojo authPojo24 = new AuthPojo("sodp_admin_test"," admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo24).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 25, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в сервисном модуле и модуле \"Конфигуратор\" при введении валидных Логина и Пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest25() {
        AuthPojo authPojo25 = new AuthPojo("sodp_admin_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo25).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp_admin_test"))
                .body("name", equalTo("sodp_admin_test"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 26, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле, с введением валидных данных только в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest26 () {
        AuthPojo authPojo26 = new AuthPojo("","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo26).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 27, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_admin_test\" в исполнительном модуле, с введением валидных данных только в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest27 () {
        AuthPojo authPojo27 = new AuthPojo("sodp_admin_test","");
        given().contentType(ContentType.JSON)
                .body(authPojo27).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №4
// Серия тестовых сценариев на авторизацию/деавторизацию в исполнительном модуле от имени пользователя "sodp_reg1_test" с ролью "Региональный пользователь СОДП СБ"
// Полномочия пользователя:
// Пользователь sodp_reg1_test (роль "Региональный пользователь СОДП СБ", доступ: Исполнительный модуль)

    @Test(priority = 28, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле с валидными логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest28() {
        AuthPojo authPojo28 = new AuthPojo("sodp_reg1_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo28).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp_reg1_test"))
                .body("name", equalTo("sodp_reg1_test"))
                .body ("permissions.wrk", equalTo(true))
                .body ("permissions.cfg", equalTo(false))
                .body ("permissions.pub", equalTo(false));
    }

    @Test(priority = 29, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest29 () {
        AuthPojo authPojo29 = new AuthPojo("Sodp_reg1_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo29).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 30, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполительном модуле с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest30 () {
        AuthPojo authPojo30 = new AuthPojo("sodp_reg1_test","User100");
        given().contentType(ContentType.JSON)
                .body(authPojo30).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 31, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполительном модуле с пустыми полями \"Логин\" и \"Пароль\"")
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

    @Test(priority = 32, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле при введении валидных логина и пароля, но с добавлением одиночного пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest32 () {
        AuthPojo authPojo32 = new AuthPojo(" sodp_reg1_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo32).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 33, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле при использовании валидных логина и пароля, но с добавлением одиночного пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest33 () {
        AuthPojo authPojo33 = new AuthPojo("sodp_reg1_test"," user100");
        given().contentType(ContentType.JSON)
                .body(authPojo33).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test (priority = 34, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в сервисном модуле и модуле \"Конфигуратор\" при использовании валидного логина и пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest34 () {
        AuthPojo authPojo34 = new AuthPojo("sodp_reg1_test","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo34).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User sodp_reg1_test haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

    @Test(priority = 35, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest35 () {
        AuthPojo authPojo35 = new AuthPojo("","user100");
        given().contentType(ContentType.JSON)
                .body(authPojo35).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

    @Test(priority = 36, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp_reg1_test\" в исполнительном модуле, с заполнением валидными данными только поля \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest36 () {
        AuthPojo authPojo36 = new AuthPojo("sodp_reg1_test","");
        given().contentType(ContentType.JSON)
                .body(authPojo36).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/auth/login"));
    }

//Группа тестов №5
// Серия тестовых сценариев на авторизацию/деавторизацию в модулях: конфигуратор, сервисный от имени пользователя "sodp0_test с ролью "Системный администратор"
// Полномочия системного администратора:
// Пользователь sodp0_test (роль "Системный администратор", доступ: только модули Сервисный и Конфигуратор)

    @Test(priority = 37, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле и модуле \"Конфигуратор\" с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest37() {
        AuthPojo authPojo37 = new AuthPojo("sodp0_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo37).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(200).assertThat()
                .body("login", equalTo("sodp0_test"))
                .body("name", equalTo("sodp0_test"))
                .body ("permissions.wrk", equalTo(false))
                .body ("permissions.cfg", equalTo(true))
                .body ("permissions.pub", equalTo(true));
    }

    @Test(priority = 38, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле и модуле \"Конфигуратор\" с невалидным логином и валидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest38 () {
        AuthPojo authPojo38 = new AuthPojo("Sodp0_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo38).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 39, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в сервисном модуле и модуле \"Конфигуратор\" с валидным логином и невалидным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest39 () {
        AuthPojo authPojo39 = new AuthPojo("sodp0_test","admin124");
        given().contentType(ContentType.JSON)
                .body(authPojo39).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 40, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в модулях \"Конфигуратор\" и \"Сервисный\"  с пустыми полями \"Логин\" и \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest40 () {
        AuthPojo authPojo40 = new AuthPojo("","");
        given().contentType(ContentType.JSON)
                .body(authPojo40).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 41, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в модулях \"Конфигуратор\" и \"Сервисный\" с добавлением пробела в поле \"Логин\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest41 () {
        AuthPojo authPojo41 = new AuthPojo(" sodp0_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo41).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test(priority = 42, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в модулях \"Конфигуратор\" и \"Сервисный\" с добавлением пробела в поле \"Пароль\"")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest42 () {
        AuthPojo authPojo42 = new AuthPojo("sodp0_test"," admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo42).filter(new RestAssuredRequestFilter())
                .post(EndPoints.login).then().and().log().all()
                .statusCode(401).assertThat()
                .body("status", equalTo(401))
                .body("error", equalTo("Unauthorized"))
                .body("path", equalTo("/uf-api/v1/cfg/auth/login"));
    }

    @Test (priority = 43, groups = "RestAuthSodp",
            description = "Авторизация пользователя \"sodp0_test\" в исполнительном модуле с валидным логином и паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void authTest43 () {
        AuthPojo authPojo43 = new AuthPojo("sodp0_test","admin123");
        given().contentType(ContentType.JSON)
                .body(authPojo43).filter(new RestAssuredRequestFilter())
                .post(EndPoints.loginApp).then().and().log().all()
                .statusCode(401).assertThat()
                .body("httpStatus", equalTo("UNPROCESSABLE_ENTITY"))
                .body("message", equalTo("No permissions for this user"))
                .body("description", equalTo("User sodp0_test haven't any permissions for login"))
                .body("errors", equalTo(null));
    }

}

package ru.amg.unisflint.source.frontend.assertions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import static com.codeborne.selenide.Selenide.$;

public class AuthPageAssertions {

    AuthPage authPage = Selenide.page(AuthPage.class);

    //Проверки для страницы авторизации пользователя

    @Step ("Проверка загрузки элементов страницы авторизации пользователя")
    public AuthPageAssertions assertLoadAuthPage () {
        $ (authPage.getLoginFiled()).shouldBe(Condition.visible);
        $ (authPage.getPasswordField()).shouldBe(Condition.visible);
        $ (authPage.getLoginButton()).shouldBe(Condition.visible);
        $ (authPage.getLoginDigitalSignButton()).shouldBe(Condition.visible); return this;
    }

    @Step ("Проверка появляения сообщения \"Не удачная попытка авторизации. Проверьте логин и пароль\"")
    public AuthPageAssertions assertAuthErrorMessage () {
        $ (authPage.getAuthError()).shouldBe(Condition.visible);return this;}

    @Step ("Проверка появления предупреждающих сообщений 'Введите логин' и 'Введите пароль'")
    public AuthPageAssertions assertWarnMessage () {
        $ (authPage.getLogin_message()).shouldBe(Condition.visible);
        $ (authPage.getPassword_message()).shouldBe(Condition.visible);return this;}

    @Step ("Проверка появление предупреждающего сообщения 'Введите логин'")
    public AuthPageAssertions assertEnterLoginMessage () {
        $ (authPage.getLogin_message()).shouldBe(Condition.visible);return this;}

    @Step ("Проверка появления предупреждающего сообщения 'Введите пароль'")
    public AuthPageAssertions assertEnterPasswordMessage () {
        $ (authPage.getPassword_message()).shouldBe(Condition.visible);return this;}

}

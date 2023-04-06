package ru.amg.unisflint.source.frontend.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.AuthPageAssertions;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    public AuthPageAssertions assertions() {return new AuthPageAssertions();}

    //Элементы страницы авторизации пользователя
    @FindBy (xpath = "//input[@placeholder='Логин']")
    private SelenideElement loginFiled;

    @FindBy (xpath = "//input[@placeholder='Пароль']")
    private SelenideElement passwordField;
    @FindBy (xpath = "//button[contains(normalize-space(),'Войти')]")
    private SelenideElement loginButton;

    @FindBy (xpath = "//button[contains(normalize-space(),'Войти по ЭП')]")
    private SelenideElement loginDigitalSignButton;

    @FindBy (xpath = "//div[@class='ant-notification-notice-description'][contains(text(),'Не удачная попытка авторизации. Проверьте логин и пароль.')]")
    private SelenideElement authError;

    @FindBy (xpath = "//div[contains(text(),'Введите логин')]")
    private SelenideElement login_message;

    @FindBy (xpath = "//div[contains(text(),'Введите пароль')]")
    private SelenideElement password_message;

    //Шаги тестов

    @Step ("Ввести логин и пароль")
    public AuthPage loginUser (String username, String password) {
        $ (loginFiled).val(username);
        $ (passwordField).val(password);return this;
    }
    @Step ("Нажать кнопку \"Войти\"")
    public AuthPage clickLoginButton () {
        $ (loginButton).click();return this;
    }

    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getLoginFiled() {
        return loginFiled;
    }

    public SelenideElement getPasswordField () {
        return passwordField;
    }

    public SelenideElement getLoginButton () {
        return loginButton;
    }

    public SelenideElement getLoginDigitalSignButton () {
        return loginDigitalSignButton;
    }

    public SelenideElement getAuthError () {return authError;}
    public SelenideElement getLogin_message () {return login_message;}
    public SelenideElement getPassword_message () {return password_message;}

}

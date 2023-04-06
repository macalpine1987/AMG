package ru.amg.unisflint.source.frontend.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.MainPageAssertions;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public MainPageAssertions assertions() {return new MainPageAssertions();}

    //Элементы главной (стартовой) страницы Web-приложения
    @FindBy(xpath = "//button[contains(normalize-space(),'Конфигуратор')]")
    private SelenideElement configuratorButton;

    @FindBy (xpath = "//button[contains(normalize-space(),'Сервисный')]")
    private SelenideElement serviceButton;

    @FindBy (xpath = "//button[contains(normalize-space(),'Исполнительный')]")
    private SelenideElement appButton;

    //Элементы страницы для использования в классах Assertions
    public SelenideElement getAppButton() {
        return appButton;
    }

    public SelenideElement getServiceButton () {
        return serviceButton;
    }

    public SelenideElement getConfiguratorButton () {
        return configuratorButton;
    }

    //Шаги тестов

    @Step("Открыть главную страницу Web-приложения")
    public MainPage open () {
        Selenide.open("/");return this;
    }

    @Step ("Нажать кнопку 'Конфигуратор'")
    public MainPage clickConfiguratorButton () {
        $ (configuratorButton).click();return this;
    }
    @Step ("Нажать кнопку 'Сервисный'")
    public MainPage clickServiceButton () {
        $ (serviceButton).click();return this;
    }
    @Step ("Нажать кнопку 'Исполнительный'")
    public MainPage clickAppButton () {
        $ (appButton).click();return this;
    }

}

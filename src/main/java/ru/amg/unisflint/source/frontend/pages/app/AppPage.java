package ru.amg.unisflint.source.frontend.pages.app;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.app.AppPageAssertions;
import ru.amg.unisflint.source.frontend.pages.AuthPage;
import ru.amg.unisflint.source.frontend.pages.MainPage;
import static com.codeborne.selenide.Selenide.$;

public class AppPage {

    public AppPageAssertions assertions() {return new AppPageAssertions();}

    MainPage mainPage = Selenide.page(MainPage.class);
    AuthPage authPage = Selenide.page(AuthPage.class);

    //Элементы главной страницы Исполнительного модуля

    @FindBy(xpath = "//span[contains(normalize-space(),'Мои отчеты')]")
    private SelenideElement myReports;

    @FindBy (xpath = "//span[contains(normalize-space(),'Мои запросы')]")
    private SelenideElement myRequests;

    @FindBy (xpath = "//span[contains(normalize-space(),'Другие функции')]")
    private SelenideElement otherFunctions;

    @FindBy (xpath = "//span[contains(normalize-space(),'Главная')]")
    private SelenideElement mainLink;

    @FindBy (xpath = "//img[@alt='exit icon']")
    private SelenideElement unathorized;

    //Шаги тестовых методов

    @Step("Деавторизация пользователя")
    public AppPage logOut () {
        $ (unathorized).click();return this;
    }

    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getMyReports () {
        return myReports;
    }

    public SelenideElement getMyRequests () {
        return myRequests;
    }

    public SelenideElement getOtherFunctions () {
        return otherFunctions;
    }

    public SelenideElement getMainLink () {
        return mainLink;
    }

}

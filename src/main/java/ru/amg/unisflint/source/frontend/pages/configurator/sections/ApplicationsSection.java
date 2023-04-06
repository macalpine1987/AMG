package ru.amg.unisflint.source.frontend.pages.configurator.sections;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.configurator.sections.ApplicationsSectionAssertions;

import static com.codeborne.selenide.Selenide.$;

public class ApplicationsSection {

    public ApplicationsSectionAssertions assertions() {return new ApplicationsSectionAssertions();}

 //Элементы раздела "Приложения" модуля "Конфигуратор"


    @FindBy(xpath = "//img[@alt='exit icon']")
    private SelenideElement unathorized;

    @FindBy(xpath = "//div[@class='header__title'][normalize-space()='Название приложения']")
    private SelenideElement applicationTitle;

    @FindBy(xpath = "//div[@class='header__title'][normalize-space()='Статус']")
    private SelenideElement statusTitle;

    @FindBy(xpath = "//div[@class='header__title'][normalize-space()='Активно с']")
    private SelenideElement activeFromTitle;

    @FindBy(xpath = "//div[@class='header__title'][normalize-space()='Активно по']")
    private SelenideElement activeToTitle;

    @FindBy(xpath = "//div[@class='header__title'][normalize-space()='Версия']")
    private SelenideElement versionTitle;

    @FindBy(xpath = "//th[@key='name']//input[@placeholder='Фильтр']")
    private SelenideElement nameFilter;

    @FindBy(xpath = "//th[@key='status']//input[@placeholder='Фильтр']")
    private SelenideElement statusFilter;

    @FindBy(xpath = "//th[@key='activeFrom']//input[@placeholder='Фильтр']")
    private SelenideElement activeFromFilter;

    @FindBy(xpath = "//th[@key='activeTo']//input[@placeholder='Фильтр']")
    private SelenideElement activeToFilter;

    @FindBy(xpath = "//th[@key='version']//input[@placeholder='Фильтр']")
    private SelenideElement versionFilter;

    @FindBy (xpath = "//span[@class='button-image button-image_add']")
    private SelenideElement imageButtonAdd;

    @FindBy (xpath = "//input[@placeholder='Введите название']")
    private SelenideElement nameField;

    @FindBy (xpath = "//div[@class='ant-select-selection__rendered']")
    private SelenideElement statusField;

    @FindBy (xpath = "//li[contains(.,'Тестовый')]")
    private SelenideElement changeStatusTest;

    @FindBy (xpath = "(//input[@placeholder='Выберите дату'])[1]")
    private SelenideElement activeFromDate;

    @FindBy (xpath = "//input[@class='ant-calendar-input ']")
    private SelenideElement inputDate;

    @FindBy (xpath = "(//input[@placeholder='Выберите дату'])[2]")
    private SelenideElement activeToDate;

    @FindBy (xpath = "//textarea[@placeholder='Описание...']")
    private SelenideElement description;

    @FindBy (xpath = "//span[@class='header-wrapper d-flex']")
    private SelenideElement windowAddApplication;

    @FindBy (xpath = "//button[@class='btn btn-success ant-btn ant-btn-button']")
    private SelenideElement saveButton;

    @FindBy (xpath = "//span[contains(normalize-space(),'Новое тестовое приложение')]")
    private SelenideElement newApplicationTitle;

    @FindBy (xpath = "//span[@class='button-image button-image_delete']")
    private SelenideElement imageButtonDelete;

    @FindBy (xpath = "//span[@class='ant-modal-confirm-title'][contains(normalize-space(),'Вы действительно хотите удалить приложение \"Новое тестовое приложение\"?')]")
    private SelenideElement deleteAppMessage;

    @FindBy (xpath = "//button[@class='ant-btn ant-btn-danger']")
    private SelenideElement deleteButton;

    @FindBy (xpath = "//div[@class='ant-notification-notice-message'][contains(text(),'Объект успешно удален')]")
    private SelenideElement appDeleteSuccessMessage;

    //Шаги тестовых методов

    @Step("Деавторизация пользователя")
    public ApplicationsSection logOut() {
        $(unathorized).click();
        return this;
    }

    @Step("Нажать кнопку \"Добавить\"")
    public ApplicationsSection clickAddButton() {
        $(imageButtonAdd).click();
        return this;
    }

    @Step("Ввести наименование приложения, описание, выбрать статус и даты активности")
    public ApplicationsSection enterApplicationData() {
        $(nameField).val("Новое тестовое приложение");
        $(statusField).click();
        $(changeStatusTest).click();
        $(activeFromDate).click();
        $(inputDate).setValue("16.11.2022");
        $(windowAddApplication).click();
        $(activeToDate).click();
        $(inputDate).setValue("31.12.2022");
        $(windowAddApplication).click();
        $(description).val("Описание тестового приложения");
        return this;
    }

    @Step("Удалить тестовое приложение")
    public ApplicationsSection deleteTestApplication() {
        $(nameFilter).sendKeys("Новое тестовое приложение");
        $(imageButtonDelete).click();
        $(deleteAppMessage).shouldBe(Condition.visible);
        $(deleteButton).click();
        $(appDeleteSuccessMessage).shouldBe(Condition.visible);
        return this;

    }

    @Step("Нажать кнопку \"Сохранить\"")
    public ApplicationsSection clickSaveButton() {
        $(saveButton).click();
        return this;
    }

    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getApplicationTitle () {
        return applicationTitle;
    }

    public SelenideElement getStatusTitle () {
        return statusTitle;
    }

    public SelenideElement getActiveFromTitle () {
        return activeFromTitle;
    }

    public SelenideElement getActiveToTitle () {
        return activeToTitle;
    }

    public SelenideElement getVersionTitle () {
        return versionTitle;
    }

    public SelenideElement getNameFilter () {
        return nameFilter;
    }

    public SelenideElement getStatusFilter () {
        return statusFilter;
    }

    public SelenideElement getActiveFromFilter () {
        return activeFromFilter;
    }

    public SelenideElement getActiveToFilter () {
        return activeToFilter;
    }

    public SelenideElement getVersionFilter () {
        return versionFilter;
    }

    public SelenideElement getNewApplicationTitle () {
        return newApplicationTitle;
    }


}

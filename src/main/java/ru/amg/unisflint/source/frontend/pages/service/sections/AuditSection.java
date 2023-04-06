package ru.amg.unisflint.source.frontend.pages.service.sections;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.amg.unisflint.source.frontend.assertions.service.sections.AuditSectionAssertions;
import static com.codeborne.selenide.Selenide.$;

public class AuditSection {

    public AuditSectionAssertions assertions() {return new AuditSectionAssertions();}

    //Элементы раздела "Аудит" модуля "Сервисный"

    @FindBy(xpath = "//div[normalize-space()='sompp-sd-test']")
    private SelenideElement sompp_sd_test;

    @FindBy(xpath = "//span[contains(text(),'Выбор атрибутов')]//span[@class='icon expanded']")
    private SelenideElement change_attributes;

    @FindBy(xpath = "//span[@class='ant-tree-title'][contains(text(),'Логин инициатора')]")
    private SelenideElement initiator_login;

    @FindBy(xpath = "//div[@class='ant-select ant-select-enabled ant-select-show-arrow']")
    private SelenideElement change_terms;

    @FindBy(xpath = "//li[contains(.,'Содержит')]")
    private SelenideElement term_contains;

    @FindBy(xpath = "//input[@placeholder='Значение']")
    private SelenideElement text_value;

    @FindBy(xpath = "//div[@class='ant-modal-footer']//button[@type='button']")
    private SelenideElement terms_save;

    @FindBy(xpath = "//div[@id='app']//button[.='Сформировать отчет']")
    private SelenideElement makereport_button;

    @FindBy(xpath = "//div[@role='combobox']")
    private SelenideElement change_number_of_records;

    @FindBy(xpath = "//li[contains(.,'50')]")
    private SelenideElement change_50_records;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sompp-sd-test' не имеет доступа к модулю\"]")
    private SelenideElement sompp_sd_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sodp_ca_test' не имеет доступа к модулю\"]")
    private SelenideElement sodp_ca_test_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'Bez1' не имеет доступа к модулю\"]")
    private SelenideElement bez1_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'Ruk1' не имеет доступа к модулю\"]")
    private SelenideElement ruk1_access;

    @FindBy(xpath = "//div[normalize-space() = \"Неверные учетные данные\"]")
    private SelenideElement user_accinformation;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sompp-SD-test не найден.\"]")
    private SelenideElement sompp_SD_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь ruk1 не найден.\"]")
    private SelenideElement ruk1_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sompp-sd-test не найден.\"]")
    private SelenideElement sompp_sd_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Ruk1 не найден.\"]")
    private SelenideElement ruk1B_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь bez1 не найден.\"]")
    private SelenideElement bez1_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Bez1 не найден.\"]")
    private SelenideElement bez1B_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Исполнительный\"]")
    private SelenideElement visible_appmodule;

    @FindBy(xpath = "//div[normalize-space() = \"Конфигуратор\"]")
    private SelenideElement visible_configurator;

    @FindBy(xpath = "//div[normalize-space() = \"Сервисный\"]")
    private SelenideElement visible_service;

    @FindBy(xpath = "//div[normalize-space() = \"Неудачно\"]")
    private SelenideElement visible_unsuccessfully;

    @FindBy(xpath = "//div[normalize-space() = \"Успешно\"]")
    private SelenideElement visible_successfully;

    @FindBy(xpath = "//div[normalize-space() = \"Открытие\"]")
    private SelenideElement visible_opening;

    @FindBy(xpath = "//div[normalize-space() = \"Вход\"]")
    private SelenideElement visible_enter;

    @FindBy(xpath = "//div[normalize-space() = \"Выход\"]")
    private SelenideElement visible_exit;

    @FindBy(xpath = "//div[normalize-space()='Ruk1']")
    private SelenideElement ruk1;

    @FindBy(xpath = "//div[normalize-space()='sompp_0_test']")
    private SelenideElement sompp_0_test;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sompp_0_test' не имеет доступа к модулю\"]")
    private SelenideElement sompp_0_test_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sodp_ogr_test' не имеет доступа к модулю\"]")
    private SelenideElement sodp_ogr_test_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sodp_reg1_test' не имеет доступа к модулю\"]")
    private SelenideElement sodp_reg1_test_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'Sotr1' не имеет доступа к модулю\"]")
    private SelenideElement sotr1_access;
    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sompp_isp1_test' не имеет доступа к модулю\"]")
    private SelenideElement sompp_isp1_test_access;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь 'sodp0_test' не имеет доступа к модулю\"]")
    private SelenideElement sodp0_test_access;
    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sompp_0_test не найден.\"]")
    private SelenideElement sompp_0_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sompp-admin-test не найден.\"]")
    private SelenideElement sompp_admin_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sOdp_ogr_test не найден.\"]")
    private SelenideElement sodp_ogr_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp_ogr_test не найден.\"]")
    private SelenideElement sodp_ogr_test_not_found;
    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sompp-admin-test не найден.\"]")
    private SelenideElement sompp_admin_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sompp_0_test не найден.\"]")
    private SelenideElement sompp_0_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sompp_isp1_test не найден.\"]")
    private SelenideElement sompp_isp1_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sompp_isp1_test не найден.\"]")
    private SelenideElement sompp_isp1_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp_admin_test не найден.\"]")
    private SelenideElement sodp_admin_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sodp_admin_test не найден.\"]")
    private SelenideElement sodp_admin_testB_not_found;
    @FindBy(xpath = "//div[normalize-space() = \"Пользователь adm1 не найден.\"]")
    private SelenideElement adm1_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp_ca_test не найден.\"]")
    private SelenideElement sodp_ca_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Adm1 не найден.\"]")
    private SelenideElement adm1B_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp_CA_test не найден.\"]")
    private SelenideElement sodp_ca_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sotr1 не найден.\"]")
    private SelenideElement sotr1_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sotr1 не найден.\"]")
    private SelenideElement sotr1B_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sodp_reg1_test не найден.\"]")
    private SelenideElement sodp_reg1_testB_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp_reg1_test не найден.\"]")
    private SelenideElement sodp_reg1_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь sodp0_test не найден.\"]")
    private SelenideElement sodp0_test_not_found;

    @FindBy(xpath = "//div[normalize-space() = \"Пользователь Sodp0_test не найден.\"]")
    private SelenideElement sodp0_testB_not_found;

    @FindBy(xpath = "//div[normalize-space()='Bez1']")
    private SelenideElement bez1;

    @FindBy(xpath = "//div[normalize-space()='sompp-admin-test']")
    private SelenideElement sompp_admin_test;

    @FindBy(xpath = "//div[normalize-space()='sompp_isp1_test']")
    private SelenideElement sompp_isp1_test;

    @FindBy(xpath = "//div[normalize-space()='Adm1']")
    private SelenideElement adm1;

    @FindBy(xpath = "//div[normalize-space()='Sotr1']")
    private SelenideElement sotr1;

    @FindBy(xpath = "//div[normalize-space()='sodp_ca_test']")
    private SelenideElement sodp_ca_test;

    @FindBy(xpath = "//div[normalize-space()='sodp_ogr_test']")
    private SelenideElement sodp_ogr_test;

    @FindBy(xpath = "//div[normalize-space()='sodp_admin_test']")
    private SelenideElement sodp_admin_test;

    @FindBy(xpath = "//div[normalize-space()='sodp_reg1_test']")
    private SelenideElement sodp_reg1_test;

    @FindBy(xpath = "//div[normalize-space()='sodp0_test']")
    private SelenideElement sodp0_test;

    @FindBy(xpath = "//img[@alt='exit icon']")
    private SelenideElement unathorized;

    //Шаги тестовых методов

    @Step("Деавторизация пользователя")
    public AuditSection logOut() {
        $(unathorized).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sompp-sd-test")
    public AuditSection reportGeneration_sompp_sd_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sompp-sd-test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sompp_0_test")
    public AuditSection reportGeneration_sompp_0_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sompp_0_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sompp-admin-test")
    public AuditSection reportGeneration_sompp_admin_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sompp-admin-test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sompp_isp1_test")
    public AuditSection reportGeneration_sompp_isp1_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sompp_isp1_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: Ruk1")
    public AuditSection reportGeneration_Ruk1() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("Ruk1");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: Bez1")
    public AuditSection reportGeneration_Bez1() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("Bez1");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: Adm1")
    public AuditSection reportGeneration_Adm1() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("Adm1");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: Sotr1")
    public AuditSection reportGeneration_Sotr1() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("Sotr1");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sodp_ca_test")
    public AuditSection reportGeneration_sodp_ca_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sodp_ca_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sodp_ogr_test")
    public AuditSection reportGeneration_sodp_ogr_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sodp_ogr_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sodp_admin_test")
    public AuditSection reportGeneration_sodp_admin_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sodp_admin_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sodp_reg1_test")
    public AuditSection reportGeneration_sodp_reg1_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sodp_reg1_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    @Step("Формирование отчета (атрибут: Логин инициатора, условие: Содержит, значение: sodp0_test")
    public AuditSection reportGeneration_sodp0_test() {
        $(change_attributes).click();
        $(initiator_login).click();
        $(change_terms).click();
        $(term_contains).click();
        $(text_value).sendKeys("sodp0_test");
        $(terms_save).click();
        $(makereport_button).click();
        $(change_number_of_records).click();
        $(change_50_records).click();
        return this;
    }

    //Элементы данной страницы для использования в классах Assertions

    public SelenideElement getSompp_sd_test () {
        return sompp_sd_test;
    }
    public SelenideElement getSompp_0_test () {return sompp_0_test;}
    public SelenideElement getSompp_admin_test () {return sompp_admin_test;}
    public SelenideElement getSompp_isp1_test () {return sompp_isp1_test;}
    public SelenideElement getRuk1 () {return ruk1;}
    public SelenideElement getBez1 () {return bez1;}
    public SelenideElement getAdm1 () {return adm1;}
    public SelenideElement getSotr1 () {return sotr1;}
    public SelenideElement getSodp_ca_test () {return sodp_ca_test;}
    public SelenideElement getSodp_ogr_test () {return sodp_ogr_test;}
    public SelenideElement getSodp_admin_test () {return sodp_admin_test;}
    public SelenideElement getSodp_reg1_test () {return sodp_reg1_test;}
    public SelenideElement getSodp0_test () {return sodp0_test;}

    public SelenideElement getSompp_sd_access () {return sompp_sd_access;}
    public SelenideElement getUser_accinformation () {return user_accinformation;}
    public SelenideElement getSompp_sd_not_found () {return sompp_sd_not_found;}
    public SelenideElement getSompp_SD_not_found () {return sompp_SD_not_found;}
    public SelenideElement getVisible_appmodule () {return visible_appmodule;}
    public SelenideElement getVisible_unsuccessfully () {return visible_unsuccessfully;}
    public SelenideElement getVisible_successfully () {return visible_successfully;}
    public SelenideElement getVisible_opening () {return visible_opening;}
    public SelenideElement getVisible_exit () {return visible_exit;}
    public SelenideElement getSompp_0_test_access () {return sompp_0_test_access;}
    public SelenideElement getSompp_0_test_not_found () {return sompp_0_test_not_found;}
    public SelenideElement getSompp_0_testB_not_found () {return sompp_0_testB_not_found;}
    public SelenideElement getVisible_enter () {return visible_enter;}
    public SelenideElement getVisible_configurator () {return visible_configurator;}
    public SelenideElement getVisible_service () {return visible_service;}
    public SelenideElement getSompp_admin_test_not_found () {return sompp_admin_test_not_found;}
    public SelenideElement getSompp_admin_testB_not_found () {return sompp_admin_testB_not_found;}
    public SelenideElement getSompp_isp1_test_access () {return sompp_isp1_test_access;}
    public SelenideElement getSompp_isp1_test_not_found () {return sompp_isp1_test_not_found;}
    public SelenideElement getSompp_isp1_testB_not_found () {return sompp_isp1_testB_not_found;}
    public SelenideElement getRuk1_access () {return ruk1_access;}
    public SelenideElement getRuk1_not_found () {return ruk1_not_found;}
    public SelenideElement getRuk1B_not_found () {return ruk1B_not_found;}
    public SelenideElement getBez1_access () {return bez1_access;}
    public SelenideElement getBez1_not_found () {return bez1_not_found;}
    public SelenideElement getBez1B_not_found () {return bez1B_not_found;}
    public SelenideElement getAdm1_not_found () {return adm1_not_found;}
    public SelenideElement getAdm1B_not_found () {return adm1B_not_found;}
    public SelenideElement getSotr1_access () {return sotr1_access;}
    public SelenideElement getSotr1_not_found () {return sotr1_not_found;}
    public SelenideElement getSotr1B_not_found () {return sotr1B_not_found;}
    public SelenideElement getSodp_ca_test_access () {return sodp_ca_test_access;}
    public SelenideElement getSodp_ca_test_not_found () {return sodp_ca_test_not_found;}
    public SelenideElement getSodp_ca_testB_not_found () {return sodp_ca_testB_not_found;}
    public SelenideElement getSodp_ogr_test_access () {return sodp_ogr_test_access;}
    public SelenideElement getSodp_ogr_test_not_found () {return sodp_ogr_test_not_found;}
    public SelenideElement getSodp_ogr_testB_not_found () {return sodp_ogr_testB_not_found;}
    public SelenideElement getSodp_admin_test_not_found () {return sodp_admin_test_not_found;}
    public SelenideElement getSodp_admin_testB_not_found () {return sodp_admin_testB_not_found;}
    public SelenideElement getSodp_reg1_test_access () {return sodp_reg1_test_access;}
    public SelenideElement getSodp_reg1_test_not_found () {return sodp_reg1_test_not_found;}
    public SelenideElement getSodp_reg1_testB_not_found () {return sodp_reg1_testB_not_found;}
    public SelenideElement getSodp0_test_access () {return sodp0_test_access;}
    public SelenideElement getSodp0_test_not_found () {return sodp0_test_not_found;}
    public SelenideElement getSodp0_testB_not_found () {return sodp0_testB_not_found;}


}

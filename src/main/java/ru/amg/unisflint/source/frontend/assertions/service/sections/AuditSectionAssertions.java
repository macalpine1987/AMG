package ru.amg.unisflint.source.frontend.assertions.service.sections;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.service.sections.AuditSection;
import static com.codeborne.selenide.Selenide.$;

public class AuditSectionAssertions {

    AuditSection auditSection = Selenide.page(AuditSection.class);

    //Проверки для раздела "Аудит" модуля "Конфигуратор"

    @Step("Проверка факта регистрации пользователя 'sompp-sd-test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSompp_sd_test() {
        $(auditSection.getSompp_sd_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sompp_0_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSompp_0_test() {
        $(auditSection.getSompp_0_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sompp_admin_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSompp_admin_test() {
        $(auditSection.getSompp_admin_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sompp_isp1_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSompp_isp1_test() {
        $(auditSection.getSompp_isp1_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'Ruk1' в журнале аудита")
    public AuditSectionAssertions assertVisibleRuk1_test() {
        $(auditSection.getRuk1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'Bez1' в журнале аудита")
    public AuditSectionAssertions assertVisibleBez1() {
        $(auditSection.getBez1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'Adm1' в журнале аудита")
    public AuditSectionAssertions assertVisibleAdm1() {
        $(auditSection.getAdm1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'Sotr1' в журнале аудита")
    public AuditSectionAssertions assertVisibleSotr1() {
        $(auditSection.getSotr1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sodp_ca_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSodp_ca_test() {
        $(auditSection.getSodp_ca_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sodp_ogr_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSodp_ogr_test() {
        $(auditSection.getSodp_ogr_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sodp_admin_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSodp_admin_test() {
        $(auditSection.getSodp_admin_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sodp_reg1_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSodp_reg1_test() {
        $(auditSection.getSodp_reg1_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка факта регистрации пользователя 'sodp0_test' в журнале аудита")
    public AuditSectionAssertions assertVisibleSodp0_test() {
        $(auditSection.getSodp0_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sompp-sd-test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sompp_sd_test() {
        $(auditSection.getSompp_sd_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSompp_sd_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSompp_SD_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getSompp_sd_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sompp_0_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sompp_0_test() {
        $(auditSection.getSompp_0_test_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSompp_0_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSompp_0_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getSompp_0_test()).shouldBe(Condition.visible);
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sompp_admin_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sompp_admin_test() {
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSompp_admin_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSompp_admin_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSompp_admin_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sompp_isp1_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sompp_isp1_test() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getSompp_isp1_test_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSompp_isp1_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSompp_isp1_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSompp_isp1_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'Ruk1' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_Ruk1() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getRuk1_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getRuk1_not_found()).shouldBe(Condition.visible);
        $(auditSection.getRuk1B_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getRuk1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'Bez1' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_Bez1() {
        $(auditSection.getBez1_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getBez1_not_found()).shouldBe(Condition.visible);
        $(auditSection.getBez1B_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getBez1()).shouldBe(Condition.visible);
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'Adm1' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_Adm1() {
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getAdm1_not_found()).shouldBe(Condition.visible);
        $(auditSection.getAdm1B_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getAdm1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'Adm1' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_Sotr1() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getSotr1_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSotr1_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSotr1B_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSotr1()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sodp_ca_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sodp_ca_test() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ca_test_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ca_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ca_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ca_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sodp_ogr_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sodp_ogr_test() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ogr_test_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ogr_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ogr_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSodp_ogr_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sodp_admin_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sodp_admin_test() {
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSodp_admin_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSodp_admin_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSodp_admin_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sodp_reg1_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sodp_reg1_test() {
        $(auditSection.getVisible_appmodule()).shouldBe(Condition.visible);
        $(auditSection.getSodp_reg1_test()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSodp_reg1_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSodp_reg1_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSodp_reg1_test()).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка наличия информации в журнале аудита о пользователе 'sodp0_test' (вход/выход, результат, модуль, примечания, события)")
    public AuditSectionAssertions assertReport_sodp0_test() {
        $(auditSection.getSodp0_test_access()).shouldBe(Condition.visible);
        $(auditSection.getUser_accinformation()).shouldBe(Condition.visible);
        $(auditSection.getSodp0_test_not_found()).shouldBe(Condition.visible);
        $(auditSection.getSodp0_testB_not_found()).shouldBe(Condition.visible);
        $(auditSection.getVisible_unsuccessfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_successfully()).shouldBe(Condition.visible);
        $(auditSection.getVisible_opening()).shouldBe(Condition.visible);
        $(auditSection.getVisible_exit()).shouldBe(Condition.visible);
        $(auditSection.getVisible_enter()).shouldBe(Condition.visible);
        $(auditSection.getSodp0_test()).shouldBe(Condition.visible);
        $(auditSection.getVisible_configurator()).shouldBe(Condition.visible);
        $(auditSection.getVisible_service()).shouldBe(Condition.visible);
        return this;
    }


}

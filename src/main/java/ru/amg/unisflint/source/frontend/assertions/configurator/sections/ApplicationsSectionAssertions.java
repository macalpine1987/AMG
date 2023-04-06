package ru.amg.unisflint.source.frontend.assertions.configurator.sections;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.amg.unisflint.source.frontend.pages.configurator.sections.ApplicationsSection;
import static com.codeborne.selenide.Selenide.$;

public class ApplicationsSectionAssertions {

    ApplicationsSection applicationsSection = Selenide.page(ApplicationsSection.class);

    //Проверки для раздела "Приложения" модуля "Конфигуратор"

    @Step("Проверка наличия необходимых элементов во вкладке \"Приложения\" модуля \"Конфигуратор\"")
    public ApplicationsSectionAssertions assertElementsApplicationsSideBar() {
        $ (applicationsSection.getApplicationTitle()).shouldBe(Condition.visible);
        $ (applicationsSection.getStatusTitle()).shouldBe(Condition.visible);
        $ (applicationsSection.getActiveFromTitle()).shouldBe(Condition.visible);
        $ (applicationsSection.getActiveToTitle()).shouldBe(Condition.visible);
        $ (applicationsSection.getVersionTitle()).shouldBe(Condition.visible);
        $ (applicationsSection.getNameFilter()).shouldBe(Condition.visible);
        $ (applicationsSection.getStatusFilter()).shouldBe(Condition.visible);
        $ (applicationsSection.getActiveFromFilter()).shouldBe(Condition.visible);
        $ (applicationsSection.getActiveToFilter()).shouldBe(Condition.visible);
        $ (applicationsSection.getVersionFilter()).shouldBe(Condition.visible);
        return this;
    }

}

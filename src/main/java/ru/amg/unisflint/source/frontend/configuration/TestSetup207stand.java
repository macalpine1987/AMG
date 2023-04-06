package ru.amg.unisflint.source.frontend.configuration;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.SoftAsserts;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.amg.unisflint.source.utilities.listeners.TestListener;
import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners({TestListener.class, TextReport.class, SoftAsserts.class})
public class TestSetup207stand {

    Logger logger = LoggerFactory.getLogger(TestSetup207stand.class);

    @BeforeClass(alwaysRun = true)
    public void setupLaunchStand() {
        Configuration.baseUrl = System.getProperty("selenide.baseUrl", "http://10.100.20.207");
        Configuration.browser = System.getProperty("selenide.browser", "firefox");
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.headless = true;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Selenide.clearBrowserCookies();
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestStart(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(p));
        TextReport.onSucceededTest = true;
        TextReport.onFailedTest = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).savePageSource(false));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method, Object[] p) {
        logger.info("Stop test " + method.getName());
    }

}




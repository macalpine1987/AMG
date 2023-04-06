package ru.amg.unisflint.source.backend.configuration;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.amg.unisflint.source.utilities.listeners.RestListener;
import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(RestListener.class)
public class Ovd207RestSetup {

    Logger logger = LoggerFactory.getLogger(Ovd207RestSetup.class);


    @BeforeClass(alwaysRun = true)
    public void setUp () {
        RestAssured.baseURI = System.getProperty("RestAssured.baseUrl","http://10.100.20.207/");

    }

    @BeforeMethod(alwaysRun = true)
    public void logTestStart(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + " with parameters " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method, Object[] p) {
        logger.info("Stop test " + method.getName());}

}

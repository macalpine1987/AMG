package ru.amg.unisflint.source.utilities.listeners;
import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RestListener implements ITestListener {

    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    private PrintStream requestVar = new PrintStream(request, true);
    private PrintStream responseVar = new PrintStream(response, true);

    public void onStart(ITestContext ITestContext) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
        System.out.println("Начало тестирования");
    }

    public void onTestSuccess(ITestResult TestResult) {
        logRequest(request);
        logResponse(response);
        System.out.println("Тест " + TestResult.getName() + " прошел успешно");
    }

    public void onTestFailure(ITestResult TestResult) {
        System.out.println("Тест " + TestResult.getName() + " не пройден. Фактический результат отличается от ожидаемого");;
    }

    @Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment(value = "response")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult TestResult) {
        System.out.println("Тест " + TestResult.getName() + " запущен");
        System.out.println(TestResult.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult TestResult) {
        System.out.println("Тест пропущен :" + TestResult.getName());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {

    }

    public void onFinish(ITestContext TestContext) {
        System.out.println("Тестирование завершено");

    }

}

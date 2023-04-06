package ru.amg.unisflint.source.utilities.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult TestResult) {
        System.out.println("Тест " + TestResult.getName() + " запущен");
        System.out.println(TestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult TestResult) {
        System.out.println("Тест " + TestResult.getName() + " прошел успешно");
    }

    @Override
    public void onTestFailure(ITestResult TestResult) {
        System.out.println("Тест " + TestResult.getName() + " не пройден. Фактический результат отличается от ожидаемого");
    }

    @Override
    public void onTestSkipped(ITestResult TestResult) {
        System.out.println("Тест пропущен :" + TestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {

    }

    @Override
    public void onStart(ITestContext TestContext) {
        System.out.println("Начало тестирования");

    }

    @Override
    public void onFinish(ITestContext TestContext) {
        System.out.println("Тестирование завершено");

    }

}

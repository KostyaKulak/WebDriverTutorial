package util.listener;

import factory.BrowserManager;
import factory.BrowserManagerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.propertiesreader.PropertiesReader;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        BrowserManagerFactory.getManager(PropertiesReader.getPropertyValue("browser")).createDriver();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        BrowserManager.quitDriver();
    }
}

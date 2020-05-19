package com.automation.utilities;

import com.automation.commons.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ExtentReporterNG extends BaseClass {
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extentReport;
    public ExtentTest extentTest;

    @BeforeTest
    public ExtentReports setHtmlReport() {
        String sPath = System.getProperty("user.dir") +
                "/src/testOutput/HtmlReports.html";
        htmlReporter = new ExtentHtmlReporter(sPath);
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("HostName", "Localhost");
        extentReport.setSystemInfo("OS", "Windows");
        extentReport.setSystemInfo("Browser", "Chrome");
        return extentReport;
    }

    @AfterTest
    public void endReport() {
        extentReport.flush();
    }
}

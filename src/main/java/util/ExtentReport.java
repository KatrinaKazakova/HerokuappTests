package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    public static ExtentReports extent;
    public static ExtentHtmlReporter reporter;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") + "/test-reports/ExtentReport.html";
        reporter = new ExtentHtmlReporter(path);

        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setReportName("Ekaterina Kazakova Challenge Test");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Environment", "Live");
        extent.setSystemInfo("QA Engineer", "Ekaterina Kazakova");
        return extent;
    }
}

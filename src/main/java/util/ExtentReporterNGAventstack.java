package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNGAventstack {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") + "//test-output//report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setReportName("Ekaterina Kazakova Challenge Test");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Environment", "Live");
        extent.setSystemInfo("Tester", "Ekaterina Kazakova");
        return extent;
    }
}

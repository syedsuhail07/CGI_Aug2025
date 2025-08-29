package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    static String projectpath = System.getProperty("user.dir");

    public static ExtentReports getinstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(
                    projectpath + "\\29thAug_ExtentReport(ExtentManager).html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}

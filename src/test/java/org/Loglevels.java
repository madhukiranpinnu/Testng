package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Loglevels {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\loglevels.html");
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest test1=extentReports.createTest("Madhu");
        test1.log(Status.INFO,"info1")
                .log(Status.INFO,"info2")
                .log(Status.PASS,"pass")
                .log(Status.FAIL,"fail")
                .log(Status.SKIP,"skipped")
                .log(Status.WARNING,"warning");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\loglevels.html").toURI());
    }
}

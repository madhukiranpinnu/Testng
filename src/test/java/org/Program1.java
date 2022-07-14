package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Program1 {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        File file=new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\sparkreport.html");
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        ExtentTest test1=extentReports.createTest("Test1");
        test1.pass("hey it is passed");
        ExtentTest test2=extentReports.createTest("Test1");
        test2.log(Status.FAIL,"status is failed");
        extentReports.createTest("Test3").log(Status.SKIP,"skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\sparkreport.html").toURI());
    }
}

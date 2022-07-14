package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GenerateReportsofStatus {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        File file1=new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\pass.html");
        File file2=new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\fail.html");
        File file3=new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\warning.html");
        ExtentSparkReporter sparkReporter1=new ExtentSparkReporter(file1);
        sparkReporter1.filter().statusFilter().as(new Status[]{Status.PASS}).apply();
        ExtentSparkReporter sparkReporter2=new ExtentSparkReporter(file2);
        sparkReporter2.filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        ExtentSparkReporter sparkReporter3=new ExtentSparkReporter(file3);
        sparkReporter3.filter().statusFilter().as(new Status[]{Status.WARNING}).apply();
        extentReports.attachReporter(sparkReporter1,sparkReporter2,sparkReporter3);
        ExtentTest test1=extentReports.createTest("Test1");
        test1.pass("hey it is passed");
        ExtentTest test2=extentReports.createTest("Test1");
        test2.log(Status.FAIL,"status is failed");
        extentReports.createTest("Test3").log(Status.WARNING,"Warning");
        extentReports.flush();
        Desktop.getDesktop().browse(new File(String.valueOf(file1)).toURI());
        Desktop.getDesktop().browse(new File(String.valueOf(file2)).toURI());
        Desktop.getDesktop().browse(new File(String.valueOf(file3)).toURI());
    }
}

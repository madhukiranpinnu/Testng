package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DifferentAttributesinExtentreports {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\differentattributes.html"));
        extentReports.attachReporter(extentSparkReporter);
        extentReports.createTest("Testhere")
                .assignAuthor("Madhukiran")
                .assignCategory("smoke")
                .assignDevice("Chrome 211.4.5");
        ExtentTest test2=extentReports.createTest("Doit")
                .assignAuthor("kiran")
                .assignCategory("sanity")
                .assignDevice("edge 123.56");
        test2.log(Status.FAIL,"Failed");
        ExtentTest test3=extentReports.createTest("Doit")
                .assignAuthor("pinnu")
                .assignCategory("regression")
                .assignDevice("IE 55.56");
        test3.log(Status.SKIP,"Skipped");
        ExtentTest test4=extentReports.createTest("Doit")
                .assignAuthor("pinnu","sai","choru","ggh")
                .assignCategory("regression","Sanity","smoke")
                .assignDevice("IE 55.56","Chrome 123","IPOD");
        test4.log(Status.PASS,"Skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\differentattributes.html").toURI());
    }
}

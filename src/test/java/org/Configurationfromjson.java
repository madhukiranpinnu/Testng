package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Configurationfromjson {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\Configurationjs.html");
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.loadJSONConfig(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\resources\\extenreportsconfig.json"));
        ExtentTest test4=extentReports.createTest("Doit")
                .assignAuthor("pinnu","sai","choru","ggh")
                .assignCategory("regression","Sanity","smoke")
                .assignDevice("IE 55.56","Chrome 123","IPOD");
        test4.log(Status.PASS,"Skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\Configurationjs.html").toURI());
    }
}

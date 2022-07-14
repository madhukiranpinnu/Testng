package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ConfigurationExtent {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\Configuration.html");
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Config REport");
        extentSparkReporter.config().setDocumentTitle("My first document");
        extentSparkReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        extentSparkReporter.config().setCss(".badge-primary {background-color: darkred;}");
        ExtentTest test4=extentReports.createTest("Doit")
                .assignAuthor("pinnu","sai","choru","ggh")
                .assignCategory("regression","Sanity","smoke")
                .assignDevice("IE 55.56","Chrome 123","IPOD");
        test4.log(Status.PASS,"Skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\Configuration.html").toURI());
    }
}

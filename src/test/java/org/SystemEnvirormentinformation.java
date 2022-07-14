package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SystemEnvirormentinformation {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\SystemEnvirorment.html");
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.loadJSONConfig(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\resources\\extenreportsconfig.json"));
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       String Browsername= ((RemoteWebDriver)driver).getCapabilities().getBrowserName();
       String BrowserVersion=((RemoteWebDriver)driver).getCapabilities().getBrowserVersion();
       String OS=System.getProperty("os.name");
       String java=System.getProperty("java.version");
       extentReports.setSystemInfo("OS",OS);
       extentReports.setSystemInfo("JavaVersion",java);
       extentReports.setSystemInfo("Browsername",Browsername);
       extentReports.setSystemInfo("VersionofBrowser",BrowserVersion);
       extentReports.setSystemInfo("AppURL","www.google.com");
        driver.quit();
        ExtentTest test4=extentReports.createTest("Doit")
                .assignAuthor("pinnu","sai","choru","ggh")
                .assignCategory("regression","Sanity","smoke")
                .assignDevice("IE 55.56","Chrome 123","IPOD");
        test4.log(Status.PASS,"Skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\SystemEnvirorment.html").toURI());
    }
}

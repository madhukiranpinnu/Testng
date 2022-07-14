package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Screenshot {
    static WebDriver driver;
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports=new ExtentReports();
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\screenshot.html");
        extentReports.attachReporter(extentSparkReporter);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
        String base64=captureScreenshotAsBASE64();
        ExtentTest test1=extentReports.createTest("madhu","We are attaching Screenshot");
        test1.info("image").addScreenCaptureFromBase64String(base64,"Google Homepage");
        extentReports.createTest("madhu log level")
                .fail("failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
        Throwable t=new RuntimeException("exceptio occu red");
        extentReports.createTest("with erorr message").fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\screenshot.html").toURI());
    }
    public static String captureScreenshotAsBASE64(){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        String base64=takesScreenshot.getScreenshotAs(OutputType.BASE64);
        return base64;
    }
}

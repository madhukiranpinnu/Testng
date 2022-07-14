package Sample1ExtentTestng;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    public static WebDriver driver;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    @BeforeSuite
    public void InitialisationReports(){
        extentReports=new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\screenshot\\Reports.html");
        extentReports.attachReporter(sparkReporter);
    }
    @AfterSuite
    public void GenerateReports() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\screenshot\\Reports.html").toURI());
    }
    @Parameters("browser")
    @BeforeTest
     public void BeforeTest(ITestContext context,String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Given Wrong Browser details");
                break;
    }
    extentTest=extentReports.createTest(context.getName());
    }
    @AfterTest
    public void Teardown(){
        driver.quit();
    }
    @AfterMethod
    public void Method(Method m, ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            String filepath=null;
            filepath=Screenshot(result.getTestContext().getName()+"-"+result.getMethod().getMethodName()+".jpg");
            extentTest.addScreenCaptureFromPath(filepath);
            extentTest.log(Status.FAIL,result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
        if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.fail(m.getName());
        }
        }
    }
    public String Screenshot(String filenme) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
        File Source=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File Dest= new File("filenme");
        FileUtils.copyFile(Source,Dest);
        return Dest.getAbsolutePath();
    }

}

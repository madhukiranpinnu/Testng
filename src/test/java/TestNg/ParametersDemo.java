package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class ParametersDemo {
    public WebDriver driver;
    @Parameters("browsername")
    @BeforeTest
    public void startBrowser(String browsername){
        switch (browsername.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "fire":
                WebDriverManager.firefoxdriver().setup();
                driver=new EdgeDriver();
            default:
                System.err.println("invalid browser");
        }

        driver.manage().window().maximize();
    }
    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }
    @Parameters("url")
    @Test
    public void launchURL(@Optional("https://opensource-demo.orangehrmlive.com/index.php/auth/login") String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }
    @Parameters({"username","password"})
    @Test
    public void LoginPage(String username,String password){
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}

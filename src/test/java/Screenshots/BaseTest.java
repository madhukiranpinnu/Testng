package Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest {
    public WebDriver driver;
    @Test
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @Test
    public void quit(){
        driver.quit();
    }
    public String  TesScreen(String s){
        TakesScreenshot base64=(TakesScreenshot) driver;
        String base=base64.getScreenshotAs(OutputType.BASE64);
        return base;
    }
}

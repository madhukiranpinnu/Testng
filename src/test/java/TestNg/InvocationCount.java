package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCount {
    @Test(invocationCount = 3,invocationTimeOut = 100000,threadPoolSize = 3)
    public void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.testingdocs.com/enable-testng-in-intellij-ide/");
        driver.quit();
    }
}

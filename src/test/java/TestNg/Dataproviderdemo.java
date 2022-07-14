package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo {
    @Test(dataProvider = "dataSend")
    //@Test(dataProvider = "dataHere")
    public void Orange(String username,String password){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @DataProvider
    //@DataProvider(name = "dataHere")
    @Test
    public Object[][] dataSend(){
        Object[][] data=new Object[2][2];
        data[0][0]="Admin";
        data[0][1]="admin123";
        data[1][0]="Admin1";
        data[1][1]="admin123";
        return data;
    }
}

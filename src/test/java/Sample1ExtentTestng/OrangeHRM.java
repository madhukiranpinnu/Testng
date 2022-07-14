package Sample1ExtentTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrangeHRM extends BaseTest {
    @Test(testName = "orangeHRM")
    public void OrangeTitle(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        extentTest.info("Navigated to Url");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        extentTest.info("sent userid");
        driver.findElement(By.id("txtPassword")).sendKeys("admin1234");
        extentTest.info("sent password");
        driver.findElement(By.id("btnLogin")).click();
        extentTest.info("clicked on submit");
        Assert.assertTrue(driver.findElement(By.id("welcome123")).isDisplayed());
        extentTest.pass("sucessfully loggedin");
    }
}

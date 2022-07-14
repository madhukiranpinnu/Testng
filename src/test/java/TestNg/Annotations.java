package TestNg;

import org.testng.annotations.*;

public class Annotations {
    @Test
    public void Test1(){
        System.out.println("Test");
    }
    @Test
    public void Test2(){
        System.out.println("Test2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
       System.out.println("after Method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("After Suite");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
}

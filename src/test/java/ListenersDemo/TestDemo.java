package ListenersDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ITestListnerClass.class)
public class TestDemo {
    @Test
    public void A1(){
        System.out.println("A1"+Thread.currentThread().getId());
    }
    @Test
    public void A2(){
        System.out.println("A2"+Thread.currentThread().getId());
        Assert.assertEquals(1,2);
    }
    @Test(dependsOnMethods = "A2")
    public void A3(){
        System.out.println("A3"+Thread.currentThread().getId());
    }
    @Test
    public void A4(){
        System.out.println("A4"+Thread.currentThread().getId());
    }
    @Test
    public void A5(){
        System.out.println("A5"+Thread.currentThread().getId());
    }
}

package TestNg;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Ignore
public class Softassertions {
    //@Ignore
    @Test(enabled = true)
    public void Soft(){
        int a=10;
        int b=20;
        int c=20;
        SoftAssert softAssert=new SoftAssert();
        System.out.println("started");
        softAssert.assertEquals(b,c,"passed");
        softAssert.assertEquals(a,b,"failed");
        System.out.println("after failed");
        softAssert.assertEquals(b,c,"passed");
        System.out.println("after passed");
        softAssert.assertAll();
    }
}

package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
    @Test
    public void TestInteger(){
     int a=1;
     int b=2;
        Assert.assertEquals(a,b,"integers are not equal");
    }
    @Test
    public void TestBooleon(){
        Boolean a=true;
        Boolean b=false;
        Assert.assertNotEquals(a,b,"The booleon Values are different");
    }
    @Test
    public void TestString(){
        String a="madhu";
        String b="madhu";
        Assert.assertEquals(a,b);
    }
    @Test
    public void TestInteger1(){
        int a=100;
        int b=105;
        Assert.assertTrue(a-b>5,"true");
    }
    @Test
    public void TestInteger2(){
        int a=100;
        int b=105;
        Assert.assertFalse(a-b>5,"true");
    }
    @Test
    public void TestNull(){
        Assert.assertNull(null);
    }
    @Test
    public void TestNotNull(){
        Assert.assertNotNull(null);
    }

}

package Grouping;

import org.testng.annotations.Test;
@Test(groups = "all")
public class Grp1 {
    @Test(groups = {"smoke","functional"})
    public void Test1(){
        System.out.println(1);
        System.out.println(System.getProperty("userName"));
        System.out.println(System.getProperty("password"));
    }
    @Test(groups = {"smoke","sanity"})
    public void Test2(){
        System.out.println(2);
    }
    @Test(groups = {"sanity","daily","smoke"})
    public void Test3(){
        System.out.println(3);
    }
}

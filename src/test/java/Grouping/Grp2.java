package Grouping;

import org.testng.annotations.Test;

public class Grp2 {
    @Test(groups = "weekly")
    public void Test4(){
        System.out.println(4);
    }
    @Test(groups = {"sanity","monthly"})
    public void Test5(){
        System.out.println(5);
    }
    @Test(groups = {"sanity","daily","smoke","functional"})
    public void Test6(){
        System.out.println(6);
    }
}

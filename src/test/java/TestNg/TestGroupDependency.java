package TestNg;

import org.testng.annotations.Test;

public class TestGroupDependency {
    @Test(groups = "smoke")
    public void T1(){
        System.out.println("1");
    }
    @Test(groups = "smoke")
    public void T2(){
        System.out.println("2");
    }
    @Test(groups = "smoke")
    public void T3(){
        System.out.println("3");
        //System.out.println(5/0);
    }
    @Test(groups = "sanity")
    public void T4(){
        System.out.println("4");
    }
    @Test(groups = "sanity")
    public void T5(){
        System.out.println("5");
    }
    @Test(groups = "reg")
    public void T6(){
        System.out.println("6");
        //System.out.println(5/0);
    }
    @Test(dependsOnGroups = {"smoke","sanity"},alwaysRun = true)
    public void Tnain(){
        System.out.println("main");
    }
}

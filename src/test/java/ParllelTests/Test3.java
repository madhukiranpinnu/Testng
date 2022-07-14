package ParllelTests;

import org.testng.annotations.Test;

public class Test3 {
    @Test
    public void C1(){
        System.out.println("C1"+Thread.currentThread().getId());
    }
    @Test
    public void C2(){
        System.out.println("C2"+Thread.currentThread().getId());
    }
    @Test
    public void C3(){
        System.out.println("C3"+Thread.currentThread().getId());
    }
    @Test
    public void C4(){
        System.out.println("C4"+Thread.currentThread().getId());
    }
    @Test
    public void C5(){
        System.out.println("C5"+Thread.currentThread().getId());
    }
}

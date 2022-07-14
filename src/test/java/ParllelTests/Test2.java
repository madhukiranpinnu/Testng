package ParllelTests;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void B1(){
        System.out.println("B1"+Thread.currentThread().getId());
    }
    @Test
    public void B2(){
        System.out.println("B2"+Thread.currentThread().getId());
    }
    @Test
    public void B3(){
        System.out.println("B3"+Thread.currentThread().getId());
    }
    @Test
    public void B4(){
        System.out.println("B4"+Thread.currentThread().getId());
    }
    @Test
    public void B5(){
        System.out.println("B5"+Thread.currentThread().getId());
    }
}

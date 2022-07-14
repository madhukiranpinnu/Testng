package ParllelTests;

import org.testng.annotations.Test;

public class Test4 {
    @Test
    public void D1(){
        System.out.println("D1"+Thread.currentThread().getId());
    }
    @Test
    public void D2(){
        System.out.println("D2"+Thread.currentThread().getId());
    }
    @Test
    public void D3(){
        System.out.println("D3"+Thread.currentThread().getId());
    }
    @Test
    public void D4(){
        System.out.println("D"+Thread.currentThread().getId());
    }
    @Test
    public void D5(){
        System.out.println("D5"+Thread.currentThread().getId());
    }
}

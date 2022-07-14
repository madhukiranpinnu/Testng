package TestNg;

import org.testng.annotations.Test;

public class PriorityDemo {
    @Test(priority=1)
    public void Signup(){
        System.out.println("signup");
    }
    @Test(priority = 2)
    public void login(){
        System.out.println("login");
    }
    @Test(priority = 3)
    public void SearchFlight(){
        System.out.println("SearchFlight");
    }
    @Test(priority = 4)
    public void BookFlight(){
        System.out.println("BookFlight");
    }
    @Test(priority = 5)
    public void Payment(){
        System.out.println("Payment");
    }
    @Test(priority = 6)
    public void confirmation(){
        System.out.println("confirmation");
    }
}

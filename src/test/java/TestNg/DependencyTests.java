package TestNg;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependencyTests {
    static public String id="null";
   /** @Ignore
    @Test(priority = 3)
    public void CreateShipment(){
        System.out.println("Create Shipment");
        id="123RT";
        //System.out.println(5/0);
    }
    */
    @Test(dependsOnMethods ={"CreateShipment"},priority = 1 , ignoreMissingDependencies =true)
    public void TrackShipment() throws Exception {
        //System.out.println(5/0);
        if(id !="null"){
            System.out.println("tracked");
        }
        else{
            throw new Exception("not tracked");
        }
    }
    @Test(dependsOnMethods = {"TrackShipment","CreateShipment"},priority =2)
    public void CancelShipment() throws Exception {
        if(id !="null"){
            System.out.println("cancelled");
        }
        else{
            throw new Exception("not cancelled");
        }
    }
}

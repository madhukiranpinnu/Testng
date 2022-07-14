package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderSingleDimension {
    @Test(dataProvider = "data")
    public void Printer(String name){
        System.out.println(name);
    }
    @DataProvider(name="data")
    public Object[] dataContainer(){
        String[] st=new String[]{
                "madhu","kiran","pinnu"
        };
        return st;
    }
}

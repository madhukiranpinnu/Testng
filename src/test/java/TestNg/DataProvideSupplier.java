package TestNg;

import org.testng.annotations.DataProvider;

public class DataProvideSupplier {
    @DataProvider(name="data")
    public Object[] dataContainer(){
        String[] st=new String[]{
                "madhu","kiran","pinnu"
        };
        return st;
    }
}

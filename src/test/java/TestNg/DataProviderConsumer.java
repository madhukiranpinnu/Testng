package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConsumer {
    @Test(dataProvider = "data",dataProviderClass = DataProvideSupplier.class)
    public void Printer(String name){
        System.out.println(name);
    }
}

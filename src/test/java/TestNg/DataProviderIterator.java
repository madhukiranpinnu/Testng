package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderIterator {
    @Test(dataProvider = "data")
    public void Printer(String name){
        System.out.println(name);
    }
    @DataProvider(name="data")
    public Iterator<String> dataContainer(){
        List<String> al=new ArrayList<>();
        al.add("madhu");
        al.add("kiran");
        al.add("pinnu");
        return al.iterator();
    }
}

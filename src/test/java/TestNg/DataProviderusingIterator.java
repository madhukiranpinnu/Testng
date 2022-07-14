package TestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderusingIterator {
    @Test(dataProvider = "data")
    public void Printer(Object[] a){
        System.out.println(a[0]+"-------"+a[1]);
    }
    @DataProvider(name="data")
    public Iterator<Object[]> dataContainer(){
        List<Object[]> al=new ArrayList<>();
        al.add(new Object[]{"madhu","kiran"});
        al.add(new Object[]{"pinnu","kiran"});
        al.add(new Object[]{"sai","kiran"});
        return al.iterator();
    }
}

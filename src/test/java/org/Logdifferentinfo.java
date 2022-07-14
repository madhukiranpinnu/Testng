package org;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Logdifferentinfo {
    public static void main(String args[]) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\logdiffrentinfo.html");
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest test1 = extentReports.createTest("Madhu");
        String xml="<!DOCTYPE glossary PUBLIC \"-//OASIS//DTD DocBook V3.1//EN\">\n" +
                " <glossary><title>example glossary</title>\n" +
                "  <GlossDiv><title>S</title>\n" +
                "   <GlossList>\n" +
                "    <GlossEntry ID=\"SGML\" SortAs=\"SGML\">\n" +
                "     <GlossTerm>Standard Generalized Markup Language</GlossTerm>\n" +
                "     <Acronym>SGML</Acronym>\n" +
                "     <Abbrev>ISO 8879:1986</Abbrev>\n" +
                "     <GlossDef>\n" +
                "      <para>A meta-markup language, used to create markup\n" +
                "languages such as DocBook.</para>\n" +
                "      <GlossSeeAlso OtherTerm=\"GML\">\n" +
                "      <GlossSeeAlso OtherTerm=\"XML\">\n" +
                "     </GlossDef>\n" +
                "     <GlossSee OtherTerm=\"markup\">\n" +
                "    </GlossEntry>\n" +
                "   </GlossList>\n" +
                "  </GlossDiv>\n" +
                " </glossary>";
        String json="{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        test1.log(Status.INFO, "info1")
                .log(Status.INFO, "<b>info2</b>")//bold
                .log(Status.FAIL,"<i>Italic<i>")//italic
                .log(Status.FAIL,"<b><i>boldItalic</b></i>")//boldtalic
                .log(Status.WARNING,xml)//xml as string
                .log(Status.WARNING,json)//json as string
                .log(Status.WARNING, MarkupHelper.createCodeBlock(xml, CodeLanguage.XML))//in XmlFormat
                .log(Status.FAIL,MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));//in json Format
        ArrayList al=new ArrayList<>();
        al.add("madhu");
        al.add("kiran");
        HashMap<String,String> map=new HashMap<>();
        map.put("madhu","kiran");
        map.put("kjk","mkdmk");
        HashSet hashSet=new HashSet<>();
        hashSet.add("madhu");
        hashSet.add("kiran");
        ExtentTest test2=extentReports.createTest("list set Map");
        test2.log(Status.FAIL,MarkupHelper.createOrderedList(hashSet))//set
                .log(Status.INFO,MarkupHelper.createOrderedList(map))//map
                .log(Status.WARNING,MarkupHelper.createUnorderedList(al));//list
        ExtentTest test3=extentReports.createTest("highlight messafe");
        test3.log(Status.FAIL,MarkupHelper.createLabel("madhukiran", ExtentColor.RED));
        try {
            int i=5/0;
        }
        catch (Exception e){
            extentReports.createTest("Test4").fail(e);
        }
        Throwable t=new RuntimeException("this is custom exception");
        extentReports.createTest("Test5").fail(t);
        extentReports.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\madhu\\EXTENT5\\src\\test\\Reports\\logdiffrentinfo.html").toURI());
    }
}

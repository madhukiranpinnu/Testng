package PDFValidation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PDFReaderOnline {
    @Test
    public void OnlinePDFValidator() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://file-examples.com/storage/fe8327078862cc4f1a2360d/2017/10/file-sample_150kB.pdf");
        String pdfURl=driver.getCurrentUrl();
        System.out.println(pdfURl);
        URL pdfUR1L=new URL(pdfURl);
        PDDocument pdf=PDDocument.load(pdfUR1L.openStream());
        PDFTextStripper pdfTextStripper=new PDFTextStripper();
        pdfTextStripper.setStartPage(1);
        pdfTextStripper.setEndPage(1);
        String docText=pdfTextStripper.getText(pdf);
        System.out.println(docText);
        Assert.assertTrue(docText.startsWith("Lorem ipsum"));
        System.out.println(docText.contains("fringilla."));
        pdf.close();
        driver.quit();
    }

}
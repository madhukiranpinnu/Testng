package PDFValidation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfReader {
    @Test
    public void ReadPDF() throws IOException {
        File pdf=new File("C:\\Users\\madhu\\Downloads\\file-sample_150kB.pdf");
        //conversts the File Format to Raw data
        FileInputStream fileInputStream=new FileInputStream(pdf);
        //Converts raw data to PDF Format
        PDDocument document=PDDocument.load(fileInputStream);
        int pagesCount=document.getPages().getCount();
        System.out.println(pagesCount);
        //To read the data from PDF Document:
        PDFTextStripper pdfTextStripper=new PDFTextStripper();
        pdfTextStripper.setStartPage(1);
        pdfTextStripper.setEndPage(1);
        String docText=pdfTextStripper.getText(document);
        System.out.println(docText);
        Assert.assertTrue(docText.startsWith("Lorem ipsum"));
        System.out.println(docText.contains("fringilla."));
        document.close();
        fileInputStream.close();
    }
}

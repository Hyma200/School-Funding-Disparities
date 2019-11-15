import java.util.*;
import java.io.*;
import java.net.MalformedURLException; 
import java.net.URL;
import java.io.File; 
import java.io.IOException; 
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.text.PDFTextStripper; 
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader extends LineFinder{
 /**
  * Reads and copies a pdf file to a text file
  * @param in of the class scanner, documents of the class PDDocument
  * @return void
  * */
  public static void recordPDF(PDDocument documents, Scanner in)  throws IOException{
    PDDocument document = documents;
    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
    stripper.setSortByPosition(true);
    PDFTextStripper tStripper = new PDFTextStripper();
    String pdfFileInText = tStripper.getText(document);
    PrintWriter out = new PrintWriter("perStudentFunding.txt");
    out.println(pdfFileInText);
    out.close();
  }
  
  public static void recordPerStudentFunding(ArrayList <Counties> counties, File studentFunding, Scanner in) throws IOException{
    for (int j = 0; j<counties.size(); j++){
      int county = findLineNums(counties.get(j).getName(), in, studentFunding, 1) -1;
      String [] countiesValue = returnData(county, county, studentFunding, in);
      String wholeValue = countiesValue[0];
      String [] separated = wholeValue.split(" ");
      for (int i = 0; i<separated.length; i++){
        separated[i] = separated[i].replaceAll("\\s", "");
      }
      
      String integer = separated[separated.length-1];
      String withoutCommas = integer.replaceAll(",", "");
      int perstudentFunding = Integer.parseInt(withoutCommas);
      counties.get(j).setPerStudentFunding(perstudentFunding);
    }
  }
}
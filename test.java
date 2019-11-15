import java.io.*;
import java.util.*;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.text.PDFTextStripper; 
import org.apache.pdfbox.text.PDFTextStripperByArea;

   
public class test{
  public static void main (String [] args) throws Exception{
    ArrayList <Counties> counties = new ArrayList <Counties>();
    Counties fairfax = new Counties ("Fairfax");
    counties.add(fairfax);
    Counties arlington = new Counties ("Arlington");
    counties.add(arlington);
    Counties henrico = new Counties ("Henrico");
    counties.add(henrico);
    Counties PrinceWilliam = new Counties("Prince William");
    counties.add(PrinceWilliam);
    Counties fauquier = new Counties("Fauquier");
    counties.add(fauquier);
    Counties prince = new Counties ("Prince William");
    counties.add(prince);
    Counties george = new Counties ("Prince George");
    counties.add(george);
    Counties king = new Counties ("King George");
    counties.add(king);
    Counties culpeper = new Counties ("Culpeper");
    counties.add(culpeper);
    Counties hanover = new Counties ("Hanover");
    counties.add(hanover);
    Counties frederick = new Counties ("Frederick");
    counties.add(frederick);
    Counties clarke = new Counties ("Clarke");
    counties.add(clarke);
    Counties westmoreland = new Counties ("Loudoun");
    counties.add(westmoreland);
    Counties mathews = new Counties ("Mathews");
    counties.add(mathews);
    Counties caroline = new Counties ("Caroline");
    counties.add(caroline);
    
    Scanner in = new Scanner (System.in);
    
    EthnicityRecorder r = new EthnicityRecorder();
    /**
     * Records ethnicities into each county
     */
    r.setEthnicityCount(counties);
    
   /**
     * Uploads docuemnt of studentFunding pdf file, copies and reads data from pdf to text file  
     */
    PDDocument document = PDDocument.load(new File("C:\\Users\\hyma2\\Documents\\1st Semester Classes\\Java\\Project\\perStudentFunding.pdf"));
    PDFReader p = new PDFReader();
    p.recordPDF(document, in);
    
    /**
     * Makes studentFunding file using its path and sets per student funding of each county
     */
    File studentFunding = new File("C:\\Users\\hyma2\\Documents\\1st Semester Classes\\Java\\Project\\perStudentFunding.txt");
    p.recordPerStudentFunding(counties, studentFunding, in);
  }
  
  
}
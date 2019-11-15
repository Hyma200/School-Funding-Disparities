import java.io.*;
import java.util.*;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

public class EthnicityRecorder extends LineFinder{
  
  public static void setEthnicityCount(ArrayList <Counties> counties) throws IOException{
    EthnicityRecorder n = new EthnicityRecorder();
    n.importEthnicityFiles(0);
    //n.importEthnicityFiles(1);
    //n.importEthnicityFiles(2);
    //n.importEthnicityFiles(3);
    //n.importEthnicityFiles(4);
    //n.importEthnicityFiles(5);
    try{
      Scanner in = new Scanner (System.in);
      recordEthnicityCount(counties, "totalCount", in);
      recordEthnicityCount(counties, "American Indian", in);
      recordEthnicityCount(counties, "White", in);
      recordEthnicityCount(counties, "Asian", in);
      recordEthnicityCount(counties, "African American", in);
      recordEthnicityCount(counties, "Hispanic", in);
    }
    
  catch (NumberFormatException e){
    System.err.println(e.getMessage());
  }
}
  
  
  public static void recordEthnicityCount(ArrayList <Counties> counties, String ethnicity, Scanner in) throws IOException{
    String ethnicityCount = "C:\\Users\\hyma2\\Documents\\1st Semester Classes\\Java\\Project\\"  + ethnicity + ".txt";
    File eCount = new File(ethnicityCount);
    for (int i = 0; i<counties.size(); i++){
      String name = counties.get(i).getName();
    int firstOccurence = findLineNums(name, in, eCount, 200);
    String [] ethValue = returnData(firstOccurence, firstOccurence, eCount, in);
    String ethCount = ethValue[0];
    String newCount = ethCount.replace(",", "");
    int count = Integer.parseInt(newCount);
    if (ethnicity.equals("American Indian"))
         counties.get(i).setAmericanIndian(count);
    else if (ethnicity.equals("African American"))
         counties.get(i).setAfricanAmerican(count);
    else if (ethnicity.equals("White"))
          counties.get(i).setWhite(count);
    else if (ethnicity.equals("Asian"))
          counties.get(i).setAsian(count);
    else if (ethnicity.equals("Hispanic"))
          counties.get(i).setHispanic(count);
    else if (ethnicity.equals("totalCount"))
      counties.get(i).setPopulation(count);
  }
    
}
      public static void importEthnicityFiles(int num){
     //turns off html warnings
    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

    //Sets html options
        WebClient webClient = new WebClient();  
        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getCookieManager().setCookiesEnabled(true);
        
        
        String input = Integer.toString(num);
        String ethnicity="";
        switch(num){
          case 0:
            input = "All Races";
            ethnicity = "totalCount";
            break;
          case 1: 
            ethnicity = "American Indian";
            break;
          case 2:
            ethnicity = "Asian";
            break;
          case 3:
            ethnicity = "African American";
            break;
          case 4:
            ethnicity = "Hispanic";
            break;
          case 5:
            ethnicity = "White"; 
            break;
        }
        


    try {  
      
         // Get the first page and the submit button
        final HtmlPage page1 = webClient.getPage("https://p1pe.doe.virginia.gov/apex/f?p=180:1:13504397254529:::::");
        final HtmlForm form = page1.getFormByName("wwv_flow");
        final HtmlButton button = (HtmlButton) page1.getElementsByTagName("button").get(4);
        
        //Select Division
        HtmlSelect division = form.getSelectByName("P1_REPORT_LEVEL");
        division.getOptionByValue("Division").setSelected(true);
        HtmlSelect county = form.getSelectByName("P1_DIVISION");
          
        
         //Select Race
        HtmlSelect race = form.getSelectByName("P1_RACE");
        race.getOptionByValue(input).setSelected(true);   
        
        //Clicks submit button and displays text
        final HtmlPage page3 = button.click();
        String text = page3.asText();  
        
        //Reads text and saves it to a file
        PrintWriter out = new PrintWriter(ethnicity + ".txt");
        out.println(text);
        out.close();
        }
    
    catch(Exception e){
      e.printStackTrace();
    }
    }
}
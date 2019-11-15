import java.util.*;
import java.io.*;
public class LineFinder{
  
public static int findLineNums (String dataType, Scanner in, File file, int start) throws IOException{
    int num1 = 0;
    int lineNum = 0;
    in = new Scanner (file);
    lineNum++;
    while (in.hasNextLine()){
      lineNum++;
      String line = in.nextLine();
      if (line.indexOf(dataType) != -1 && lineNum>=start){
        return lineNum; 
      } 
    }
    return -1;
  }
    
  public static String [] returnData (int num1, int num2, File file, Scanner in) throws IOException{
    String [] returnValues = new String [(num2-num1)+1];
    in = new Scanner(file);
      String line;
      int arrayNum = 0;
      int lineNum = 0;
      while (in.hasNextLine()){
        lineNum++;
        String nextLine = in.nextLine();
        if (lineNum>= num1 && lineNum<=num2){
          returnValues[arrayNum] = nextLine;
          arrayNum++;
        }
      }
      return returnValues;
  }
}
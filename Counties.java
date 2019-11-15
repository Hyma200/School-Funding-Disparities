import java.util.ArrayList;
public class Counties{
  private String name;
  private int population;
  private double perStudentFunding;
  private int africanAmericans;
  private int white;
  private int americanIndian;
  private int asian;
  private int hispanic;
  
  
  public Counties (String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  
  public void setPopulation(int p){
    this.population = p;
  }
  
  public int getPopulation(){
    return population;
  }
  
  public void setPerStudentFunding(double p){
    this.perStudentFunding = p;
  }
  
  public double getPerStudentFunding(){
    return perStudentFunding;
  }
  
  public void setAfricanAmerican(int a){
    this.africanAmericans = a;
  }
  
  public int getAfricanAmerican(){
    return africanAmericans;
  }
  
  public void setWhite(int w){
    this.white = w;
  }
  
  public int getWhite(){
    return white;
  }
  
  public void setAmericanIndian(int a){
    this.americanIndian = a;
  }
  
  public int getAmericanIndian(){
    return americanIndian;
  }
  
  public void setAsian (int a ){
    this.asian = a;
  }
  
  public int getAsian(){
    return asian;
  }
  
  public void setHispanic(int h){
    this.hispanic = h;
  }
  
  public int getHispanic(){
    return hispanic;
  }
  
}
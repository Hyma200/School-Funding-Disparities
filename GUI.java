import javafx.application.Application;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.control.Label; 
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import javafx.scene.Group; 
import javafx.scene.image.ImageView;  
import javafx.scene.text.*; 
import javafx.event.EventHandler;
import javafx.event.ActionEvent; 
import javafx.scene.Scene;
import java.io.*;

//https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/001_creatingASimpleWindow/Main.java
public class GUI extends Application {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }
    //https://docs.oracle.com/javafx/2/charts/bar-chart.htm#CIHJFHDE
    @Override
    public void start(Stage stage) throws Exception {
       ArrayList <Counties> counties = returnCounties();
       //EthnicityRecorder r = new EthnicityRecorder();
       //r.setEthnicityCount(counties);
       Group root = new Group();
       Scene scene = new Scene(root, 600, 600,  Color.BEIGE);  
       Text title = new Text("Choose one of the following counties");
       title.setX(120);
       title.setY(50);
       title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
       stage.setTitle("User Input");
       addImages("Fairfax", 0, scene, root, stage, counties);
       addImages("Arlington", 1, scene, root, stage, counties);
       addImages("Henrico", 2, scene, root, stage, counties);
       addImages("Prince William", 3, scene, root, stage, counties);
       addImages("Fauquier", 4, scene, root, stage, counties);
       root.getChildren().add(title);
       stage.setScene(scene);
       stage.show();
    }
    
    public void addImages(String county, int num, Scene scene, Group root, Stage stage, ArrayList <Counties> counties) throws IOException{
       Image image = new Image(new FileInputStream("C:\\Users\\hyma2\\Pictures\\" + county + ".jpg")); 
       Button text = new Button(county);
       ImageView imageView = new ImageView(image);
       int xNum = num % 4;
       int yNum = num/4;
       imageView.setX(25 + (150 * xNum)); 
       imageView.setY(70 + (150* yNum));
       text.setLayoutX(40 + (150 * xNum));
       text.setLayoutY(185 + (150*yNum));
       imageView.setFitHeight(100); 
       imageView.setFitWidth(100); 
       //Button pressed event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
              Button newButton = new Button ("Return");
              for (int i = 0; i<4; i++){
              generatePieChart(counties.get(i), newButton, stage, scene);
              }
            } 
        }; 
       text.setOnAction(event);
       root.getChildren().add(imageView);
       root.getChildren().add(text);

    }
    
    public ArrayList <Counties> returnCounties(){
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
      return counties;
    }
    
    public void generatePieChart(Counties c, Button b, Stage stage, Scene scene){
      Group county = new Group();
      Text pop = new Text(c.getName());
      pop.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
      pop.setX(300);
      pop.setY(30);
      county.getChildren().add(pop);
      Button newButton = new Button ("Return");
      newButton.setLayoutX(500);
      newButton.setLayoutY(550);
      county.getChildren().add(newButton);
      Scene scene2 = new Scene(county, 600, 600);
      stage.setScene(scene2); 
      EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent e){
              stage.setScene(scene);
                  }
                };
     newButton.setOnAction(event1);
    }
    
    
    }
    


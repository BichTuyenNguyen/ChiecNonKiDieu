/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiecnonkidieu;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author 15510
 */
public class FXMLDocumentController implements Initializable {
   
  
    
    @FXML private Circle circle;
    @FXML private Pane pane;
    @FXML private Label lbred;
    @FXML private Label lbgreen;
    @FXML private Label lbblue;
    @FXML private Label lbyellow;
   
    private Color [] arrColor = {Color.RED, Color.BLUE, Color.GREEN,Color.YELLOW};
    private Arc[] arrArc = new Arc[4];
    
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        circle = new Circle(100);
        circle.setFill(null);
        circle.setStroke(Color.YELLOW);
        circle.setCenterX(270);
        circle.setCenterY(200);
       
        
        Polygon polygon = new Polygon();
        polygon.setFill(Color.BLACK); polygon.setStroke(Color.RED);
        polygon.getPoints().add(Double.valueOf(100));
        polygon.getPoints().add(Double.valueOf(180));
        
        polygon.getPoints().add(Double.valueOf(100)); 
        polygon.getPoints().add(Double.valueOf(230));
        
        polygon.getPoints().add(Double.valueOf(180)); 
        polygon.getPoints().add(Double.valueOf(200));
         pane.getChildren().add(2,circle);
        pane.getChildren().add(4, polygon);
       // double cv = 2 * Math.PI * 100;
        double StartAG= 0;
        for(int i = 0; i<4; i++)
        {
            arrArc[i] = new Arc();
            arrArc[i].setStartAngle(StartAG);
            arrArc[i].setLength(90);
            arrArc[i].setCenterX(270);
            arrArc[i].setCenterY(200);
            arrArc[i].setRadiusX(100);
            arrArc[i].setRadiusY(100);
            arrArc[i].setType(ArcType.ROUND);
            arrArc[i].setFill( arrColor[i]);
            pane.getChildren().add(i, arrArc[i]);         
            StartAG +=90;
        }
        int []time = {10,20,30};
        //int cycleCount = 100;
        for(int i = 0; i <time.length; i++)
        {
             Timeline animation = new Timeline(new KeyFrame(Duration.millis(time[i]), e -> 
        {
            for(Arc arc :arrArc)
            {
              
                arc.setStartAngle(arc.getStartAngle()+2);  
                for(int j = 0; j<=20; j++)
                {
                    if(arc.getFill() == Color.RED)               
                    {
                       if(arc.getStartAngle()==540-90+360*j)
                             {
                                lbred.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                             }
                       else if(arc.getStartAngle()==180+360*j)
                       {
                            lbred.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                       }

                    }


                    else if(arc.getFill() == Color.YELLOW)               
                    {
                       if(arc.getStartAngle()==540-90+360*j)
                             {
                                lbyellow.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                             }
                        else if(arc.getStartAngle()==540+360*j)
                        {
                            lbyellow.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                        }

                    }
                    else if(arc.getFill() == Color.GREEN)               
                    {
                       if(arc.getStartAngle()==540-90+360*j)
                             {
                                lbgreen.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                             }
                        else if(arc.getStartAngle()==540+360*j)
                        {
                            lbgreen.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                        } 

                    }
                    else if(arc.getFill() == Color.BLUE)               
                    {
                       if(arc.getStartAngle()==540-90+360*j)
                             {
                                lbblue.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
                             }
                        else if(arc.getStartAngle()==540+360*j)
                        {
                            lbblue.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
                        }                       
                    } 
                }
            }
                
            
        })); 
             
       animation.setCycleCount(180*3); 
       animation.play();
        }

    }   
}

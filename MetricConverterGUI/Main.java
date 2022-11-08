
package hellofx;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
@Override 
public void start(Stage primaryStage) {
TextField userInput = new TextField();
TextField textOut = new TextField();
Button btConvert = new Button("Convert");
GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Enter an inquiry. (For ex: '1 g = kg')"), 0, 1);
    gridPane.add(userInput, 1, 1);
    gridPane.add(new Label("Conversion:"), 0, 3);
    gridPane.add(textOut, 1, 3);
    gridPane.add(btConvert, 1, 5);
    textOut.setEditable(false);   
    GridPane.setHalignment(btConvert, HPos.RIGHT);

    gridPane.add(new Label("This program converts:"), 0, 6);
    gridPane.add(new Label("lb —> oz & mg"), 0, 7);
    gridPane.add(new Label("g —> kg & mg"), 0, 8);
    gridPane.add(new Label("ft  —> in & yard"), 0, 9);
    gridPane.add(new Label("cm —> mm & m"), 0, 10);
    

    gridPane.setAlignment(Pos.CENTER);
    userInput.setAlignment(Pos.BOTTOM_RIGHT);
    textOut.setAlignment(Pos.BOTTOM_RIGHT);
    GridPane.setHalignment(btConvert, HPos.RIGHT);

    btConvert.setOnMouseClicked(event -> {
      String input=userInput.getText();
        String[] strArray;
        strArray=input.split(" ");
        float sourceNum = Float.parseFloat(strArray[0]);
        String sourceMetric = strArray[1];
        String targetMetric = strArray[3];
        metricConverter(sourceMetric,targetMetric,sourceNum, textOut);
    });
  
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Metric Converter"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
  
  }
   
  public static float metricConverter(String sourceMetric, String targetMetric, float sourceNum,TextField tf) {
    float targetNum=0;
    switch(sourceMetric) {
        case "lb":
            switch (targetMetric){
                case "oz":
                targetNum=sourceNum*16;
                tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                break;
                case "mg":
                targetNum=sourceNum*453592;
                tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                break;
                default: 
                tf.setText(String.format("Your input is not valid. Please try again."));
            }
        break; 
        case "g":
            switch(targetMetric) {
                case "kg":
                targetNum=sourceNum*(float)0.001;
                tf.setText(String.format("%.2f %s = %.3f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                break;
                case "mg":
                targetNum=sourceNum*1000;
                tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                break;
                default: 
                tf.setText(String.format("Your input is not valid. Please try again."));
            }
        break;
        case "ft":
        switch(targetMetric) {
            case "in":
            targetNum=sourceNum*12;
            tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
            break;
            case "yard":
            targetNum=sourceNum/3;
            tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
            break;
            default: 
            tf.setText(String.format("Your input is not valid. Please try again."));
        }
        break;
        case "cm":
        switch(targetMetric) {
            case "mm":
            targetNum=sourceNum*10;
            tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
            break;
            case "m":
            targetNum=sourceNum*(float).01;
            tf.setText(String.format("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
            break;
            default: 
            tf.setText(String.format("Your input is not valid. Please try again."));
        }
        break;
        default: 
        tf.setText(String.format("Your input is not valid. Please try again."));
    }  
    return targetNum; 
} 

  public static void main(String[] args) {
    launch(args);    
  }
}
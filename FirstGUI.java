package GUIReview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FirstGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(25);
        final String [] words = {"Cat", "Dog", "Example", "Cake", "Test"};
        
        TextField tf = new TextField();
        tf.setEditable(false);
        
        
        Button randomButton = new Button("Button");
        randomButton.setOnAction((e)->{
            System.out.println("Pressed");
            int rng = (int) (Math.random() * words.length);
            tf.setText(words[rng]);  
        });
        
            Button clearButton = new Button("Clear");
            clearButton.setOnAction((e)->{
                tf.clear();
            });
        
            CheckBox cb = new CheckBox();
            cb.setOnAction((e)->{
                if(cb.isSelected()){
            tf.setText(tf.getText().toUpperCase());
            } else {
                 tf.setText(tf.getText().toLowerCase());
   
                }
            });
        
        // Add nodes to the pane
        pane.add(randomButton, 0, 0);
        pane.add(tf, 1, 0);
        pane.add(clearButton, 0, 1);
        pane.add(cb, 1, 1);
        
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.setTitle("Crappy GUI");
        stage.setHeight(150);
        stage.setWidth(300);
        stage.show();
    }

}

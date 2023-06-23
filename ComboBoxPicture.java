

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alec
 */
public class ComboBoxPicture extends Application {

   
    @Override
    public void start(Stage stage) throws Exception {
        
        //pane
        BorderPane bp = new BorderPane();
        
        //ComboBox combo = new peopleComboBox();
        ComboBox combo = peopleComboBox(bp);
        bp.setBottom(combo);
        BorderPane.setAlignment(combo, Pos.BOTTOM_CENTER);
        
        Scene scene = new Scene(bp, 300, 250);
        stage.setTitle("Drop Down Images");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static ComboBox peopleComboBox(BorderPane bp){
        String [] names = {"Morgan Freeman",  "Spongebob","Gordan Freeman", "Gordan Ramsey"};
        ComboBox combo = new ComboBox(FXCollections.observableArrayList(names));
        
      //lambda for functionanlity
            combo.setOnAction((e)->{
                System.out.println(combo.getValue() + " selected.");
               // String name = combo.getValue().toString();
               bp.setCenter(setImage(combo.getValue().toString()));
            });
        
        return combo;//must return cb
        
    }
    
    public static ImageView setImage (String name){
        DropShadow shadow = new DropShadow(500, Color.PURPLE);
        String[] links = {
            IMAGES.MORGAN_FREEMAN,
            IMAGES.SPONGEBOB,
            IMAGES.GORDON_FREEMAN,
            IMAGES.GORDON_RAMSAY

                
        };
        String link = "";
        
        if(name.equalsIgnoreCase("Morgan Freeman")){
            link = links[0];
        } else if (name.equalsIgnoreCase("Spongebob")){
            link = links[1];
        }else if (name.equalsIgnoreCase("Gordan Freeman")){
            link = links[2];
        } else if (name.equalsIgnoreCase("Gordan Ramsey")){
            link = links[3];
        }
        
        Image img = new Image(link, 200, 200, false, false);
        ImageView iv = new ImageView(img);
        iv.setEffect(shadow);
        return iv;
    }
    public static void main(String[] args) {
        //LAUNCH mandatory to call the rest...
        launch(args);
    }
    
}

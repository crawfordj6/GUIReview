
import Jwiki.Jwiki;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
public class SearchEngineGUI extends Application {

    @Override
  
    public void start(Stage stage) throws Exception {
 //To change body of generated methods, choose Tools | Templates.
    BorderPane pane = new BorderPane();
    
    //Create nodes
    Label title = new Label("Search for an image:");
    title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 25));
    
    TextField searchTF = new TextField();
    searchTF.setPromptText("Type your image here");//????BUG????
    searchTF.setFocusTraversable(false);
   
    Button searchButton = new Button("Search");
    searchButton.setPrefWidth(100);
    
    Button infoButton = new Button("More Information");
    infoButton.setPrefWidth(200);
    infoButton.setVisible(false);
    infoButton.setOnAction((e) -> {
            System.out.println("More Information pressed");
            getInfo(title.getText(), stage);
    });
    //Lambda Functionality
    //Serch button functionality
    searchButton.setOnAction((e) -> {
        System.out.println("Search button pressed!");
        setTitle(searchTF, title);
        pane.setCenter(setImage(searchTF.getText(), infoButton));
        searchTF.clear();
        searchTF.requestFocus();
    });
    
    
    VBox topBox = new VBox(10); 
    topBox.setAlignment(Pos.CENTER);
    topBox.getChildren().addAll(title, searchTF, searchButton, infoButton);
    //*******new code
    final ImageView selectedImage = new ImageView();
    Image image1 = new Image(new InputStream());
    
    selectedImage.setImage(image1);
    root.getChildren().assAll(selectedImage);
    
    scene.setRoot(root);
    //place nodes on Pane
    pane.setTop(topBox);
    
    Scene scene = new Scene(pane, 500, 500);
    stage.setScene(scene);
    stage.setTitle("Search Engine");   
    stage.setResizable(false);
    stage.show();
    }
    public static void setTitle(TextField tf, Label title) {
        if(tf.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Search field cannnot be empty.");
            alert.show();
        } else{
            title.setText(tf.getText()); 
        }
       
    }
    
    public static ImageView setImage(String search, Button infoButton){   
        Color[] colors = {Color.BLUEVIOLET, Color.TOMATO, Color.MAGENTA, Color.THISTLE, Color.DARKORCHID, Color.GREEN,};
        int random = (int)(Math.random() * colors.length);
        DropShadow shadow = new DropShadow(500, colors[random]);
    
//        String imgURL;  
  //      try {
    //        Jwiki jwiki = new Jwiki(search);
      //      imgURL = jwiki.getImageURL();
         //   infoButton.setVisible(true);
        // if(search.equalsIgnoreCase("cat")){
          //   Media m = new Media(Paths.get("meow.mp3").toUri().toString());
            // new MediaPlayer(m).play();
        // }
          //  infoButton.setVisible(true);
            
       // } catch (Exception e) {
         // infoButton.setVisible(false);
           //System.out.println(search + " does not exist. Here is a kitten.");
            //imgURL = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.wIEMGkgnFYEAKFQcb-dVTgHaJ4%26pid%3DApi&f=1&ipt=b2e02fd8a7c362b1043eb18a5516a11d5bee082e1b54d996b7c836d31922c4a4&ipo=images;";
       
        
        Image image = new Image(imgURL, 250, 250, false, false);
        ImageView imgv = new ImageView(image);
        imgv.setEffect(shadow);
        return imgv;
        
    }
    
        public static void getInfo(String search, Stage stage) {
            Stage infoStage = new Stage ();
            infoStage.setTitle(search + " information");
            
            
            
            TextArea info = new TextArea();
            Jwiki jwiki  = new Jwiki(search);
            info.appendText(jwiki.getExtractText());
            info.setWrapText(true);
            info.setEditable(false);
            info.setFont   (Font.font("Verdana", FontWeight.BOLD, 14));
            
            Scene infoScene = new Scene(info, 550, 200);
            infoStage.setScene(infoScene);
            
            infoStage.setX(stage.getX());
            infoStage.setY(stage.getY() + 550);
            infoStage.show();
        }
    
       public static void main(String[] args) {
        launch();
    }

    
}

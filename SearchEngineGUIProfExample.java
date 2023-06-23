
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class SearchEngineGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        
        // Create Nodes
        Label title = new Label("Search for an image");
        title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 25));
        
        TextField searchTF = new TextField();
        searchTF.setPromptText("Type your image here");
        
        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);
        
        // Lambda Functionality
        // Search Button Functionality
        searchButton.setOnAction((e) -> {
            System.out.println("Search button pressed!");
            setTitle(searchTF, title);
            searchTF.clear();
            searchTF.requestFocus();
        });
        
        VBox topBox = new VBox(10);
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(title, searchTF, searchButton);
        
        // Place nodes on Pane
        pane.setTop(topBox);
        
        Scene scene = new Scene(pane, 500, 500);
        
        stage.setScene(scene);
        stage.setTitle("Search Engine");
        stage.setResizable(false);
        stage.show();
    }
    
    public static void setTitle(TextField tf, Label title) {
        if(tf.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Search field cannot be empty.");
            alert.show();
        } else {
            title.setText(tf.getText());
        }
    }
    
    public static void main(String[] args) {
        launch();
    }


}

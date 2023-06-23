
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MyFirstGUI_Events_Outer extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    // Create a pane and set its properties
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(10, 10, 10, 10));
    
    // Add later
    pane.setHgap(10);
    pane.setVgap(25);
    
    // Text Field
    TextField tf = new TextField();
    tf.setPrefWidth(150);
    // show edible
    
    // Button
    Button b = new Button("BUTTON");
    
    // Add functionality (handler) / action listener
    ExampleButtonHandlerClass buttonHandler = new ExampleButtonHandlerClass();
    // Finally, add the handler to the button itself
    b.setOnAction(buttonHandler);
    
    // Text
    Text t = new Text("Example Check Box:");
    
    // Checkbox
    CheckBox cb = new CheckBox();
    CheckBoxHandler cbh = new CheckBoxHandler();
    cb.setOnAction(cbh);

    
    pane.add(tf, 0, 0);
    pane.add(b, 1, 0);
    pane.add(t, 0, 1);
    pane.add(cb, 1, 1); // Change to 2 1 to show distance (skip cols)

    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setWidth(300);
    primaryStage.setHeight(150);
    primaryStage.setTitle("First GUI");
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage (Show without this)
  }
    
}
// End Class

// Start new classes
//1 Innser class to handle button
class ExampleButtonHandlerClass implements EventHandler<ActionEvent> {
  @Override
  public void handle(ActionEvent e) {
    System.out.println("OK button clicked"); 
  }
}
  
//2 Show how we COULD work with check / uncheck
  class CheckBoxHandler implements EventHandler<ActionEvent> {
  static int count = 2;
  @Override
  public void handle(ActionEvent e) {
      //System.out.println("Check Box Clicked.");
      // .cb does not work as cb is OUT OF SCOPE ************
      if(count % 2 == 0) {
          System.out.println("Check Box is checked!");
          count++;
      }
      else {
          System.out.println("Check box has been unchcked.");
          count++;
      }
  }
 }

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Clayout {

 private Scene[] container;
 private int index;
 public Clayout() {
     
     
     index = 0;

 }
 
 public Scene Show(int scene) {
     
     return container[scene];
     
 }

 public void AddPanel(Scene scene) {

     container[index] = scene;
     index++;
     container = new Scene[index];
}

}

package cryptoproject;



	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CryptoApp extends Application {

	 @Override
	 public void start(Stage stage) throws Exception {
	    Parent panel = FXMLLoader.load(getClass().getResource("Crypto.fxml"));
	    Scene scene = new Scene(panel);
	    stage.setScene(scene);
	    stage.setTitle("Crypto");
	    stage.show();
	  }
	
	  public static void main(String[] args) {
	    launch(args);
	  }
}

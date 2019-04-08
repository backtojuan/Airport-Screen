//___________________________________________________package of the class___________________________________________________________

	package GUI;

//__________________________________________________________________________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
//__________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the User Interface.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Main extends Application{
		@Override
		public void start(Stage stage) throws Exception{
			Parent root =
					FXMLLoader.load(getClass().getResource("AirportScreen.fxml"));
	
			Scene scene = new Scene(root);
			stage.setTitle("Airport Screen Simulator");
			stage.setFullScreen(true);
			stage.setScene(scene);
			
			
			Image icon = new Image("GUI/imgs/icon.png");
			stage.getIcons().add(icon);
			stage.show();
		}
//___________________________________________________________________________________________________________________________________
	
	public static void main(String[]args){
		launch(args);
	}
	
//___________________________________________________________________________________________________________________________________
}

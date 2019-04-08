//___________________________________________________package of the class_____________________________________________________________

	package GUI;
//______________________________________________________packages used_________________________________________________________________
	
	import java.util.Random;

	import Model.Airport;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Label;
	import javafx.scene.control.ScrollPane;
	import javafx.scene.layout.BorderPane;

//_______________________________________________Attributes___________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to create and design the User Interface.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class AirportScreenController {
			  
			@FXML
			private BorderPane borderpane;
			
			@FXML
			private ScrollPane scrollpane;
			
			@FXML
		    private Label lblMessage;
		    
			private Airport IcesiAirport;
			
			private Random generator;
			
//_______________________________________________Methods for this class_______________________________________________________________
			
			@FXML
			/**
			 * This method initialize the components of the GUI before to be launched by the constructor main method.
			 * 
			 */
			private void initialize() {
				
				scrollpane = new ScrollPane();
				scrollpane.setMaxSize(900.0, 500.0);
				borderpane.setCenter(scrollpane);
				
				generator = new Random();
				IcesiAirport = new Airport(generator.nextInt(Airport.MAX_FLIGHTS));
				prueba();
			}
			
	//________________________________________________________________________________________________________________________________
			
		    @FXML
		    /**
		     * This method generate a random number flights on the airport
		     *  
		     * @param event the event triggered by the user that is handle in this method
		     * @see Model.Airport#setFlights()
		     */
		    void generateRandomFlights(ActionEvent event) {
		    	
		    	IcesiAirport.setFlights(generator.nextInt(Airport.MAX_FLIGHTS));
		    }
	
	//________________________________________________________________________________________________________________________________
	
		    
		    public void prueba() {
		    	String mssg = "";
		    	for(int i=0;i<IcesiAirport.getFlights().length;i++) {
		    		mssg += IcesiAirport.getFlights()[i].getDate() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getHour() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getAirline() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getId() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getGate() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getDestinationcity() + "\n";
		    		
		    		System.out.println(mssg);
		    	}
		    }
		    
}

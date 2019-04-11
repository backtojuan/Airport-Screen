//___________________________________________________package of the class_____________________________________________________________

	package GUI;
//______________________________________________________packages used_________________________________________________________________
	
	
	import java.io.IOException;
	import java.util.Random;
	
	import Model.Airport;
	import Model.Flight;
	import customexception.InvalidInformationException;
	import Sorting.Selection;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.image.Image;
	import javafx.scene.layout.BorderPane;
	import javafx.stage.Modality;
	import javafx.stage.Stage;

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
		    private Label lblMessage;
			
			@FXML
			private TextField sizeTextField;
			
			private TableView<Flight> table;
			private ObservableList<Flight> flights;
			
		//___________________________________________
			
			private Airport IcesiAirport;
	
			private Random generator;
			
			private Selection selection;
			
//_______________________________________________Methods for this class_______________________________________________________________
			
			@FXML
			/**
			 * This method initialize the components of the GUI before to be launched by the constructor main method.
			 * 
			 */
			private void initialize() throws IOException{
				
				try {
				//Initialize the necessary objects to make the application works
				selection = new Selection();
				generator = new Random();
				IcesiAirport = new Airport(generator.nextInt(Airport.MAX_FLIGHTS));
				
				InitializeTV();
				prueba();
				}
				catch (IOException ioe) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warningWindow.fxml"));
			    	Parent root1 = (Parent) fxmlLoader.load();
			    	Stage stage = new Stage();
			    	stage.setTitle("Warning Suggestions");
			    	stage.centerOnScreen();
			    	stage.setResizable(false);
			    	
			    	Image image = new Image ("GUI/imgs/Icon.png");
					stage.getIcons().add(image);
					stage.initModality(Modality.WINDOW_MODAL);
					
			    	stage.setScene(new Scene(root1));  
			    	stage.show();
				}
			}
	//________________________________________________________________________________________________________________________________
			
			@SuppressWarnings("unchecked")
			@FXML
			/**
			 * This method initialize the tableview control element so the flights can be displayed in the GUI 
			 * @return a TableView of type Flight that containts the random flights generated once the program starts
			 */
			public void InitializeTV() {
				
				//Creates the table of flights
				//Date Column
				TableColumn<Flight, String> dateColumn = new TableColumn<>("Date");
				dateColumn.setMinWidth(200);
				dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
				
				//Hour Column
				TableColumn<Flight, String> hourColumn = new TableColumn<>("Hour");
				hourColumn.setMinWidth(200);
				hourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
				
				//Airline Column
				TableColumn<Flight, String> airlineColumn = new TableColumn<>("Airline");
				airlineColumn.setMinWidth(200);
				airlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
				
				//ID Column
				TableColumn<Flight, Integer> idColumn = new TableColumn<>("Identifier");
				idColumn.setMinWidth(200);
				idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
				
				//Destination Column
				TableColumn<Flight, String> destinationColumn = new TableColumn<>("Destination");
				destinationColumn.setMinWidth(200);
				destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destinationcity"));
			
				//Gate Column
				TableColumn<Flight, String> gateColumn = new TableColumn<>("Gate");
				gateColumn.setMinWidth(200);
				gateColumn.setCellValueFactory(new PropertyValueFactory<>("gate"));
				
				//Creates the table of flights
				table = new TableView<>();
				table.setItems(getFlights());
				table.getColumns().addAll(dateColumn,hourColumn,airlineColumn,idColumn,destinationColumn,gateColumn);
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				borderpane.setCenter(table);	
			}
	//________________________________________________________________________________________________________________________________
			
		    @FXML
		    /**
		     * This method generate a random number flights on the airport.<br>
		     *  
		     * @param event the event triggered by the user that is handle in this method
		     * @see Model.Airport#setFlights()
		     */
		    public void generateRandomFlights(ActionEvent event) throws IOException{
		    	
		    	try {
		    		int size = Integer.parseInt(sizeTextField.getText());
			    	IcesiAirport.setFlights(size);
			    	
			    	if(size<0) {
			    		throw new InvalidInformationException(size);
			    	}
			    	else if(size>1000) {
			    		throw new InvalidInformationException(0);
			    	}
			    	updateGUI();
			    	prueba();
		    	}
		    	catch (IOException ioe) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warningWindow.fxml"));
			    	Parent root1 = (Parent) fxmlLoader.load();
			    	Stage stage = new Stage();
			    	stage.setTitle("Warning Suggestions");
			    	stage.centerOnScreen();
			    	stage.setResizable(false);
			    	
			    	Image image = new Image ("GUI/imgs/Icon.png");
					stage.getIcons().add(image);
					
			    	stage.setScene(new Scene(root1));  
			    	stage.show();
				}
		    	catch(InvalidInformationException | NumberFormatException e){
		    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warningWindow2.fxml"));
			    	Parent root1 = (Parent) fxmlLoader.load();
			    	Stage stage = new Stage();
			    	stage.setTitle("Warning Suggestions");
			    	stage.centerOnScreen();
			    	stage.setResizable(false);
			    	
			    	Image image = new Image ("GUI/imgs/Icon.png");
					stage.getIcons().add(image);
					
			    	stage.setScene(new Scene(root1));  
			    	stage.show();
		    	}
		    }
	
	//________________________________________________________________________________________________________________________________
	
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByHour(ActionEvent event) {
		   
		    	prueba();
		    	updateGUI();
		    }
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByDate(ActionEvent event) {
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByDestination(ActionEvent event) {
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByAirline(ActionEvent event) {
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByGate(ActionEvent event) {
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its hour in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByHour(Airport IcesiAirport)
		     */
		    void sortByIdentifier(ActionEvent event) {
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    /**
		     * This method returns a list that contains the random generated flights of the airport
		     * @return An observablelist of type flight 
		     */
		    public ObservableList<Flight> getFlights(){
		    	flights = FXCollections.observableArrayList();
		    	for(int i=0;i<IcesiAirport.getFlights().length;i++) {
		    		flights.add(IcesiAirport.getFlights()[i]);
		    	}
		    	return flights;
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    /**
		     * This method refresh the tableView of the GUI everytime new random flights are generated.<br>
		     * <b>Pos:</b> the tableView of the GUI shows the new flights generated
		     */
		    public void updateGUI() {
		    	for(int i=0;i<this.getFlights().size();i++) {
		    		flights.add(IcesiAirport.getFlights()[i]);
		    	}
		    	table.setItems(flights);	
		    }
	//________________________________________________________________________________________________________________________________
		    
		    /**
		     * This method prints by console the generation of the random flights.
		     */
		    public void prueba() {
		    	String mssg = "";
		    	for(int i=0;i<IcesiAirport.getFlights().length;i++) {
		    		mssg += IcesiAirport.getFlights()[i].getDate() + "-";
		    		mssg += IcesiAirport.getFlights()[i].getHour() + "-";
		    		mssg += " " + IcesiAirport.getFlights()[i].getAirline() + " -";
		    		mssg += " " + IcesiAirport.getFlights()[i].getId() + " -";
		    		mssg += " " + IcesiAirport.getFlights()[i].getGate() + " -";
		    		mssg += " " + IcesiAirport.getFlights()[i].getDestinationcity() + "\n";
		    		
		    		System.out.println(mssg);
		    	}
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    
		    
//____________________________________________________________________________________________________________________________________   
}

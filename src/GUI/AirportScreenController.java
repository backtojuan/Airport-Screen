//___________________________________________________package of the class_____________________________________________________________

	package GUI;
//______________________________________________________packages used_________________________________________________________________
	
	
	import java.io.IOException;
	import java.util.Arrays;
	import java.util.Random;
	
	import Model.Airport;
	import Model.Flight;
	import Sorting.Bubble;
	import Sorting.FlightComparator;
	import Sorting.Insertion;
	import Sorting.Selection;
	import Searching.Linear;
	import Searching.Binary;
	import customexception.InvalidInformationException;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.image.Image;
	import javafx.scene.layout.BorderPane;
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
			private Label timeReport;
			
			@FXML
			private TextField sizeTextField;
			
			@FXML
			private TextField searchTextField;
		//___________________________________________
			
			private TableView<Flight> table;
			private ObservableList<Flight> flights;
			
		//___________________________________________
			
			private Airport IcesiAirport;
	
			private Random generator;
			
			private Selection selection;
			
			private Bubble bubble;
			
			private Insertion insertion;
	
			private Linear linear;
			
			private Binary binary;
			
//_______________________________________________Methods for this class_______________________________________________________________
			
			@FXML
			/**
			 * This method initialize the components of the GUI before to be launched by the constructor main method.
			 * 
			 */
			private void initialize() throws IOException{
				
				//Initialize the necessary objects to make the application works
				selection = new Selection();
				bubble = new Bubble();
				insertion = new Insertion();
				
				linear = new Linear();
				binary = new Binary();
				
				generator = new Random();
				
				IcesiAirport = new Airport(20);
				
				InitializeTV();
			}
	//________________________________________________________________________________________________________________________________
			
			@SuppressWarnings("unchecked")
			@FXML
			/**
			 * This method initialize the tableview control element so the flights can be displayed in the GUI 
			 * @return a TableView of type Flight that containts the random flights generated once the program starts
			 */
			private void InitializeTV() {
				
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
		     * @see 
		     */
		    public void sortByHour(ActionEvent event) {
		 
		    	
		    }
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its date in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see 
		     */
		    public void sortByDate(ActionEvent event) {
		    	
		    	
		    }
		    
	//________________________________________________________________________________________________________________________________
		
		    @FXML
		    /**
		     * This method sort the flights by its destination in an lexicographycal order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see 
		     */
		    public void sortByDestination(ActionEvent event) {
		    	
		    	long b = System.currentTimeMillis();
		    	Arrays.sort(IcesiAirport.getFlights(), new FlightComparator());
		    	long f = System.currentTimeMillis();
		    	
		    	updateGUI();
		    	timeReport.setText(" " + (f-b) + " Milliseconds ");
		    
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its airline in an lexicographycal order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Bubble#sortByAirline(Airport IcesiAirport)
		     */
		    public void sortByAirline(ActionEvent event) {
		    	
		    	long b = System.currentTimeMillis();
		    	bubble.sortByAirline(IcesiAirport);
		    	long f = System.currentTimeMillis();
		    	
		    	updateGUI();
		    	timeReport.setText(" " + (f-b) + " Milliseconds ");
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its gate in an lexicographycall order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Selection#sortByGate(Airport IcesiAirport)
		     */
		    public void sortByGate(ActionEvent event) {
		    	
		    	long b = System.currentTimeMillis();
		    	selection.sortByGate(IcesiAirport);
		    	long f = System.currentTimeMillis();
		    	
		    	updateGUI();
		    	timeReport.setText(" " + (f-b) + " Milliseconds ");
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method sort the flights by its identifier in an ascendent order.<br>
		     * 
		     * @param event the event triggered by the user that is handle in this method
		     * @see Sorting.Insertion#sortByIdentifier(Airport IcesiAirport)
		     */
		    public void sortByIdentifier(ActionEvent event) {
		    	
		    	long b = System.currentTimeMillis();
		    	selection.sortByIdentifier(IcesiAirport);
		    	long f = System.currentTimeMillis();
		    	
		    	updateGUI();
		    	timeReport.setText(" " + (f-b) + " Milliseconds ");
		    }
		    
	//________________________________________________________________________________________________________________________________
		    
		    @FXML
		    /**
		     * This method searchs a flight with an indicated airline inside the airport
		     * @param event the event triggered by the user that is handle in this method
		     */
		    void searchAirline(ActionEvent event) {
		    	try {
		    		long b = System.currentTimeMillis();
		    		int pos = binary.searchAirline(IcesiAirport, searchTextField.getText()); 
		    		long f = System.currentTimeMillis();
			    		if(pos !=0) {
			    			IcesiAirport.getFlights()[0] = IcesiAirport.getFlights()[pos];
			    			updateGUI();
			    			lblMessage.setText("Your searched flight is being displayed as first");
		    			}
			    		else {
			    			lblMessage.setText("The flight could not be searched, make sure:" + "The value is correct and is in Capital letters" );
			    		}
			    		
			    		timeReport.setText(" " + (f-b) + " Milliseconds ");
			    	}
			    	catch(NumberFormatException nfe) {
			    		lblMessage.setText("You can not search without given a value" + "\nor entering invalid information");
			    	}
		    }
		    
	//________________________________________________________________________________________________________________________________

		    @FXML
		    /**
		     * This method searchs a flight with an indicated destination inside the airport
		     * @param event the event triggered by the user that is handle in this method
		     */
		    void searchDestination(ActionEvent event) {
		    	try {
		    		long b = System.currentTimeMillis();
		    		int pos = binary.searchDestination(IcesiAirport, searchTextField.getText());
		    		long f = System.currentTimeMillis();
		    		if(pos !=0) {
		    			IcesiAirport.getFlights()[0] = IcesiAirport.getFlights()[pos];
		    			updateGUI();
		    			lblMessage.setText("Your searched flight is being displayed as first");
	    			}
		    		else {
		    			lblMessage.setText("The flight could not be searched, make sure:" + "The value is correct and is in Capital letters" );
		    		}
		    		
		    		timeReport.setText(" " + (f-b) + " Milliseconds ");
		    	}
			    	catch(NumberFormatException nfe) {
			    		lblMessage.setText("You can not search without given a value" + "\nor entering invalid information");
			    	}
		    }
	//________________________________________________________________________________________________________________________________
		   
		    @FXML
		    /**
		     * This method searchs a flight with an indicated gate inside the airport
		     * @param event the event triggered by the user that is handle in this method
		     */
		    void searchGate(ActionEvent event) {
		    	try {
		    		long b = System.currentTimeMillis();
		    		int pos = linear.searchGate(IcesiAirport, searchTextField.getText());
		    		long f = System.currentTimeMillis();
		    		if(pos !=0) {
		    			IcesiAirport.getFlights()[0] = IcesiAirport.getFlights()[pos];
		    			updateGUI();
		    			lblMessage.setText("Your searched flight is being displayed as first");
	    			}
		    		else {
		    			lblMessage.setText("The flight could not be searched, make sure:" + "The value is correct and is in Capital letters" );
		    		}
		    		
		    		timeReport.setText(" " + (f-b) + " Milliseconds ");
		    	}
			    	catch(NumberFormatException nfe) {
			    		lblMessage.setText("You can not search without given a value" + "\nor entering invalid information");
			    	}
		    }
	
	//________________________________________________________________________________________________________________________________
	
		    @FXML
		    /**
		     * This method searchs a flight with an indicated identifier inside the airport
		     * @param event the event triggered by the user that is handle in this method
		     */
		    void searchIdentifier(ActionEvent event) {
		    	try {
		    		long b = System.currentTimeMillis();
		    		int pos = linear.searchIdentifier(IcesiAirport, Integer.parseInt(searchTextField.getText()));
		    		long f = System.currentTimeMillis();
		    		if(pos !=0) {
		    			IcesiAirport.getFlights()[0] = IcesiAirport.getFlights()[pos];
		    			updateGUI();
		    			lblMessage.setText("Your searched flight is being displayed as first");
	    			}
		    		else {
		    			lblMessage.setText("The flight could not be searched");
		    		}
		    		
		    		timeReport.setText(" " + (f-b) + " Milliseconds ");
		    	}
		    		catch(NumberFormatException nfe) {
		    			lblMessage.setText("You can not search without given a value" + "\nor entering invalid information");
		    		}
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

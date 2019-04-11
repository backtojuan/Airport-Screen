//___________________________________________________package of the class___________________________________________________________

	package Model;
//__________________________________________________used packages for this class______________________________________________________
	
	import java.io.IOException;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.util.ArrayList;
	
	import java.util.Random;
//__________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create an Airport.
	 * 
	 * @author Juan Jos� Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Airport {
		
		public final static int MAX_FLIGHTS = 500;	

		public final static String PATH_AIRLINES = "data/Airlines.txt";
		public final static String PATH_DESTINATIONS = "data/Destinations.txt";
		public final static String PATH_GATES = "data/Gates.txt";
		
		private ArrayList<String> airlines;
		private ArrayList<String> destinations;
		private ArrayList<String> gates;
	
		private Flight[] flights;

		private Random generator;
//_______________________________________________Methods for this class_______________________________________________________________
		
		/**
		 * <b>Airport Constructor</b>
		 * This method creates and airport with its own flights <br>
		 * @param size the number of flights that the airport is going to have
		 */
		public Airport(int size) throws IOException{
			
			generator = new Random();
			
			flights = new Flight[size];
			init();
			checkIDs();

			airlines = new ArrayList<String>();
			destinations = new ArrayList<String>();
			gates = new ArrayList<String>();
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This mehod change the number of the flights and create new ones inside the airport.<br>
		 * <b>Pre:</b> The airport exists. <br>
		 * <b>Pos:</b> The new flights have been created inside the airport. <br>
		 * @param size the new number of flights that the airport is going to have.
		 */
		public void setFlights(int size) throws IOException{
			flights = new Flight[size];
			init();
			checkIDs();
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method initialize the flights inside the airport with the random attributes generated from the flight class.<br>
		 * <b>Pre:</b> The array of airports has been initialized with the finally size.<br>
		 * <b>Pos:</b> The array of airports is fill with the respective number of airports.<br>
		 */
		public void init() throws IOException{
			for(int i=0;i<flights.length;i++) {
				flights[i] = new Flight(generateRandomAirline(),generateRandomDestination(),generateRandomGate());
			}
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method makes sure that every flight has its own id with no repetition.<br>
		 * <b>Pre:</b> The array of airports has been initialized and fill with the respective and correct flights.<br>
		 * <b>Pos:</b> The flights are check and remain with an unique number.<br>
		 */
		public void checkIDs() {
			for(int i=0;i<flights.length;i++) {
				int id1 = flights[i].getId();
				for(int j=i+1;j<flights.length;j++) {
					int id2 = flights[j].getId();
					if(id1 == id2) {
						//changes the id of the flight in the case that two of them has the same number assignated
						flights[j].setId(flights[j].generateRandomID());
					}
				}
			}
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the array that contains the flights inside the airport.<br>
		 * <b>Pre:</b> The airport exists.
		 * <b>Pre:</b> The array of flights exists. <br>
		 * @return the currently assignated flights to the airport.
		 */
		public Flight[] getFlights() {
			return flights;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method loads and reads the files that contains the respective information to generate random
		 * airlines, destinations, and gates
		 * @throws IOException in the case that the file does not exist or a problem occur during reading the file
		 */
		public void load(String path) throws IOException{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			while(line!=null) {
				if(path == PATH_AIRLINES) {
					airlines.add(line);
				}
				else if(path == PATH_DESTINATIONS){
					destinations.add(line);
				}
				else if(path == PATH_GATES){
					gates.add(line);
				}
				line = br.readLine();
			}
			br.close();
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a random airline to the flight
		 * <b>Pos:</b> A random generated airline is given to the flight
		 */
		private String generateRandomAirline() throws IOException{
			
				load(PATH_AIRLINES);
				
				int indicator = generator.nextInt(airlines.size());
	
				String airline = airlines.get(indicator);
				
				return airline;
			}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a random destination to the flight
		 * <b>Pos:</b> A random generated destination is given to the flight
		 */
		private String generateRandomDestination() throws IOException {
			
				load(PATH_DESTINATIONS);
				
				int indicator = generator.nextInt(destinations.size());
	
				String destinationCity = destinations.get(indicator);
			
				return destinationCity;
			}		
	//________________________________________________________________________________________________________________________________	
		
		/**
		 * This method gives a random gate to the flight
		 * <b>Pos:</b> A random generated gate is given to the flight 
		 */
		private String generateRandomGate() throws IOException{
			
				load(PATH_GATES);
				
				int indicator = generator.nextInt(gates.size());
	
				String gate = gates.get(indicator);
				
				return gate;
		}
		
	//________________________________________________________________________________________________________________________________
}

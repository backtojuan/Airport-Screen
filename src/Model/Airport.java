//___________________________________________________package of the class___________________________________________________________

	package Model;
	
//__________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create an Airport.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Airport {
		
		public final static int MAX_FLIGHTS = 1000;	
		private Flight[] flights;

//_______________________________________________Methods for this class_______________________________________________________________
		
		/**
		 * <b>Airport Constructor</b>
		 * This method creates and airport with its own flights <br>
		 * @param size the number of flights that the airport is going to have
		 */
		public Airport(int size) {
			flights = new Flight[size];
			init();
			checkIDs();
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This mehod change the number of the flights and create new ones inside the airport.<br>
		 * <b>Pre:</b> The airport exists. <br>
		 * <b>Pos:</b> The new flights have been created inside the airport. <br>
		 * @param size the new number of flights that the airport is going to have.
		 */
		public void setFlights(int size) {
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
		public void init() {
			for(int i=0;i<flights.length;i++) {
				flights[i] = new Flight();
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
}

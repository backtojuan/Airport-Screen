//___________________________________________________package of the class_____________________________________________________________
	
	package Searching;
	
//________________________________________________packages used for this class________________________________________________________

	import Model.*;
	
//_______________________________________________________Atributtes___________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to create methods to search flights with binary methods.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Binary {
//_______________________________________________Methods for this class_______________________________________________________________		
		
		
		/**
		 * This method search a flight inside the Airport by using Binary Searching
		 * @param airport the airport that contains the flight needed
		 * @param destination the value that is going to be searched associated with the flights
		 * @return a boolean that represents if the flight was found or not
		 */
		public int searchDestination(Airport airport, String destination) {
			
			boolean found = false;
			int pos = 0;
			int low = 0;
			int high = airport.getFlights().length-1;
			
			while(low<=high && !found) {
				int mid = (low+high)/2;
				if(airport.getFlights()[mid].getDestinationcity().equals(destination)) {
					found = true;
					pos = mid;
				}
				else if(airport.getFlights()[mid].getDestinationcity().compareTo(destination)>0) {
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}
		
			return pos;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method search a flight inside the Airport by using Binary Searching
		 * @param airport the airport that contains the flight needed
		 * @param airline the value that is going to be searched associated with the flights
		 * @return a boolean that represents if the flight was found or not
		 */
		public int searchAirline(Airport airport, String airline) {
			
			boolean found = false;
			int pos = 0;
			int low = 0;
			int high = airport.getFlights().length-1;
			while(low<=high && !found) {
				int mid = (low+high)/2;
				if(airport.getFlights()[mid].getAirline().equals(airline)) {
					found = true;
					pos = mid;
				}
				else if(airport.getFlights()[mid].getAirline().compareTo(airline)>0) {
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}
		
			return pos;
			
		}
	//________________________________________________________________________________________________________________________________
	
	
	//________________________________________________________________________________________________________________________________
	
	
//____________________________________________________________________________________________________________________________________
}

//___________________________________________________package of the class_____________________________________________________________
	
	package Searching;
	
//________________________________________________packages used for this class________________________________________________________

	import Model.*;
	
//_______________________________________________________Atributtes___________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to create methods to search flights with linear methods.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Linear {	
//_______________________________________________Methods for this class_______________________________________________________________		
		
		/**
		 * This method searchs an id inside the array of flights associated with the airport.<br>
		 * @param airport the airport that contain the flights where is going to be search the needed one.
		 * @param id the id associated to the flight that needs to be found
		 * @return an Integer that indicates where the flight was found
		 */
		public int searchIdentifier(Airport airport, int id) {
			
			boolean found = false;
			int pos = 0;
			
			for(int i=0;i<airport.getFlights().length && !found;i++) {
				if(airport.getFlights()[i].getId() == id) {
					found = true;
					pos = i;
				}
			}
			
			return pos;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method searchs a gate inside the array of flights associated with the airport.<br>
		 * @param airport the airport that contain the flights where is going to be search the needed one.
		 * @param gate the gatee associated to the flight that needs to be found
		 * @return an Integer that represents where the flight was found
		 */
		public int searchGate(Airport airport, String gate) {
			
			boolean found = false;
			int pos = 0;
			
			for(int i=0;i<airport.getFlights().length && !found;i++) {
				if(airport.getFlights()[i].getGate().equals(gate)) {
					found = true;
					pos = i;
				}
			}
			
			return pos;
		}
	//________________________________________________________________________________________________________________________________
	
	
	//________________________________________________________________________________________________________________________________
	
	
//____________________________________________________________________________________________________________________________________
}
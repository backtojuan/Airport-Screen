//___________________________________________________package of the class_____________________________________________________________
	
	package Sorting;
	
//________________________________________________packages used for this class________________________________________________________

	import Model.*;
	
//_______________________________________________________Atributtes___________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and sort flights Bubble methods.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Bubble {
//_______________________________________________Methods for this class_______________________________________________________________		
		
		/**
		 * This method sorts the airlines of the airline in a lexicographically order using the classic Bubble method.<br>
		 * @param airport the airport that contains the flights with the airlines that are going to be sort
		 */
		public void sortByAirline(Airport airport) {
			for(int i=0;i<airport.getFlights().length-1;i++) {
				for(int j=0;j<airport.getFlights().length-i-1;j++) {
					if(airport.getFlights()[j].getAirline().compareTo(airport.getFlights()[j+1].getAirline())>0) {
						Flight aux = airport.getFlights()[j];
						airport.getFlights()[j] = airport.getFlights()[j+1];
						airport.getFlights()[j+1] = aux;
					}
				}
			}
		}
		
	//________________________________________________________________________________________________________________________________
//____________________________________________________________________________________________________________________________________
}

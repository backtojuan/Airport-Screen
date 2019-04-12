//___________________________________________________package of the class_____________________________________________________________
	
	package Sorting;
	
//________________________________________________packages used for this class________________________________________________________

	import Model.*;
	
//_______________________________________________________Atributtes___________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and sort Flights with selection methods
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Selection {
		
//_______________________________________________Methods for this class_______________________________________________________________		
		
		/**
		 * This method sorts the gates of the airlines lexicographycally using the classic Selection method
		 * @param airport The airport that contains the flights with the gates that are going to be sort.
		 */
		public void sortByGate(Airport airport) {
				for (int i = 0; i < airport.getFlights().length-1; i++) {
					int min = i;
					for (int j = i+1; j < airport.getFlights().length; j++) {
						Flight minValue = airport.getFlights()[min];
						Flight current  = airport.getFlights()[j];
						if(current.getGate().compareTo(minValue.getGate())<0) {
							min = j;
						}
					}
					Flight temp = airport.getFlights()[min];
					airport.getFlights()[min] = airport.getFlights()[i];
					airport.getFlights()[i] = temp;
				}		
			}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method sorts the identifiers of the airlines to the smallest to the biggest amount using the classic Selection Method
		 * @param airport The airport that contains the flights with the identifiers that are going to be sort.
		 */
		public void sortByIdentifier(Airport airport) {
			for(int i=0; i<airport.getFlights().length-1;i++) {
				int min = i;
				for(int j=i+1; j<airport.getFlights().length;j++) {
					Flight minValue = airport.getFlights()[min];
					Flight current = airport.getFlights()[j];
					if(current.compareTo(minValue)<0) {
						min = j;
					}
					Flight aux = airport.getFlights()[min];
					airport.getFlights()[min] = airport.getFlights()[i];
					airport.getFlights()[i] = aux;
				}
			}
		}
	//________________________________________________________________________________________________________________________________
	
	
	//________________________________________________________________________________________________________________________________
	
	
//____________________________________________________________________________________________________________________________________

}

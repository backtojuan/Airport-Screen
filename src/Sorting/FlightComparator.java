//___________________________________________________package of the class_____________________________________________________________

	package Sorting;

//________________________________________________packages used for this class________________________________________________________
	
	import java.util.Comparator;
	import Model.Flight;
	
//_______________________________________________________Atributtes___________________________________________________________________
	
	/**
	 * This class manage the necessary attributes and methods to manage and create a Flight
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class FlightComparator implements Comparator<Flight>{
	
		@Override
		/**
		 * The method overrides the compare method of the interface comparator to compare and sort the destination
		 * of the flights<br>
		 * @param f1 the first flight to compare 
		 * @param f2 the second flight to be compare with the first one
		 * @returns an Integer that represents if the destinations are the same, smallest or biggest than another one
		 */
		public int compare(Flight f1, Flight f2) {
			
			int comparation;
			
			String destination1 = f1.getDestinationcity();
			String destination2 = f2.getDestinationcity();
			
			if(destination1.compareTo(destination2)>0) {
				comparation = 1;
			}
			else if(destination1.compareTo(destination2)<0) {
				comparation = -1;
			}
			else {
				comparation = 0;
			}
			return comparation;
		}
//____________________________________________________________________________________________________________________________________
}

//___________________________________________________package of the class_____________________________________________________________

	package customexception;

//________________________________________________________attributes__________________________________________________________________
	
	/**
	 * This class manages the necessary attributes and methods to creates exception objects of type InvalidInformationException
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_February_2019
	 */
	public class InvalidInformationException extends Exception{
	
	private int invalidsize;
	
//___________________________________________________Constructor method_______________________________________________________________
		
		/**
		 * <b>InvalidInformationException constructor</b><br>
		 * @param invalidorder the order that the user enter wrong asked information
		 * @param invalidcentralbox the centralbox that the user choosed wrong asked information
		 * @param invaliddirection the direction that the user choosed wrong asked information
		 */
		public InvalidInformationException(int invalidsize) {
			
			super();
			this.invalidsize = invalidsize;
			
		}
//__________________________________________________Methods for this class____________________________________________________________
		
		/**
		 * This method allow the exception to generates an special message for every case where the user enter a wrong value
		 * @return A string report with the reason that lead the program to caused an exception
		 */
		@Override
		public String getMessage() {
			
			//report that is going to be return
			String report = "";
			
			//Size must be positive
			if(this.invalidsize < 0)
			{
				report += "You cannot create a negative size of flights" + "\n";
			}
			
			//Order can't be higher
			if(this.invalidsize >1000000) {
				report += "You cannot create a size of more than 1000000" + "\n";
			}
	
			return report;
		}
//____________________________________________________________________________________________________________________________________
	
}

//___________________________________________________package of the class_____________________________________________________________
	
	package Model;

//________________________________________________packages used for this class________________________________________________________
	
	import java.util.Random;
	import java.time.LocalDate;
	
//_______________________________________________________Atributtes___________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and create a Flight
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Flight {

		private String date;
		private String hour;
		private Airline airline;
		private int id;
		private Destination destinationcity;
		private Gate gate;
		
		private Random generator;
		
//_______________________________________________Methods for this class_______________________________________________________________
		
		/**
		 * <b>Flight Constructor</b>
		 * This method creates a flight with random attributes
		 */
		public Flight() {
			generator = new Random();
			
			date = generateRandomDate();
			verifyDate();
			hour = generateRandomHour();
			verifyHour();
			generateRandomAirline();
			generateRandomID();
			generateRandomDestination();
			generateRandomGate();
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method generates a random date (random year/random month/random day)
		 * <b>Pos:</b> A random date is generated 
		 * @return a String that represents the date of the flight
		 */
		private String generateRandomDate() {
			
			String date = "";
			
			int year = generator.nextInt(3000);
			int month = generator.nextInt(13);
			int day = generator.nextInt(32);
			
			//range given for the years
			if(2000<year && year<2050) {
				date += year + "/";
				if(month>0) {
					date += month + "/";
					
					//months with 31 days
					if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
						if(day>0 && day<=31) {
							date += day + "/";
						}
					}
					//months with 30 days
					else if(month == 4 || month == 6 || month == 9 || month == 11) {
						if(day>0 && day<=30) {
							date += day + "/";
						}
					}
					//months with 28 days
					else if(month == 2) {
						if(day>0 && day<=28) {
							date += day + "/";
						}
					}
				}
			}
			return date;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method generates a random hour (random h : random min)
		 * <b>Pos:</b> A random hour is generated 
		 * @return a String that represents the hour of the flight
		 */
		private String generateRandomHour() {
			
			String hour = "";
			
			int h = generator.nextInt(13);
			int m = generator.nextInt(61);

			int t = generator.nextInt(3);
			
			//hours for the day (12 hours format)
			if(h>0) {
				
				hour += h + ":";
				//O'clock hour
				if(m == 0) {
					hour += m;
					hour += m;
				}
				else {
					hour += m;
				}
			}
			
			//time of the day (morning or afternoon/evening)
			if(t>0) {
				if(t==1) {
					hour += " AM";
				}
				else {
					hour += " PM";
				}
			}
			
			return hour;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method generates a random identifier for the flight
		 * <b>Pos:</b> A random identifier is generated 
		 * @return an Integer that represents the identifier of the flight
		 */
		public int generateRandomID() {
			int id = generator.nextInt(1000);			
			return id;
		}
		
	//________________________________________________________________________________________________________________________________	
		
		/**
		 * This method gives a random airline to the flight
		 * <b>Pos:</b> A random generated airline is given to the flight
		 */
		private void generateRandomAirline() {
			
			int indicator = generator.nextInt(5);
			
			switch(indicator) {
				case 0:
					airline = Airline.AVIANCA;
				break;
				case 1:
					airline = Airline.COPAAIRLINES;
				break;
				case 2:
					airline = Airline.LATAM;
				break;
				case 3:
					airline = Airline.VIVACOLOMBIA;
				break;
				case 4:
					airline = Airline.WINGO;
				break;
			}
			
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a random destination to the flight
		 * <b>Pos:</b> A random generated destination is given to the flight
		 */
		private void generateRandomDestination() {
			
			int indicator = generator.nextInt(10);
			
			switch(indicator) {
				case 0:
					destinationcity = Destination.ARGENTINA;
				break;
				case 1:
					destinationcity = Destination.BOGOTA;
				break;
				case 2:
					destinationcity = Destination.CHILE;
				break;
				case 3:
					destinationcity = Destination.CHINA;
				break;
				case 4:
					destinationcity = Destination.EEUU;
				break;
				case 5:
					destinationcity = Destination.ISRAEL;
				break;
				case 6:
					destinationcity = Destination.LONDRES;
				break;
				case 7:
					destinationcity = Destination.RUSIA;
				break;
				case 8:
					destinationcity = Destination.SANANDRES;
				break;
				case 9:
					destinationcity = Destination.VENEZUELA;
				break;
			}
		}
		
	//________________________________________________________________________________________________________________________________	
		
		/**
		 * This method gives a random gate to the flight
		 * <b>Pos:</b> A random generated gate is given to the flight 
		 */
		private void generateRandomGate() {
			
			int indicator = generator.nextInt(10);
			
			switch(indicator){
				case 0:
					gate = Gate.A;
				break;
				case 1:
					gate = Gate.B;
				break;
				case 2:
					gate = Gate.C;
				break;
				case 3:
					gate = Gate.D;
				break;
				case 4:
					gate = Gate.E;
				break;
				case 5:
					gate = Gate.F;
				break;
				case 6:
					gate = Gate.G;
				break;
				case 7:
					gate = Gate.H;
				break;
				case 8:
					gate = Gate.I;
				break;
				case 9:
					gate = Gate.J;
				break;
			}		
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method verifies that the date of the flight is always right-generated
		 * <b>Pos:</b> the date of the flight has been verified and modified correctly
		 */
		private void verifyDate() {
			
			boolean correct = false;
			//checks if the date has the correct length
			while(!correct) {
				if(date.length() == 10 ) {
					correct = true;
				}
				else{
					date = generateRandomDate();
				}
			}
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method verifies that the hout of the flight is always right-generated
		 * <b>Pos:</b> the hour of the flight has been verified and modified correctly 
		 */
		private void verifyHour() {
			
			boolean correct = false;
			//checks if the hour has the correct lenght
			while(!correct) {
				if(hour.length() == 5) {
					correct = true;
				}
				else {
					hour = generateRandomHour();
				}
			}
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method sets the identifier attribute of the flight in the case that is necessary
		 * <b>Pre:</b> the flight exists
		 * <b>Pos:</b> the identifier of the flight has been set for the new value that arrives as a parameter
		 * @param newid
		 */
		public void setId(int newid) {
			id = newid;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the identifier of the flight
		 * @return an Integer that represents the unique identifier number of the flight
		 */
		public int getId() {
			return id;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the date of the flight
		 * @return a String that represents the date of the flight
		 */
		public String getDate() {
			return date;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the hour of the flight
		 * @return a String that represents the hour of the flight
		 */
		public String getHour() {
			return hour;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Airline given to the flight
		 * @return an Airline enumeration assignment that represents the airline given to the flight
		 */
		public Airline getAirline() {
			return airline;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Destination city given to the flight
		 * @return a Destination enumeration assignment that represents the Destination city given to the flight
		 */
		public Destination getDestinationcity() {
			return destinationcity;
		}
	//_______________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Gate given to the flight
		 * @return a Gate enumeration assignment that represents the Gate given to the flight
		 */
		public Gate getGate() {
			return gate;
		}		
//____________________________________________________________________________________________________________________________________
}

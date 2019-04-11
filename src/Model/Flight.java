//___________________________________________________package of the class_____________________________________________________________
	
	package Model;

//________________________________________________packages used for this class________________________________________________________
	
	import java.util.Random;
	import java.util.ArrayList;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	
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
		private String airline;
		private int id;
		private String destinationcity;
		private String gate;
	
		private Random generator;
	
		
//_______________________________________________Methods for this class_______________________________________________________________
		
		/**
		 * <b>Flight Constructor</b>
		 * This method creates a flight with random attributes
		 */
		public Flight(String airline, String destination, String gate){
			generator = new Random();
			
			date = generateRandomDate();
			verifyDate();
			hour = generateRandomHour();
			verifyHour();
			giveAirline(airline);
			generateRandomID();
			giveDestinationCity(destination);
			giveGate(gate);
		}
	//________________________________________________________________________________________________________________________________
		
		
	//________________________________________________________________________________________________________________________________
	
		/**
		 * This method generates a random date (random year/random month/random day)
		 * <b>Pos:</b> A random date is generated 
		 * @return a String that represents the date of the flight
		 */
		private String generateRandomDate() {
			
			String date = "";
			
			int year = 2019;
			int month = generator.nextInt(13);
			int day = generator.nextInt(32);
			
			//range given for the years
				date += year + "/";
				if(month>0) {
					date += month + "/";
					
					//months with 31 days
					if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
						if(day>0 && day<=31) {
							date += day + " ";
						}
					}
					//months with 30 days
					else if(month == 4 || month == 6 || month == 9 || month == 11) {
						if(day>0 && day<=30) {
							date += day + " ";
						}
					}
					//months with 28 days
					else if(month == 2) {
						if(day>0 && day<=28) {
							date += day + " ";
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
			int m = generator.nextInt(60);
			
			int t = generator.nextInt(2);
			
			//hours for the day (12 hours format)
			if(h>0 && m>0) {
				
				hour += h + ":";
				
				//O'clock hour
				if(m == 0) {
					hour += m;
					hour += m;
				}
				else if(m != 0){
					if(m<10) {
						hour += "0" + m;
					}
					else {
						hour += m;
					}
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
			int id = generator.nextInt(Airport.MAX_FLIGHTS);			
			return id;
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
			
			int indicator = generator.nextInt(2);
			
			boolean correct = false;
			//checks if the hour has the correct lenght
			while(!correct) {
				if(hour.length() == 5) {
					correct = true;
					if (indicator == 0) {
						hour += " AM ";
					}else {
						hour += " PM ";
					}
				}
				else {
					hour = generateRandomHour();
				}
			}
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a value to the airline of the flight
		 * @param Airline the airline that is going to be assign to the attribute of the flight
		 */
		public void giveAirline(String Airline) {
			airline = Airline;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a value to the destination of the flight
		 * @param destinationc
		 */
		public void giveDestinationCity(String destinationc) {
			destinationcity = destinationc;
		}
		
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method gives a value to the destination of the flight
		 * @param g
		 */
		public void giveGate(String g) {
			gate = g;
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
		 * This method sets the hour of the flight when its necessary
		 * <b>Pre:</b> the flight exists
		 * <b>Pos:</b> the hour of the flight has been set for the new value that arrives as a parameter
		 * @param newHour
		 */
		public void setHour(String newHour) {
			hour = newHour;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Airline given to the flight
		 * @return an Airline enumeration assignment that represents the airline given to the flight
		 */
		public String getAirline() {
			return airline;
		}
	//________________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Destination city given to the flight
		 * @return a Destination enumeration assignment that represents the Destination city given to the flight
		 */
		public String getDestinationcity() {
			return destinationcity;
		}
	//_______________________________________________________________________________________________________________________________
		
		/**
		 * This method returns the Gate given to the flight
		 * @return a Gate enumeration assignment that represents the Gate given to the flight
		 */
		public String getGate() {
			return gate;
		}		
//____________________________________________________________________________________________________________________________________
}

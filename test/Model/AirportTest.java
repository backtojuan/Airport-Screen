//________________________________________________package of the class_____________________________________________________________________

	package Model;
	
//_____________________________________________used packages for this class________________________________________________________________
	
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.Test;
	
	import java.util.Random;
	import java.io.IOException;
//_____________________________________________________Scenaries___________________________________________________________________________
	
	/**
	 * This class manage the necessary attributes and methods to test the Model class "Game".
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class AirportTest {

		private Airport airport;
		private Random random;
		
		/**
		 *This scenary is created to test the Airport constructor. 
		 */
		private void setUpScenary1() {
			
		}
		
		/**
		 *This scenary is created to test the Airport checkIDs method.
		 */
		private void setUpScenary2() throws IOException{
			random = new Random();
			airport = new Airport(random.nextInt(Airport.MAX_FLIGHTS));
		}
//____________________________________________________Test Methods_________________________________________________________________________
		
		@Test
		/**
		 * This method test the constructor of the Model class Airport, making sure the Airport is right initialized.
		 */
		public void testAirport() {
			try {
				setUpScenary1();
				random = new Random();
				airport = new Airport(random.nextInt(Airport.MAX_FLIGHTS));
				
				assertNotNull("The Airport Couldn't be created, its value is null", airport != null);
				assertNotNull("The flights does not exists", airport.getFlights() != null); 
			}
			catch(IOException ioe) {
				
			}
		}

	//_____________________________________________________________________________________________________________________________________
		
		@Test
		/**
		 * This method test the init method of the Model class Airport, making sure that the flights are correctly initialized and created
		 * inside the Airport
		 */
		public void testInit(){
			try {
				setUpScenary2();
			
				for(int i=0;i<airport.getFlights().length;i++) {
					assertNotNull("The flight is null", airport.getFlights()[i] != null);
				}
			}
			catch(IOException ioe) {
				
			}
		}
	//_____________________________________________________________________________________________________________________________________
		
		@Test
		/**
		 * This method test the checkIDs method of the model class Airport, making sure that the Airport checks the Identifiers of the 
		 * flights correctly and that these are totally unique.
		 */
		public void testCheckIds() {
			
			try {
				setUpScenary2();
			
					for(int i=0;i<airport.getFlights().length;i++) {
						int id1 = airport.getFlights()[i].getId();
						for(int j=i+1;j<airport.getFlights().length;j++) {
							int id2 = airport.getFlights()[j].getId();
							assertTrue("The ids are not unique", id1 != id2);
						}
					}
			}
			catch(IOException ioe) {
				
			}
		}
		
	//_____________________________________________________________________________________________________________________________________
		
//_________________________________________________________________________________________________________________________________________
		

}

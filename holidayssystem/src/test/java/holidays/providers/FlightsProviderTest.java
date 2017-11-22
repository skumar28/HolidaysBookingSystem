package holidays.providers;

import java.util.List;

import holidays.components.Flight;
import junit.framework.TestCase;

public class FlightsProviderTest extends TestCase {

	public void testFlightsProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		FlightsProvider flightProvider = new FlightsProvider();
	
		List<Flight> flightList = flightProvider.flightsByIds("1");
		for(Flight flt : flightList) {
			System.out.println(flt.getCarrierName());
		}
		
	}

}

package holidays.providers;

import java.util.List;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

import holidays.components.Flight;
import junit.framework.TestCase;

public class FlightsProviderTest extends TestCase {
	
	public void testFlightsProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		FlightsProvider flightProvider = new FlightsProvider();
		List<Flight> flightList = flightProvider.flightsByIds("1,2");
		int size = flightList.size(); 
		//displayFlight(flightList);
		System.out.println(gcd(4,2));
		
	}
	//@Requires({ " flightList.size() > 0" })
	public  void testDisplayFlight() {
		FlightsProvider flightProvider = new FlightsProvider();
		List<Flight> flightList = flightProvider.flightsByIds("1,2");
		for(Flight flt : flightList) {
			System.out.println(flt.getCarrierName());
		}		
		assertNotNull(flightList);
	}
	
	@Requires({ "x > 5", "y > 0" })
	@Ensures({ "result != 0", 
		       "old(x) % result == 0", 
		       "old(y) % result == 0" })
	public static int gcd(int x, int y) {
		while (x != 0 && y != 0) {
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		}
		return (x != 0) ? x : y;
	}

}

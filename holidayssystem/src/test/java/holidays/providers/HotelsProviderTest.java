package holidays.providers;

import java.util.List;

import holidays.components.Hotel;
import junit.framework.TestCase;

public class HotelsProviderTest extends TestCase {

	public void testHotelsProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		HotelsProvider hotelProvider = new HotelsProvider();
	
		List<Hotel> hotelList = hotelProvider.hotelsByIds("1,2,3");
		for(Hotel htl : hotelList) {
			System.out.println(htl.getName());
		}
		
	}
}

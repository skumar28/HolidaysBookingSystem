package holidays.providers;

import java.util.List;

import holidays.components.Hotel;
import junit.framework.TestCase;

public class HotelsProviderTest extends TestCase {
	
	HotelsProvider hotelProvider;
	
	public void setUp() {
		hotelProvider = new HotelsProvider();
	}

	public void testHotelsProvider()
    {	
		List<Hotel> hotelList = hotelProvider.hotelsByIds("1,2,3");
		
		assertEquals(3, hotelList.size());
    }
	
	public void testNoHotelFound() {
		List<Hotel> hotelList = hotelProvider.hotelsByIds("100");
		assertTrue(hotelList.isEmpty());
	}
	
	public static void main(String args[]) {
		HotelsProvider hotelProvider = new HotelsProvider();
	
		List<Hotel> hotelList = hotelProvider.hotelsByIds("1,2,3");
		for(Hotel htl : hotelList) {
			System.out.println(htl.getName());
		}
		
	}
}

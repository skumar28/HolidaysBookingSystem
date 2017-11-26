package holidays.providers;

import java.util.List;
import junit.framework.TestCase;
import holidays.services.ServiceProvider;
import holidays.components.Hotel;
import holidays.services.HolidayPackage;

public class ServiceProviderTest extends TestCase {
	
	ServiceProvider serviceProvider;
	
	public void setUp() {
		serviceProvider = new ServiceProvider();
	}

	public void testServiceProvider()
    {	
		List<HolidayPackage> packageList = serviceProvider.packageByIds("1");
		
		assertEquals(1, packageList.size());
    }
	
	public void testNoPackageFound() {
		List<HolidayPackage> packageList = serviceProvider.packageByIds("100");
		assertTrue(packageList.isEmpty());
	}
	

}

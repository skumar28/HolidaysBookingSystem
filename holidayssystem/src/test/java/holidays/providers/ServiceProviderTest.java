package holidays.providers;

import java.util.List;
import junit.framework.TestCase;
import holidays.services.ServiceProvider;

import holidays.services.HolidayPackage;

public class ServiceProviderTest extends TestCase {
	
	public void testServiceProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		ServiceProvider serviceProvider = new ServiceProvider();
		
		List<HolidayPackage> packageList = serviceProvider.packageByIds("1");
		//for(HolidayPackage hp : packageList) {
		//	System.out.println(hp.getName());
		//}
		
		packageList=serviceProvider.searchPackage("Best");
		
		if(packageList==null)
		{
			System.out.println("Sorry!!,No Packages Found!\n");
		}
		else
			serviceProvider.ListPackages(packageList);
		
		
		
	}

}

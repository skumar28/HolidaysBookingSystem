package holidays.providers;

import java.util.List;

import holidays.components.Transport;
import junit.framework.TestCase;

public class TransportProviderTest extends TestCase {
	public void testTransportProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		TransportProvider transportProvider = new TransportProvider();
	
		List<Transport>  transportList = transportProvider.transportByIds("1");
		for(Transport transport : transportList) {
			System.out.println(transport.getName());
		}
		
	}
}

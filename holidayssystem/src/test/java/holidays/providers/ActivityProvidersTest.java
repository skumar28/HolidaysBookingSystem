package holidays.providers;

import java.util.List;

import holidays.components.Activity;
import junit.framework.TestCase;

public class ActivityProvidersTest extends TestCase {
	public void testActivityProvider()
    {
        assertTrue( true );
    }
	
	public static void main(String args[]) {
		ActivityProviders activityProvider = new ActivityProviders();
	
		List<Activity> activityList = activityProvider.activityByIds("1");
		for(Activity act : activityList) {
			System.out.println(act.getName());
		}
		
	}
}

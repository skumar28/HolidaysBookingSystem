package holidays.LoginDetails;

import java.util.Random;

import holidays.customer.LoginInfo;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	Login login;
	LoginInfo userInfo1, userInfo2;
	Random rand;

	public void setUp() {
		login = new Login();
	}

	public void testLoginInfoFound() {
		userInfo1 = new LoginInfo();
		userInfo1.setUserName("achopra6");
		userInfo1.setPassword("1234");
		assertTrue(login.validateUser(userInfo1));
	}

	public void testRegisterLoginInfo() {
		userInfo2 = new LoginInfo();
		rand = new Random();
		userInfo2.setUserName("pqrst" + rand.nextInt(1000));
		userInfo2.setPassword("123");
		assertTrue(login.registerNewUser(userInfo2));
	}
}

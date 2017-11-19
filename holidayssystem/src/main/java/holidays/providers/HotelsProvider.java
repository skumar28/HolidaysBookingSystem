package holidays.providers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HotelsProvider {

	public static void main(String args[]) {
		try {
			File hotelData = new File(
					"D:\\Fall_2017\\CSE522_OOD\\project\\HolidaysBookingSystem\\holidayssystem\\src\\main\\java\\holidays\\datacontents\\file\\HotelsData.txt");
			FileReader fileReader = new FileReader(hotelData);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

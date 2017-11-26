package holidays.services;

import holidays.components.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import holidays.components.Flight;
import holidays.customer.CustomerInfo;
import holidays.providers.*;
import holidays.services.HolidayPackage;

public class ServiceProvider {

	Map<Integer, HolidayPackage> packageDataMap = new HashMap<>();

	public ServiceProvider() {
		loadServiceData();
	}

	private void loadServiceData() {
		// TODO Auto-generated method stub
		try {
			File serviceData = new File("src/main/java/holidays/datacontents/file/HolidayPacakges.txt");
			FileReader fileReader = new FileReader(serviceData);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				HolidayPackage holidayPackage = populateService(line);

				packageDataMap.put(holidayPackage.getId(), holidayPackage);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 1#Best of Western New York#This is value for money package#1#4 Days 3
	// Nights#Buffalo#noImage#1,2#2,3#1,2#1
	private HolidayPackage populateService(String line) {
		String servicedetails[] = line.split("#");
		HotelsProvider hp = new HotelsProvider();
		HolidayPackage holidayPackage = new HolidayPackage();

		ActivityProviders ap = new ActivityProviders();
		FlightsProvider fp = new FlightsProvider();
		TransportProvider tp = new TransportProvider();

		holidayPackage.setId(Integer.parseInt(servicedetails[0]));
		holidayPackage.setName(servicedetails[1]);
		holidayPackage.setDescription(servicedetails[2]);
		holidayPackage.setType(PackageType.getById(Integer.parseInt(servicedetails[3])));
		holidayPackage.setDuration(servicedetails[4]);
		holidayPackage.setFromCity(servicedetails[5]);
		holidayPackage.setImgsrc(servicedetails[6]);
		holidayPackage.setHotels(hp.hotelsByIds(servicedetails[7]));

		holidayPackage.setFlights(fp.flightsByIds(servicedetails[8]));
		holidayPackage.setActivities(ap.activityByIds(servicedetails[9]));
		holidayPackage.setTransport(tp.transportByIds(servicedetails[10]));

		return holidayPackage;
	}

	public List<HolidayPackage> packageByIds(String ids) {
		List<HolidayPackage> packageList = new ArrayList<>();
		String id[] = ids.split(",");

		for (String strId : id) {
			HolidayPackage pkg = packageDataMap.get(Integer.parseInt(strId));
			if (pkg != null) {
				packageList.add(pkg);
			}
		}
		return packageList;
	}

	public List<HolidayPackage> searchPackage(String searchcriteria) {

		List<HolidayPackage> packageList = new ArrayList<>();
		for (HolidayPackage hp : packageDataMap.values()) {
			if (hp.getFromCity().toLowerCase().contains(searchcriteria.toLowerCase())
					|| hp.getName().toLowerCase().contains(searchcriteria.toLowerCase())) {
				packageList.add(hp);
			}
		}

		return packageList;
	}

	public void ListPackages(List<HolidayPackage> listPackages) {

		List<Hotel> hotelList = new ArrayList<>();
		List<Activity> activityList = new ArrayList<>();
		List<Flight> flightList = new ArrayList<>();
		List<Transport> transportList = new ArrayList<>();

		for (HolidayPackage hp : listPackages) {

			hotelList = hp.getHotels();
			activityList = hp.getActivities();
			flightList = hp.getFlights();
			transportList = hp.getTransport();

			System.out.println("**************************************************************");
			System.out.println("ID :" + hp.getId() + "   Package Name: " + hp.getName());
			System.out.println("**************************************************************");
			System.out.println("Description :" + hp.getDescription());
			System.out.println("Type :" + hp.getType());
			System.out.println("Duration :" + hp.getDuration());
			System.out.println("From City :" + hp.getFromCity());

			if (!flightList.isEmpty()) {
				System.out.println("-----------------");
				System.out.println("Flight Details");
				System.out.println("-----------------");
				for (Flight flight : flightList) {
					System.out.println("Flight Name: " + flight.getCarrierName() + ", " + flight.getFlightName());
					System.out.println(
							"Departure Airport: " + flight.getFromCity() + "        Time: " + flight.getStartTime());
					System.out
							.println("Arrival Airport: " + flight.getToCity() + "       Time: " + flight.getEndTime());

					System.out.println();
				}
			}

			if (!hotelList.isEmpty()) {
				System.out.println("---------------");
				System.out.println("Hotel Details");
				System.out.println("---------------");
				for (Hotel htl : hotelList) {
					System.out.println("Hotel Name: " + htl.getName() + "    City:" + htl.getCityName());
					System.out.println("Description: " + htl.getDescription());
					System.out.println(
							"Checkin Time: " + htl.getCheckinTime() + "      Checkout Time: " + htl.getCheckoutTime());
					System.out.println("Room: " + htl.getRoomInfo().getCategory() + "     Meal :"
							+ htl.getRoomInfo().getDescription());
					System.out.println();
				}
			}

			if (!activityList.isEmpty()) {
				System.out.println("-------------------");
				System.out.println("Activities Details");
				System.out.println("-------------------");
				for (Activity act : activityList) {
					System.out.println("Activity Name: " + act.getName() + "     Duration: " + act.getDuration());
					System.out.println("Description: " + act.getDescription());
					System.out.println();
				}
			}

			if (!transportList.isEmpty()) {
				System.out.println("------------------");
				System.out.println("Transport Details");
				System.out.println("------------------");
				for (Transport trp : transportList) {
					System.out.println("Transport Name: " + trp.getName());
					System.out.println("Description: " + trp.getDescription());
				}
			}

			System.out.println();
			System.out.println();
		}
	}

	public HolidayPackage selectPackage(String id) {

		return null;
	}

	public HolidayPackage bookPackage(HolidayPackage hp) {

		return null;
	}

	public boolean makePayment(String packageId, CustomerInfo customer) {

		return true;
	}

	public Boolean savePackage(HolidayPackage hp, CustomerInfo customer) {

		return true;
	}

	public String sendConfirmation() {

		return null;
	}

	public boolean cancelPackage(Integer id) {

		return true;
	}
}

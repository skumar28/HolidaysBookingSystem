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
	
	
	Map<Integer, HolidayPackage> PackageDataMap = new HashMap<>();
	
	
	public ServiceProvider() {
		loadServiceData();
	}
	
	private void loadServiceData() {
		// TODO Auto-generated method stub
		try {
			File serviceData = new File(
					"/Users/akshaychopra/Documents/HolidaysBookingSystem/holidayssystem/src/main/java/holidays/datacontents/file/HolidayPacakges.txt");
			FileReader fileReader = new FileReader(serviceData);
			BufferedReader bufReader = new BufferedReader(fileReader);
			String line = "";

			while ((line = bufReader.readLine()) != null) {
				HolidayPackage holidayPackage = populateService(line);
				
				PackageDataMap.put(holidayPackage.getId(), holidayPackage);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//1#Best of Western New York#This is value for money package#1#4 Days 3 Nights#Buffalo#noImage#1,2#2,3#1,2#1
	private HolidayPackage populateService(String line) {
		String servicedetails[] = line.split("#");
		HotelsProvider hp = new  HotelsProvider();	
		HolidayPackage holidayPackage = new HolidayPackage();
		
		ActivityProviders ap= new ActivityProviders();
		FlightsProvider fp= new FlightsProvider(); 
		TransportProvider tp= new TransportProvider();
		
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
	
	
	public List<HolidayPackage> packageByIds(String ids){
		List<HolidayPackage> packageList = new ArrayList<>();
		String id[] = ids.split(","); 
		
		for(String strId : id) {
			packageList.add(PackageDataMap.get(Integer.parseInt(strId)));
		}
		return packageList;
	}
	
	
	
	public List<HolidayPackage> searchPackage(String searchcriteria) {		
		
		List<HolidayPackage> packageList= new ArrayList<>();
		for(HolidayPackage hp: PackageDataMap.values())
		{
			if(hp.getFromCity().toLowerCase().contains(searchcriteria.toLowerCase()) || hp.getName().toLowerCase().contains(searchcriteria.toLowerCase()))
			{
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
		
		for(HolidayPackage hp: listPackages)
		{
			
			hotelList=hp.getHotels();
			activityList=hp.getActivities();
			flightList=hp.getFlights();
			transportList=hp.getTransport();
			
			
			System.out.println("Pacakge ID :"+hp.getId());
			System.out.println("Name :"+hp.getName());
			System.out.println("Description :"+hp.getDescription());
			System.out.println("Type :"+hp.getType());
			System.out.println("Duration :"+hp.getDuration());
			System.out.println("City :"+hp.getFromCity());
			System.out.print("Hotel :\t");
			for(int i=0;i<hotelList.size();i++)
				System.out.print(hotelList.get(i).getName()+" ");
			
			System.out.println();
			
			System.out.print("Activities :");
			for(int i=0;i<activityList.size();i++)
				System.out.print(activityList.get(i).getName()+", ");
			
			System.out.println();
			
			System.out.print("Flight :");
			for(int i=0;i<flightList.size();i++)
				System.out.print(flightList.get(i).getCarrierName()+", ");
			
			
			System.out.println();
			
			System.out.print("Transport :");
			for(int i=0;i<transportList.size();i++)
				System.out.print(transportList.get(i).getName()+", ");
			
			
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

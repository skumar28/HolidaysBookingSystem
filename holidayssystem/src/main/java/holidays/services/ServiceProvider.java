package holidays.services;

import java.util.List;

import holidays.customer.CustomerInfo;

public class ServiceProvider {
	public List<HolidayPackage> searchPackage(String searchriteria) {

		return null;
	}

	public void ListPackages(List<HolidayPackage> listPackages) {

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

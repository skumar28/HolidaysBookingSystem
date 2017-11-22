package holidays.services;

import java.util.List;

public class HolidayPackage {
	private int id;
	private String name;
	private String description;
	private PackageType type;
	private String startDate;
	private String endDate;
	private String fromCity;
	private double totalPrice;
	private String imgsrc;
	private List<String> hotels;
	private List<String> flights;
	private List<String> activities;
	private List<String> transport;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PackageType getType() {
		return type;
	}

	public void setType(PackageType type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<String> getHotels() {
		return hotels;
	}

	public void setHotels(List<String> hotels) {
		this.hotels = hotels;
	}

	public List<String> getFlights() {
		return flights;
	}

	public void setFlights(List<String> flights) {
		this.flights = flights;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public List<String> getTransport() {
		return transport;
	}

	public void setTransport(List<String> transport) {
		this.transport = transport;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

}

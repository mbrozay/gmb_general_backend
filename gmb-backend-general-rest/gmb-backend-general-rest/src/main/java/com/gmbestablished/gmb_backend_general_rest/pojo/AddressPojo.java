package com.gmbestablished.gmb_backend_general_rest.pojo;


public class AddressPojo {
	private Long id;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String county;
	private String country;
	private String postCode;
	private String latitudeCoordinate;
	private String longitudeCoordinate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getLatitudeCoordinate() {
		return latitudeCoordinate;
	}
	public void setLatitudeCoordinate(String latitudeCoordinate) {
		this.latitudeCoordinate = latitudeCoordinate;
	}
	public String getLongitudeCoordinate() {
		return longitudeCoordinate;
	}
	public void setLongitudeCoordinate(String longitudeCoordinate) {
		this.longitudeCoordinate = longitudeCoordinate;
	}
	
}

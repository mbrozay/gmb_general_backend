package com.gmbestablished.gmb_backend_general_dataAccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long entityId;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
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
	public Long getEntityId() {
		return entityId;
	}
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
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

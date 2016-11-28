package com.gmbestablished.gmb_backend_general_rest.pojo;

import java.util.ArrayList;
import java.util.Collection;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;

public class EntityPrimaryPojo {
	
	private Long id;
	private String name;
		private String description;
		/*		private ArrayList<Address> address = new ArrayList<Address>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private String logo;
	private String aboutUs;
	private String servicesBlurb; */
	private ArrayList<Service> services = new ArrayList<Service>(); 
	private String response;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	/*	public ArrayList<Address> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	} */
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services; 
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}

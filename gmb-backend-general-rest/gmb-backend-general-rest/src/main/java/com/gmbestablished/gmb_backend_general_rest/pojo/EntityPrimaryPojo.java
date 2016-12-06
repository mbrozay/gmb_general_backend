package com.gmbestablished.gmb_backend_general_rest.pojo;

import java.util.ArrayList;
import java.util.Collection;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;

public class EntityPrimaryPojo {
	
	private Long id;
	private ArrayList<UserPojo> users = new ArrayList<UserPojo>();
	private String name;
	private String description;
	private Long category;
	private ArrayList<AddressPojo> addresses = new ArrayList<AddressPojo>();
	private ArrayList<Service> services = new ArrayList<Service>();
	private String logo;
	private String aboutUs;
	private String response;
	private ArrayList<Testimonial> testimonials = new ArrayList<Testimonial>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<UserPojo> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<UserPojo> users) {
		this.users = users;
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
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public ArrayList<AddressPojo> getAddresses() {
		return addresses;
	}
	public void setAddresses(ArrayList<AddressPojo> addresses) {
		this.addresses = addresses;
	}
	public ArrayList<Service> getServices() {
		return services;
	}
	public void setServices(ArrayList<Service> services) {
		this.services = services; 
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public ArrayList<Testimonial> getTestimonials() {
		return testimonials;
	}
	public void setTestimonials(ArrayList<Testimonial> testimonials) {
		this.testimonials = testimonials;
	}
}

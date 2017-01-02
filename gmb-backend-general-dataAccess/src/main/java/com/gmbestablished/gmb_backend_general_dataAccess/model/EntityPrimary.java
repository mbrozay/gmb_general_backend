package com.gmbestablished.gmb_backend_general_dataAccess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class EntityPrimary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="entityPrimary", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Address> addresses = new ArrayList<Address>();
	@ManyToMany
	@JoinTable(name = "category_entityPrimary_association", joinColumns = {
	@JoinColumn(name = "entityId") },
	inverseJoinColumns = { @JoinColumn(name = "categoryId")})
	@JsonManagedReference
	private List<Category> categories = new ArrayList<Category>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="entityPrimary")
	@JsonManagedReference
	private List<Metadata> metadata = new ArrayList<Metadata>();
	@ManyToMany(mappedBy="entityPrimary")
	@JsonBackReference
	private List <User> users = new ArrayList<User>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy="entityPrimary", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Review> reviews = new ArrayList<Review>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy="entityPrimary", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Service> services = new ArrayList<Service>();
	
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
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Metadata> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
		
}

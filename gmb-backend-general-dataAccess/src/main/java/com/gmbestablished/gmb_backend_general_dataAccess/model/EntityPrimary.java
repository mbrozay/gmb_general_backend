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
	private List<Address> address = new ArrayList<Address>();
	@ManyToMany
	@JoinTable(name = "category_entityPrimary_association", joinColumns = {
	@JoinColumn(name = "entityId") },
	inverseJoinColumns = { @JoinColumn(name = "categoryId")})
	@JsonManagedReference
	private List<Category> category = new ArrayList<Category>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="entityPrimary")
	@JsonManagedReference
	private List<Metadata> metadata = new ArrayList<Metadata>();
	@ManyToMany
	@JoinTable(name = "entityprimary_user_association", joinColumns = {
	@JoinColumn(name = "entityPrimaryId") },
	inverseJoinColumns = { @JoinColumn(name = "userId")})
	@JsonManagedReference
	private List <User> user = new ArrayList<User>();
	
	
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
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public List<Metadata> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}	
}

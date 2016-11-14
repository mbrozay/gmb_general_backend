package com.gmbestablished.gmb_backend_general_dataAccess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class EntityPrimary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="entityPrimary")
	@JsonManagedReference
	private List<Address> address = new ArrayList<Address>();
	@ManyToMany(mappedBy="entityPrimary")
	@JsonManagedReference
	private List<Category> category = new ArrayList<Category>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="entityPrimary")
	@JsonManagedReference
	private List<Metadata> metadata = new ArrayList<Metadata>();
	
	
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
	

		
}

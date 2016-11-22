package com.gmbestablished.gmb_backend_general_dataAccess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	@ManyToMany(mappedBy="category")
	@JsonBackReference
	private List<EntityPrimary> entityPrimary = new ArrayList<EntityPrimary>();
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
	public List<EntityPrimary> getEntityPrimary() {
		return entityPrimary;
	}
	public void setEntityPrimary(List<EntityPrimary> entityPrimary) {
		this.entityPrimary = entityPrimary;
	}
	
	
	
}

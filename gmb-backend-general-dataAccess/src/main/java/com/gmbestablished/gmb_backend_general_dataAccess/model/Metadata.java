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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Metadata {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="metaDataTypeId")
	@JsonManagedReference
	private Metadatatype metaDataTypeId;
	//private long metaDataTypeId;
	private String metaDataValue;
	@ManyToMany
	@JoinTable(name = "entityprimary_metadata_association", joinColumns = {
	@JoinColumn(name = "metadataId") },
	inverseJoinColumns = { @JoinColumn(name = "entityPrimaryId")})
	@JsonBackReference
	private List<EntityPrimary> entityPrimary = new ArrayList<EntityPrimary>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Metadatatype getMetaDataTypeId() {
		return metaDataTypeId;
	}
	public void setMetaDataTypeId(Metadatatype metaDataTypeId) {
		this.metaDataTypeId = metaDataTypeId;
	}
	public String getMetaDataValue() {
		return metaDataValue;
	}
	/*public long getMetaDataTypeId() {
		return metaDataTypeId;
	}
	public void setMetaDataTypeId(long metaDataTypeId) {
		this.metaDataTypeId = metaDataTypeId;
	}*/
	public void setMetaDataValue(String metaDataValue) {
		this.metaDataValue = metaDataValue;
	}
	public List<EntityPrimary> getEntityPrimary() {
		return entityPrimary;
	}
	public void setEntityPrimary(List<EntityPrimary> entityPrimary) {
		this.entityPrimary = entityPrimary;
	}
	
}

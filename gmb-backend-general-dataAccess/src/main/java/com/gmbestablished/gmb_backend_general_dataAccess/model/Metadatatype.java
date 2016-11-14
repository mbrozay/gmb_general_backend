package com.gmbestablished.gmb_backend_general_dataAccess.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Metadatatype {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String metaDataTypeName;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="metaDataTypeId")
	@JsonBackReference
	private List<Metadata> metadata = new ArrayList<Metadata>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
		public List<Metadata> getMetadata() {
		return metadata;
	}
	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
	public String getMetaDataTypeName() {
		return metaDataTypeName;
	}
	public void setMetaDataTypeName(String metaDataTypeName) {
		this.metaDataTypeName = metaDataTypeName;
	}

}

package com.gmbestablished.gmb_backend_general_rest.pojo;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadata;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadatatype;

public class AboutUs extends Metadata {

	private long id;
	private Metadatatype metaDataTypeId;
	private String metaDataValue;
	
	public AboutUs (EntityPrimaryPojo entityPrimaryPojo){
		setMetaDataValue("TestString");
	}
	
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
	public void setMetaDataValue(String metaDataValue) {
		this.metaDataValue = metaDataValue;
	}
	
}

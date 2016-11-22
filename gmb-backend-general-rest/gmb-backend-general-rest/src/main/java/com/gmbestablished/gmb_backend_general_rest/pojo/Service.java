package com.gmbestablished.gmb_backend_general_rest.pojo;

public class Service {

	private long id;
	private String serviceBlockHeading;
	private String serviceBlockText;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getServiceBlockHeading() {
		return serviceBlockHeading;
	}
	public void setServiceBlockHeading(String serviceBlockHeading) {
		this.serviceBlockHeading = serviceBlockHeading;
	}
	public String getServiceBlockText() {
		return serviceBlockText;
	}
	public void setServiceBlockText(String serviceBlockText) {
		this.serviceBlockText = serviceBlockText;
	}
}

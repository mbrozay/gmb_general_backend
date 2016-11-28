package com.gmbestablished.gmb_backend_general_rest.pojo;

public class Service {

	private long id;
	private String serviceBlockTitle;
	private String serviceBlockBody;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getServiceBlockTitle() {
		return serviceBlockTitle;
	}
	public void setServiceBlockTitle(String serviceBlockTitle) {
		this.serviceBlockTitle = serviceBlockTitle;
	}
	public String getServiceBlockBody() {
		return serviceBlockBody;
	}
	public void setServiceBlockBody(String serviceBlockBody) {
		this.serviceBlockBody = serviceBlockBody;
	}
}

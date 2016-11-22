package com.gmbestablished.gmb_backend_general_rest.pojo;

public class Testimonial {
	
	private Long id;
	private String testimonialFromName;
	private String testimonialBody;
	private String testimonialFromURL;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestimonialFromName() {
		return testimonialFromName;
	}
	public void setTestimonialFromName(String testimonialFromName) {
		this.testimonialFromName = testimonialFromName;
	}
	public String getTestimonialBody() {
		return testimonialBody;
	}
	public void setTestimonialBody(String testimonialBody) {
		this.testimonialBody = testimonialBody;
	}
	public String getTestimonialFromURL() {
		return testimonialFromURL;
	}
	public void setTestimonialFromURL(String testimonialFromURL) {
		this.testimonialFromURL = testimonialFromURL;
	}
}

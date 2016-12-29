package com.gmbestablished.gmb_backend_general_dataAccess.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String reviewerName;
	private String reviewerUrl;
	private String reviewerBody;
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="entityPrimaryId")
	@JsonBackReference
	private EntityPrimary entityPrimary;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReviewerUrl() {
		return reviewerUrl;
	}
	public void setReviewerUrl(String reviewerUrl) {
		this.reviewerUrl = reviewerUrl;
	}
	public String getReviewerBody() {
		return reviewerBody;
	}
	public void setReviewerBody(String reviewerBody) {
		this.reviewerBody = reviewerBody;
	}
	public EntityPrimary getEntityPrimary() {
		return entityPrimary;
	}
	public void setEntityPrimary(EntityPrimary entityPrimary) {
		this.entityPrimary = entityPrimary;
	}	
}

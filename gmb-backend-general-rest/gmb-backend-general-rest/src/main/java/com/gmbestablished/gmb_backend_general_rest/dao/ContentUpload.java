package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.EntityPrimary;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadata;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadatatype;
import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;

public class ContentUpload {

	public String ContentUploadSave(EntityPrimaryPojo entityPrimaryPojo) {
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		EntityPrimary entityPrimary = new EntityPrimary();
		Address address = new Address();
		address.setAddressLine1(entityPrimaryPojo.getAddresses().get(0).getAddressLine1());
		address.setAddressLine2(entityPrimaryPojo.getAddresses().get(0).getAddressLine2());
		address.setAddressLine3(entityPrimaryPojo.getAddresses().get(0).getAddressLine3());
		address.setCity(entityPrimaryPojo.getAddresses().get(0).getCity());
		address.setCounty(entityPrimaryPojo.getAddresses().get(0).getCounty());
		address.setCountry(entityPrimaryPojo.getAddresses().get(0).getCountry());
		address.setPostCode(entityPrimaryPojo.getAddresses().get(0).getPostCode());
		address.setLatitudeCoordinate(entityPrimaryPojo.getAddresses().get(0).getLatitudeCoordinate());
		address.setLongitudeCoordinate(entityPrimaryPojo.getAddresses().get(0).getLongitudeCoordinate());
		address.setEntityPrimary(entityPrimary);	
		
		User user = new User();
		user.setFirstName(entityPrimaryPojo.getUsers().get(0).getFirstName());
		user.setLastName(entityPrimaryPojo.getUsers().get(0).getLastName());
		user.setUsername(entityPrimaryPojo.getUsers().get(0).getUsername());
		user.setPassword(entityPrimaryPojo.getUsers().get(0).getPassword());
		session.save(user);
		List<User> users = new ArrayList<User>();
		users.add(user);
		

		entityPrimary.setUser(users);
		entityPrimary.setName(entityPrimaryPojo.getName());
		entityPrimary.setDescription(entityPrimaryPojo.getDescription());
		
		Long categoryId = (long) entityPrimaryPojo.getCategory();
		Category category = (Category) session.get(Category.class, categoryId);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		entityPrimary.setCategory(categories);
		
		List<Metadata> metadatas = new ArrayList<Metadata>();
		//About Us
		Metadata aboutUsMetadata = new Metadata();
		Metadatatype aboutUsMetadatatype = (Metadatatype) session.get(Metadatatype.class, (long) 2);
		aboutUsMetadata.setMetaDataTypeId(aboutUsMetadatatype);
		aboutUsMetadata.setMetaDataValue(entityPrimaryPojo.getAboutUs());
		session.save(aboutUsMetadata);
		metadatas.add(aboutUsMetadata);	
		
		Metadata aboutUsMetadataOOP = new MetaDataContent((long)2).metadataSingleValue(entityPrimaryPojo);
		session.save(aboutUsMetadataOOP);
		
		entityPrimary.setMetadata(metadatas);
		
		session.save(entityPrimary);
		entityPrimary.getAddress().add(address);
		user.getEntityPrimary().add(entityPrimary);	
		aboutUsMetadata.getEntityPrimary().add(entityPrimary);
		session.save(address);
		session.getTransaction().commit();
		
		return null;
	}
	
}

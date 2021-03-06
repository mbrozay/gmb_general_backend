package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadata;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadatatype;
import com.gmbestablished.gmb_backend_general_dataAccess.model.SessionToken;
import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;
import com.gmbestablished.gmb_backend_general_dataAccess.model.EntityPrimary;

public class ContentUpload {

	public String ContentUploadSave(EntityPrimaryPojo entityPrimaryPojo) {
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		EntityPrimary entityPrimary = new EntityPrimary();
		Address address = new Address();
		if (entityPrimaryPojo.getAddresses().get(0).getId() != null){
			address.setId(entityPrimaryPojo.getAddresses().get(0).getId());
		}
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
		
		/*User user = new User();
		if (entityPrimaryPojo.getUsers().get(0).getId() !=null){
			user.setId(entityPrimaryPojo.getUsers().get(0).getId());
		}
		user.setFirstName(entityPrimaryPojo.getUsers().get(0).getFirstName());
		user.setLastName(entityPrimaryPojo.getUsers().get(0).getLastName());
		user.setUsername(entityPrimaryPojo.getUsers().get(0).getUsername());
		user.setPassword(entityPrimaryPojo.getUsers().get(0).getPassword());
		session.saveOrUpdate(user);
		List<User> users = new ArrayList<User>();
		users.add(user);*/
		
		String sessionToken = entityPrimaryPojo.getSessionToken();
		String sessionHql = "from SessionToken where sessionToken = :sessionToken";
		//	String sessionToken = epPicker_pojo.getSessionToken();
			Query sessionQuery = session.createQuery(sessionHql);
			sessionQuery.setParameter("sessionToken", sessionToken);
			List<SessionToken> sessionTokens = (ArrayList<SessionToken> )sessionQuery.list();
		
			User user = sessionTokens.get(0).getUser();
			List<User> users = new ArrayList<User>();
			users.add(user);
			
		if (entityPrimaryPojo.getId() != null){
			entityPrimary.setId(entityPrimaryPojo.getId());
		}
//		entityPrimary.setUser(users);
		entityPrimary.setName(entityPrimaryPojo.getName());
		entityPrimary.setDescription(entityPrimaryPojo.getDescription());
		
		Long categoryId = (long) entityPrimaryPojo.getCategory();
		Category category = (Category) session.get(Category.class, categoryId);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		entityPrimary.setCategories(categories);
		
/*		List<Metadata> metadatas = new ArrayList<Metadata>();
		//About Us
		Metadata aboutUsMetadata = new Metadata();
		Metadatatype aboutUsMetadatatype = (Metadatatype) session.get(Metadatatype.class, (long) 2);
		aboutUsMetadata.setMetaDataTypeId(aboutUsMetadatatype);
		aboutUsMetadata.setMetaDataValue(entityPrimaryPojo.getAboutUs());
		session.saveOrUpdate(aboutUsMetadata);
		metadatas.add(aboutUsMetadata);		
		
		//Services
		Metadata service1TitleMetadata = new Metadata();
		Metadatatype service1TitleMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 3);
		service1TitleMetadata.setMetaDataTypeId(service1TitleMetadataType);
		service1TitleMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(0).getServiceBlockTitle());
		session.saveOrUpdate(service1TitleMetadata);
		metadatas.add(service1TitleMetadata);
		
		Metadata service1BodyMetadata = new Metadata();
		Metadatatype service1BodyMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 4);
		service1BodyMetadata.setMetaDataTypeId(service1BodyMetadataType);
		service1BodyMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(0).getServiceBlockBody());
		session.saveOrUpdate(service1BodyMetadata);
		metadatas.add(service1BodyMetadata);
		
		Metadata service2TitleMetadata = new Metadata();
		Metadatatype service2TitleMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 5);
		service2TitleMetadata.setMetaDataTypeId(service2TitleMetadataType);
		service2TitleMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(1).getServiceBlockTitle());
		session.saveOrUpdate(service2TitleMetadata);
		metadatas.add(service2TitleMetadata);
		
		Metadata service2BodyMetadata = new Metadata();
		Metadatatype service2BodyMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 6);
		service2BodyMetadata.setMetaDataTypeId(service2BodyMetadataType);
		service2BodyMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(1).getServiceBlockBody());
		session.saveOrUpdate(service2BodyMetadata);
		metadatas.add(service2BodyMetadata);
		
		Metadata service3TitleMetadata = new Metadata();
		Metadatatype service3TitleMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 7);
		service3TitleMetadata.setMetaDataTypeId(service3TitleMetadataType);
		service3TitleMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(2).getServiceBlockTitle());
		session.saveOrUpdate(service3TitleMetadata);
		metadatas.add(service3TitleMetadata);
		
		Metadata service3BodyMetadata = new Metadata();
		Metadatatype service3BodyMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 8);
		service3BodyMetadata.setMetaDataTypeId(service3BodyMetadataType);
		service3BodyMetadata.setMetaDataValue(entityPrimaryPojo.getServices().get(2).getServiceBlockBody());
		session.saveOrUpdate(service3BodyMetadata);
		metadatas.add(service3BodyMetadata);
		
		//Testimonial
		Metadata testimonialFromName1Metadata = new Metadata();
		Metadatatype testimonial1FromNameMetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 9);
		testimonialFromName1Metadata.setMetaDataTypeId(testimonial1FromNameMetadataType);
		testimonialFromName1Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(0).getTestimonialFromName());
		session.saveOrUpdate(testimonialFromName1Metadata);
		metadatas.add(testimonialFromName1Metadata);
				
		Metadata testimonialFromWebSite1Metadata = new Metadata();
		Metadatatype testimonialFromWebSite1MetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 10);
		testimonialFromWebSite1Metadata.setMetaDataTypeId(testimonialFromWebSite1MetadataType);
		testimonialFromWebSite1Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(0).getTestimonialFromURL());
		session.saveOrUpdate(testimonialFromWebSite1Metadata);
		metadatas.add(testimonialFromWebSite1Metadata);

		Metadata testimonialBody1Metadata = new Metadata();
		Metadatatype testimonialBody1MetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 11);
		testimonialBody1Metadata.setMetaDataTypeId(testimonialBody1MetadataType);
		testimonialBody1Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(0).getTestimonialBody());
		session.saveOrUpdate(testimonialBody1Metadata);
		metadatas.add(testimonialBody1Metadata);
		
		Metadata testimonialFromName2Metadata = new Metadata();
		Metadatatype testimonialFromName2MetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 12);
		testimonialFromName2Metadata.setMetaDataTypeId(testimonialFromName2MetadataType);
		testimonialFromName2Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(1).getTestimonialFromName());
		session.saveOrUpdate(testimonialFromName2Metadata);
		metadatas.add(testimonialFromName2Metadata);
				
		Metadata testimonialFromWebSite2Metadata = new Metadata();
		Metadatatype testimonialFromWebSite2MetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 13);
		testimonialFromWebSite2Metadata.setMetaDataTypeId(testimonialFromWebSite2MetadataType);
		testimonialFromWebSite2Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(1).getTestimonialFromURL());
		session.saveOrUpdate(testimonialFromWebSite2Metadata);
		metadatas.add(testimonialFromWebSite2Metadata);

		Metadata testimonialBody2Metadata = new Metadata();
		Metadatatype testimonialBody2MetadataType = (Metadatatype) session.get(Metadatatype.class, (long) 14);
		testimonialBody2Metadata.setMetaDataTypeId(testimonialBody2MetadataType);
		testimonialBody2Metadata.setMetaDataValue(entityPrimaryPojo.getTestimonials().get(1).getTestimonialBody());
		session.saveOrUpdate(testimonialBody2Metadata);
		metadatas.add(testimonialBody2Metadata);*/
		
//		entityPrimary.setMetadata(metadatas);
		session.saveOrUpdate(entityPrimary);
		entityPrimary.getAddresses().add(address);
		user.getEntityPrimary().add(entityPrimary);	
/*		aboutUsMetadata.getEntityPrimary().add(entityPrimary);
		service1TitleMetadata.getEntityPrimary().add(entityPrimary);
		service1BodyMetadata.getEntityPrimary().add(entityPrimary);
		service2TitleMetadata.getEntityPrimary().add(entityPrimary);
		service2BodyMetadata.getEntityPrimary().add(entityPrimary);
		service3TitleMetadata.getEntityPrimary().add(entityPrimary);
		service3BodyMetadata.getEntityPrimary().add(entityPrimary);
		testimonialFromName1Metadata.getEntityPrimary().add(entityPrimary);
		testimonialFromWebSite1Metadata.getEntityPrimary().add(entityPrimary);
		testimonialBody1Metadata.getEntityPrimary().add(entityPrimary);
		testimonialFromName2Metadata.getEntityPrimary().add(entityPrimary);
		testimonialFromWebSite2Metadata.getEntityPrimary().add(entityPrimary);
		testimonialBody2Metadata.getEntityPrimary().add(entityPrimary);*/
		session.saveOrUpdate(address);
		session.getTransaction().commit();
		
		return null;
	}
	
}

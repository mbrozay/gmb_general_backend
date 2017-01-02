package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gmbestablished.gmb_backend_general_dataAccess.model.EntityPrimary;
import com.gmbestablished.gmb_backend_general_dataAccess.model.SessionToken;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.UserPojo;

public class EntityPrimaryList {
	
	public String EntityPrimaryListJson(UserPojo userPojo) throws JsonProcessingException{
		
		List<EntityPrimary> allEntityPrimary = null;
		String sessionToken = userPojo.getSessionToken();
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		if (userPojo.getSessionToken() == null){
			Query query = 
					session.createQuery("from EntityPrimary");
			
			allEntityPrimary = (ArrayList<EntityPrimary>) query.list();
			System.out.println("Size of list result is " + allEntityPrimary.size());
			if (allEntityPrimary.size() > 0){
				System.out.println(allEntityPrimary.get(0).getAddresses().get(0).getAddressLine1());
				System.out.println(allEntityPrimary.get(0).getCategories().get(0).getDescription());
//				System.out.println(allEntityPrimary.get(0).getMetadata().get(0).getMetaDataTypeId().getMetaDataTypeName());
			}
		}
		else {
			String sessionHql = "from SessionToken where sessionToken = :sessionToken";
			//	String sessionToken = epPicker_pojo.getSessionToken();
				Query sessionQuery = session.createQuery(sessionHql);
				sessionQuery.setParameter("sessionToken", sessionToken);
				List<SessionToken> sessionTokens = (ArrayList<SessionToken> )sessionQuery.list();
				allEntityPrimary = sessionTokens.get(0).getUser().getEntityPrimary();
		}


		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String allEntityPrimaryJacksonJson = mapper.writeValueAsString(allEntityPrimary);
		System.out.println(allEntityPrimaryJacksonJson);
		
		session.close();
	return allEntityPrimaryJacksonJson;	
	}
	
/*	public String EntityPrimaryWithAddressList (){
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from Address");
		
		ArrayList<Object[]> allEntityPrimary = (ArrayList<Object[]>) query.list();
		System.out.println("Size of list result is " + allEntityPrimary.size());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String allEntityPrimaryWithAddressJacksonJson = null;
		try {
			allEntityPrimaryWithAddressJacksonJson = mapper.writeValueAsString(allEntityPrimary);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(allEntityPrimaryWithAddressJacksonJson);
		
		session.close();
	return allEntityPrimaryWithAddressJacksonJson;	
		
		
	}*/


}

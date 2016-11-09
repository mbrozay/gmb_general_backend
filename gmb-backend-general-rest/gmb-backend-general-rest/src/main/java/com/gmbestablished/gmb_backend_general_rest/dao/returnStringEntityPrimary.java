package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gmbestablished.gmb_backend_general_dataAccess.model.EntityPrimary;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;

public class returnStringEntityPrimary {
	
	public String EntityPrimaryList() throws JsonProcessingException{
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from EntityPrimary");
		
		List<EntityPrimary> allEntityPrimary = (ArrayList<EntityPrimary>) query.list();
		System.out.println("Size of list result is " + allEntityPrimary.size());
		System.out.println(allEntityPrimary.get(0).getAddress().get(0).getAddressLine1());
		System.out.println(allEntityPrimary.get(0).getCategory().get(0).getDescription());
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String allEntityPrimaryJacksonJson = mapper.writeValueAsString(allEntityPrimary);
		System.out.println(allEntityPrimaryJacksonJson);
		
		session.close();
	return allEntityPrimaryJacksonJson;	
	}
	
	public String EntityPrimaryWithAddressList (){
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
		
		
	}


}

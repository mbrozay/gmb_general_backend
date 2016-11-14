package com.gmbestablished.gmb_backend_general_rest.testmains;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadata;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;

public class TestOTMJoin {

	public static void main(String[] args) {
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query = 
				session.createQuery("from Metadata");
		
		List<Metadata> allMetadata = (ArrayList<Metadata>) query.list();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String allEntityPrimaryJacksonJson;
		try {
			allEntityPrimaryJacksonJson = mapper.writeValueAsString(allMetadata);
			System.out.println(allEntityPrimaryJacksonJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		session.close();
		
		Session sessionAddress = null;
		sessionAddress = HibernateUtil.getSessionFactory().getCurrentSession();
		sessionAddress.beginTransaction();
		
		Query queryAddress = 
				sessionAddress.createQuery("from Address");
		
		List<Address> allAddress = (ArrayList<Address>) queryAddress.list();
		
		ObjectMapper mapperAddress = new ObjectMapper();
		mapperAddress.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		String allAddressJacksonJson;
		try {
			allAddressJacksonJson = mapper.writeValueAsString(allAddress);
			System.out.println(allAddressJacksonJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		sessionAddress.close();
	}

}

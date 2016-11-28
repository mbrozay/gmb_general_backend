package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;

public class ReturnCategories {

	String allcategriesJacksonJson;
	
	public String categories(){
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from Category";
		Query query = session.createQuery(hql);
		
		List<Category> allCategories = (ArrayList<Category>) query.list();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		try {
			allcategriesJacksonJson = mapper.writeValueAsString(allCategories);
					System.out.println(allcategriesJacksonJson);			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.close();
		return allcategriesJacksonJson;
	}
	
}

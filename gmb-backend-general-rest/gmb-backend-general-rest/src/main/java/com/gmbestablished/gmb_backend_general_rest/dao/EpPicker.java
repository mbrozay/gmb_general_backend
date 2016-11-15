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
import com.gmbestablished.gmb_backend_general_rest.pojo.EpPicker_pojo;

public class EpPicker {

	String allEntityPrimaryJacksonJson;
	
	public String epPick(EpPicker_pojo epPicker_pojo) {
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from EntityPrimary where id = :id";
		Long id = epPicker_pojo.getId();
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		
		List<EntityPrimary> allEntityPrimary = (ArrayList<EntityPrimary>) query.list();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		

		try {
			allEntityPrimaryJacksonJson = mapper.writeValueAsString(allEntityPrimary);
					System.out.println(allEntityPrimaryJacksonJson);
			
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.close();
		return allEntityPrimaryJacksonJson;
		
		
	}
	
}

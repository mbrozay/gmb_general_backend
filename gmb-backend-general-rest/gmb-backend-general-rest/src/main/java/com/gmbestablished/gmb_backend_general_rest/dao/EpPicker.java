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
import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EpPicker_pojo;

public class EpPicker {

	String allEntityPrimaryJacksonJson;
	
	public String epPick(EpPicker_pojo epPicker_pojo) {
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Query query;
		List<EntityPrimary> allEntityPrimary;
		String sessionToken = epPicker_pojo.sessionToken;
		if (sessionToken != null && !sessionToken.isEmpty()){	
		String sessionHql = "from SessionToken where sessionToken = :sessionToken";
	//	String sessionToken = epPicker_pojo.getSessionToken();
		Query sessionQuery = session.createQuery(sessionHql);
		sessionQuery.setParameter("sessionToken", sessionToken);
		List<SessionToken> sessionTokens = (ArrayList<SessionToken> )sessionQuery.list();
		allEntityPrimary = sessionTokens.get(0).getUser().getEntityPrimary();
	//	String description = sessionTokens.get(0).getUser().getEntityPrimary().get(0).getDescription();
	//	System.out.println(description);
		}
		else
		{	
		String hql = "from EntityPrimary where id = :id";
		Long id = epPicker_pojo.getId();
		query = session.createQuery(hql);
		query.setParameter("id", id);
		allEntityPrimary = (ArrayList<EntityPrimary>) query.list();
		}
		
	//	List<EntityPrimary> allEntityPrimary = (ArrayList<EntityPrimary>) query.list();
		
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

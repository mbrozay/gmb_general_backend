package com.gmbestablished.gmb_backend_general_rest.dao;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.auth0.jwt.algorithms.Algorithm;
import com.gmbestablished.gmb_backend_general_dataAccess.model.SessionToken;
import com.gmbestablished.gmb_backend_general_rest.pojo.LoginPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.UserPojo;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;

public class LoginValidate {

	String message;
	String sessionTokenValue;
	
	
	static ArrayList<User> users;
	
	public String LoginCheckCreds (UserPojo userPojo){
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String username = userPojo.getUsername();
		String password = userPojo.getPassword();
		String email = userPojo.getEmail();
		Boolean jWt = userPojo.getjWT();
		ArrayList<User> users;
		
		
		if (jWt == true) {
			String hql = "from User where email = :email and password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			users = (ArrayList<User>) query.list();
		}
		else 
		{
		String hql = "from User where username = :username and password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		users = (ArrayList<User>) query.list();	
		}
		
		
		
		if (users.size()>0){
			sessionTokenValue = UUID.randomUUID().toString();
			SessionToken sessionToken = new SessionToken();
			Long playerId = users.get(0).getId();
			sessionToken.setSessionToken(sessionTokenValue);
			sessionToken.setUser(users.get(0));
			session.save(sessionToken);
			session.getTransaction().commit();
			
		}		
		else {
			sessionTokenValue = null;
		}		
		session.getSessionFactory().close();
		return sessionTokenValue;
	}
}

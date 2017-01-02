package com.gmbestablished.gmb_backend_general_rest.dao;

import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.LoginPojo;
import com.gmbestablished.gmb_backend_general_rest.pojo.UserPojo;

public class UserUpdater {
	
	public String userUpdate(UserPojo userPojo){
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User user = new User();
		user.setFirstName(userPojo.getFirstName());
		user.setLastName(userPojo.getLastName());
		user.setUsername(userPojo.getUsername());
		user.setPassword(userPojo.getPassword());
		
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		
		LoginValidate loginValidate = new LoginValidate();
		String sessionToken = loginValidate.LoginCheckCreds(userPojo);
		
		
		return sessionToken;
	}

}

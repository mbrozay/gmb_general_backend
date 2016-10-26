package com.gmbestablished.gmb_backend_general_dataAccess.TestMains;

// import java.util.ArrayList;
// import org.hibernate.Query;
import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.User;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;

public class TestCRUD {

	public static void main(String[] args) {
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		User user = new User();
		user.setFirstName("Michael");
		user.setLastName("Brosnan");
		user.setUsername("mbrosnan26102016a");
		user.setPassword("mbrosnan26102016a");
		
		session.save(user);
		session.getTransaction().commit();
		
		
		System.exit(0);

	}

}

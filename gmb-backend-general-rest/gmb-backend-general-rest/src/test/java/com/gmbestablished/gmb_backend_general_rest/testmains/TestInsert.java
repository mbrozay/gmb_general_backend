package com.gmbestablished.gmb_backend_general_rest.testmains;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Address;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Category;
import com.gmbestablished.gmb_backend_general_dataAccess.model.EntityPrimary;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;

public class TestInsert {

	public static void main(String[] args) {

		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	
		Address address = new Address();
		address.setAddressLine1("1");
		address.setAddressLine2("the street");
		address.setCity("Cork");
		address.setPostCode("123");
		address.setCountry("Ireland");
		
		EntityPrimary entityPrimary = new EntityPrimary();
		entityPrimary.setName("name1");
		entityPrimary.setDescription("description1");
		Long categoryId1 = (long) 1;
		Long categoryId2 = (long) 2;
		Category category1 = (Category) session.get(Category.class, categoryId1);
		Category category2 = (Category) session.get(Category.class, categoryId2);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);
		entityPrimary.setCategory(categories);
		address.setEntityPrimary(entityPrimary);
		session.save(entityPrimary);
		entityPrimary.getAddress().add(address);
		
		session.save(address);
		session.getTransaction().commit();
	}

}

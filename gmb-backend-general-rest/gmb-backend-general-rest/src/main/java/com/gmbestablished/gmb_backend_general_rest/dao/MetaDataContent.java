package com.gmbestablished.gmb_backend_general_rest.dao;

import org.hibernate.Session;

import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadata;
import com.gmbestablished.gmb_backend_general_dataAccess.model.Metadatatype;
import com.gmbestablished.gmb_backend_general_dataAccess.util.HibernateUtil;
import com.gmbestablished.gmb_backend_general_rest.pojo.EntityPrimaryPojo;

public class MetaDataContent {
	private Long metaDataTypeIdRetrieved;
	private Metadata metadata;
	
	public MetaDataContent(long metaDataTypeId){
		metaDataTypeIdRetrieved = metaDataTypeId;
	}
	
	public Metadata metadataSingleValue(EntityPrimaryPojo entityPrimaryPojo) {
		System.out.println(entityPrimaryPojo.getAboutUs());
		System.out.println(metaDataTypeIdRetrieved.toString());
		
		Session session = null;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		
		Metadatatype aboutUsMetadatatype = (Metadatatype) session.get(Metadatatype.class, metaDataTypeIdRetrieved);
		metadata.setMetaDataTypeId(aboutUsMetadatatype);
		metadata.setMetaDataValue(entityPrimaryPojo.getAboutUs());
		return metadata;
	}
}

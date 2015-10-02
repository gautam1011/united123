package com.vamsee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamsee.entities.File;
import com.vamsee.entities.PartialFileInfo;

@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void persistFile(File file) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(file);
	}

	@Override
	public File getFileById(Long fileId) {
		// TODO Auto-generated method stub
		return (File) sessionFactory.getCurrentSession().get(File.class, fileId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartialFileInfo> getallImages() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("getAllImages").list();
	}
	
	

}

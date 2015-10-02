package com.vamsee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamsee.dao.FileDao;
import com.vamsee.entities.File;
import com.vamsee.entities.PartialFileInfo;

@Service
@Transactional
public class FileServiceImpl implements FileService {
	@Autowired
	private FileDao filedao;
	
	
	@Override
	public void persistFile(File file) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(5000);
		}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
		
		filedao.persistFile(file);
	}

	@Override
	public File getFileById(Long fileId) {
		// TODO Auto-generated method stub
		return filedao.getFileById(fileId);
	}

	@Override
	public List<PartialFileInfo> getallImages() {
		// TODO Auto-generated method stub
		return filedao.getallImages();
	}

}
